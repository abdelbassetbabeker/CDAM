package com.example.firstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataModel> {


    private Home homeInstance;
    private ArrayList<DataModel> data;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView price;
        TextView totalPrice;
        ImageView info;
        ImageView img;

        TextView qty;
        Button addQty;
        Button minsQty;
        Button addToShoppingButton;
    }

    public CustomAdapter(ArrayList<DataModel> data, Context context, Home homeInstance) {
        super(context, R.layout.row_item, data);
        this.data = data;
        this.mContext = context;
        this.homeInstance = homeInstance;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public DataModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);

            viewHolder.img = convertView.findViewById(R.id.img);  // Ensure proper initialization

            Glide.with(mContext)
                    .load(dataModel.getImageUrl())
                    .error(R.drawable.loadin_icon) // Placeholder for error case
                    .into(viewHolder.img);

            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
            viewHolder.price = (TextView) convertView.findViewById(R.id.price);
            viewHolder.qty = (TextView) convertView.findViewById(R.id.qty);
            viewHolder.addQty = (Button) convertView.findViewById(R.id.btnAdd);
            viewHolder.minsQty = (Button) convertView.findViewById(R.id.btnMinus);
            viewHolder.totalPrice = (TextView) convertView.findViewById(R.id.totalPrice);

            viewHolder.addToShoppingButton = (Button) convertView.findViewById(R.id.addToShoppingButton);


            viewHolder.minsQty.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle quantity decrement
                    dataModel.decrementQuantity();
                    notifyDataSetChanged();
                    if (homeInstance != null) {
                        homeInstance.showShoppingCart();
                    }
                }
            });
            viewHolder.addQty.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle quantity decrement
                    dataModel.incrementQuantity();
                    notifyDataSetChanged();
                    if (homeInstance != null) {
                        homeInstance.showShoppingCart();
                    }
                }
            });
            result = convertView;


            viewHolder.addToShoppingButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleAddToShoppingButtonClick(dataModel, viewHolder);
                }
            });

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }


        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtType.setText(dataModel.getType());
        viewHolder.price.setText(String.valueOf(dataModel.getQty() + " X " + dataModel.getPrice()));
        viewHolder.qty.setText(String.valueOf(dataModel.getQty()));
        viewHolder.totalPrice.setText(dataModel.getQty() * dataModel.getPrice() + " .OO DZD");


        RelativeLayout parentLayout = convertView.findViewById(R.id.RelativeLayout);
        RelativeLayout additionalDetails = convertView.findViewById(R.id.additionalDetails);

        TextView totalSelectedPrice = convertView.findViewById(R.id.totalSelectedPrice);
        Button addToShoppingButton = convertView.findViewById(R.id.addToShoppingButton);


        parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visibility = additionalDetails.getVisibility();
                additionalDetails.setVisibility(visibility == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }

    private void handleAddToShoppingButtonClick(DataModel dataModel, ViewHolder viewHolder) {
        dataModel.setSelected(!dataModel.isSelected());

        if (dataModel.isSelected()) {
            dataModel.setSelectedQuantity(dataModel.qty);
            viewHolder.addToShoppingButton.setBackgroundResource(R.drawable.remove_from_shopping_icon);
        } else {
            dataModel.setSelectedQuantity(0);
            viewHolder.addToShoppingButton.setBackgroundResource(R.drawable.addtoshopping_icon);

        }

        // Notify the adapter that the data set has changed
        notifyDataSetChanged();

        // Call showShoppingCart from Home class
        if (homeInstance != null) {
            homeInstance.showShoppingCart();
        }
    }
}