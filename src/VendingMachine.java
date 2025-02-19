import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
public class VendingMachine {
    public static void main(String[] args) throws Exception {

        try {

        int i = 0;
        int j = 0;
        int k = 0;

        double vendingLength = 0;
        boolean done = false;

        Scanner input = new Scanner(System.in);

        double[] orderArray = new double[99];
        int h = 0;
        double finalAnswer = 0;

        double change = 0;

        String[] letterArray = {"A", "B", "C", "D", "E"};

        String[][] vendingLayout = {
            {"Fritos", "Onion Rings", "UTZ Original", "Ruffles", "Mini Pretzels"},
            {"Lays Original", "Lays BBQ", "Lays SC&O", "Lays Lightly Salted", "Lays Wavy"},
            {"Nacho Doritos", "Ranch Doritos", "Chili Doritos", "Cheetos", "Spicy Cheetos"},
            {"Pop-Tart", "Cheez-its", "Granola Bar", "M&Ms", "Skittles"},
            {"Oreo Pack", "Hershey Bar", "Sour Patch Kids", "Snickers Bar", "Twix Bar"},
        };
        double[][] priceLayout = {
            {1.50, 1.25, 1.50, 1.25, 1.25},
            {1.50, 1.50, 1.50, 1.50, 1.50},
            {1.25, 1.25, 1.25, 1.25, 1.25},
            {1.25, 1.00, 1.00, 1.00, 1.00},
            {1.50, 1.25, 1.75, 1.25, 1.25}
        };

        NumberFormat formatter = new DecimalFormat("#0.00");

        while (!done) {
            while (i < 5) {
                while (j < 5) {
                    //vendingLength = vendingLayout[i][j].length() / 2;
                    // while ((vendingLength) > k) {
                    //     System.out.print(" ");
                    //     k++;
                    // }
                    // k = 0;

                    System.out.print(vendingLayout[i][j]);

                    while (j < 4) {
                        // while ((20 - vendingLength) > k) {
                        //     System.out.print(" ");
                        //     k++;
                        // }
                        // k = 0;
                        System.out.print(" | ");
                        break;
                    }
                    j++;
                }
                j = 0;
                //prints product name row

                
                System.out.println("");
                while (j < 5) {
                    vendingLength = vendingLayout[i][j].length();
                    //k = 4;
                    // while ((vendingLength) > k) {
                    //     System.out.print(" ");
                    //     k++;
                    // }
                    // k = 0;

                    System.out.print("$" + formatter.format(priceLayout[i][j]));
                    while (j < 4) {
                        k = 3;
                        while ((vendingLength) > k) {
                            System.out.print(" ");
                            k++;
                        }
                        k = 0;
                        System.out.print("| ");
                        break;
                    }
                    j++;
                }
                j = 0;
                //prints price row


                System.out.println("");
                while (j < 5) {
                    // k = 1;
                    // while ((vendingLength) > k) {
                    //     System.out.print(" ");
                    //     k++;
                    // }
                    // k = 0;

                    System.out.print(letterArray[i] + (j+1));
                    k = 1;
                    while (j < 4) {
                        while ((vendingLength) > k) {
                            System.out.print(" ");
                            k++;
                        }
                        k = 0;
                        System.out.print(" | ");
                        break;
                    }
                    j++;
                }
                j = 0;
                //prints label row

                System.out.println("");
                System.out.println("");
                i++;
            }
        
            System.out.println("Select what would you like, then type 'exit' to finish.");
            String in = input.nextLine().toUpperCase();
            //System.out.println(in.length());
            //System.out.println(in);

            if (in.length() < 2) {
                in = "exit";
            }

            if ("EXIT".equals(in)) {
                done = true;
                if (finalAnswer <= 0 && orderArray[0] == 0) {
                    System.out.println("Your total is $" + formatter.format(finalAnswer));
                    System.out.println("Your change is $" + formatter.format(change));
                    System.out.println("Goodbye!");
                    break;
                }
                while (h >= 0) {
                    finalAnswer = finalAnswer + orderArray[h];
                    h--;
                }
                System.out.println("Your total is $" + formatter.format(finalAnswer));
                System.out.println("Please Insert money ($1 bills accepted only)");
                int totalMoney = 0;
                int bill;
        
                while (true) {
                    bill = input.nextInt();
                    if (bill == 1) {
                        totalMoney += bill;
                        System.out.println("Total inserted: $" + formatter.format(totalMoney));
                        if (totalMoney >= finalAnswer) {
                            change = totalMoney - finalAnswer;
                            System.out.println("Thank you for your purchase! Your change is $" + formatter.format(change));
                        }
                    } else {
                        System.out.println("Only $1 bills are accepted, use the '1' key to place bills inside");
                    }
                }
                // Check if user has enough money

            } else if (in.length() == 2) {
                if (in.charAt(0) == 'A') {
                    j = 0;
                } else
                if (in.charAt(0) == 'B') {
                    j = 1;
                } else
                if (in.charAt(0) == 'C') {
                    j = 2;
                } else
                if (in.charAt(0) == 'D') {
                    j = 3;
                } else
                if (in.charAt(0) == 'E') {
                    j = 4;
                } else {
                    //j = 4;
                    in = "exit";
                }

                if (in.charAt(1) == 1 || in.charAt(1) == 2 || in.charAt(1) == 3 || in.charAt(1) == 4 || in.charAt(1) == 5) {
                    i = Integer.parseInt(String.valueOf(in.charAt(1)));
                } else {
                    i = 5;
                }
                i = i - 1;
                // System.out.println(j);
                // System.out.println(i);
                // System.out.println(priceLayout[j][i]);
                
                if (in.length() == 2) {
                    orderArray[h] = priceLayout[j][i];
                    h++;
                }
                i = 0;
                j = 0;
                System.out.println("");
                System.out.println("---------------");
            }
        }
        
        input.close();

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("java.lang.StringIndexOutOfBoundsException");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException f) {
            System.out.println("java.lang.ArrayIndexOutOfBoundsException");
            f.printStackTrace();
        } catch (IndexOutOfBoundsException g) {
            System.out.println("java.lang.IndexOutOfBoundsException");
            g.printStackTrace();
        } catch (NumberFormatException h) {
            h.printStackTrace();
        }
    }