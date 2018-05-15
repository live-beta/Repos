package com.books.sam.repos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;



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


}
