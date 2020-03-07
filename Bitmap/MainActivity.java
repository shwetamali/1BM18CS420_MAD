package com.example.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap bit=Bitmap.createBitmap(720,1280, Bitmap.Config.ARGB_8888);
        ImageView i=findViewById(R.id.imageView);
        i.setBackgroundDrawable(new BitmapDrawable(bit));
        Canvas canvas=new Canvas(bit);
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(40);
        canvas.drawText("Rectangle",420,150,paint);
        canvas.drawRect(400,200,650,700,paint);

        canvas.drawText("Circle",200,150,paint);
        canvas.drawCircle(200,350,150,paint);

        canvas.drawText("Square",120,800,paint);
        canvas.drawRect(50,850,350,1150,paint);

        canvas.drawText("Line",480,800,paint);
        canvas.drawLine(520,850,520,1150,paint);
    }
}
