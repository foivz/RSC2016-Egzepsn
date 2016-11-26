package com.egzepsn.rsc.rscapp.models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.egzepsn.rsc.rscapp.R;

import java.util.ArrayList;

/**
 * Created by kiki3 on 26.11.2016..
 */

public class QuizListRecyclerAdapter extends RecyclerView.Adapter<QuizListRecyclerAdapter.ViewHolder>  {
    private ArrayList<Event> events;
    private Context context;

    public QuizListRecyclerAdapter(ArrayList<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.quiz_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.quizName.setText(events.get(position).getName());
        holder.quizDescription.setText(events.get(position).getQuizDescription());
        holder.quizTime.setText(events.get(position).getTime());
        if (events.get(position).isEnabled()) {
            holder.itemView.setVisibility(View.VISIBLE);
        }
        else{
            holder.itemView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView quizName = (TextView) itemView.findViewById(R.id.quiz_name);
        public TextView quizDescription = (TextView) itemView.findViewById(R.id.quiz_description);
        public TextView quizTime = (TextView) itemView.findViewById(R.id.quiz_time);
        public ImageView imageView = (ImageView) itemView.findViewById(R.id.quiz_enabled);

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
