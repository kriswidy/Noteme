package com.example.krisandroid.noteme.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.krisandroid.noteme.Models.Note;
import com.example.krisandroid.noteme.R;
import com.example.krisandroid.noteme.UpdateActivity;

import java.util.List;

/**
 * Created by kris on 09/12/18.
 */

public class NotemeAdapter extends RecyclerView.Adapter<NotemeAdapter.noteViewHolder>{
    List<Note> noteList;
    public NotemeAdapter(List<Note> noteList){this.noteList = noteList;}

    @NonNull
    @Override
    public NotemeAdapter.noteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_note_item, parent,false);
        noteViewHolder mHolder = new noteViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(NotemeAdapter.noteViewHolder holder, final int position) {
        holder.txtTittle.setText(noteList.get(position).getJudul());
        holder.txtDate.setText(noteList.get(position).getTanggal());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UpdateActivity.class);
                intent.putExtra("judul", noteList.get(position).getJudul());
                intent.putExtra("tanggal", noteList.get(position).getTanggal());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class noteViewHolder extends RecyclerView.ViewHolder{
        TextView txtTittle, txtDate;
        public noteViewHolder(View noteView){
            super(noteView);
            txtTittle = (TextView) noteView.findViewById(R.id.txt_title_note);
            txtDate = (TextView) noteView.findViewById(R.id.txt_date_note);
        }

    }
}
