/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.emerald.main;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.master_thesis.R;
import com.spartacusrex.spartacuside.session.TermSession;
import com.spartacusrex.spartacuside.util.TermSettings;

/**
 * A terminal emulator activity.
 */

public class Term extends Activity {
	/**
	 * The ViewFlipper which holds the collection of EmulatorView widgets.
	 */
	private TermViewFlipper mViewFlipper;
	/**
	 * The name of the ViewFlipper in the resources.
	 */
	private static final int VIEW_FLIPPER = R.id.view_flipper;

	private ArrayList<TermSession> mTermSessions;

	private SharedPreferences mPrefs;
	private TermSettings mSettings;

	private static Handler mHandler;
	private TextView ipText;

	private boolean mAlreadyStarted = false;

	private Intent TSIntent;

	public static final int REQUEST_CHOOSE_WINDOW = 1;
	private int onResumeSelectWindow = -1;

	private TermService mTermService;
	private ServiceConnection mTSConnection = new ServiceConnection() {
		public void onServiceConnected(ComponentName className, IBinder service) {
			Log.i(TermDebug.LOG_TAG, "Bound to TermService");
			TermService.TSBinder binder = (TermService.TSBinder) service;
			mTermService = binder.getService();
			populateViewFlipper();
		}

		public void onServiceDisconnected(ComponentName arg0) {
			mTermService = null;
		}
	};

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		Log.e(TermDebug.LOG_TAG, "onCreate");
		mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		mSettings = new TermSettings(mPrefs);

		TSIntent = new Intent(this, TermService.class);

		if (!bindService(TSIntent, mTSConnection, BIND_AUTO_CREATE)) {
			Log.w(TermDebug.LOG_TAG, "bind to service failed!");
		}

		setContentView(R.layout.view_flipper);
		mViewFlipper = (TermViewFlipper) findViewById(VIEW_FLIPPER);
		registerForContextMenu(mViewFlipper);
		ipText = (TextView) findViewById(R.id.ipView);

