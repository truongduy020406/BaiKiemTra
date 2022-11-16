package com.example.baitap.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;
import com.example.baitap.traicay.bookAdapter;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private Context mcontext;
    private List<Category> mlistcategory;

    public CategoryAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    public void setData(List<Category> list){
        this.mlistcategory=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category= mlistcategory.get(position);
        if(category==null){
            return;
        }
        holder.tvnameCategory.setText(category.getNameCategory());

        bookAdapter bookAdapter =new bookAdapter();
        bookAdapter.setData(category.getBooks());

        LinearLayoutManager layoutManager = new LinearLayoutManager(mcontext,RecyclerView.HORIZONTAL,false);
        holder.rcvBooks.setLayoutManager(layoutManager);

        holder.rcvBooks.setAdapter(bookAdapter);
    }

    @Override
    public int getItemCount() {
        if(mlistcategory!=null){
            return mlistcategory.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private TextView tvnameCategory;
        private RecyclerView rcvBooks;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnameCategory = itemView.findViewById(R.id.tv_cate);
            rcvBooks = itemView.findViewById(R.id.rsv_traicay);
        }
    }
}