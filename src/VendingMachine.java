import java.util.Scanner;
public class VendingMachine {
    public static void main(String[] args) throws Exception {
    // Snacks:
<<<<<<< HEAD
        double doritos = 1.25;
        double chocolate = 1.00;
        double sourpatchkids = 1.00;
        double lays = 1.25;
        double poptart = 1.50;
=======
        // double doritos = 1.25;
        // double chocolate = 1.00;
        // double sourpatchkids = 1.00;
        // double lays = 1.25;
        // double poptart = 1.50;
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
            {1.25, 1.25}
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

        
>>>>>>> 1323a54011f9983b889bcffcdb3241b68fb7e23c
        System.out.println("What would you like");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        
<<<<<<< HEAD

=======
        input.close();
>>>>>>> 1323a54011f9983b889bcffcdb3241b68fb7e23c
    }
}