package com.bearbao.makeupdictionary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bearbao.makeupdictionary.FaceCategoryItemFragment.OnCategoryFragmentInteractionListener;

import java.util.List;


public class MyFaceCategoryItemRecyclerViewAdapter extends RecyclerView.Adapter<MyFaceCategoryItemRecyclerViewAdapter.ViewHolder> {

    private final List<FaceCategoryItem> mValues;
    private final OnCategoryFragmentInteractionListener mListener;

    public MyFaceCategoryItemRecyclerViewAdapter(List<FaceCategoryItem> items, OnCategoryFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_facecategoryitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mFaceIcon.setImageResource(mValues.get(position).getCategory_pic_id());
        holder.mFaceCategory.setText(mValues.get(position).getCategory());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onCategoryFragmentInteraction(holder.mItem.getCategory());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mFaceIcon;
        public final TextView mFaceCategory;
        public FaceCategoryItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mFaceIcon = (ImageView) view.findViewById(R.id.face_icon);
            mFaceCategory = (TextView) view.findViewById(R.id.text_view_face_category);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mFaceCategory.getText() + "'";
        }
    }
}
