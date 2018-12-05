package com.example.krisandroid.noteme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteContent_Adapter extends RecyclerView.Adapter<NoteContent_Adapter.ViewwHolderr>{
    Context contex;
    private ArrayList<NoteContent_Model> mNote;

    public NoteContent_Adapter(Context contex, ArrayList<NoteContent_Model> mNote) {
        this.contex = contex;
        this.mNote = mNote;
    }

    public ViewwHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_note_item,parent,false);

        ViewwHolderr vh = new ViewwHolderr(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewwHolderr holder, int position) {
        NoteContent_Model nt = mNote.get(position);
        holder.TitleNote.setText(nt.getTitleNote());
        holder.DateNote.setText(nt.getDate());

    }

    @Override
    public int getItemCount() {
        return mNote.size();
    }

    public class ViewwHolderr extends RecyclerView.ViewHolder{
        public TextView TitleNote,DateNote;

        public ViewwHolderr(View itemView) {
            super(itemView);
            TitleNote = itemView.findViewById(R.id.txt_title_note);
            DateNote =itemView.findViewById(R.id.txt_date_note);

        }
    }
}
