import java.util.ArrayList;

public class Product {
    private String id;
    private String productName;
    private int quantity;
    private double price;
    private double totalPrice;

    public Product(String id, String productName, int quantity, double price, double totalPrice) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public Product(String id, String productName, int quantity, double price) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static void productsDisplayFormat(){
        System.out.println("---------------------------Product List-----------------------------------");
        System.out.format("---------------------------------------------------------------------------");
        System.out.print("\nProduct ID \t\tName\t\t\t  Rate\t\t\t Quantity\n");
        System.out.format("---------------------------------------------------------------------------\n");
    }

    public static void invoiceDisplayFormat()
    {
        System.out.format("------------------------------------------------------------------------------------------");
        System.out.print("\nProduct ID \t\tProduct Name\t Quantity\t\t\tRate\t\t\t\tTotal Price\n");
        System.out.format("------------------------------------------------------------------------------------------\n");
    }
    //Final Display
    public void display()
    {
        System.out.format("%5s %17s %14s %17s %20s\n" ,id, productName, quantity, price, totalPrice);
    }

    // To display items on arraylist
    public void displayProduct(){
        System.out.format("%5s %17s %14s %17s\n" ,id, productName, price, quantity);
    }
    /*
     Creating arraylist with datatype Product which is a constructor so, we don't have to initialize object everytime and also
     storing it to addProducts method that returns all products
     */

    public static ArrayList<Product> addProducts(){
    ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("1", "Apple", 100, 10));
        products.add(new Product("2", "Biscuit", 200, 10));
        products.add(new Product("3", "Chips", 300, 100));
        products.add(new Product("4", "Cold Drinks", 90, 70));
        products.add(new Product("5", "Batteries", 50, 10));
        products.add(new Product("6", "Cooking oil", 10, 200));
        products.add(new Product("7", "Chocolates", 100, 50));
        products.add(new Product("8", "Shampoo", 100, 500));
        products.add(new Product("9", "Soap", 100, 20));
        products.add(new Product("10", "Detergent", 100, 180));
    return products;
    }
}

