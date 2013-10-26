

package com.emerald.startup;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.example.master_thesis.R;
import com.emerald.main.Term;
import com.emerald.main.TermService;
import com.emerald.startup.installer;
import com.emerald.startup.introscreen;

/**
*
* @author Spartacus Rex
*/
public class introscreen extends Activity implements OnClickListener{

   Dialog mConfirmDialog;
   Dialog mInstallDialog;
   Intent mTSIntent;

   @Override
   public void onCreate(Bundle icicle) {
       super.onCreate(icicle);

       setContentView(R.layout.view_main_windows);

       //Start the Service..
       mTSIntent = new Intent(this, TermService.class);
       startService(mTSIntent);

       Button but = (Button)findViewById(R.id.main_start);
       but.setOnClickListener(this);
       but = (Button)findViewById(R.id.main_stop);
       but.setOnClickListener(this);
       but = (Button)findViewById(R.id.main_install);
       but.setOnClickListener(this);

       AlertDialog.Builder build = new AlertDialog.Builder(this);
       build.setTitle("Confirm");
       build.setMessage("Shutdown all terminals ?");
       build.setCancelable(true);
       build.setPositiveButton("Shutdown", new android.content.DialogInterface.OnClickListener() {
           public void onClick(DialogInterface arg0, int arg1) {
               stopService(mTSIntent);

               finish();

               mConfirmDialog.dismiss();
           }
       });
       build.setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {
           public void onClick(DialogInterface arg0, int arg1) {
               mConfirmDialog.dismiss();
           }
       });
       mConfirmDialog = build.create();

       build = new AlertDialog.Builder(this);
       build.setTitle("Emerald Warning");
       build.setMessage("To use Emerald, you need to install utilities");
       build.setCancelable(true);
       build.setPositiveButton("Show me", new android.content.DialogInterface.OnClickListener() {
           public void onClick(DialogInterface arg0, int arg1) {
               //Install the system
               startActivity(new Intent(introscreen.this, installer.class));
               
               mConfirmDialog.dismiss();
           }
       });
       build.setNegativeButton("Later", new android.content.DialogInterface.OnClickListener() {
           public void onClick(DialogInterface arg0, int arg1) {
               //Start the Terminal
               startActivity(new Intent(introscreen.this, Term.class));

               mConfirmDialog.dismiss();
           }
       });
       mInstallDialog = build.create();
   }

   @Override
   public void onDestroy() {
       super.onDestroy();
   }

   public void onClick(View zButton) {
       if(zButton == findViewById(R.id.main_start)){
           //Check if system is installed
           SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
           String current    =  prefs.getString("CURRENT_SYSTEM", "no system installed");
           int    currentnum =  prefs.getInt("CURRENT_SYSTEM_NUM", -1);

           if(currentnum < installer.CURRENT_INSTALL_SYSTEM_NUM){
               mInstallDialog.show();
           }else{
               //Start the Terminal
               startActivity(new Intent(introscreen.this, Term.class));
           }

       }else if(zButton == findViewById(R.id.main_stop)){
           mConfirmDialog.show();
           
       }else if(zButton == findViewById(R.id.main_install)){
           //Install the system
           startActivity(new Intent(this, installer.class));
       }
   }

   @Override
   public void onConfigurationChanged(Configuration newConfig) {
       super.onConfigurationChanged(newConfig);
   }
}
