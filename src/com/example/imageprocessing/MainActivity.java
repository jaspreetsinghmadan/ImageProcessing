package com.example.imageprocessing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button cameraBtn;
	static final int REQUEST_IMAGE_CAPTURE = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cameraBtn = (Button) findViewById(R.id.camera_btn);
		cameraBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
				        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
				    }
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
			Intent intent = new Intent(MainActivity.this, ImageProcessingActivity.class);
			
	        Bundle extras = data.getExtras();
	        intent.putExtras(extras);
	        //Bitmap imageBitmap = (Bitmap) extras.get("data");
	        startActivity(intent);
	       
	    }
	}
}
