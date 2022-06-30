# Coffee_Application

to start, click run on the IDE

choose whether to sign in or not
if signing in, provide your name and ID number
otherwise a default name of Unknown and ID number of 0 are assigned

when the app is running you have 5 choices, 

1 read inventory to load and display the current inventory from the inventory.txt file
2 create coffee order to add multiple coffees to an order
  a. to add a new coffee follow instructions for toppings
  b. to complete coffee type e
  c. to add another coffee to the same order type yes when prompted
  d. to complete order type no 
3 update inventory to manually update the inventory
4 update log to manually update the log of order receipts
5 quit application to automatically update the log and inventory and then quit the app

files included in project are 
1. LogFile.txt containing the order receipts
2. Inventory.txt containing the current order number and invenotry
3. src folder holding code files
  a. Main.java, the main class that holds the main method and runs the application
  b. Coffee.java the coffee interface that is used by sub classes
  c. CoffeeDecorator.java abstract class which implements Coffee class and is used by toppings
  d. BasicCoffee.java class which implements the Coffee class
  e. Employee.java which holds the employee class for sign in purposes
  f. topping class files that hold the information of each topping and extend the CoffeeDecorator class
    1. BlackCoffee.java
    2. HotWater.java
    3. WhippedCream.java
    4. Espresso.java
    5. Milk.java
    6. Sugar.java
  
