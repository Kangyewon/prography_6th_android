package com.example.bottomnavigationproject.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationproject.R;
import com.example.bottomnavigationproject.model.Film;
import com.example.bottomnavigationproject.service.FilmService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatsFragment extends Fragment {
    public ChatsFragment() {}
    View view;
    public RecyclerView recyclerView;
    public FilmsRecycleViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_chats, container, false);
        // 리사이클러뷰에 LinearLayoutManager 객체 지정.


        FilmService service = FilmService.retrofit.create(FilmService.class);
        Call<ArrayList<Film>> call = service.films();
        call.enqueue(new Callback<ArrayList<Film>>() {
            @Override
            public void onResponse(Call<ArrayList<Film>> call, Response<ArrayList<Film>> response) {
                ArrayList<Film> films = response.body();
                recyclerView = view.findViewById(R.id.films_recycle_view) ;
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext())) ;
                adapter = new FilmsRecycleViewAdapter(films) ;
                recyclerView.setAdapter(adapter) ;

            }

            @Override
            public void onFailure(Call<ArrayList<Film>> call, Throwable t) {
                Log.e("test", t.toString());
            }
        });

        return view;
    }

}
