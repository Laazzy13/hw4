package com.example.vadim.home_work_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ImageAnimActivity extends AppCompatActivity {

    Animation animationOne, animationTwo, animationThree, animationFour;
    ImageView imageOne, imageTwo, imageThree, imageFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_anim);
        animationOne = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        animationTwo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        animationThree = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        animationFour = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);

        imageOne = (ImageView) findViewById(R.id.imageView_1);
        imageTwo = (ImageView) findViewById(R.id.imageView_2);
        imageThree = (ImageView) findViewById(R.id.imageView_3);
        imageFour = (ImageView) findViewById(R.id.imageView_4);

        imageOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageOne.startAnimation(animationOne);
            }
        });

        imageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageTwo.startAnimation(animationTwo);
            }
        });

        imageThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageThree.startAnimation(animationThree);
            }
        });

        imageFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageFour.startAnimation(animationFour);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.ACTIVITY_ONE_MENU_ITEM:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.zoom_out);
                return true;
            case R.id.ACTIVITY_TWO_MENU_ITEM:
                intent = new Intent(getApplicationContext(), ImageAnimActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.zoom_out);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_backbtn, R.anim.slide_out_backbtn);
    }
}
