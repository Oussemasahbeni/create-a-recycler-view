package com.example.tp7_create_a_recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordViewHolder> {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;



    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();

    }
}
class WordViewHolder extends RecyclerView.ViewHolder {
    public final TextView wordItemView;
    final WordListAdapter mAdapter;
    public WordViewHolder(@NonNull View itemView, TextView wordItemView, WordListAdapter mAdapter) {
        super(itemView);
        this.wordItemView = wordItemView;
        this.mAdapter = mAdapter;
    }
    public WordViewHolder(View itemView, WordListAdapter adapter) {
        super(itemView);
        wordItemView = (TextView) itemView.findViewById(R.id.word);
        this.mAdapter = adapter;
    }
}