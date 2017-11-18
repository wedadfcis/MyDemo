package com.example.wedad.mydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends Activity {
    static final int RESULT_OK = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle b = getIntent().getExtras();
        String val1 = b.getString("Value1");

        System.out.println(val1);
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra("returnKey1", "Swinging on a star. ");
        setResult(RESULT_OK, data);
        super.finish();

    }

}
