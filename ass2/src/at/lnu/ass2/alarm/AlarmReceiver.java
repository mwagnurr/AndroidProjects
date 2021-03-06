package at.lnu.ass2.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context ctx, Intent intent) {
		Log.d("AlarmReceiver", "received alarm broad cast");
		String msg = intent.getStringExtra("message");
		Toast.makeText(ctx,msg,Toast.LENGTH_SHORT).show();
		
		//create new intent for the AlarmResult activity and add the sent alarm again
		Intent alarmResultIntent = new Intent(ctx, AlarmResult.class);
		alarmResultIntent.putExtra("alarm", intent.getSerializableExtra("alarm"));
		alarmResultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		ctx.startActivity(alarmResultIntent);
	}
}
