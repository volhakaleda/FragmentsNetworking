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
  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;

  private RecyclerView rec;
  private BookAdapter adapter;

  public BottomFragment() {
    // Required empty public constructor
  }

  public static BottomFragment newInstance(String param1, String param2) {
    BottomFragment fragment = new BottomFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
      mParam2 = getArguments().getString(ARG_PARAM2);
    }
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
