/** This code creates an abstract CoffeeDecorator class which implements the Coffee class
 * it is inherited by the black coffee and topping classes
 */


public abstract class CoffeeDecorator implements Coffee {

    /**Coffee object coffee
     */
    protected Coffee coffee;

    /**constructor sets coffee to class level coffee variable
     * @param coffee
     */
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    /** adds coffee topping to coffee
     * @param coffee
     */
    public void addTopping(Coffee coffee) {
        this.coffee.addTopping(coffee);
    }

    /** prints coffee order by returning the printCoffee as a String
     * @return this.coffee.printCoffee()
     */
    public String printCoffee() {
        return this.coffee.printCoffee();
    }

    /** abstract Double variable cost
     */
    public abstract Double cost();
}
