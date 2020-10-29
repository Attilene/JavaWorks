package ControlWork2;

public class Sale_Product extends Menu{
    private final double amount;
    public boolean isGive;

    public Sale_Product(String name, int price, String unit, int amount, String composition) {
        super(name, price, unit, composition);
        this.amount = amount;
        isGive = false;
    }

    public double getAmount() {
        return amount;
    }
}
