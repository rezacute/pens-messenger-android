package net.pens.pensmessengger.app.ui.loader;

import java.util.List;

import net.pens.pensmessengger.app.model.ChatFriend;
import android.content.Context;

/**
 * A Loader to get {@link ChatFriend} from chat_friends bucket.
 * 
 * @author noriyoshi.fukuzaki@kii.com
 */
public class FriendListLoader extends AbstractAsyncTaskLoader<List<ChatFriend>> {
	
	public FriendListLoader(Context context) {
		super(context);
	}
	@Override
	public List<ChatFriend> loadInBackground() {
		return ChatFriend.list();
	}
}
