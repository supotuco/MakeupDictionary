package com.bearbao.makeupdictionary;

import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.params.Face;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;


import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class FaceCategoryItemFragment extends Fragment {
    
    private OnCategoryFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FaceCategoryItemFragment() {
    }


    public static FaceCategoryItemFragment newInstance() {
        FaceCategoryItemFragment fragment = new FaceCategoryItemFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_facecategoryitem_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            String[] face_cagetories = context.getResources().getStringArray(R.array.face_cats);
            ArrayList<FaceCategoryItem> faceCategoryList = new ArrayList<>(face_cagetories.length);

            for(int i = 0; i < face_cagetories.length; i = i + 1){
                faceCategoryList.add(new FaceCategoryItem(face_cagetories[i],R.drawable.ic_face_black_24dp));
            }

            recyclerView.setAdapter(new MyFaceCategoryItemRecyclerViewAdapter(faceCategoryList, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof OnCategoryFragmentInteractionListener){
            mListener = (OnCategoryFragmentInteractionListener) activity;
        }else {
            throw new RuntimeException(activity.toString()
                    + "must implement OnCategoryFragmentInteractionListener");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCategoryFragmentInteractionListener) {
            mListener = (OnCategoryFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnCategoryFragmentInteractionListener");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnCategoryFragmentInteractionListener {
        void onCategoryFragmentInteraction(String category);
    }
}
