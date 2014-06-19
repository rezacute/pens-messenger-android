package net.pens.pensmessenger.app.ui;

import net.pens.pensmessenger.app.PreferencesManager;
import net.pens.pensmessenger.app.model.ChatRoom;
import net.pens.pensmessenger.app.ui.util.SimpleProgressDialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

import com.kii.cloud.storage.KiiUser;
import com.kii.cloud.storage.callback.KiiUserCallBack;

/**
 * Main activity.
 * This activity does not have UI.
 * 
 * @author noriyoshi.fukuzaki@kii.com
 */
public class MainActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String token = PreferencesManager.getStoredAccessToken();
		if (!TextUtils.isEmpty(token)) {
			SimpleProgressDialogFragment.show(getSupportFragmentManager(), "Login", "Processing...");
			KiiUser.loginWithToken(new KiiUserCallBack() {
				@Override
				public void onLoginCompleted(int token, KiiUser user, Exception e) {
					if (e == null) {
						ChatRoom.ensureSubscribedBucket(user);
						Intent intent = new Intent(MainActivity.this, ChatMainActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intent);
					} else {
						PreferencesManager.setStoredAccessToken("");
						Intent intent = new Intent(MainActivity.this, SigninActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intent);
					}
					SimpleProgressDialogFragment.hide(getSupportFragmentManager());
				}
			},token);
		} else {
			Intent intent = new Intent(MainActivity.this, SigninActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
	}
}
