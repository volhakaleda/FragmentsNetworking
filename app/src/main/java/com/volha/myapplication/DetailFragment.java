package com.volha.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailFragment extends Fragment{

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.detail_fragment, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    FragmentManager manager = getChildFragmentManager();
    FragmentTransaction topTransaction = manager.beginTransaction();
    TopFragment topFragment = new TopFragment();
    topTransaction.replace(R.id.top, topFragment);
    topTransaction.commit();

    FragmentTransaction bottomTransaction = manager.beginTransaction();
    BottomFragment bottomFragment = new BottomFragment();
    bottomTransaction.replace(R.id.bottom, bottomFragment);
    bottomTransaction.commit();
  }
}
