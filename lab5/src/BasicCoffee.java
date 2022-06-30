
/** This code creates basic coffee Class which implements the Coffee class
 *it has methods to add the topping, print the coffee and return the cost
 */

public class BasicCoffee implements Coffee {
    /** add topping method overrides parent class method
     */
    @Override
    public void addTopping(Coffee coffee) {
    }

    /** print coffee method returns a string with the topping name
     * @return "Black coffee"
     */
    @Override
    public String printCoffee() {
        return "Black coffee";
    }

    /** print coffee method returns a double with the cost
     * @return 0.85
     */
    @Override
    public Double cost() {
        return 0.85;
    }
}
