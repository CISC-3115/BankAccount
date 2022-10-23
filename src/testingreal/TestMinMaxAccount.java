package testingreal;


public class TestMinMaxAccount {
    public static void main(String[] args) {
        testExtendsBankAccount();
        testNumFields();
        testConstructor();
        testToString();
        testDeposit();
        testWithdraw();
        testGetMinAndGetMax();
    }

    private static void testExtendsBankAccount() {
        System.out.println("testing extends BankAccount");

        MinMaxAccount account = new MinMaxAccount("123456", new MonetaryValue(100.00));
        System.out.println(account instanceof BankAccount); // expected: true

        System.out.println();
    }

    private static void testNumFields() {
        System.out.println("testing num fields");

        java.lang.reflect.Field[] fields = MinMaxAccount.class.getDeclaredFields();
        System.out.println(fields.length);  // expected: 2

        System.out.println();
    }

    private static void testConstructor() {
        System.out.println("test constructor");

        MinMaxAccount account = new MinMaxAccount("123456", new MonetaryValue(25.00));
        System.out.println(account.getAccountNumber()); // expected: 123456
        System.out.println(account.getBalance());       // expected: $25.00
        System.out.println(account.getMin());           // expected: $25.00
        System.out.println(account.getMax());           // expected: $25.00

        System.out.println();
    }

    private static void testToString() {
        System.out.println("test toString");

        MinMaxAccount account = new MinMaxAccount("123456", new MonetaryValue(100.00));
        System.out.println(account); // expected: 123456 $100.00 [min=$100.00, max=$100.00]

        System.out.println();
    }

    private static void testDeposit() {
        System.out.println("test deposit");

        MinMaxAccount account = new MinMaxAccount("123456", new MonetaryValue(100.00));
        System.out.println(account); // expected: 123456 $100.00 [min=$100.00, max=$100.00]

        boolean result = account.deposit(new MonetaryValue(50.00));
        System.out.println(result);  // expected: true
        System.out.println(account); // expected: 123456 $150.00 [min=$100.00, max=$150.00]

        result = account.deposit(new MonetaryValue(50.00));
        System.out.println(result);  // expected: true
        System.out.println(account); // expected: 123456 $200.00 [min=$100.00, max=$200.00]

        // attempt to deposit a negative amount
        result = account.deposit(new MonetaryValue(-50.00));
        System.out.println(result);  // expected: false
        System.out.println(account); // expected: 123456 $200.00 [min=$100.00, max=$200.00]

        System.out.println();
    }

    private static void testWithdraw() {
        System.out.println("test withdraw");

        MinMaxAccount account = new MinMaxAccount("123456", new MonetaryValue(100.00));
        System.out.println(account); // expected: 123456 $100.00 [min=$100.00, max=$100.00]

        boolean result = account.withdraw(new MonetaryValue(50.00));
        System.out.println(result); // expected: true
        System.out.println(account); // expected: 123456 $50.00 [min=$50.00, max=$100.00]

        result = account.withdraw(new MonetaryValue(25.00));
        System.out.println(result); // expected: true
        System.out.println(account); // expected: 123456 $25.00 [min=$25.00, max=$100.00]

        // attempt to withdraw a negative amount
        result = account.withdraw(new MonetaryValue(-10.00));
        System.out.println(result); // expected: false
        System.out.println(account); // expected: 123456 $25.00 [min=$25.00, max=$100.00]

        // attempt to make the balance go below $0.00
        result = account.withdraw(new MonetaryValue(50.00));
        System.out.println(result); // expected: false
        System.out.println(account); // expected: 123456 $25.00 [min=$25.00, max=$100.00]

        System.out.println();
    }

    private static void testGetMinAndGetMax() {
    	System.out.println("test getMin and getMax");

    	MinMaxAccount account = new MinMaxAccount("123456", new MonetaryValue(100.00));
    	System.out.println(account.getBalance()); // expected: $100.00
    	System.out.println(account.getMin());     // expected: $100.00
    	System.out.println(account.getMax());     // expected: $100.00

    	account.withdraw(new MonetaryValue(50.00));
    	System.out.println(account.getBalance()); // expected: $50.00
    	System.out.println(account.getMin());     // expected: $50.00
    	System.out.println(account.getMax());     // expected: $100.00

    	account.deposit(new MonetaryValue(25.00));
    	System.out.println(account.getBalance()); // expected: $75.00
    	System.out.println(account.getMin());     // expected: $50.00
    	System.out.println(account.getMax());     // expected: $100.00

    	account.deposit(new MonetaryValue(50.00));
    	System.out.println(account.getBalance()); // expected: $125.00
    	System.out.println(account.getMin());     // expected: $50.00
    	System.out.println(account.getMax());     // expected: $125.00
    	
    	account.withdraw(new MonetaryValue(25.00));
    	System.out.println(account.getBalance()); // expected: $100.00
    	System.out.println(account.getMin());     // expected: $50.00
    	System.out.println(account.getMax());     // expected: $125.00
    	
    	account.withdraw(new MonetaryValue(25.00));
    	System.out.println(account.getBalance()); // expected: $75.00
    	System.out.println(account.getMin());     // expected: $50.00
    	System.out.println(account.getMax());     // expected: $125.00
    	
    	account.withdraw(new MonetaryValue(50.00));
    	System.out.println(account.getBalance()); // expected: $25.00
    	System.out.println(account.getMin());     // expected: $25.00
    	System.out.println(account.getMax());     // expected: $125.00
    	
    	System.out.println();
    }
}