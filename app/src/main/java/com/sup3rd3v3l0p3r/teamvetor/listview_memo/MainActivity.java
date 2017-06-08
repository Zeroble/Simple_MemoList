package com.sup3rd3v3l0p3r.teamvetor.listview_memo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText search;
    ListView list;

    String val;
    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (EditText) findViewById(R.id.search);
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        list = (ListView) findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
        //adapter.add("adsfasdf");
        adapter.notifyDataSetChanged();

        setSupportActionBar(toolbar);
        toolbar.setTitle("메인");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.memo :
                startActivityForResult(new Intent(this,MemoActivity.class),200);
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 200:
                val = data.getStringExtra("value");
                title = data.getStringExtra("title");

                Toast.makeText(getApplicationContext(),val+"\n"+title,Toast.LENGTH_SHORT).show();
        }
    }

}
