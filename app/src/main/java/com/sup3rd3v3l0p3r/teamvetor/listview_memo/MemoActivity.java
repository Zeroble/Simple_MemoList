package com.sup3rd3v3l0p3r.teamvetor.listview_memo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by dlals on 2017-05-16.
 */

public class MemoActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView textTitle, textDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        toolbar = (Toolbar) findViewById(R.id.memo_activity_bar);
        setSupportActionBar(toolbar); //v7일때 서포트 액션 바
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textTitle = (TextView) findViewById(R.id.text_title);
        textDesc = (TextView) findViewById(R.id.textbox);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.memo_memo,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.okay :
                getIntent().putExtra("title",textTitle.getText().toString());
                getIntent().putExtra("value",textDesc.getText().toString());

                setResult(RESULT_OK, getIntent());
                finish();
                break;

            case R.id.home : //뒤로가기키 눌렀을때
                finish();
                break;
        }
        return true;
    }
}
