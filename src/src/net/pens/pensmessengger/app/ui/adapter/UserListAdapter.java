package net.pens.pensmessengger.app.ui.adapter;

import net.pens.pensmessengger.app.R;
import net.pens.pensmessengger.app.model.IUser;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A adapter class to show the {@link IUser}.
 * 
 * @author noriyoshi.fukuzaki@kii.com
 */
public class UserListAdapter extends AbstractArrayAdapter<IUser> {
	
	private final LayoutInflater inflater;
	
	public UserListAdapter(Context context) {
		super(context, R.layout.image_list_item);
		this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = this.inflater.inflate(R.layout.image_list_item, parent, false);
			holder = new ViewHolder();
			holder.text = (TextView)convertView.findViewById(R.id.row_text);
			holder.icon = (ImageView)convertView.findViewById(R.id.row_icon);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder)convertView.getTag();
		}
		
		IUser user = this.getItem(position);
		holder.position = position;
		holder.text.setText(user.getUsername());
		holder.icon.setImageResource(R.drawable.list_account);
		return convertView;
	}

}
