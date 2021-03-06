package com.volha.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BottomFragment extends Fragment {

  private RecyclerView rec;
  private BookAdapter adapter;

  public BottomFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_bottom, container, false);
    rec = view.findViewById(R.id.recycler_view);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    adapter = new BookAdapter();
    rec.setLayoutManager(layoutManager);
    rec.setAdapter(adapter);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    String jsonData = "{\n"
      + "    \"books\": [\n"
      + "        {\n"
      + "            \"title\": \"Nothanger Abbey\",\n"
      + "            \"author\": \"Austen, Jane\",\n"
      + "            \"year\": 1814\n"
      + "        },\n"
      + "        {\n"
      + "            \"title\": \"War and Peace\",\n"
      + "            \"author\": \"Tolstoy, Leo\",\n"
      + "            \"year\": 1865\n"
      + "        },\n"
      + "        {\n"
      + "            \"title\": \"Anna Karenina\",\n"
      + "            \"author\": \"Tolstoy, Leo\",\n"
      + "            \"year\": 1875\n"
      + "        }\n"
      + "    ]\n"
      + "}";

    try {
      JSONObject jsonObject = new JSONObject(jsonData);
      JSONArray array = jsonObject.getJSONArray("books");
      List<Book> books = new ArrayList<>();

      for (int i = 0; i < array.length(); i++) {
        JSONObject jsonBook = (JSONObject) array.get(i);

        Book book = new Book();
        book.setTitle(jsonBook.getString("title"));
        book.setAuthor(jsonBook.getString("author"));
        book.setYear(jsonBook.getInt("year"));
        books.add(book);

      }
      adapter.setData(books);
      adapter.notifyDataSetChanged();

    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
}
