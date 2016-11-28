package com.example.vadim.home_work_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        String[] names = {"Anton Ivanov", "Artem Boiko", "Piter Pen", "Vova Klon", "Sasha Day"};
        String[] post = {"friend", "friend", "friend", "friend", "friend"};
        mAdapter = new Adapter(names, post);
        mRecyclerView.setAdapter(mAdapter);
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
        Intent intent = new Intent(getApplicationContext(), ImageAnimActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_backbtn, R.anim.slide_out_backbtn);
    }
}
