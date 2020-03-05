package com.example.bottomnavigationproject.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationproject.R;
import com.example.bottomnavigationproject.model.Film;

import java.util.ArrayList;

public class FilmsRecycleViewAdapter extends  RecyclerView.Adapter<FilmsRecycleViewAdapter.ViewHolder>{
    private ArrayList<Film> mData = new ArrayList<Film>();
    public FilmsRecycleViewAdapter(ArrayList<Film> films) {
        mData = films;
    }
    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView numTextView;
        TextView titleTextView ;
        TextView directorTextVIew;
        TextView releaseDateTextView;

        ViewHolder(final View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            numTextView = itemView.findViewById(R.id.num);
            titleTextView = itemView.findViewById(R.id.title);
            directorTextVIew = itemView.findViewById(R.id.director);
            releaseDateTextView = itemView.findViewById(R.id.release_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    int position = getAdapterPosition();
                    intent.putExtra("title", mData.get(position).getTitle());
                    intent.putExtra("director", mData.get(position).getDirector());
                    intent.putExtra("release_date", mData.get(position).getRelease_date());
                    intent.putExtra("description", mData.get(position).getDescription());
                    intent.putExtra("producer", mData.get(position).getProducer());
                    intent.putExtra("rt_score", mData.get(position).getRt_score());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
    @NonNull
    @Override
    public FilmsRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.films_recycleview_adapter, parent, false) ;
        FilmsRecycleViewAdapter.ViewHolder vh = new FilmsRecycleViewAdapter.ViewHolder(view) ;

        return vh ;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsRecycleViewAdapter.ViewHolder holder, int position) {
        Film film = mData.get(position) ;
        holder.numTextView.setText(String.valueOf(position + 1));
        holder.titleTextView.setText(film.title) ;
        holder.directorTextVIew.setText(film.director);
        holder.releaseDateTextView.setText(film.release_date);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public void setFilms(ArrayList<Film> films) {
        mData = films;
    }

}
