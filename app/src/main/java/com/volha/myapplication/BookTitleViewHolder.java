package com.volha.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class BookTitleViewHolder extends RecyclerView.ViewHolder {

  TextView textView;

  public BookTitleViewHolder(View itemView) {
    super(itemView);

    textView = itemView.findViewById(R.id.text);
  }

  public void bindData(Book book) {
    textView.setText(book.getTitle());
  }

}
