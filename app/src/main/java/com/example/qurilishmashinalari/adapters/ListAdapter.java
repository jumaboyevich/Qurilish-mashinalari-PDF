package com.example.qurilishmashinalari.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qurilishmashinalari.R;
import com.example.qurilishmashinalari.notes.ListNote;

import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListNote> mData;
    private final ThemeAdapter.ItemClickListener mClickListener;
    private final Activity activity;


    // data is passed into the constructor
    public ListAdapter(Activity activity, List<ListNote> data, ThemeAdapter.ItemClickListener mClickListener) {
        this.mData = data;
        this.mClickListener=mClickListener;
        this.activity=activity;
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ListNote listNote = mData.get(position);

        holder.title.setText(listNote.getTitle());

        ThemeAdapter userAdapter=new ThemeAdapter(activity, listNote.getThemeNoteList(), mClickListener);
        holder.recyclerView.setAdapter(userAdapter);
        userAdapter.notifyDataSetChanged();



    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void swapData(List<ListNote> userNoteList) {
        mData = userNoteList;
        notifyDataSetChanged();
    }



    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        RecyclerView recyclerView;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            recyclerView = itemView.findViewById(R.id.list_recyclerview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    // allows clicks events to be caught
//   void setClickListener(ItemClickListener itemClickListener) {
//            this.mClickListener = itemClickListener;
//    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}