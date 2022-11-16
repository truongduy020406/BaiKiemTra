package com.example.baitap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.baitap.category.Category;
import com.example.baitap.category.CategoryAdapter;
import com.example.baitap.traicay.Book;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rcvCategory= findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);


        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
    }
    private List<Category> getListCategory(){
        List<Category> listCategory= new ArrayList<>();

        List<Book> books = new ArrayList<>();
        books.add(new Book(R.drawable.cam,"cam"));
        books.add(new Book(R.drawable.cachua,"ca chua"));
        books.add(new Book(R.drawable.cam,"cam"));
        books.add(new Book(R.drawable.cachua,"ca chua"));


        listCategory.add(new Category("Category 1",books));
        listCategory.add(new Category("Category 2",books));
        listCategory.add(new Category("Category 3",books));
        listCategory.add(new Category("Category 4",books));

        return listCategory;
    }
}