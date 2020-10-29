package ControlWork2;

import java.util.ArrayList;

public class System_Cafe {
    ArrayList<Order> orders;
    ArrayList<Menu> menu;
    ArrayList<Menu> stop_list;

    public System_Cafe() {
        orders = new ArrayList<>();
        menu = new ArrayList<>();
        stop_list = new ArrayList<>();
    }

    public void create_Menu(ArrayList<Menu> menu) {
        this.menu = menu;
    }

    public void add_Product_Menu(Menu product) {
        menu.add(product);
    }

    public void remove_Product_Menu(Menu product) {
        menu.remove(product);
    }

    public void add_Stop_List(Menu product) {
        stop_list.add(product);
    }

    public void remove_Stop_List(Menu product) {
        stop_list.remove(product);
    }

    public void create_Order(int table_number, ArrayList<Sale_Product> products) {
        Order order;
        ArrayList<Sale_Product> res = new ArrayList<>();
        for (Sale_Product product: products) {
            if (!stop_list.contains(product)) res.add(product);
        }
        order = new Order(table_number, res);
        orders.add(order);
    }

    public void description_Order(Order order) {
        String status;
        if (order.isPaid) status = "Paid";
        else status = "Not paid";
        System.out.println("Number of table:" + order.getTable_number());
        System.out.println();
        for (Sale_Product product: order.getOrder_products()) {
            System.out.println("Name: " + product.getName());
            System.out.println("Price for one: " + product.getPrice());
            System.out.println("Amount: " + product.getAmount() + " " + product.getUnit());
            System.out.println("Composition: " + product.getComposition());
            System.out.println("Is gived: " + product.isGive);
            System.out.println();
        }
        System.out.println("Final sum of order: " + order.getSum_order());
        System.out.println("Status: " + status);
    }

    public void close_Order(Order order) {
        order.isPaid = true;
        orders.remove(order);
    }

    public boolean give_Product(int table_number, Sale_Product product) {
        for (Order order: orders)
            if (order.getTable_number() == table_number)
                for (Sale_Product prod: order.getOrder_products())
                    if (prod == product) {
                        prod.isGive = true;
                        return true;
                    }
        return false;
    }

    public ArrayList<Menu> getMenu() {
        return menu;
    }

    public ArrayList<Menu> getStop_list() {
        return stop_list;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public static void main(String[] args) {
        Menu wine1 = new Bar("wine1", 53, "l", "sdfdgfhgjhkb,n");
        Menu product1 = new Kitchen("salad", 100, "shtuka", "sdfdgklfetrtyn");
        Menu wine2 = new Bar("wine2", 1203, "l", "sdtfygkdtfbdfhjt,fbrent");
        Menu product2 = new Kitchen("soup", 20, "shtuka", "opiuewr");
        System_Cafe system = new System_Cafe();
        ArrayList<Menu> menu = new ArrayList<>();
        menu.add(wine1);
        menu.add(product1);
        menu.add(wine2);
        menu.add(product2);
        system.create_Menu(menu);
        system.add_Stop_List(wine2);
        ArrayList<Menu> order_list = new ArrayList<>();
        Menu wine = new Sale_Product("wine2", 1203, "l", 3, "sdtfygkdtfbdfhjt,fbrent");
        Menu salad = new Sale_Product("salad", 100, "shtuka", 3, "sdfdgklfetrtyn");
//        Order order1 = new Order(4, )
    }
}
