/** This code creates the main coffee interface which is used by the CoffeeDecorator
 *  BasicCoffee class
 *it has methods to add the topping, print the coffee and return the cost
 */

public interface Coffee {

    /** interface method is used by child clases
     * @param coffee
     */
    void addTopping(Coffee coffee);

    /** printCoffee method used by child classes
     */
    String printCoffee();

    /**cost method used by child classes
     */
    Double cost();
}
