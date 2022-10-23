package testingreal;

public class CheckingAccount extends BankAccount {

    private MonetaryValue over;

    public CheckingAccount(String accountNumber, MonetaryValue balance, MonetaryValue over) {
        super(accountNumber, balance);
        this.over = over;
    }

    public MonetaryValue getOverdraftLimit() {

        return over;

    }

    @Override

    public boolean withdrawalNotAllowed(MonetaryValue x) {

        MonetaryValue l = over.minus(over).minus(over); //100

        return !((getBalance().minus(x).isGreaterThan(l)) || (getBalance().minus(x).equals(l)));

       

    }
}
