package com.example.decode;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends Activity {

	private ImageView mResultImage;
	private TextView mResultText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}

	/**
	 * 客户主扫
	 * @param view
	 */
	public void eventScan(View view) {
		//扫描成功后调用
		//Intent intent = new Intent(SecondActivity.this,ScanActivity.class);
		//startActivity(intent);
	}

}
