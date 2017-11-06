package edu.umbc.dmutlu1.bikerentaldem;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final ArrayList<Bike> dataSet;
    private final LinkHandler handler;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        final TextView mTextView;
        final ImageView imageViewIcon;
        final FloatingActionButton mFAB;

        public ViewHolder(View v) {
            super(v);

            this.mTextView = itemView.findViewById(R.id.textViewName);
            this.imageViewIcon = itemView.findViewById(R.id.imageView);
            this.mFAB = itemView.findViewById(R.id.floatingActionButton);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<Bike> myDataset, LinkHandler handler) {
        dataSet = myDataset;
        this.handler = handler;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bike_cards, parent, false);

        // set the view's size, margins, paddings and layout parameters

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(dataSet.get(position).getName());
        holder.imageViewIcon.setImageResource(dataSet.get(position).getImage());

        holder.mFAB.setOnClickListener(view -> handler.openLink());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}