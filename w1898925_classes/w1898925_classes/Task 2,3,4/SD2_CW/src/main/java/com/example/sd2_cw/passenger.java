package com.example.sd2_cw;
import java.io.*;
import java.util.Scanner;

public class passenger {
    //Declaring an array to store customers
    public static FuelQueue queue1[] = new FuelQueue[6];
//    public static FuelQueue queue2[] = new FuelQueue[6];
//    public static FuelQueue queue3[] = new FuelQueue[6];
//    public static FuelQueue queue4[] = new FuelQueue[6];
//    public static FuelQueue queue5[] = new FuelQueue[6];

    //Waiting queue
    public static FuelQueue waitingQueue[] = new FuelQueue[6600];

    //to copy the array elements for sorting method
    static String sNames1[] = new String[6];
    static String sNames2[] = new String[6];
    static String sNames3[] = new String[6];
    static String sNames4[] = new String[6];
    static String sNames5[] = new String[6];

    //To store input values
    static String fName = null;
    static String sName = null;
    static String vehicleNo = null;
    static int noOfLiters = 0;

    public static int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, minQueue = 0, pump1Income = 0, pump2Income = 0, pump3Income = 0, pump4Income = 0, pump5Income = 0, fuelStock = 6600, addFuelStock = 0, indexOf, queuee = 0, servedCustomer;

    //to get customer's names
    static String rName;

    //main method
    public static void mainMethod() {
        HelloApplication Object1 = new HelloApplication();

        while (true) {
            //MENU
            System.out.println("""
                                        
                    -----------------MENU----------------------
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
                    Enter 110 or IFQ:- To Income of each Fuel queue.
                    Enter 111 or OG :- To Open GUI
                    Enter 999 or EXT:- To Exit the Program.
                    -------------------------------------------                  
                    """);

            Scanner input1 = new Scanner(System.in);
            System.out.print("Enter the option: ");
            String option = input1.nextLine().toUpperCase();

            switch (option) {
                // View all Fuel Queues
                case "100":
                case "VFQ":
                    System.out.println("View all Fuel Queues");
                    System.out.println();
                    printQueues(1, count1, queue1);
//                    printQueues(2, count2, queue2);
//                    printQueues(3, count3, queue3);
//                    printQueues(4, count4, queue4);
//                    printQueues(5, count5, queue5);
                    System.out.println();
                    System.out.println("Waiting QUEUE: ");
                    for (int i = 0; i < count6; i++) {
                        System.out.println((i + 1) + " : " + waitingQueue[i].getfName() + " " + waitingQueue[i].getsName());
                    }
                    break;

                // View all Empty Queues
                case "101":
                case "VEQ":
                    System.out.println("View all Empty Queues");
                    printEmptyQueues();
                    break;

                //Add customer to a Queue
                case "102":
                case "ACQ":
                    System.out.println("Add customer to a Queue");
                    if (fuelStock <= 500)
                        System.out.println("WARNING! The remaining fuel stock is: " + fuelStock);

                    minQueue();
                    addCustomer();
                    fuelStock = fuelStock - noOfLiters;
                    break;

                //Remove a customer from a Queue
                case "103":
                case "RCQ":
                    System.out.println("Remove a customer from a Queue.");
                    removeCustomer103();
                    fuelStock = fuelStock + noOfLiters;
                    break;

                //Remove a served customer
                case "104":
                case "PCQ":
                    System.out.println("Remove a served customer");
                    removeServedCustomer104();
                    break;

                //View Customers Sorted in alphabetical order
                case "105":
                case "VCS":
                    System.out.println("View Customers Sorted in alphabetical order (Do not use library sort routine)");
                    System.out.println();
                    System.out.println("Sorted QUEUE 1 : ");
                    sortCustomers(count1, queue1, sNames1);
//                    System.out.println("Sorted QUEUE 2 : ");
//                    sortCustomers(count2, queue2, sNames2);
//                    System.out.println("Sorted QUEUE 3 : ");
//                    sortCustomers(count3, queue3, sNames3);
//                    System.out.println("Sorted QUEUE 4 : ");
//                    sortCustomers(count4, queue4, sNames4);
//                    System.out.println("Sorted QUEUE 5 : ");
//                    sortCustomers(count5, queue5, sNames5);
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
                    System.out.println();
                    System.out.println("Fuel stock is: " + fuelStock);
                    break;

                //Add Fuel Stock
                case "109":
                case "AFS":
                    System.out.println("Add Fuel Stock");
                    System.out.println();
                    Scanner sc1 = new Scanner(System.in);
                    System.out.print("How much liters do you want to add: ");
                    addFuelStock = sc1.nextInt();
                    fuelStock();
                    break;

                //Income of each Fuel queue
                case "110":
                case "IFQ":
                    System.out.println("Income of each Fuel queue");
                    System.out.println();
                    income(1, pump1Income);
                    income(2, pump2Income);
                    income(3, pump3Income);
                    income(4, pump4Income);
                    income(5, pump5Income);
                    System.out.println();
                    System.out.println("Total income  : Rs." + (pump1Income + pump2Income + pump3Income + pump4Income + pump5Income) + ".00");
                    break;

                case "111":
                    Object1.mainprog();
                    break;

                // Exit the Program
                case "999":
                case "EXT":
                    System.out.println("Exit the Program");
                    System.out.println();
                    System.out.println("Thank you!");
                    return;

                //if the user enter invalid option
                default:
                    System.out.println("Invalid option.Please try again!");
                    break;
            }
        }
    }

