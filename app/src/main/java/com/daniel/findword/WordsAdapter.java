package com.daniel.findword;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordViewHolder> {
    private List<String> words;
    private WordsListener wordsListener;
    private Context context;

    public WordsAdapter(List<String> words, WordsListener wordsListener, Context context) {
        this.words = words;
        this.wordsListener = wordsListener;
        this.context = context;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WordViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.recycler_item,
                        parent,
                        false
                )
        );
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.text.setText(words.get(position));
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class WordViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        WordViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }
}
