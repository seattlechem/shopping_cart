package com.ciastis.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<LineItem> items = new ArrayList();

    public List<LineItem> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for(LineItem each_item: items) {
            BigDecimal quant = new BigDecimal(each_item.getQuantity());
            total = total.add(quant.multiply(each_item.getItem().getPrice()));
        }
        return total;
    }

    public void addItem(Item item, int quant) {
        LineItem item_to_add = new LineItem(item, quant);
        items.add(item_to_add);
    }

    public List<String> getItemQuantity() {
        ArrayList<String> result = new ArrayList<>();
        for(LineItem each_item: items) {
            String itemName = each_item.getItem().getItemName();
            String itemQty = Integer.toString(each_item.getQuantity());
            result.add(String.format("%s - Qty: %s", itemName, itemQty));
        }
        return result;

    }
}
