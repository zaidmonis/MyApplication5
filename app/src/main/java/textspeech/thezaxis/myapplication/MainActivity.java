package textspeech.thezaxis.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private List<Chat> chatList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private Button buttonSend, buttonRecieve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        buttonSend = findViewById(R.id.button_send);
        buttonRecieve = findViewById(R.id.button_recieve);

        mAdapter = new MoviesAdapter(chatList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareChatData();
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chat chat = new Chat("Hello", "me");
                chatList.add(chat);
                mAdapter.notifyDataSetChanged();
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        // Call smooth scroll
                        recyclerView.smoothScrollToPosition(mAdapter.getItemCount() - 1);
                    }
                });
            }
        });
        buttonRecieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chat chat = new Chat("Hey There!", "him");
                chatList.add(chat);
                mAdapter.notifyDataSetChanged();
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        // Call smooth scroll
                        recyclerView.smoothScrollToPosition(mAdapter.getItemCount() - 1);
                    }
                });
            }
        });
    }
    private void prepareChatData(){
        Chat chat = new Chat("Hello", "me");
        chatList.add(chat);

        chat = new Chat("Hey there!", "him");
        chatList.add(chat);

        chat = new Chat("how are you!", "me");
        chatList.add(chat);

        chat = new Chat("fine", "him");
        chatList.add(chat);

        chat = new Chat("ok", "me");
        chatList.add(chat);

        chat = new Chat("now go", "him");
        chatList.add(chat);

        chat = new Chat("go to hell", "him");
        chatList.add(chat);
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}