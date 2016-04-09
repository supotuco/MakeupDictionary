package com.bearbao.makeupdictionary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bearbao.makeupdictionary.ProductItemFragment.OnProductFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnProductFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyProductItemRecyclerViewAdapter extends RecyclerView.Adapter<MyProductItemRecyclerViewAdapter.ViewHolder> {

    private final List<ProductItem> mValues;
    private final OnProductFragmentInteractionListener mListener;

    public MyProductItemRecyclerViewAdapter(List<ProductItem> items, OnProductFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_productitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mProductImage.setImageResource(mValues.get(position).getProduct_pic_id());
        holder.mProductName.setText(mValues.get(position).getProduct());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onProductFragmentInteraction(holder.mItem.getProduct());
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
        public final ImageView mProductImage;
        public final TextView mProductName;
        public ProductItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mProductImage = (ImageView) view.findViewById(R.id.product_icon);
            mProductName = (TextView) view.findViewById(R.id.product_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mProductName.getText() + "'";
        }
    }
}
