package com.books.sam.repos;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    private EditText mSearchBoxEditText;
    private TextView mUrlDisplayTextView;
    private TextView mSearchResultsTextView;
    private TextView errorMessageTextView;
    private ProgressBar mLoadingIndicator;


    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);

        mSearchBoxEditText= findViewById(R.id.et_search_results_json);
        mUrlDisplayTextView = findViewById(R.id.tv_display_url);
        mSearchResultsTextView = findViewById(R.id.tv_show_repos);
        errorMessageTextView = findViewById(R.id.tv_error_message_display);
        mLoadingIndicator = findViewById(R.id.progress_bar);

    }

    void makeGithubSearchQuery(){
        String gitHubQuery = mSearchBoxEditText.getText().toString();
        URL gitHubSearchURL = NetworkUtils.buildUrl(gitHubQuery);
        mUrlDisplayTextView.setText(gitHubSearchURL.toString());
        new GithubQueryTask().execute(gitHubSearchURL);

    }

    public class GithubQueryTask extends AsyncTask<URL,Void,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(URL... params){
            URL searchUrl = params[0];
            String githubSearchResults = null;

            try{
                githubSearchResults = NetworkUtils.getResposeFromHttp(searchUrl);

            }catch (IOException e){
                e.printStackTrace();
            }
            return githubSearchResults;
        }
        @Override
        protected void onPostExecute(String githubSearchResults){
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            if(githubSearchResults != null && !githubSearchResults.equals("")){
                showJsonDataView();
                mSearchResultsTextView.setText(githubSearchResults);
            }else{
                showErrorMessage();
            }
        }
    }

    private void showJsonDataView() {
        errorMessageTextView.setVisibility(View.INVISIBLE);
        mSearchResultsTextView.setVisibility(View.VISIBLE);
    }
    private void showErrorMessage() {
        mSearchResultsTextView.setVisibility(View.INVISIBLE);
        errorMessageTextView.setVisibility(View.VISIBLE);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int itemSelected = item.getItemId();
        if (itemSelected == R.id.action_search){
            makeGithubSearchQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }



}
