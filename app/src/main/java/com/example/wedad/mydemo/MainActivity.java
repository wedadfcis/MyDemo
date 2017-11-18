package com.example.wedad.mydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {


    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Filems>filemsList;
    private ApiInterface apiInterface;
    static final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
        System.out.println(apiInterface);
        Call<List<Filems>> call=apiInterface.getFilems();
        call.enqueue(new Callback<List<Filems>>() {
            @Override
            public void onResponse(Call<List<Filems>> call, Response<List<Filems>> response) {
                filemsList=response.body();
                recyclerViewAdapter=new RecyclerViewAdapter(filemsList,getApplicationContext());
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<Filems>> call, Throwable t) {
                System.out.println(t.toString());
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

            }
        });


    }

    //---------------------add entries to action bar -------------------//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_item, menu);
        return true;
    }

    //------------------- add action to entries in action bar -----------//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_refresh:
                Toast.makeText(this, "hello refresh", Toast.LENGTH_LONG).show();
                break;
            case R.id.setting:
                Toast.makeText(this, "hello Settings", Toast.LENGTH_LONG).show();
                break;

        }
        return (super.onOptionsItemSelected(item));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


}