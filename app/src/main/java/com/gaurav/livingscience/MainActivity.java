package com.gaurav.livingscience;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.gaurav.livingscience.adapter.ChapterAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements ChapterAdapter.OnChapterClickListener {

    private RecyclerView recyclerView;
    private String[] chapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        chapters = getResources().getStringArray(R.array.chapters);

        initRV();
        loadBannerAd();
    }

    void initRV() {
        ChapterAdapter adapter = new ChapterAdapter(MainActivity.this, chapters);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onChapterClick(int pos) {
        Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
        intent.putExtra("chapter_number", pos);
        startActivity(intent);
    }

    private void loadBannerAd() {
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
