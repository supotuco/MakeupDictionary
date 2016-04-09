package com.bearbao.makeupdictionary;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements FaceCategoryItemFragment.OnCategoryFragmentInteractionListener, ProductItemFragment.OnProductFragmentInteractionListener {

    private final int NUMBER_FACE_CATEGORIES = 5;
    Toolbar toolbar;
    FaceCategoryItemFragment faceCategoryItemFragment;
    ProductItemFragment[] productItemFragments = new ProductItemFragment[NUMBER_FACE_CATEGORIES];
    String[] categories;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categories = getResources().getStringArray(R.array.face_cats);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        faceCategoryItemFragment = FaceCategoryItemFragment.newInstance();
        productItemFragments[0] = ProductItemFragment.newInstance(R.array.brow_prod);
        productItemFragments[1] = ProductItemFragment.newInstance(R.array.eye_prod);
        productItemFragments[2] = ProductItemFragment.newInstance(R.array.face_prod);
        productItemFragments[3] = ProductItemFragment.newInstance(R.array.lip_prod);
        productItemFragments[4] = ProductItemFragment.newInstance(R.array.tool_prod);

        FragmentManager manager = getFragmentManager();


        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frag_container, faceCategoryItemFragment);
        transaction.commit();

    }

    @Override
    public void onProductFragmentInteraction(String product){

    }

    @Override
    public void onCategoryFragmentInteraction(String category) {
        int index = 0;

        for( ; index < categories.length; index = index + 1){
            if(category.equals(categories[index])){
                break;
            }
        }

        if(BuildConfig.DEBUG && index >= 5){
            throw  new AssertionError("Incorrect Category Search");

        }

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frag_container, productItemFragments[index]);
        transaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        transaction.commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
