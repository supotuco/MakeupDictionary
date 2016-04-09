package com.bearbao.makeupdictionary;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p>
 * Activities containing this fragment MUST implement the {@link OnProductFragmentInteractionListener}
 * interface.
 */
public class ProductItemFragment extends Fragment {

    private OnProductFragmentInteractionListener mListener;
    private static final String ARG_STRING_RESOURCE = "COM.BEARBAO.MAKEUPDICTIONARY.STRING-RESOURCE-ID";
    private int string_resource_id;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProductItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ProductItemFragment newInstance(int stringRecourceId) {
        ProductItemFragment fragment = new ProductItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STRING_RESOURCE, stringRecourceId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            string_resource_id = getArguments().getInt(ARG_STRING_RESOURCE);
        }
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

            String[] product_list = context.getResources().getStringArray(string_resource_id);
            ArrayList<ProductItem> data_list = new ArrayList<>();
            for(int i = 0; i < product_list.length; i = i + 1){
                data_list.add(new ProductItem(product_list[i], R.drawable.ic_face_black_24dp));
            }

            recyclerView.setAdapter(new MyProductItemRecyclerViewAdapter(data_list, mListener));
        }
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof OnProductFragmentInteractionListener){
            mListener = (OnProductFragmentInteractionListener) activity;
        }else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnProductFragmentInteractionListener");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnProductFragmentInteractionListener) {
            mListener = (OnProductFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnProductFragmentInteractionListener");
        }
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnProductFragmentInteractionListener {
        // TODO: Update argument type and name
        void onProductFragmentInteraction(String product);
    }
}