		updatePrefs();
		mAlreadyStarted = true;
		mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
			}
		};
		Timer timer = new Timer();
		createTimerUpdateNetworkInfo(timer); // updated the network ip address
	}

	private void populateViewFlipper() {
		if (mTermService != null) {
			mTermSessions = mTermService.getSessions(getFilesDir());

			for (TermSession session : mTermSessions) {
				EmulatorView view = createEmulatorView(session);
				mViewFlipper.addView(view);
			}

			updatePrefs();
		}

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mViewFlipper.removeAllViews();
		unbindService(mTSConnection);

		// stopService(TSIntent);

		mTermService = null;
		mTSConnection = null;

		// if (mWakeLock.isHeld()) {
		// mWakeLock.release();
		// }
		// if (mWifiLock.isHeld()) {
		// mWifiLock.release();
		// }
	}

	private void restart() {
		startActivity(getIntent());
		finish();
	}

	public String getLocalIpAddress() {
		String ipAddress = "Host Address: 127.0.0.1";

		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface
					.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf
						.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress()) {

						if (!inetAddress.getHostAddress().toString()
								.startsWith("fe")) {
							ipAddress = "Host Address: "
									+ inetAddress.getHostAddress().toString();

						}
					}
				}
			}
		} catch (Exception ex) {
		}

		return ipAddress;
	}

	private void createTimerUpdateNetworkInfo(Timer t) {
		t.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						ipText.setText(getLocalIpAddress());
					}
				});
			}
		}, 1000, 1000);
	}

	private EmulatorView createEmulatorView(TermSession session) {
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		EmulatorView emulatorView = new EmulatorView(this, session,
				mViewFlipper, metrics);

		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.WRAP_CONTENT,
				FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.LEFT);
		emulatorView.setLayoutParams(params);

		session.setUpdateCallback(emulatorView.getUpdateCallback());

		return emulatorView;
	}

	private TermSession getCurrentTermSession() {
		return mTermSessions.get(mViewFlipper.getDisplayedChild());
	}

	private EmulatorView getCurrentEmulatorView() {
		return (EmulatorView) mViewFlipper.getCurrentView();
	}

	private void updatePrefs() {
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);

		for (View v : mViewFlipper) {
			((EmulatorView) v).setDensity(metrics);
			((EmulatorView) v).updatePrefs(mSettings);
		}
		{
			Window win = getWindow();
			WindowManager.LayoutParams params = win.getAttributes();
			final int FULLSCREEN = WindowManager.LayoutParams.FLAG_FULLSCREEN;
			int desiredFlag = mSettings.showStatusBar() ? 0 : FULLSCREEN;
			if (desiredFlag != (params.flags & FULLSCREEN)) {
				if (mAlreadyStarted) {
					// Can't switch to/from fullscreen after
					// starting the activity.
					restart();
				} else {
					win.setFlags(desiredFlag, FULLSCREEN);
				}
			}
		}
	}

	@Override
	public void onResume() {
		super.onResume();

		if (mTermSessions != null
				&& mTermSessions.size() < mViewFlipper.getChildCount()) {
			for (int i = 0; i < mViewFlipper.getChildCount(); ++i) {
				EmulatorView v = (EmulatorView) mViewFlipper.getChildAt(i);
				if (!mTermSessions.contains(v.getTermSession())) {
					v.onPause();
					mViewFlipper.removeView(v);
					--i;
				}
			}
		}

		mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		mSettings.readPrefs(mPrefs);
		updatePrefs();

		if (onResumeSelectWindow >= 0) {
			mViewFlipper.setDisplayedChild(onResumeSelectWindow);
			onResumeSelectWindow = -1;
		} else {
			mViewFlipper.resumeCurrentView();
		}
	}

	@Override
	public void onPause() {
		super.onPause();

		mViewFlipper.pauseCurrentView();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

		EmulatorView v = (EmulatorView) mViewFlipper.getCurrentView();
		if (v != null) {
			v.updateSize(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		if (id == R.id.menu_window_list) {

			openContextMenu(mViewFlipper);

		} else if (id == R.id.menu_toggle_soft_keyboard) {
			doToggleSoftKeyboard();

		} else if (id == R.id.menu_back_esc) {
			doBACKtoESC();

		} else if (id == R.id.menu_keylogger) {
			doToggelKeyLogger();

		} else if (id == R.id.menu_paste) {
			doPaste();

		} else if (id == R.id.menu_copyall) {
			doCopyAll();

		} 
		return super.onOptionsItemSelected(item);
	}



	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);

		// Show alist of windows
		menu.setHeaderTitle("Terminals");
		menu.add(0, 0, 0, "Terminal 1");
		menu.add(0, 1, 1, "Terminal 2");
		menu.add(0, 2, 2, "Terminal 3");
		menu.add(0, 3, 3, "Terminal 4");
		menu.add(0, 4, 4, "Terminal 5");
		menu.add(0, 5, 5, "Terminal 6");
		menu.add(0, 6, 6, "Terminal 7");
		menu.add(0, 7, 7, "Terminal 8");
		menu.add(0, 8, 8, "Terminal 9");
		menu.add(0, 9, 9, "Terminal 10");

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// Set the selected window..

		mViewFlipper.setDisplayedChild(item.getItemId());

		return super.onContextItemSelected(item);
	}

	private boolean canPaste() {
		ClipboardManager clip = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		if (clip.hasText()) {
			return true;
		}
		return false;
	}

	private void doPreferences() {
		startActivity(new Intent(this, TermPreferences.class));
	}


	private void doCopyAll() {
		ClipboardManager clip = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		clip.setText(getCurrentTermSession().getTranscriptText().trim());
	}

	private void doPaste() {
		ClipboardManager clip = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		if (!clip.hasText()) {
			Toast tt = Toast.makeText(this, "No text to Paste..",
					Toast.LENGTH_SHORT);
			tt.show();
			return;
		}

		CharSequence paste = clip.getText();
		byte[] utf8;
		try {
			utf8 = paste.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			Log.e(TermDebug.LOG_TAG, "UTF-8 encoding not found.");
			return;
		}

		getCurrentTermSession().write(paste.toString());
	}


	private void doToggleSoftKeyboard() {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
	}

	private void doToggelKeyLogger() {
		if (mTermService == null) {
			return;
		}

		boolean on = mTermService.isKeyLoggerOn();
		mTermService.setKeyLogger(!on);
		if (mTermService.isKeyLoggerOn()) {
			Toast tt = Toast
					.makeText(
							this,
							"KEY LOGGER NOW ON!\n\nCheck ~/.keylog \n\n# tail -f ~/.keylog",
							Toast.LENGTH_LONG);
			tt.show();
		} else {
			Toast tt = Toast.makeText(this, "Key Logger switched off..",
					Toast.LENGTH_SHORT);
			tt.show();
		}

	}

	private void doBACKtoESC() {
		if (mTermService == null) {
			return;
		}

		boolean on = mTermService.isBackESC();
		mTermService.setBackToESC(!on);
		if (mTermService.isBackESC()) {
			Toast tt = Toast.makeText(this, "BACK => ESC", Toast.LENGTH_SHORT);
			tt.show();
		} else {
			Toast tt = Toast.makeText(this, "BACK behaves NORMALLY",
					Toast.LENGTH_SHORT);
			tt.show();
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// Is BACK ESC

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (mTermService.isBackESC()) {
				// Send the ESC sequence..
				int ESC = TermKeyListener.KEYCODE_ESCAPE;
				getCurrentEmulatorView().dispatchKeyEvent(
						new KeyEvent(KeyEvent.ACTION_DOWN, ESC));
				getCurrentEmulatorView().dispatchKeyEvent(
						new KeyEvent(KeyEvent.ACTION_UP, ESC));
				return true;
			}
		}

		return super.onKeyDown(keyCode, event);
	}

}
