package net.pens.pensmessenger.app;

import net.pens.pensmessenger.app.util.AppUtils;
import net.pens.pensmessenger.app.util.Logger;
import android.app.Application;
import android.content.Context;

import com.kii.cloud.analytics.KiiAnalytics;
import com.kii.cloud.storage.Kii;

/**
 * Custom implementation of Application.
 * 
 * @author noriyoshi.fukuzaki@kii.com
 */
public class PMApplication extends Application {
	
	private static Context context;
	
	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
		// Initialize SDK when application is started.
		Logger.i("■■■ initialize KII SDK ■■■");
		Kii.initialize(ApplicationConst.APP_ID, ApplicationConst.APP_KEY, Kii.Site.SG);
		Logger.i("■■■ initialize KII Analytics SDK ■■■");
		KiiAnalytics.initialize(context, ApplicationConst.APP_ID, ApplicationConst.APP_KEY, KiiAnalytics.Site.JP);
		
		// Print Key Hash for FB Apps
		AppUtils.printHashKey(context);
	}
	public static Context getContext(){
		return context;
	}
	public static String getMessage(int msgId) {
		return context.getResources().getString(msgId);
	}
	public static String getFormattedMessage(int msgId, Object... args) {
		String message = context.getResources().getString(msgId);
		return String.format(message, args);
	}
}
