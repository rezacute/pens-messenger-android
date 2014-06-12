package net.pens.pensmessenger.app;

/**
 * Define application constant.
 * 
 * @author noriyoshi.fukuzaki@kii.com
 */
public final class ApplicationConst {
	
	// TODO:Needs to overwrite APP_ID and APP_KEY. Refer to http://documentation.kii.com/en/starts/android/
	public static final String APP_ID = "76d23455";
	public static final String APP_KEY = "cf658ffa668066334892a29befd48e69";
	// TODO:Needs to overwrite SENDER_ID. Refer to http://developer.android.com/google/gcm/gcm.html#senderid
	public static final String SENDER_ID = "989311911094";
	// TODO:Needs to overwrite FACEBOOK_APP_ID. Refer to http://documentation.kii.com/en/guides/android/managing-users/social-network-integration/facebook-integration/
	public static final String FACEBOOK_APP_ID = "669299033138375";
	// TODO:Needs to overwrite AGGREGATION_RULE_ID. Refer to http://documentation.kii.com/en/guides/android/managing-analytics/flex-analytics/analyze-event-data/
	public static final String AGGREGATION_RULE_ID = "87";
	
	public static final String TWITTER_CONSUMER_KEY = "YTTaywAlREW1Q5cd7klfo3NX0";
	public static final String TWITTER_CONSUMER_SECRET = "YC6U7k40C8qY9dbIEveLmLObTeiYnbKgopQxJWiBn8krTy1tTZ";
	
	public static final String TOPIC_INVITE_NOTIFICATION = "invite_notify";
	/**
	 * 
	 * Represents the action indicating that chat is started.
	 */
	public static final String ACTION_CHAT_STARTED = "com.kii.sample.chat.ACTION_CHAT_STARTED";
	/**
	 * Represents the action indicating that push message is received.
	 */
	public static final String ACTION_MESSAGE_RECEIVED = "com.kii.sample.chat.ACTION_MESSAGE_RECEIVED";
	/**
	 * The name of the extra data.
	 */
	public static final String EXTRA_MESSAGE = "com.kii.sample.chat.EXTRA_MESSAGE";
	
	private ApplicationConst() {
	}
}
