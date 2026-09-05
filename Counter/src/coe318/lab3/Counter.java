/**
 *
 * @author Iqraa Wahid
 */
package coe318.lab3;
public class Counter {
    //Instance variables:
    private int modulus;
    private Counter left;
    private int digit;
    
    public Counter(int modulus, Counter left) {
        //setting intial values for the instance variables
        this.modulus = modulus;
        this.left = left;
        this.digit = 0;
    }


    /**
     * @return the modulus
     */
    public int getModulus() {
        return modulus;
    }

    /**
     * Returns the Counter to the left attached to this
     * Counter.  Returns null if there is no Counter
     * to the left.
     * @return the left
     */
    public Counter getLeft() {
        return left;
    }

    /**
     * @return the digit
     */
    public int getDigit() {
        return digit;
    }

    /**
     * @param digit the digit to set
     */
    public void setDigit(int digit) {
        this.digit = digit;
    }

    /**
     * Increment this counter.  If it rolls over,
     * its left Counter is also incremented if it
     * exists.
     */
    public void increment() { //this method increment's the Counter's digit
        digit=digit+1;
        if(digit == modulus){
            digit = 0; //if the counter's digit equals the modulus, then the counter's digit is reset to zero
            if(left!=null){//The absence of a left neighbour is indicated with the keyword null, so if left does not equal null, that means the left neigbour is present, then 
                left.increment();//left neighbour increments
            }
        }
    }

    /** Return the count of this Counter combined
     * with any Counter to its left.
     *
     * @return the count
     */
    public int getCount() {
        if(left == null){ //if there is no left neighbour then...
            return digit; //the count is the same as the digit
        }
        else{ //else
            return digit + modulus * left.getCount(); //count = sum of the digit and the modulus times the count of the left neighbour
        }
    }

    /** Returns a String representation of the Counter's
     * total count (including its left neighbour).
     * @return the String representation
     */
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        return "" + getCount();
    }

}