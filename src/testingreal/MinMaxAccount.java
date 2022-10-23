
package testingreal;

public class MinMaxAccount extends BankAccount {

    MonetaryValue low;
    MonetaryValue high;

    public MinMaxAccount(String accountNumber, MonetaryValue balance) {
        super(accountNumber, balance);

        low = balance;
        high = balance;

    }

    public MonetaryValue getMin() {

        if (getBalance().isLessThan(low)) {
            low = getBalance();

        }
        return low;

    }

    public MonetaryValue getMax() {

        if (getBalance().isGreaterThan(high)) {
            high = getBalance();

        }
        return high;

    }

    @Override
    public String toString() {

        return super.toString() + " "  + "{min=" + low + "," + "max=" + high + "}";

    }

    @Override
    public boolean deposit(MonetaryValue amount) {
        super.deposit(amount);

        low = getMin();
        high = getMax();

        return false;

    }

    @Override
    public boolean withdraw(MonetaryValue amount) {
        super.withdraw(amount);

        low = getMin();
        high = getMax();

        return false;

    }
}
