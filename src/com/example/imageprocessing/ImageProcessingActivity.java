package com.example.imageprocessing;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageProcessingActivity extends Activity {
	
	ImageView imageView;
	Paint myPaint = new Paint();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Bitmap imageBitmap = null;
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_processing_layout);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			imageBitmap  = (Bitmap) extras.get("data");
		}
		myPaint.setColor(Color.CYAN);
		imageView = (ImageView) findViewById(R.id.cam_image);
		Bitmap tempBitmap = Bitmap.createBitmap(imageBitmap.getWidth(), imageBitmap.getHeight(), Bitmap.Config.RGB_565);
		Canvas tempCanvas = new Canvas(tempBitmap);
		tempCanvas.drawBitmap(imageBitmap, 0, 0, null);
		//Draw everything else you want into the canvas, in this example a rectangle with rounded edges
		tempCanvas.drawRoundRect(new RectF(0,0,10,10), 2, 2, myPaint);

		//Attach the canvas to the ImageView
		imageView.setImageDrawable(new BitmapDrawable(getResources(), tempBitmap));
	}
}
