package com.example.proyecto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CardArrayAdapter  extends BaseAdapter {
   /* private static final String TAG = "CardArrayAdapter";
    private List<Card> cardList = new ArrayList<Card>();*/
   Context context;
   ArrayList<TwitterTweet> tweets;

    static class CardViewHolder {
        TextView line1;
        TextView line2;
    }

    public CardArrayAdapter(Context context, ArrayList<TwitterTweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

   /* @Override
    public void add(Card object) {
        cardList.add(object);
        super.add(object);
    }*/

    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return this.tweets.size();
    }

    @Override
    public TwitterTweet getItem(int index) {
        return this.tweets.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CardViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_card, parent, false);
            viewHolder = new CardViewHolder();
            viewHolder.line1 = (TextView) row.findViewById(R.id.line1);
            viewHolder.line2 = (TextView) row.findViewById(R.id.line2);
            row.setTag(viewHolder);
        } else {
            viewHolder = (CardViewHolder)row.getTag();
        }
        TwitterTweet tweet = getItem(position);
        viewHolder.line1.setText(tweet.getText());
        //viewHolder.line2.setText(tweet.getLine2());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}