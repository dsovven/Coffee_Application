/** This code creates an Espresso Class which extends the CoffeeDecorator class
 *it has methods to add the topping, print the coffee and return the cost
 */

public class Espresso extends CoffeeDecorator {

    /** Espresso constructor passes coffee param to superclass
     * @param coffee
     */
    public Espresso(Coffee coffee) {

        super(coffee);
    }

    /** add topping method overrides parent class method to add the topping
     *
     */
    @Override
    public void addTopping(Coffee coffee) {
        //coffee.addTopping(this.coffee);
        this.coffee = coffee;
    }

    /** print coffee method returns a string with the topping name
     * @return " - Espresso Shot"
     */
    @Override
    public String printCoffee() {
        return " - Espresso Shot";
    }


    /** print coffee method returns a double with the topping cost
     * @return this.coffee.cost()+0.35
     */
    @Override
    public Double cost() {
        return this.coffee.cost()+0.35;
    }
}
