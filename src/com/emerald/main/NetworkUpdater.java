package com.emerald.main;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;


public class NetworkUpdater {
	
	InetAddress iAddress;

	public String getIpAddress() {
		String ipAddress = "";

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
							ipAddress = inetAddress.getHostAddress().toString();
							

						}
					}
				}
			}
		} catch (Exception ex) {
		}
		return ipAddress;
	}

}
