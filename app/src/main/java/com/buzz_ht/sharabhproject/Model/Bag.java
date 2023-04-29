package com.buzz_ht.sharabhproject.Model;

public class Bag {

    String bagName;
    String bagDimensions;
    String color;
    String price;
    String availability;
    int image;
    String currentQuantity;

    public Bag() {
    }

    public Bag(String bagName, String bagDimensions, String color, String price, String availability, int image, String currentQuantity) {
        this.bagName = bagName;
        this.bagDimensions = bagDimensions;
        this.color = color;
        this.price = price;
        this.availability = availability;
        this.image = image;
        this.currentQuantity = currentQuantity;
    }

    public String getBagName() {
        return bagName;
    }

    public void setBagName(String bagName) {
        this.bagName = bagName;
    }

    public String getBagDimensions() {
        return bagDimensions;
    }

    public void setBagDimensions(String bagDimensions) {
        this.bagDimensions = bagDimensions;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(String currentQuantity) {
        this.currentQuantity = currentQuantity;
    }
}

