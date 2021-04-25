package com.example.recyclerview.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.model.Movie;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Movie> listMovies;

    public Adapter(List<Movie> movies) {
        this.listMovies = movies;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView year;
        TextView gender;


        public MyViewHolder(View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.textTitle);
            year = itemView.findViewById(R.id.textYear);
            gender = itemView.findViewById(R.id.textGender);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View movieList = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_movies,
                parent,
                false
        );

        return new MyViewHolder(movieList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = this.listMovies.get(position);

        holder.title.setText(movie.getTitle());
        holder.year.setText(movie.getYear());
        holder.gender.setText(movie.getGender());
    }

    @Override
    public int getItemCount() {
        int size = this.listMovies.size();

        return size;
    }
}
