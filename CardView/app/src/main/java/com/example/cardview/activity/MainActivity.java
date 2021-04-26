package com.example.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cardview.R;
import com.example.cardview.adapter.PostAdapter;
import com.example.cardview.model.Post;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPost;
    private List<Post> posts = new ArrayList<Post>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPost = findViewById(R.id.recyclerPost);

        // Definindo layout
        // Exibe em uma lista de cima para baixo.
       // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        // Exibe em uma lista da esquerda para a direita
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        // Exibe em forma de GRID
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        recyclerPost.setLayoutManager(layoutManager);

        // Definindo adapter
        this.createPosts();

        PostAdapter adapter = new PostAdapter(posts);
        recyclerPost.setAdapter(adapter);
    }

    private void createPosts() {

        Post post = new Post("Thaynnara Gonçalves", "#NiceSky", R.drawable.imagem1);
        this.posts.add(post);

        post = new Post("Hotel JM", "#VIAJE", R.drawable.imagem2);
        this.posts.add(post);

        post = new Post("Maria Luiza", "#Paris", R.drawable.imagem3);
        this.posts.add(post);

        post = new Post("Marcos Paulo", "#LINDO", R.drawable.imagem4);
        this.posts.add(post);

    }
}
