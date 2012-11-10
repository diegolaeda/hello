package diego.laeda.helloworld;

import javax.security.auth.Destroyable;

import diego.laeda.helloworld.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;

public class Hello extends Activity implements OnClickListener{

	private TextView email, pass;
	EditText edit_email, edit_pass;
	Boolean flag;
	RadioButton r1, r2;
	CharSequence cite;
	ProgressDialog dialog;
	int i, max;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello);

		flag = true;

		email = (TextView)findViewById(R.id.email);
		pass = (TextView)findViewById(R.id.pass);

		edit_email = (EditText)findViewById(R.id.edit_email);
		edit_pass = (EditText)findViewById(R.id.edit_pass);

		final Button btn_enter = (Button)findViewById(R.id.btn_enter);
		btn_enter.setOnClickListener(this);
	} //public void onCreate(Bundle savedInstanceState)

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_hello, menu);
		return true;
	}//public boolean onCreateOptionsMenu(Menu menu)

	public void onClick(View v) {
		// TODO Auto-generated method stub

		final RadioButton r1 = (RadioButton)findViewById(R.id.r1);
		final RadioButton r2 = (RadioButton)findViewById(R.id.r2);

		if(r1.isChecked()) {cite = r1.getText();}
		if(r2.isChecked()) {cite = r2.getText();}

		if(flag) {
			i = 9;
			max = 100;

			dialog = new ProgressDialog(this);
			dialog.setCancelable(false);
			dialog.setMessage("Connecting...");
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setProgress(0);
			dialog.setMax(max);
			dialog.show();
			
			Thread background = new Thread(new Runnable() {
				public void run() {
					// TODO Auto-generated method stub
					try {

						while(dialog.getProgress() <= dialog.getMax()) {
							Thread.sleep(100);
							progressHandler.sendMessage(progressHandler.obtainMessage());
						}///while(dialog.getProgress() <= dialog.getMax())
					}//try
					catch (java.lang.InterruptedException e) {
					}//catch (java.lang.InterruptedException e)
				}//public void run()
			});//Thread background = new Thread(new Runnable()
			background.start();
			
			email.setText("Success login for "+edit_email.getText()+" on "+cite);
			pass.setVisibility(-1);
			edit_email.setVisibility(-1);
			edit_pass.setVisibility(-1);

			flag = false;
		}//if(flag)
		else {			
			email.setText("E-mail address:");
			pass.setVisibility(1);
			edit_email.setVisibility(1);
			edit_pass.setVisibility(1);

			flag = true;
		}//else
	}//	public void onClick(View v)	

	Handler progressHandler = new Handler() {
		public void handleMessage(Message msg) {
			dialog.incrementProgressBy(i);

			if(dialog.getProgress()==dialog.getMax())
			{
				dialog.dismiss();
			}
		}//public void handleMessage(Message msg)
	};
}//public class Hello extends Activity implements OnClickListener