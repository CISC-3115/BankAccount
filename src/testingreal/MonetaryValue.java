
package testingreal;

public class MonetaryValue {
    private int cents;
    public static final MonetaryValue ZERO = new MonetaryValue(0);

    public MonetaryValue() {
        this(0);
    }

    public MonetaryValue(int cents) {
        this.cents = cents;
    }

    public MonetaryValue(double amount) {
        this.cents = (int)(amount * 100);
    }

    public MonetaryValue(MonetaryValue old) {
        this.cents = old.cents;
    }

    public String toString() {
        int absCents = Math.abs(cents);
        return "$"
                + (isNegative()? "-" : "")
                + absCents / 100
                + "."
                + ((absCents % 100) < 10? "0" : "")
                + absCents % 100;
    }

    /*
    // alternative version:
    public String toString() {
        int dollarsPart = Math.abs(cents / 100), centsPart = Math.abs(cents % 100);
        String result = "$";

        if (isNegative()) {
            result += "-";
        }

        result += dollarsPart + ".";

        if (centsPart < 10) {
            result += "0" + centsPart;
        } else {
            result += centsPart;
        }

        return result;
    }
    */

    public double toDouble() {
        return cents / 100.0;
    }

    public boolean isNegative() {
        return cents < 0;
    }

    public boolean isGreaterThan(MonetaryValue other) {
        return this.cents > other.cents;
    }

    public boolean isLessThan(MonetaryValue other) {
        return this.cents < other.cents;
    }

    public MonetaryValue plus(MonetaryValue amount) {
        return new MonetaryValue(this.cents + amount.cents);
    }

    public MonetaryValue minus(MonetaryValue amount) {
        return new MonetaryValue(this.cents - amount.cents);
    }

    public static MonetaryValue sum(MonetaryValue value1, MonetaryValue value2) {
        return new MonetaryValue(value1.cents + value2.cents);
    }

    public static MonetaryValue difference(MonetaryValue value1, MonetaryValue value2) {
        return new MonetaryValue(value1.cents - value2.cents);
    }
    
        public boolean equals (Object x){
        	
        if(x instanceof MonetaryValue){
        	MonetaryValue other =(MonetaryValue)x;
        	return this.cents== other.cents;
        }
        return false;
    }
}

