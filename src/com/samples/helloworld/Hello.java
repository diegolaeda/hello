package com.samples.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class Hello extends Activity implements OnClickListener{

	private TextView email, pass;
	private EditText edit_email, edit_pass;
	private Boolean flag;

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_hello, menu);
        return true;
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag) {
		email.setText("Success login for "+edit_email.getText());
		pass.setVisibility(-1);
		edit_email.setVisibility(-1);
		edit_pass.setVisibility(-1);
		
		flag = false;
		}
		else {
			email.setText("E-mail address:");
			pass.setVisibility(1);
			edit_email.setVisibility(1);
			edit_pass.setVisibility(1);
			
			flag = true;
		}
	}

}
