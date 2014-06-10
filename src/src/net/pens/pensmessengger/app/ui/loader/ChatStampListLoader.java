package net.pens.pensmessengger.app.ui.loader;

import java.util.List;

import net.pens.pensmessengger.app.model.ChatStamp;
import android.content.Context;

/**
 * A Loader to get {@link ChatStamp} from chat_stamps bucket.
 * 
 * @author noriyoshi.fukuzaki@kii.com
 */
public class ChatStampListLoader extends AbstractAsyncTaskLoader<List<ChatStamp>> {

	public ChatStampListLoader(Context context) {
		super(context);
	}
	@Override
	public List<ChatStamp> loadInBackground() {
		return ChatStamp.listOrderByNewly();
	}

}
