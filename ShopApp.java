import java.util.Scanner;

public class ShopApp { 

    public static void main(String[] args) { 

        System.out.println("Student ID:3010123");
        System.out.println("Welcome and Here we Proceed ,What you wanna do ?");

        Scanner input = new Scanner(System.in); 

        Product[] products = new Product[5];

        products[0] = new Product("Laptop",11, 120.99); 
        products[1] = new Product("Headphone", 16, 152.99); 
        products[2] = new Product("Keyboard", 23, 25.99);
        products[3] = new Product("Smartwatch", 32, 99.99); 
        products[4] = new Product("Camera", 9, 588.99);

        int choice = 0; 

        while (choice != 6) { 

            System.out.println("\n1. Display all products"); // MENU OPTION
            System.out.println("2. Buy stock"); 
            System.out.println("3. Sell stock");
            System.out.println("4. Re-price product");
            System.out.println("5. Display total stock value");
            System.out.println("6. Exit");

            System.out.print("Enter your choice in number(1-6) : "); // PROMT USER
            choice = input.nextInt(); // READ USER CHOICE

            if (choice == 1) { 
                for (int i = 0; i < products.length; i++) { // LOOP THROUGH ARAY
                    System.out.println(i + ": " + products[i].getName() +
                            " | Stock: " + products[i].getStockLevel() +
                            " | Price: £" + products[i].getPrice()); 
                }
            }

            if (choice == 2) {
                System.out.print(" Which product Stock You wanna buy : "); // ASKING FOR PRODUCT 
                int index = input.nextInt();

                if (index >= 0 && index < products.length) {
                    System.out.print("Enter amount to buy: ");
                    int amount = input.nextInt(); 
                    double value = products[index].buyStock(amount);
                    System.out.println("Stock bought value: £" + value); 
                } else {
                    System.out.println("Invalid product index");
                }
            }

            if (choice == 3) { // SELL STOCKS
                System.out.print("WHich Product Stock you wanna sell? : "); // ASKING FOR INDEX
                int index = input.nextInt(); 

                if (index >= 0 && index < products.length) { 
                    System.out.print("Enter amount : ");
                    int amount = input.nextInt(); // READ AMOUNT
                    boolean success = products[index].sell(amount); 
                   System.out.println(success ? "Sale successful" : "Not enough stock"); 
                } else {
                    System.out.println("Invalid product index"); 
                }
            }

            if (choice == 4) { 
                System.out.print("Which Product price You wanna chnage? : "); // ASKING FOR INDEX
                int index = input.nextInt(); // READ INDEX

                if (index >= 0 && index < products.length) { 
                    System.out.print("Enter new price: "); 
                    double price = input.nextDouble(); 
                    products[index].setPrice(price); 
                    System.out.println("Price have been Updated successfully"); // CONFIRMATION
                } else {
                    System.out.println("Invalid product index"); 
                }
            }

            if (choice == 5) { 
                double totalValue = 0; // STORING THE TOTAL VALUE
                for (int i = 0; i < products.length; i++) { 
                    totalValue += products[i].getStockLevel() * products[i].getPrice(); 
                }
                System.out.println("Total stock value: £" + totalValue); 
            }
        }

        input.close(); // Close Scanner
        System.out.println("Program ended"); // EXIT MESSAGE
        System.out.println("Thank you");
    }

}




