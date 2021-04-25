package com.example.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.RecyclerItemClickListener;
import com.example.recyclerview.activity.adapter.Adapter;
import com.example.recyclerview.activity.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;
    private List<Movie> listMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recycler view
        list = findViewById(R.id.listId);

        this.createMovies();

        // instanciando o adapter para o recycler view
        Adapter adapter = new Adapter(this.listMovies);

        // configurando recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
            getApplicationContext()
        );
        list.setLayoutManager(layoutManager);
        list.setHasFixedSize(true);
        list.addItemDecoration(new DividerItemDecoration(
                this,
                LinearLayout.VERTICAL
        ));
        list.setAdapter(adapter);

        // evento de click
        list.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    list,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Toast.makeText(
                                    getApplicationContext(),
                                    listMovies.get(position).getTitle(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Toast.makeText(
                                    getApplicationContext(),
                                    listMovies.get(position).getYear(),
                                    Toast.LENGTH_SHORT
                            ).show();

                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );
    }

    private void createMovies(){

        Movie movie = new Movie("A viagem de Chiriro", "2001", "Fantasia");
        this.listMovies.add(movie);

        movie = new Movie("Meu amigo Totoro", "1988", "Fantasia");
        this.listMovies.add(movie);

        movie = new Movie("O castelo animado", "2004", "Fantasia");
        this.listMovies.add(movie);

        movie = new Movie("Laputa, O castelo no céu", "1986", "Fantasia");
        this.listMovies.add(movie);

        movie = new Movie("Ponyo", "2008", "Fantasia");
        this.listMovies.add(movie);

        movie = new Movie("Nausicãa, do vale do vento", "1984", "Fantasia");
        this.listMovies.add(movie);

        movie = new Movie("O serviço de entregar da Kiki", "1989", "Fantasia");
        this.listMovies.add(movie);

        movie = new Movie("Vidas ao vento", "2013", "Fantasia");
        this.listMovies.add(movie);

        movie = new Movie("Porco Rosso", "1992", "Fantasia");
        this.listMovies.add(movie);

        movie = new Movie("O mundo dos pequeninos", "2010", "Fantasia");
        this.listMovies.add(movie);
    }
}
