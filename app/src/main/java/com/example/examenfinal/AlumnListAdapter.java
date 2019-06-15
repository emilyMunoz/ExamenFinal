package com.example.examenfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class AlumnListAdapter extends RecyclerView.Adapter<AlumnListAdapter.AlumViewHolder> {

    class AlumViewHolder extends RecyclerView.ViewHolder{
        private final TextView alumnIdView;
        private final TextView alumnNameView;

        private AlumViewHolder(View itemView){
            super(itemView);
            alumnIdView = itemView.findViewById(R.id.idAlumn);
            alumnNameView = itemView.findViewById(R.id.nameAlumn);
        }
    }

    private final LayoutInflater mInflater;
    private List<Alumno> mAlumns = Collections.emptyList();

    AlumnListAdapter(Context context){mInflater = LayoutInflater.from(context);}

    @NonNull
    @Override
    public AlumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new AlumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumViewHolder holder, int position) {
        Alumno current = mAlumns.get(position);
        holder.alumnIdView.setText(current.getmId());
        holder.alumnNameView.setText(current.getmNombre());
    }

    void setAlumns(List<Alumno> alumns){
        mAlumns = alumns;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mAlumns.size();
    }
}
