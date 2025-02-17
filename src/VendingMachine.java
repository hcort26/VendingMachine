import java.util.Scanner;
public class VendingMachine {
    public static void main(String[] args) throws Exception {

        int i = 0;
        int j = 0;

        String[] letterArray = {"A", "B", "C", "D", "E"};

        String[][] vendingLayout = {
            {"Pop Tart", "Hershey Bar", "Sour Patch Kids", "Mini Pretzels", "Placeholder"},
            {"Lays", "Lays BBQ", "Turkey", "Bison", "Black Bean"},
            {"Nacho Cheese Doritos", "Chedder", "Swiss", "Provaloan", "Blue"},
            {"Buffalo Sauce", "Ketchup", "Mustard", "Mayo", "Special Sauce"},
            {"Rare", "Medium Rare", "Medium", "Medium-Well", "Burnt"},
        };

        double[][] priceLayout = {
            {1.50, 1.00, 1.50, 1.00, 1.00},
            {1.25, 1.25, 1.00, 1.00, 1.00},
            {1.25, 1.25, 1.25, 1.25, 1.25},  
            {1.00, 1.00, 1.00, 1.00, 1.00},  
            {1.50, 1.50, 1.50, 1.50, 1.50}   
        };
        
        while (i < 5) {
            while (j < 4) {
                System.out.print(vendingLayout[i][j]);
                while (j < 3) {
                    System.out.print(" | ");
                    break;
                }
                j++;
            }
            j = 0;
               
            System.out.println("");
            while (j < 5) {
                System.out.print("$" + priceLayout[i][j]);
                while (j < 4) {
                    System.out.print("   | ");
                    break;
                }
                j++;
            }
            j = 0;

            System.out.println("");
            while (j < 5) {
                System.out.print(letterArray[i] + (j+1));
                while (j < 4) {
                    System.out.print("   | ");
                    break;
                }
                j++;
            }
            j = 0;

            System.out.println("");
            System.out.println("");
            i++;
        }

        System.out.println("Enter the code for the snack you want (e.g., A1, B2):");
        Scanner input = new Scanner(System.in);
        String choice = input.next().toUpperCase();

        // Convert choice to row and column index
        int row = choice.charAt(0) - 'A'; 
        int col = Character.getNumericValue(choice.charAt(1)) - 1;

        // Validate input
        if (row >= 0 && row < vendingLayout.length && col >= 0 && col < vendingLayout[row].length) {
            System.out.println("You selected: " + vendingLayout[row][col] + " - $" + priceLayout[row][col]);
        } else {
            System.out.println("Invalid selection. Please try again.");
            return; 
        } 

        System.out.println("Insert money ($1 bills only). Enter 0 when finished:");
        int totalMoney = 0;
        int bill;

        while (true) {
            bill = input.nextInt();
            if (bill == 0) break; 
            if (bill == 1) {
                totalMoney += bill;
                System.out.println("Total inserted: $" + totalMoney);
            } else {
                System.out.println("Only $1 bills are accepted.");
            }
        }

        // Check if user has enough money
        if (totalMoney >= priceLayout[row][col]) {
            double change = totalMoney - priceLayout[row][col];
            System.out.println("Thank you for your purchase! Your change is $" + change);
        } else {
            System.out.println("Insufficient funds. Please insert more money.");
        }

    }
}
