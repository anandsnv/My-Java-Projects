package com.company;
 class Amount{
    private String currency;
    private int amount;

     public Amount(String currency, int amount) {
         super();
         this.currency = currency;
         this.amount = amount;
     }
     public void addMethod( Amount that)throws Exception{
         if (!this.currency.equals(that.currency))
             throw  new RuntimeException("currency doesn't match"+ " "+this.currency+" & "+that.currency);

         this.amount=this.amount+that.amount;

     }
     public String toString() {
         return  amount+" "+currency;
     }
 }

public class ThrowingExceptionRunner {

    public static void main(String[] args)throws Exception {
        Amount amount= new Amount("USD",20);
        Amount amount1= new Amount("EUR",10);
        amount.addMethod(amount1);
        System.out.println(amount);

    }
}
