package com.ciastis.shoppingcart;

public class LineItem {
    private Item item;
    private int quantity;

    public LineItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Item getItem() {
        return this.item;
    }
}
