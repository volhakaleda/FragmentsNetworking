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

    itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //I dont know how to get access to FragmentManager within itemView. It is easy to do that in another Fragment and create
        //bundle and pass data.
      }
    });
  }

}
