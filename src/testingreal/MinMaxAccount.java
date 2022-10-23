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

        return super.toString() + " " + "[min=" + low + "," + "max=" + high + "] ";

    }

    @Override
    public boolean deposit(MonetaryValue amount) {

        if (super.deposit(amount) == true) {
            low = getMin();
            high = getMax();
            return true;

        }

        return false;

    }

    @Override
    public boolean withdraw(MonetaryValue amount) {

        if (super.withdraw(amount) == true) {
            low = getMin();
            high = getMax();
            return true;

        }

        return false;

    }
}
