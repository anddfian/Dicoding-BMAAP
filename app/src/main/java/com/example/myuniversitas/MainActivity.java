package com.example.myuniversitas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvUniv;
    private ArrayList<Univ> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUniv = findViewById(R.id.rv_univ);
        rvUniv.setHasFixedSize(true);

        list.addAll(UnivData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvUniv.setLayoutManager(new LinearLayoutManager(this));
        ListUnivAdapter listUnivAdapter = new ListUnivAdapter(list);
        rvUniv.setAdapter(listUnivAdapter);

        listUnivAdapter.setOnItemClickCallback(new ListUnivAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Univ data) {
                showSelectedUniv(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode)
    {
        if(selectedMode == R.id.action_profile)
        {
            showProfile();
        }
    }

    private void showProfile()
    {
        Intent moveIntent = new Intent(MainActivity.this, Profile.class);
        startActivity(moveIntent);
    }

    private void showSelectedUniv(Univ univ) {
        switch(univ.getPhoto())
        {
            case R.drawable.ugm:
                Intent moveIntentUGM = new Intent(MainActivity.this, UGMActivity.class);
                startActivity(moveIntentUGM);
                return;
            case R.drawable.ui:
                Intent moveIntentUI = new Intent(MainActivity.this, UIActivity.class);
                startActivity(moveIntentUI);
                return;
            case R.drawable.itb:
                Intent moveIntentITB = new Intent(MainActivity.this, ITBActivity.class);
                startActivity(moveIntentITB);
                return;
            case R.drawable.ipb:
                Intent moveIntentIPB = new Intent(MainActivity.this, IPBActivity.class);
                startActivity(moveIntentIPB);
                return;
            case R.drawable.undip:
                Intent moveIntentUNDIP = new Intent(MainActivity.this, UNDIPActivity.class);
                startActivity(moveIntentUNDIP);
                return;
            case R.drawable.ub:
                Intent moveIntentUB = new Intent(MainActivity.this, UBActivity.class);
                startActivity(moveIntentUB);
                return;
            case R.drawable.its:
                Intent moveIntentITS = new Intent(MainActivity.this, ITSActivity.class);
                startActivity(moveIntentITS);
                return;
            case R.drawable.uns:
                Intent moveIntentUNS = new Intent(MainActivity.this, UNSActivity.class);
                startActivity(moveIntentUNS);
                return;
            case R.drawable.unsyiah:
                Intent moveIntentUNSYIAH = new Intent(MainActivity.this, UNSYIAHActivity.class);
                startActivity(moveIntentUNSYIAH);
                return;
            case R.drawable.unpad:
                Intent moveIntentUNPAD = new Intent(MainActivity.this, UNPADActivity.class);
                startActivity(moveIntentUNPAD);
        }
    }
}