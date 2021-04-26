package com.example.cardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardview.R;
import com.example.cardview.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    private List<Post> posts;

    public PostAdapter(List<Post> p) {

        this.posts = p;
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {

        private TextView name;
        private TextView post;
        private ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.namePost);
            this.post = itemView.findViewById(R.id.textPost);
            this.image = itemView.findViewById(R.id.imagePost);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View postList = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.post,
                parent,
                false
        );

        return new MyViewHolder(postList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Post post = this.posts.get(position);

        holder.name.setText(post.getName());
        holder.post.setText(post.getText());
        holder.image.setImageResource(post.getImage());
    }

    @Override
    public int getItemCount() {
        return this.posts.size();
    }
}
