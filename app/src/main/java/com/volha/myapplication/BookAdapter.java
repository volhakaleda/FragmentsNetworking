package com.volha.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookTitleViewHolder>{

  List<Book> books = new ArrayList<>();

  @Override
  public BookTitleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_layout, parent, false);
    return new BookTitleViewHolder(view);
  }

  @Override
  public void onBindViewHolder(BookTitleViewHolder holder, int position) {
    Book book = books.get(position);
    holder.bindData(book);

  }

  @Override
  public int getItemCount() {
    return books.size();
  }

  public void setData(List<Book> books) {
    this.books = books;
  }
}
