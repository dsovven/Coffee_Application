/** Davis Owen
 * Lab 5 coffee order program
 * 6/26/22
 * CS 160L
 * this code creates a coffee order application that reads and updates an inventory and writes a log file
 * based on new orders
 * @author Davis Owen
*/



import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    /** declares an order number int variable for use in all the main class
     */
    protected static int orderNum;

    /** declares an Employee object
     */
    protected static Employee employee1;

    /**declares an inventory array of integers of size 6
     */
    protected static int[] inv = new int[6];

    /** declares a Stack of strings and creates a new Stack object
     */
    protected static Stack<String> stack = new Stack<>();


    public static void main(String[] args) {

        /* creates a new scanner object for use in the rest of the app
         */
        Scanner CafeApplication = new Scanner(System.in);


        System.out.println("Do you want to sign in? yes or no");

        /* allows user to sign in and provide their name and id number
         */
        if(CafeApplication.nextLine().equals("yes")) {

            System.out.println("Please enter employee name");
            String empName = CafeApplication.nextLine();
            System.out.println("Please enter employee ID number");
            int empNum = CafeApplication.nextInt();
            employee1 = new Employee(empName, empNum);
        }
        /* if user chooses not to sign in, default name and id num are assigned
         */
        else {
            employee1 = new Employee("Unknown", 0);
        }

        /* sets the order number to the previous order number +1
         * by using the getLastOrderNum method which reads the inventory.txt file for the last number
         */
        orderNum = getLastOrderNum() +1;


        int input = 0;

        /* main coffee application menu
         */
        while (input != 1) {

            System.out.println("\nCoffee Application Running... ");
            System.out.println("Cashier: " + employee1.getName() +"\n");
            System.out.println("""
                    Press 1 : Read Inventory
                    Press 2 : Create Coffee Order
                    Press 3 : Update Inventory
                    Press 4: Update log file
                    Press 5: Exit the application
                    """);

            /* checks user input
             */
            switch (CafeApplication.nextLine()) {

                /*runs inventory reader method to load the latest inventory
                 */
                case "1":
                    inventoryReader();
                    break;

                /* runs orderHelper method which then uses create order method to add multiple coffees to an order
                 */
                case "2":
                    orderHelper();
                    break;

                /* updates the inventory.txt file using inventoryWriter method
                 * and latest inv array
                 */
                case "3":
                    inventoryWriter(inv);
                    break;

                //*updates the log with the remaining orders from the stack

                case "4":
                    logWriter(stack);
                    break;

                //exits the app by setting input to 1 after writing the inventory and log

                case "5":
                    inventoryWriter(inv);
                    logWriter(stack);
                    input = 1;
                    break;

                // has user input a correct selection

                default:
                    System.out.println("Invalid Selection. Please Try Again");
            }
        }
    }

    /** method returns the last order number used by reading the top line of the inventory.txt file
     * @return orderNum
     * @throws RuntimeException "File Not Found"
     */

    public static int getLastOrderNum(){
        String line, parts[];
        int orderNum;

        // tries to create a new infile object with a buffered reader from the inventory.txt file
        try {
            BufferedReader infile = new BufferedReader(new FileReader("inventory.txt"));
            line = infile.readLine(); //reads the first line of the file
            parts = line.split(": "); //splits the file into 2 strings separated at ": " which leaves the order num as the second string
            orderNum  = Integer.parseInt(parts[1]); // assigns the order number from the second part of the string after parsing it to an int
            System.out.println("\nLast order number: " + orderNum + "\n");
            return orderNum;
        }
        // throws exception if the file is not found
        catch (Exception e) {
            System.out.println("File Not Found");
            throw new RuntimeException(e);
        }
    }

    /** print order pushes the current order to the stack after using a string builder to create the receipt using
     * the items and price parameters
     * @param Item arraylist of coffee order items
     * @param price arraylist of coffee order prices
     * @return str.toString()  returns order
     */
    public static String printOrder(ArrayList<String> Item, ArrayList<Double> price) {

        StringBuilder str = new StringBuilder(); //new string builder
        str.append("RECEIPT\n");
        str.append("Cashier: " + employee1.getName() + " - ID number: " + employee1.getIDnumber() +"\n"); // uses the employee1 object to get the name and id number

        str.append("Order number: " +orderNum + "\n"); //adds the order number to the order

        orderNum++; //increments the order number
        if (orderNum>100){  // if the order number is > 100 then it is reassigned to 1
            orderNum=1;
        }

        double total = 0;

        // for each item in the item arraylist add the item name and toppings and cost to the string builder
        for (int i = 1; i <= Item.size(); i++) {
            str.append("Item " + i + ": A Black Coffee with" + Item.get(i - 1) + " | cost:" + price.get(i - 1) + "\n");

            total = total + price.get(i - 1); // add the total from each item
        }

        str.append("TOTAL COST OF ORDER:" + total + "\n");  // adds the total to the string builder
        stack.push(str.toString()); // pushes the completed string builder to the stack
        return str.toString(); // returns the stringbuilder
    }

    /** creates an order for each individual coffee that can have multiple toppings
     * checks that there is enough of the topping in the inventory and then decrements them if they are used
     * adds the coffee/topping to the order arraylist and returns the order which is a single coffee with or without toppings
     * @return ArrayList<Coffee> order
     */

    public static ArrayList<Coffee> createOrder() {

        ArrayList<Coffee> order = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int in = 0;
        Coffee coffee = new BasicCoffee(); // creates a new coffee object
        inv[0] -=1; // decrements the inventory of black coffee

        // runs a loop that allows for multiple topping choices to be added, if topping is out, notifies the user and restarts loop
        while (in != 1) {
            System.out.println("Enter the following values to add toppings: 1.) milk, 2.) hot water, 3.) espresso, 4.) sugar, 5) whipped cream, e - to complete order\n");
            switch (sc.nextLine()) {
                case "1":
                    if (inv[1] == 0){
                        System.out.println("Out of milk. Try a different topping");
                    }
                    else {
                        coffee = new Milk(coffee);
                        inv[1] -= 1;
                        break;
                    }
                case "2":
                    if (inv[2] == 0){
                        System.out.println("Out of hot water. Try a different topping");
                    }
                    else {
                        coffee = new HotWater(coffee);
                        inv[2] -= 1;
                        break;
                    }
                case "3":
                    if (inv[3] == 0){
                        System.out.println("Out of Espresso. Try a different topping");
                    }
                    else {
                        coffee = new Espresso(coffee);
                        inv[3] -= 1;
                        break;
                    }
                case "4":
                    if (inv[4] == 0){
                        System.out.println("Out of Sugar. Try a different topping");
                    }
                    else {
                        coffee = new Sugar(coffee);
                        inv[4] -= 1;
                        break;
                    }
                case "5":
                    if (inv[5] == 0){
                        System.out.println("Out of whipped cream. Try a different topping");
                    }
                    else {
                        coffee = new WhippedCream(coffee);
                        inv[5] -= 1;
                        break;
                    }
                case "e":
                    in = 1;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
            order.add(coffee);
        }
        return order;
    }


    /** reads inventory with a buffered file reader from inventory.txt and returns an int array of the items
     * @return int[]  inv
     */
    ///used this source for help with the buffered file reader https://www.reddit.com/r/javahelp/comments/44y20l/java_help_scanner_printwriter_filereader/
    public static int[] inventoryReader() {

        String line, parts[];
        System.out.println("\nCurrent items in the inventory:\n");

        try { // tries to create new file reader and read file
            BufferedReader infile = new BufferedReader(new FileReader("inventory.txt"));
            infile.readLine(); // skips the first line of the inventory.txt file which is reserved for the last order number
            for (int i = 0; i < 6; ++i) { // loops through each of the 6 toppings reading just the number and saving them to an array
                line = infile.readLine();
                System.out.println(line);
                parts = line.split(" = ");
                inv[i] = Integer.parseInt(parts[1]);
            }
            return inv;

        } catch (Exception e) { // throws exception if the file isn't found
            System.out.println("File Not Found");
            throw new RuntimeException(e);
        }
    }

    /** initial method used to create orders. uses the createOrder() method to make individual coffees for the order
     * can add multiples coffees to item and price arraylists each consisting of multiple toppings
     *
     */
    public static void orderHelper() {

        if (inv[0] == 0) { // before order started checks if there is no more black coffee then skips the order

            System.out.println("\nOut of coffees. Visit us later.");
        }

        else {
            ArrayList<String> Item = new ArrayList<>();
            ArrayList<Double> price = new ArrayList<>();
            ArrayList<Coffee> Temp2;

            Scanner userOrders = new Scanner(System.in);

            System.out.println("\nCoffee order created. Select toppings for the first coffee:\n");
            String line = "yes";

            double currCost = 0.0;
            String currName = "";
            do {

                Temp2 = createOrder(); //uses createOrder() method and then loops through each coffee to read off the names of the toppings and costs
                // and saves that to the correct arrays
                for (Coffee c : Temp2) {
                    currCost += c.cost();
                    currName += c.printCoffee();
                }
                price.add(currCost);
                Item.add(currName);

                currCost = 0.0; // resets current name and cost
                currName = "";

                //
                if (inv[0] == 0) { // if the order is out of coffees notify user and break loop
                    System.out.println("\nOrder Completed. No more coffees.");
                    break;
                }
                System.out.println("Do you want to add another coffee to this order? - yes or no");

            } while (!(line = userOrders.nextLine()).equals("no")); // breaks the order loop when user enters no

            printOrder(Item,price); // uses the print order method to add the item and price arraylists to the stack
        }

    }

    /** writes the updated inventory to be used after making new orders
     * @param inventoryArray int array of the current topping inventory
     */
    public static void inventoryWriter(int[] inventoryArray){

        // array of topping names
        String[] toppingArray = new String[]{"Black Coffee", "Milk", "Hot Water","Espresso","Sugar","Whipped Cream"};

        // attempts to create new file writer by overwriting the current inventory.txt file
        try {
            FileWriter myWriter = new FileWriter("inventory.txt");
            myWriter.write("Last order number: " + orderNum + "\n"); // writes order number
            for (int i = 0; i<6; ++i) {  // for each topping add the topping name and amount left
                myWriter.write(toppingArray[i] + " = " + inventoryArray[i] + "\n");
            }

            System.out.println("Successfully updated the inventory"); // notifies the console user that it updated successfully and closes the writer
            myWriter.close();

        }
        catch (IOException e) { // catches errors in the file writer
            System.out.println("An error occurred.");
        }
    }

    /** updates the log using the current stack of receipts from new orders
     * @param stack stack of order receipts
     */
    public static void logWriter(Stack<String> stack) {

        try { // tries to create new file writer for the log file
            FileWriter writer = new FileWriter("LogFile.txt", true);

            SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd 'at' HH:mm:ss z"); //creates date formatter
            Date date = new Date(System.currentTimeMillis()); //updates the current date
            writer.write(("\n\nWriting orders from stack " + formatter.format(date))+"\n");//adds timestamp

            for (String o : stack){ // iterates through the orders in the stack and writes each one
                writer.write("\n" + o);
            }

            writer.write("\n");
            writer.close(); // closes the file
            System.out.println("\nSuccessfully updated log file"); // notifies of successful update
        }

        catch (Exception e){ // notifies of file error
            System.out.println("An error occurred.");
        }
    }

}
