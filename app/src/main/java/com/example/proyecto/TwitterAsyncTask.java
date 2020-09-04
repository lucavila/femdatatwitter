package com.example.proyecto;

import android.app.ListActivity;
import android.text.method.LinkMovementMethod;
import android.widget.ArrayAdapter;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TwitterAsyncTask extends AsyncTask<Object, Void, ArrayList<TwitterTweet>> {
    ListActivity callerActivity;

    final static String TWITTER_API_KEY = "hnUaqDKCwuptxuJLZfKyiQhFd";
    final static String TWITTER_API_SECRET = "ShbXSLzem7Dy9eKDVcTsBs3rEa186F4dQD5JP5328VybnxhGrB";
    ListView listview;
    AppCompatActivity activity;
    @Override
    protected ArrayList<TwitterTweet> doInBackground(Object... params) {
        ArrayList<TwitterTweet> twitterTweets = null;
        listview = (ListView) params[1];
        activity = (AppCompatActivity) params[2];
        if (params.length > 0) {
            TwitterAPI twitterAPI = new TwitterAPI(TWITTER_API_KEY,TWITTER_API_SECRET);
            twitterTweets = twitterAPI.getTwitterTweets(params[0].toString());
        }
        return twitterTweets;
    }

    @Override
    protected void onPostExecute(ArrayList<TwitterTweet> twitterTweets) {
        CardArrayAdapter adapter = new CardArrayAdapter(activity, twitterTweets);
         listview.setAdapter(adapter); //mostraria los elementos que le mandamos

        /*ArrayAdapter<TwitterTweet> adapter =
                new ArrayAdapter<TwitterTweet>(callerActivity, R.layout.twitter_tweets_list, R.id.listTextView, twitterTweets);
        callerActivity.setListAdapter(adapter);
        ListView lv = callerActivity.getListView();
        lv.setDividerHeight(0);*/

        //lv.setDivider(this.getResources().getDrawable(android.R.color.transparent));
        //lv.setBackgroundColor(callerActivity.getResources().getColor(R.color.Twitter_blue));
    }
}

