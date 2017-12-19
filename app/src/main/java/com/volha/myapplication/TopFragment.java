package com.volha.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TopFragment extends Fragment {

  private TextView titleTV;
  private TextView authorTV;
  private TextView yearTV;

  private static final String ARG_PARAM1 = "title";
  private static final String ARG_PARAM2 = "author";
  private static final String ARG_PARAM3 = "year";

  private String title;
  private String author;
  private String year;

  public TopFragment() {
    // Required empty public constructor
  }


  // TODO: Rename and change types and number of parameters
  public static TopFragment newInstance(String title, String author, String year) {
    TopFragment fragment = new TopFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, title);
    args.putString(ARG_PARAM2, author);
    args.putString(ARG_PARAM3, year);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      title = getArguments().getString(ARG_PARAM1);
      author = getArguments().getString(ARG_PARAM2);
      year = getArguments().getString(ARG_PARAM3);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_top, container, false);
    titleTV = view.findViewById(R.id.title);
    authorTV = view.findViewById(R.id.author);
    yearTV = view.findViewById(R.id.year);

    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    titleTV.setText(title);
    authorTV.setText(author);
    yearTV.setText(year);
  }
}
