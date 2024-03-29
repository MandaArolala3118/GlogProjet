/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;
import java.util.Objects;

/**
 *
 * @author BEST
 */
public class Money implements IMoney {
    private int fAmount;
    private String fCurrency;
    public Money(){
        
    }
    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }
    @Override
    public int amount() {
        return fAmount;
    }

    @Override
    public String currency() {
        return fCurrency;
    }

        @Override
      public IMoney add(IMoney m) {
        System.out.print("Moneys ");
          if (m.currency().equals(currency())) {
              this.fAmount = amount() + m.amount();
              return this;
          } else if (m instanceof Money) {
              Money[] moneyArray = { this, (Money)m };
              return new MoneyBag(moneyArray);
          } 

        MoneyBag otherBag = (MoneyBag) m;
        Money[] moneyArray = new Money[otherBag.getFMonies().size() + 1];
        moneyArray[0] = this;
        for (int i = 0; i < otherBag.getFMonies().size(); i++) {
            moneyArray[i + 1] = (Money) otherBag.getFMonies().get(i);
        }
        return new MoneyBag(moneyArray);
         
      }

    @Override
    public String typeOf(){
        return "MoneyBag";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Money other = (Money) obj;
        return fAmount == other.fAmount && Objects.equals(fCurrency, other.fCurrency);
    }

}