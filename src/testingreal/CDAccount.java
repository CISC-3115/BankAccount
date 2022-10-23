
package testingreal;

import java.time.LocalDate;
import java.time.Period;


public class CDAccount extends BankAccount {
    LocalDate start;
    Period term;
    
    
    
    public CDAccount(String accountNumber, MonetaryValue balance, LocalDate start, Period term) {
    super (accountNumber, balance);
    this.start = start;
    this.term = term;
    
    
}
   public  LocalDate getTermEnd(){
       
       return start.plus(term);
       
       
   }
   
   
    @Override
   public boolean withdrawalNotAllowed(MonetaryValue x) {

      if ((getTermEnd().isBefore(LocalDate.now()) && ( super.withdrawalNotAllowed(x) == false))){
          
          
          return false;
      }
      
      
      
       
return true;
    }
}
   
   
    
    

