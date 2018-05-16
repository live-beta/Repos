package com.books.sam.repos;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText mSearchBoxEditText;
    private TextView mUrlDisplayTextView;
    private TextView mSearchResultsTextView;


    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);

        mSearchBoxEditText= findViewById(R.id.et_search_results_json);
        mUrlDisplayTextView = findViewById(R.id.tv_display_url);
        mSearchResultsTextView = findViewById(R.id.tv_show_repos);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        //action code goes here
        int itemSelected = item.getItemId();
        if (itemSelected == R.id.action_search){
            Context context = MainActivity.this;
            Toast.makeText(context,"Search Selected",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);

    }



}
