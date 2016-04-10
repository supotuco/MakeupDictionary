package com.bearbao.makeupdictionary;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements  FaceCategoryItemFragment.OnCategoryFragmentInteractionListener,
                                                                ProductItemFragment.OnProductFragmentInteractionListener,
                                                                FragmentManager.OnBackStackChangedListener
                                {

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

        getFragmentManager().addOnBackStackChangedListener(this);

        getFragmentManager().beginTransaction()
                            .add(R.id.frag_container, faceCategoryItemFragment)
                            .addToBackStack(null)
                            .commit();

    }

                                    @Override
                                    public void onBackStackChanged() {
                                        if(getFragmentManager().getBackStackEntryCount() > 1){
                                            getSupportActionBar().setHomeButtonEnabled(true);
                                            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                                        }else{
                                            getSupportActionBar().setHomeButtonEnabled(true);
                                            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                                        }
                                    }

                                    @Override
                                    public boolean onOptionsItemSelected(MenuItem item) {
                                        if(item.getItemId() == android.R.id.home){
                                            if(getFragmentManager().getBackStackEntryCount() > 0){
                                                getFragmentManager().popBackStack();
                                            }else{
                                                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                                            }
                                        }

                                        return super.onOptionsItemSelected(item);
                                    }

                                    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this,"Back Pressed", Toast.LENGTH_LONG).show();
    }


    public void popBackStack(View view){
        this.getFragmentManager().popBackStack();
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
        transaction.replace(R.id.frag_container, productItemFragments[index], categories[index])
                .addToBackStack(null)
                .commit();
    }
}