    //method for print all the queues
    static void printQueues(int queueNum, int count, FuelQueue[] queuee) {
        System.out.println("QUEUE " + queueNum + ": ");
        for (int i = 0; i < count; i++) {
            System.out.println("customer" + (i + 1) + "- " + queuee[i].getfName() + " " + queuee[i].getsName());
        }
        System.out.println();
    }

    //method for print empty queues
    static void printEmptyQueues() {
        System.out.println();
        if (count1 <= 5) {
            System.out.println("QUEUE 1 - empty space count is:" + (6 - count1));
            for (int i = 0; i < count1; i++) {
                System.out.println((i + 1) + "- " + queue1[i].getfName() + " " + queue1[i].getsName());
            }
        }
//                 System.out.println();
//        if (count2 <= 5){
//            System.out.println("QUEUE 2 - empty space count is:" + (6 - count2));
//            for (int i = 0; i < count2; i++) {
//                System.out.println((i + 1) + "- " + queue2[i].getfName() + " " + queue2[i].getsName());}}
//                System.out.println();
//        if (count3 <= 5){
//            System.out.println("QUEUE 3 - empty space count is:" + (6 - count3));
//            for (int i = 0; i < count3; i++) {
//                System.out.println((i + 1) + "- " + queue3[i].getfName() + " " + queue3[i].getsName());}}
//                System.out.println();
//        if (count4 <= 5){
//            System.out.println("QUEUE 4 - empty space count is:" + (6 - count4));
//            for (int i = 0; i < count4; i++) {
//                System.out.println((i + 1) + "- " + queue4[i].getfName() + " " + queue4[i].getsName());}}
//                System.out.println();
//        if (count5 <= 5){
//            System.out.println("QUEUE 5 - empty space count is:" + (6 - count5));
//            for (int i = 0; i < count5; i++) {
//                System.out.println((i + 1) + "- " + queue5[i].getfName() + " " + queue5[i].getsName());}
//                 System.out.println();}
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
            }
//            else if (count2 == i) {
//                minQueue = 2;
//                break;
//            } else if (count3 == i) {
//                minQueue = 3;
//                break;
//            } else if (count4 == i) {
//                minQueue = 4;
//                break;
//            } else if (count5 == i) {
//                minQueue = 5;
//                break;
//            }
        }
    }

    //method for add customers
    static void addCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first name: ");
        fName = sc.next();
        System.out.print("Enter the second name: ");
        sName = sc.next();
        System.out.print("Enter the vehicle number: ");
        vehicleNo = sc.next();
        while (true) {
            try {
                System.out.print("Enter the number of liters: ");
                noOfLiters = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Integer Required! Please enter the number ");
                sc.next();
            }
        }
        System.out.println(fName + " is successfully added to the queue!");
