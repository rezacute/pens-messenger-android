package net.pens.pensmessengger.app.util;

import java.io.IOException;

import net.pens.pensmessengger.app.ApplicationConst;
import net.pens.pensmessengger.app.PMApplication;

import com.google.android.gms.gcm.GoogleCloudMessaging;

/**
 * A suite of utilities surrounding the use of the GCM(Google Cloud Messaging)
 * 
 * @author noriyoshi.fukuzaki@kii.com
 */
public class GCMUtils {
	private GCMUtils() {
	}
	public static String register() throws Exception {
		String registrationId = null;
		int retry = 0;
		while (retry < 3) {
			try {
				GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(PMApplication.getContext());
				registrationId = gcm.register(ApplicationConst.SENDER_ID);
				break;
			} catch (IOException ignore) {
				Thread.sleep(1000);
				retry++;
				Logger.w("failed to register GCM. retry " + retry + " times  reason=" + ignore.getMessage());
			}
		}
		if (registrationId == null || retry >= 3) {
			throw new IOException("failed to register GCM");
		}
		return registrationId;
	}
}
