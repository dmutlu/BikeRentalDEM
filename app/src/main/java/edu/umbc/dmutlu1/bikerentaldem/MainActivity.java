package edu.umbc.dmutlu1.bikerentaldem;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LinkHandler
{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static ArrayList<Bike> data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycleView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        data = new ArrayList<>();
        for (int i = 0; i < BikeData.bikes.length; i++) {
            data.add(new Bike(
                    BikeData.bikes[i],
                    BikeData.drawableArray[i]
            ));
        }

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(data, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void openLink()
    {
        Intent openURL = new Intent();
        openURL.setAction(Intent.ACTION_VIEW);
        openURL.setData(Uri.parse(getResources().getString(R.string.rental_URL)));
        startActivity(openURL);
    }
}