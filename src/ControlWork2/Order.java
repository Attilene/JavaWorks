package ControlWork2;

import java.util.ArrayList;

public class Order {
    private ArrayList<Sale_Product> order_products;
    private int table_number;
    private double sum_order = 0;
    public boolean isPaid;

    public Order(int table_number, ArrayList<Sale_Product> order_products) {
        this.table_number = table_number;
        this.order_products = order_products;
        isPaid = false;
    }

    public double getSum_order() {
        for (Sale_Product product: order_products) {
            sum_order += product.getPrice() * product.getAmount();
        }
        return sum_order;
    }

    public ArrayList<Sale_Product> getOrder_products() {
        return order_products;
    }

    public int getTable_number() {
        return table_number;
    }
}
