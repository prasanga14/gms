import java.util.ArrayList;
import java.util.Scanner;

public class Billing {
    //to store the products array in productLists
    public static ArrayList<Product> productLists = Product.addProducts();
    public static void main(String[] args) {
        // Creating variables
        String id = null;
        int quantity = 0;
        double price = 0.0;
        double totalPrice = 0.0;
        double overAllPrice = 0.0;
        double subtotal = 0.0, discount = 0.0;
        char choice = '\0';

        // Firstly to display a format for product lists
        Product.productsDisplayFormat();

        //Advanced for loop to print all items of productLists;
        for(Product p : productLists){
            p.displayProduct();
        }
        //For spacing
        System.out.println("");

    // Taking name id and address of customer using scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Customer Address: ");
        String customerAddress = scanner.nextLine();

        Customer customer = new Customer(customerId, customerName, customerAddress);
        System.out.println("");
        
        System.out.println("\t\t\t\t--------------------Invoice-----------------");
        System.out.println("\t\t\t\t\t " + "  " + " \tA to Z Grocery Shop");
        System.out.println("\t\t\t\t\t\t  \tBalaju-8, kathmandu");
        System.out.println("Name: " + customer.getCustomerName() + "\n" + "Address: " + customer.getAddress());

        //Creating an ArrayList to store products that customer buys
        ArrayList<Product> customerProducts = new ArrayList<>();

        //Creating a do while loop so customer can buy goods at least once or until he says no

        do{
            System.out.print("Enter Product ID: ");
            id = scanner.nextLine();

            System.out.print("Enter Quantity: ");
            quantity = scanner.nextInt();
            //Calculate total price for each product
            totalPrice = getTotalPrice(productLists, id, quantity);


                if(totalPrice == -2){
                    System.out.println("Quantity Exceeds available Stock");

                }else if(totalPrice == -1){
                    System.out.println("No Product with id " + id + " Found!");
                    continue;

                }
            //calculates overall price
            overAllPrice = overAllPrice + totalPrice;

            //creates Product class object and add it to the List
            buildProductObject(id, quantity, totalPrice, productLists, customerProducts);

            //To add more items
            System.out.print("Wanna Continue (Y/N): ");
            choice = scanner.next().charAt(0);
            scanner.nextLine();

            //Display all products to continue buying
            Product.productsDisplayFormat();
            for (Product p : productLists){
                p.displayProduct();
            }

            System.out.println("");

        } while (choice == 'Y' || choice == 'y');

        Product.invoiceDisplayFormat();
        for (Product p: customerProducts){
            p.display();
        }
        //price calculation
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t                Total Amount (Rs.) " + overAllPrice);
        //calculating discount
        discount = overAllPrice * 2 / 100;
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t                Discount (Rs.) " + discount);
        //total amount after discount
        subtotal = overAllPrice - discount;
        //calculating amount to be paid by buyer
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t                Invoice Total " + (subtotal));
        System.out.println("\t\t\t\t--------------------------Thank You for Shopping!!---------------------------");
        System.out.println("\t\t\t\t                               Visit Again");

    }
    
    // Function to build the array of products bought by customer
    public static void buildProductObject(String id, int quantity, double totalPrice, ArrayList<Product> productLists, ArrayList<Product> customerProducts){
    for (int i = 0; i < productLists.size(); i++){
        if (productLists.get(i).getId().equals(id)){
        customerProducts.add(new Product(id, productLists.get(i).getProductName(), quantity, productLists.get(i).getPrice(), totalPrice));
        }
    }
    }
    //Function to get Total Price
    public static double getTotalPrice(ArrayList<Product> productLists, String id, int quantity){
       for (int i = 0; i < productLists.size(); i++){
           if(productLists.get(i).getId().equals(id)){
               if (productLists.get(i).getQuantity() >= quantity){
                   reduceProductQuantityFromStock(i,productLists.get(i),quantity);
                   return productLists.get(i).getPrice() * quantity;
               } else {
                   return -2;
               }
           }
       }
        return -1;
    }
    // Function to reduce stock quantity from product
    private static void reduceProductQuantityFromStock(int index, Product customerProducts, int quantity) {
        customerProducts.setQuantity(customerProducts.getQuantity() - quantity);
        productLists.set(index, customerProducts);
    }
}

