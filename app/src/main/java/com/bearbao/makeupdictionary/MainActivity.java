package com.bearbao.makeupdictionary;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FaceCategoryItemFragment.OnListFragmentInteractionListener {

    Toolbar toolbar;
    FaceCategoryItemFragment faceCategoryItemFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        faceCategoryItemFragment = FaceCategoryItemFragment.newInstance();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.frag_container, faceCategoryItemFragment);
        transaction.commit();

    }

    @Override
    public void onListFragmentInteraction(int itemPosition) {

    }
}
