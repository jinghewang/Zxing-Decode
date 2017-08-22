package com.example.decode;


import com.rbj.zxing.decode.QrcodeDecode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ScanActivity extends Activity {


	private SurfaceView scanPreview;//相机
	private RelativeLayout scanCropView;//扫描框
	private ImageView scanLine;//扫描框中间的线
	
	private QrcodeDecode qd;

	private String Tag = "HBD--";

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		Window window = getWindow();
		window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_capture);
		scanPreview = (SurfaceView) findViewById(R.id.capture_preview);
		scanCropView = (RelativeLayout) findViewById(R.id.capture_crop_view);
		scanLine = (ImageView) findViewById(R.id.capture_scan_line);

		qd = new QrcodeDecode(this,scanPreview,scanCropView) {
			
			@Override
			public void handleDecode(Bundle bundle) {
				//扫描成功后调用
				//startActivity(new Intent(ScanActivity.this, ResultActivity.class).putExtras(bundle));

				String result = bundle.getString(QrcodeDecode.BARCODE_RESULT);
				Log.e(Tag, result);
				//Toast.makeText(ScanActivity.this,result,Toast.LENGTH_LONG);
				Intent intent = new Intent();
				Bundle b = new Bundle();
				b.putString("result",result);
				intent.putExtras(b);
				this.setResult(0,intent);

				qd.finish();
			}
		};

		//animation
		TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT,				0.9f);
		animation.setDuration(4500);
		animation.setRepeatCount(-1);
		animation.setRepeatMode(Animation.RESTART);
		scanLine.startAnimation(animation);
	}

	@Override
	protected void onResume() {
		super.onResume();
		//在此处开起扫描
		qd.onResume();
	}

	@Override
	protected void onPause() {
		//
		qd.onPause();
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		//释放资源
		qd.onDestroy();
		super.onDestroy();
	}
}
