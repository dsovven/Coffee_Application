/** This code creates sugar Class which extends the CoffeeDecorator class
 *it has methods to add the topping, print the coffee and return the cost
 */

public class Sugar extends CoffeeDecorator {

    /** constructor passes coffee param to superclass
     * @param coffee
     */
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    /** add topping method overrides parent class method to add the topping
     */
    @Override
    public void addTopping(Coffee coffee) {
        coffee.addTopping(this.coffee);
        this.coffee = coffee;
    }

    /** print coffee method returns a string with the topping name
     * @return " - sugar"
     */
    @Override
    public String printCoffee() {
        return " - sugar";
    }

    /** print coffee method returns a double with the cost
     * @return this.coffee.cost()+0.05
     */
    @Override
    public Double cost() {
        return this.coffee.cost()+0.05;
    }
}
