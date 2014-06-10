package net.pens.pensmessengger.app.ui.loader;

import java.util.ArrayList;
import java.util.List;

import net.pens.pensmessengger.app.model.ChatUser;
import net.pens.pensmessengger.app.util.Logger;
import android.content.Context;
import android.text.TextUtils;

import com.kii.cloud.storage.KiiUser;

/**
 * A Loader to get {@link ChatUser} from chat_users bucket.
 * 
 * @author noriyoshi.fukuzaki@kii.com
 */
public class UserListLoader extends AbstractAsyncTaskLoader<List<ChatUser>> {
	
	private String keyword;
	
	public UserListLoader(Context context, String keyword) {
		super(context);
		this.keyword = keyword;
	}
	@Override
	public List<ChatUser> loadInBackground() {
		List<ChatUser> users = new ArrayList<ChatUser>();
		try {
			List<ChatUser> results = ChatUser.searchByKeyword(keyword);
			for (ChatUser user : results) {
				// Ignore myself.
				if (!TextUtils.equals(user.getUri(), KiiUser.getCurrentUser().toUri().toString())) {
					users.add(user);
				}
			}
		} catch (Exception e) {
			Logger.e("Unable to list users", e);
		}
		return users;
	}
}
