/** This code creates black coffee Class which extends the CoffeeDecorator class
 *it has methods to add the topping, print the coffee and return the cost
 */


public class BlackCoffee extends CoffeeDecorator {

    /** constructor passes coffee param to superclass
     * @param coffee
     */
    public BlackCoffee(Coffee coffee) {
        super(coffee);
    }


    /** add topping method overrides parent class method to add the topping
     * @param coffee
     */
    @Override
    public void addTopping(Coffee coffee) {
        coffee.addTopping(this.coffee);
        this.coffee = coffee;
    }

    /** print coffee method returns a string with the topping name
     * @return this.coffee.printCoffee()
     */
    @Override
    public String printCoffee() {
        return this.coffee.printCoffee();
    }


    /** print coffee method returns a double with the cost
     * @return this.coffee.cost()
     */
    @Override
    public Double cost() {
        return this.coffee.cost();
    }
}