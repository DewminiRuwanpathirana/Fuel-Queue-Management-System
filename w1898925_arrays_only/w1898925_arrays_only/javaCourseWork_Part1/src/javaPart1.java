import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class javaPart1 {
    //Declaring an array to store customers
    static String array1[] = new String[6];
    static String array2[] = new String[6];
    static String array3[] = new String[6];

    //to count the number of elements in each queue
    static int count1 = 0, count2 = 0, count3 = 0;

    //to get customer's names
    static String rName;

    //to store integer values
    static int fuelStock = 6600, addFuelStock = 0, indexOf, queuee = 0, servedCustomer, minQueue,n;

    //to copy the array elements for sorting method
    static String sNames1[] = new String[6];
    static String sNames2[] = new String[6];
    static String sNames3[] = new String[6];


    public static void main(String[] args) {
        //while loop for loop entire program
        while (true) {
            //MENU
            System.out.println("""
                                        
                    -----------------MENU-----------------
                    Enter 100 or VFQ:- To View all Fuel Queues.
                    Enter 101 or VEQ:- To View all Empty Queues.
                    Enter 102 or ACQ:- To Add customer to a Queue.
                    Enter 103 or RCQ:- To Remove a customer from a Queue. (From a specific location)
                    Enter 104 or PCQ:- To Remove a served customer.
                    Enter 105 or VCS:- To View Customers Sorted in alphabetical order (Do not use library sort routine)
                    Enter 106 or SPD:- To Store Program Data into file.
                    Enter 107 or LPD:- To Load Program Data from file.
                    Enter 108 or STK:- To View Remaining Fuel Stock.
                    Enter 109 or AFS:- To Add Fuel Stock.
                    Enter 999 or EXT:- To Exit the Program.
                    -----------------------------------------                  
                    """);

            Scanner get = new Scanner(System.in);
            System.out.print("Enter the option: ");
            String option = get.nextLine().toUpperCase();

            switch (option) {
                // View all Fuel Queues
                case "100":
                case "VFQ":
                    System.out.println("View all Fuel Queues");
                    if (fuelStock <= 500)
                        System.out.println("WARNING! The remaining fuel stock is: " + fuelStock);

                    viewAllQueues(1,array1);
                    viewAllQueues(2,array2);
                    viewAllQueues(3,array3);
                    break;

                // View all Empty Queues
                case "101":
                case "VEQ":
                    System.out.println("View all Empty Queues");
                    System.out.println();
                    NoOfElements();
                    viewAllEmptyQueues();
                    break;

                //Add customer to a Queue
                case "102":
                case "ACQ":
                    System.out.println("Add customer to a Queue");
                    NoOfElements();
                    minQueue();
                    System.out.print("Enter the name: ");
                    String name = get.next();
                    System.out.println();

                    if (minQueue == 1) {
                        array1[count1] = name;
                    } else if (minQueue == 2) {
                        array2[count2] = name;
                    } else if (minQueue == 3) {
                        array3[count3] = name;
                    }
                    System.out.println(name + " is successfully added to the queue!");
                    fuelStock = fuelStock - 10;
                    break;

                //Remove a customer from a Queue
                case "103":
                case "RCQ":
                    System.out.println("Remove a customer from a Queue.");
                    viewAllQueues(1,array1);
                    viewAllQueues(2,array2);
                    viewAllQueues(3,array3);
                    System.out.println();

                    System.out.print("From which queue,do you want to remove the customer(1 or 2 or 3): ");
                    queuee = get.nextInt();
                    System.out.print("Enter the name: ");
                    rName = get.next();

                    if (queuee == 1) {
                        findIndex(array1);
                        removeElementAndShift(array1, indexOf,1);
                    }
                    if (queuee == 2) {
                        findIndex(array2);
                        removeElementAndShift(array2, indexOf,2);
                    }
                    if (queuee == 3) {
                        findIndex(array3);
                        removeElementAndShift(array3, indexOf,3);
                    }
                    System.out.println("Successfully removed the customer!");
                    fuelStock = fuelStock + 10;
                    break;

                //Remove a served customer
                case "104":
                case "PCQ":
                    System.out.println("Remove a served customer");
                    System.out.print("From which queue,do you want to remove the customer(1 or 2 or 3): ");
                    servedCustomer = get.nextInt();

                    if (servedCustomer == 1) {
                        removeElementAndShift(array1, 0,1);
                    }
                    if (servedCustomer == 2) {
                        removeElementAndShift(array2, 0,2);
                    }
                    if (servedCustomer == 3) {
                        removeElementAndShift(array3, 0,3);
                    }

                    System.out.println("Successfully removed the served customer!");
                    break;

                //View Customers Sorted in alphabetical order
                case "105":
                case "VCS":
                    NoOfElements();
                    System.out.println("View Customers Sorted in alphabetical order (Do not use library sort routine)");
                    sortCustomers(count1, array1, sNames1,1);
                    sortCustomers(count2, array2, sNames2,2);
                    sortCustomers(count3, array3, sNames3,3);
                    break;

                // Store Program Data into file
                case "106":
                case "SPD":
                    System.out.println("Store Program Data into file");
                    fileWrite();
                    System.out.println("Data successfully stored into the file! ");
                    break;

                // Load Program Data from file
                case "107":
                case "LPD":
                    System.out.println("Load Program Data from file");
                    fileRead();
                    break;

                // View Remaining Fuel Stock
                case "108":
                case "STK":
                    System.out.println("View Remaining Fuel Stock");
                    System.out.println("Fuel stock is: " + fuelStock);
                    break;

                //Add Fuel Stock
                case "109":
                case "AFS":
                    System.out.println("Add Fuel Stock");
                    System.out.print("How much fuel liters do you want to add: ");
                    addFuelStock = get.nextInt();

                    fuelStock();
                    break;

                // Exit the Program
                case "999":
                case "EXT":
                    System.out.println("Exit the Program");
                    System.out.println("Thank you!");
                    return;

                //if the user enter invalid option
                default:
                    System.out.println("Invalid option.Please try again.");
                    break;


            }
        }
    }

    //method for count number of elements in the array
     static void NoOfElements() {
        count1 = 0;
        for (int a = 0; a < array1.length; a++) {
            if (array1[a] != null) {
                count1++;
            }
        }
        count2 = 0;
        for (int a = 0; a < array2.length; a++) {
            if (array2[a] != null)
                count2++;
        }

        count3 = 0;
        for (int a = 0; a < array3.length; a++) {
            if (array3[a] != null)
                count3++;
        }
    }

    //method for print three queues
     static void viewAllQueues(int numb, String[] arrayy) {
         System.out.println();
         System.out.println("QUEUE " + numb + ": ");
         for(int i=0;i<arrayy.length;i++)
             if (arrayy[i] != null){
                System.out.println("customer" + (i+1) + "- " +arrayy[i]);}
    }

    //method for print all the empty queues
    static void viewAllEmptyQueues(){
        if (count1 <= 5){
            System.out.println("QUEUE 1 - empty space count is:" + (6 - count1));
            System.out.println("QUEUE 1: " + Arrays.toString(array1).replace("[", "").replace("]", "").replace("null", "").replace(",", "  "));
            System.out.println();}
        if (count2 <= 5){
            System.out.println("QUEUE 2 - empty space count is:" + (6 - count2));
            System.out.println("QUEUE 2: " + Arrays.toString(array2).replace("[", "").replace("]", "").replace("null", "").replace(",", "  "));
            System.out.println();}
        if (count3 <= 5){
            System.out.println("QUEUE 3 - empty space count is:" + (6 - count3));
            System.out.println("QUEUE 3: " + Arrays.toString(array2).replace("[", "").replace("]", "").replace("null", "").replace(",", "  "));
            System.out.println();}
        else
            System.out.println("NO empty queues!");
    }

    //method for find minimum queue
    static void minQueue() {
        System.out.println();
        for (int i = 0; i <= 6; i++) {
            if (count1 == i) {
                minQueue = 1;
                break;
            } else if (count2 == i) {
                minQueue = 2;
                break;
            } else if (count3 == i) {
                minQueue = 3;
                break;
            }
        }
    }

    //method for count remaining fuel count
     static void fuelStock() {
        fuelStock = addFuelStock + fuelStock;
        System.out.println("Available fuel stock is: " + fuelStock);
    }


    //method for remove element from the queue and shift other elements.
    // reference: https://howtodoinjava.com/java/array/removing-items-from-array/
    static void removeElementAndShift(String[] arrayName, int indexToRemove, int num) {
        for (int x = indexToRemove; x < arrayName.length - 1; x++) {
            arrayName[x] = arrayName[x + 1];
        }
        System.out.println();
        System.out.println("NEW PUMP "+ num +" Queue: " + Arrays.toString(arrayName).replace("[", "").replace("]", "").replace("null", "").replace(",", "  "));

    }

    //method for sort customer's names
     static void sortCustomers(int count, String[] arrays, String[] sNames,int number) {
        String test1;
        for (int b = 0; b <= count; b++) {
            sNames[b] = arrays[b];
        }

        for (int c = 0; c < count; c++) {
            for (int d = c + 1; d < count; d++) {
                if (sNames[c].compareTo(sNames[d]) > 0) {
                    test1 = sNames[c];
                    sNames[c] = sNames[d];
                    sNames[d] = test1;
                }
            }
        }
        System.out.println("Sorted queue "+ number +": " + Arrays.toString(sNames).replace("[", "").replace("]", "").replace("null", "").replace(",", "  "));
    }

    //method for write to the file
    static void fileWrite(){
        try {
            FileWriter writer = new FileWriter("files.txt");
            writer.write("\nRemaining fuel stock is:" + fuelStock);
            writer.write("\nPUMP 1 Queue: " + Arrays.toString(array1).replace("[", "").replace("]", "").replace("null", "").replace(",", " "));
            writer.write("\nPUMP 2 Queue: " + Arrays.toString(array2).replace("[", "").replace("]", "").replace("null", "").replace(",", " "));
            writer.write("\nPUMP 3 Queue: " + Arrays.toString(array3).replace("[", "").replace("]", "").replace("null", "").replace(",", " "));

            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //method for read from file
    static void fileRead(){
        File file = new File("files.txt");
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //method for find customer's location from queue
     static void findIndex(String[] arrayss) {
        for (int i = 0; i < arrayss.length; i++) {
            if (arrayss[i] != null) {
                if (arrayss[i].equals(rName)) {
                    indexOf = i;

                }
            }
        }

    }
}
