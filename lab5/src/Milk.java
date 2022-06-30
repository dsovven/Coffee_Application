/** This code creates milk Class which extends the CoffeeDecorator class
 *it has methods to add the topping, print the coffee and return the cost
 */

public class Milk extends CoffeeDecorator {

    /** constructor passes coffee param to superclass
     * @param coffee
     */
    public Milk(Coffee coffee) {
        super(coffee);
    }

    /** add topping method overrides parent class method to add the topping
     * @param coffee
     */
    @Override
    public void addTopping(Coffee coffee) {
        coffee.addTopping(this.coffee);
        this.coffee = this.coffee;
    }

    /** print coffee method returns a string with the topping name
     * @return " - milk"
     */

    @Override
    public String printCoffee() {
        return " - milk";
    }


    /** print coffee method returns a double with the cost
     * @return this.coffee.cost()+0.15
     */
    @Override
    public Double cost() {
        return this.coffee.cost()+0.15;
    }
}
