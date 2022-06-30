/**
 * This code creates an employee class which can have an ID number and name assigned to it
 */


public class Employee {
    /**
     * Employee name and ID
     */
    private String name;
    private int IDnumber;

    /**
     * default employee constructor
     */
    public Employee(){}

    /**
     *  employee constructor that assigns name and id number from parameters
     * @param IDnumber
     * @param name
     */

    public Employee(String name, int IDnumber){
        this.name = name;
        this.IDnumber = IDnumber;
    }

    /**
     * gets name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * sets name
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets id number
     * @return IDnumber
     */
    public int getIDnumber() {
        return IDnumber;
    }

    /**
     * sets id number
     * @param IDnumber
     */
    public void setIDnumber(int IDnumber) {
        this.IDnumber = IDnumber;
    }
}
