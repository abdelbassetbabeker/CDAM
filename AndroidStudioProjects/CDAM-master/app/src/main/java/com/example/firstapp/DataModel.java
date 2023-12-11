package com.example.firstapp;

public class DataModel {

    String name;
    String type;
    Integer price;
    String feature;
    String img;
    Integer maxqty;

    Integer qty = 0;

    Integer selectedQuantity = 0;


    private boolean isSelected;


    public DataModel(String name, String type, Integer price, String feature, String img, Integer maxqty) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.feature = feature;
        this.img = img;
        this.maxqty = maxqty;
    }

    public String getImageUrl() {
        return img;
    }

    public void setImageUrl(String imageUrl) {
        this.img = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQty() {
        return qty;
    }

    public String getFeature() {
        return feature;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getSelectedQuantity() {
        return selectedQuantity;
    }

    public void setSelectedQuantity(int selectedQuantity) {
        this.selectedQuantity = selectedQuantity;
    }

    public int getTotalPrice() {
        return getPrice() * selectedQuantity;
    }

    public void incrementQuantity() {
        if (qty <= maxqty) {
            qty++;
        }
    }

    public void decrementQuantity() {
        if (qty > 0) {
            qty--;
        }
    }


}