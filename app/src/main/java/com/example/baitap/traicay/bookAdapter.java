package com.example.baitap.traicay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;

import java.util.List;

public class bookAdapter extends RecyclerView.Adapter<bookAdapter.BookViewHolder> {
    private List<Book> mBOOK;

    public void setData(List<Book> list){
        this.mBOOK=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = mBOOK.get(position);
        if(book==null){
            return;
        }
        holder.imgbook.setImageResource(book.getResourceid());
        holder.tvtitle.setText(book.getTitle());
    }

    @Override
    public int getItemCount() {
        if(mBOOK !=null){
            return mBOOK.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgbook;
        private TextView  tvtitle;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            imgbook =itemView.findViewById(R.id.imagev);
            tvtitle = itemView.findViewById(R.id.tv_item);
        }
    }
}