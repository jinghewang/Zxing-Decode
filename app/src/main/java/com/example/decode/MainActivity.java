package com.example.decode;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.rbj.zxing.decode.QrcodeDecode;

public class MainActivity extends Activity {

	private ImageView mResultImage;
	private TextView mResultText;

	private EditText result_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		result_text  = (EditText) this.findViewById(R.id.result_text);
	}

	/**
	 * 客户主扫
	 * @param view
	 */
	public void eventScan(View view) {
		//扫描成功后调用
		Bundle bundle = new Bundle();
		Intent intent = new Intent(MainActivity.this,ScanActivity.class);
		startActivityForResult(intent,1,bundle);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		Bundle bundle = data.getExtras();
		String s = bundle.getString("result");
		result_text.setText(s);
		String x = s.toLowerCase();
	}

	/**
	 * 客户主扫
	 * @param view
	 */
	public void eventScan2(View view) {
		//扫描成功后调用
		Intent intent = new Intent(MainActivity.this,SecondActivity.class);
		startActivity(intent);
	}

}
