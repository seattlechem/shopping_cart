package com.ciastis.shoppingcart;

import java.math.BigDecimal;

public class Item {
    private String name;
    private BigDecimal price;
    private boolean onSale;

    public Item(String name, BigDecimal price, boolean onSale) {
        this.name = name;
        this.price = price;
        this.onSale = onSale;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getItemName() {
        return this.name;
    }
}