//|| count2 <= 5 || count3 <= 5 || count4 <= 5 || count5 <= 5
        if (count1 <= 5 ) {
            if (minQueue == 1) {
                FuelQueue obj1 = new FuelQueue(fName, sName, vehicleNo, noOfLiters);
                obj1.setfName(fName);
                obj1.setsName(sName);
                obj1.setVehicleNo(vehicleNo);
                obj1.setNoOfLiters(noOfLiters);
                queue1[count1] = obj1;
                count1++;
            }
//            else if (minQueue == 2) {
//                FuelQueue obj2 = new FuelQueue(fName, sName, vehicleNo, noOfLiters);
//                obj2.setfName(fName);
//                obj2.setsName(sName);
//                obj2.setVehicleNo(vehicleNo);
//                obj2.setNoOfLiters(noOfLiters);
//                queue2[count2] = obj2;
//                count2++;
//            } else if (minQueue == 3) {
//                FuelQueue obj3 = new FuelQueue(fName, sName, vehicleNo, noOfLiters);
//                obj3.setfName(fName);
//                obj3.setsName(sName);
//                obj3.setVehicleNo(vehicleNo);
//                obj3.setNoOfLiters(noOfLiters);
//                queue3[count3] = obj3;
//                count3++;
//            } else if (minQueue == 4) {
//                FuelQueue obj4 = new FuelQueue(fName, sName, vehicleNo, noOfLiters);
//                obj4.setfName(fName);
//                obj4.setsName(sName);
//                obj4.setVehicleNo(vehicleNo);
//                obj4.setNoOfLiters(noOfLiters);
//                queue4[count4] = obj4;
//                count4++;
//            } else if (minQueue == 5) {
//                FuelQueue obj5 = new FuelQueue(fName, sName, vehicleNo, noOfLiters);
//                obj5.setfName(fName);
//                obj5.setsName(sName);
//                obj5.setVehicleNo(vehicleNo);
//                obj5.setNoOfLiters(noOfLiters);
//                queue5[count5] = obj5;
//                count5++;
//            }
        } else {
            addCustomerToWaitingQueue();
        }
    }

    //method for find the specific customer's index(place)
    static void findIndex(FuelQueue[] arrayss) {

        for (int i = 0; i < arrayss.length; i++) {
            if (arrayss[i] != null) {
                if (arrayss[i].getfName().equals(rName)) {
                    indexOf = i;
                }
            }
        }
    }

    //method for remove customers and shift
    static void removeElementAndShift(int indexToRemove, int count, FuelQueue[] queueNum) {

        for (int x = indexToRemove; x < (count); x++) {
            if (count < 5) {
                if (queueNum[x + 1] != null) {
                    queueNum[x].setfName(queueNum[x + 1].getfName());
                    queueNum[x].setsName(queueNum[x + 1].getsName());
                    queueNum[x].setVehicleNo(queueNum[x + 1].getVehicleNo());
                    queueNum[x].setNoOfLiters(queueNum[x + 1].getNoOfLiters());
                } else {
                    queueNum[x].setfName(null);
                    queueNum[x].setsName(null);
                    queueNum[x].setVehicleNo(null);
                    queueNum[x].setNoOfLiters(0);
                }
            }
        }
    }

    //method for remove customer from specific location
    static void removeCustomer103() {
        System.out.println();
        Scanner sc2 = new Scanner(System.in);
        System.out.print("From which queue,do you want to remove the customer(1 or 2 or 3 or 4 or 5): ");
        queuee = sc2.nextInt();
        System.out.print("Enter the first name: ");
        rName = sc2.next();

        if (queuee == 1) {
            if (count1 != 0) {
                findIndex(queue1);
                System.out.println("indexof: "+indexOf);
                printQueues(1, count1, queue1);
                removeElementAndShift(indexOf, count1, queue1);
                count1--;
                printQueues(1, count1, queue1);
                System.out.println("Successfully removed the customer!");
            } else
                System.out.println("Queue 1 is empty");
            if (count1 == 5 && waitingQueue[0] != null) {
                addCustomerFromWaitingQueue(queue1);
                count1++;
            }
        }
//        else if (queuee == 2) {
//            if (count2 != 0 ) {
//                findIndex(queue2);
//                removeElementAndShift(indexOf, count2, queue2);
//                count2--;
//                System.out.println("Successfully removed the customer!");
//            }else
//                System.out.println("Queue 2 is empty");
//            if (count2==5 && waitingQueue[0]!= null){
//                addCustomerFromWaitingQueue(queue2);
//                count2++;}
//        } else if (queuee == 3) {
//            if (count3 != 0 ) {
//                findIndex(queue3);
//                removeElementAndShift(indexOf, count3, queue3);
//                count3--;
//                System.out.println("Successfully removed the customer!");
//            }else
//                System.out.println("Queue 3 is empty");
//            if (count3==5 && waitingQueue[0]!= null){
//                addCustomerFromWaitingQueue(queue3);
//                count3++;}
//        } else if (queuee == 4) {
//            if (count4 != 0 ) {
//                findIndex(queue4);
//                removeElementAndShift(indexOf, count4, queue4);
//                count4--;
//                System.out.println("Successfully removed the customer!");
//            }else
//                System.out.println("Queue 4 is empty");
//            if (count4==5 && waitingQueue[0]!= null){
//                addCustomerFromWaitingQueue(queue4);
//                count4++;}
//        } else if (queuee == 5) {
//            if (count5 != 0 ) {
//                findIndex(queue5);
//                removeElementAndShift(indexOf, count5, queue5);
//                count5--;
//                System.out.println("Successfully removed the customer!");
//            }else
//                System.out.println("Queue 5 is empty");
//            if (count5==5 && waitingQueue[0]!= null){
//                addCustomerFromWaitingQueue(queue5);
//                count5++;}
//    }

}


    //method for remove served customer
     static void removeServedCustomer104(){
        System.out.println();
        Scanner sc3 = new Scanner(System.in);
        System.out.print("From which queue,do you want to remove the customer(1 or 2 or 3 or 4 or 5): ");
        servedCustomer = sc3.nextInt();

        if (servedCustomer == 1) {
            removeElementAndShift(0, count1, queue1);
            count1--;
            if (count1 == 5 && waitingQueue[0] != null) {
                addCustomerFromWaitingQueue(queue1);
                count1++;}
            pump1Income = pump1Income + (430 * noOfLiters);}
//        else if (servedCustomer == 2) {
//            removeElementAndShift(0,count2,queue2);
//            count2--;
//            if (count2==5 && waitingQueue[0]!= null){
//                addCustomerFromWaitingQueue(queue2);
//                count2++;}
//            pump2Income = pump2Income + (430*noOfLiters);}
//        else if (servedCustomer == 3) {
//            removeElementAndShift(0,count3,queue3);
//            count3--;
//            if (count3==5 && waitingQueue[0]!= null){
//                addCustomerFromWaitingQueue(queue3);
//                count3++;}
//            pump3Income = pump3Income + (430*noOfLiters);}
//        else if (servedCustomer == 4) {
//            removeElementAndShift(0,count4,queue4);
//            count4--;
//            if (count4==5 && waitingQueue[0]!= null){
//                addCustomerFromWaitingQueue(queue4);
//                count4++;}
//            pump4Income = pump4Income + (430*noOfLiters);}
//        else if (servedCustomer == 5) {
//            removeElementAndShift(0,count5,queue5);
//            count5--;
//            if (count5==5 && waitingQueue[0]!= null){
//                addCustomerFromWaitingQueue(queue5);
//                count5++;}
//            pump5Income = pump5Income + (430*noOfLiters);}
        System.out.println("Successfully removed the served customer!");
    }

     //method for sort customers
     static void sortCustomers(int count, FuelQueue[] arrays, String[] sNames) {
        String test1;

        for (int b = 0; b < count; b++) {
            sNames[b] = arrays[b].getfName();
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
        for (int r = 0; r < count; r++) {
            System.out.println(sNames[r]);
        }
    }

     //method for count fuel stock
     static void fuelStock() {
        fuelStock = addFuelStock + fuelStock;
        System.out.println("Available fuel stock is: " + fuelStock);
    }

    //method for count income
     static void income(int number, int pumpIncome) {
        System.out.println("PUMP " + number + " income : Rs." + pumpIncome + ".00");
    }

    //method for add customers to the waiting queue
     static void addCustomerToWaitingQueue() {
        FuelQueue obj4 = new FuelQueue(fName, sName, vehicleNo, noOfLiters);
        obj4.setfName(fName);
        obj4.setsName(sName);
        obj4.setVehicleNo(vehicleNo);
        obj4.setNoOfLiters(noOfLiters);
        waitingQueue[count6] = obj4;
        count6++;

        fuelStock = fuelStock - noOfLiters;
    }

    //method for add customer to main queue(from waiting queue)
     static void addCustomerFromWaitingQueue(FuelQueue[] queueNo) {
        queueNo[5].setfName(waitingQueue[0].getfName());
        queueNo[5].setsName(waitingQueue[0].getsName());
        queueNo[5].setVehicleNo(waitingQueue[0].getVehicleNo());
        queueNo[5].setNoOfLiters(waitingQueue[0].getNoOfLiters());

        for (int x = 0; x < count6; x++) {
            if (waitingQueue[x + 1] != null) {
                waitingQueue[x].setfName(waitingQueue[x + 1].getfName());
                waitingQueue[x].setsName(waitingQueue[x + 1].getsName());
                waitingQueue[x].setVehicleNo(waitingQueue[x + 1].getVehicleNo());
                waitingQueue[x].setNoOfLiters(waitingQueue[x + 1].getNoOfLiters());
            } else {
                waitingQueue[x].setfName(null);
                waitingQueue[x].setsName(null);
                waitingQueue[x].setVehicleNo(null);
                waitingQueue[x].setNoOfLiters(0);
            }
        }
        count6--;
    }

    //method for file writing part
     static void fileWrite() {
        System.out.println();
        try {
            File filee = new File("files.txt");
            PrintStream writee = new PrintStream(filee);
            writee.println("Remaining Fuel Stock: " + fuelStock);
            writee.println("QUEUE 1 : ");
            for (int i = 0; i < count1; i++) {
                writee.println((i+1) + " - " + queue1[i].getfName() + " , " + queue1[i].getsName() + " , " + queue1[i].getVehicleNo() + " , " + queue1[i].getNoOfLiters());
            }
//            writee.println("QUEUE 2 : ");
//            for (int i = 0; i < count2; i++) {
//                writee.println((i+1) + " - " + queue2[i].getfName() + " , " + queue2[i].getsName() + " , " + queue2[i].getVehicleNo() + " , " + queue2[i].getNoOfLiters());
//            }writee.println("QUEUE 3 : ");
//            for (int i = 0; i < count3; i++) {
//                writee.println((i+1) + " - " + queue3[i].getfName() + " , " + queue3[i].getsName() + " , " + queue3[i].getVehicleNo() + " , " + queue3[i].getNoOfLiters());
//            }writee.println("QUEUE 4 : ");
//            for (int i = 0; i < count4; i++) {
//                writee.println((i+1) + " - " + queue4[i].getfName() + " , " + queue4[i].getsName() + " , " + queue4[i].getVehicleNo() + " , " + queue4[i].getNoOfLiters());
//            }writee.println("QUEUE 5 : ");
//            for (int i = 0; i < count5; i++) {
//                writee.println((i+1) + " - " + queue5[i].getfName() + " , " + queue5[i].getsName() + " , " + queue5[i].getVehicleNo() + " , " + queue5[i].getNoOfLiters());
//            }
            writee.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

     //method for read file
     static void fileRead() {
        System.out.println();
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
}