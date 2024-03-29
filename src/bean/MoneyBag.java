/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author BEST
 */
import java.util.Objects;
import java.util.Vector;
import java.util.Iterator;
import java.lang.Iterable;
import java.util.Vector;

public class MoneyBag implements IMoney {
    private Vector<IMoney> fMonies = new Vector<IMoney>();

    public MoneyBag(IMoney m1, IMoney m2) {
        appendMoney(m1); 
        appendMoney(m2);
    }

    public MoneyBag(IMoney[] bag) {
        for (int i = 0; i < bag.length; i++)
            appendMoney(bag[i]);
    }

    private void appendMoney(IMoney m) {
        if (fMonies.isEmpty()) {
            fMonies.add(m);
        } else {
            int i = 0;
            while (i < fMonies.size() && !(fMonies.get(i).currency().equals(m.currency()))) {
                i++;
            }
            if (i >= fMonies.size()) {
                fMonies.add(m);
            } else {
                IMoney existingMoney = fMonies.get(i);
                fMonies.set(i, existingMoney.add(m));
            }
        }
        ElimineZero();
    }
    private void ElimineZero(){
        Iterator<IMoney> iterator = fMonies.iterator();
        while (iterator.hasNext()){
            IMoney money = iterator.next();
            if(money.amount() == 0){
                iterator.remove();
            }
        }
    }
    private void ElimineElement(String cur){
        Iterator<IMoney> iterator = fMonies.iterator();
        while (iterator.hasNext()){
            IMoney money = iterator.next();
            if(money.currency() == cur){
                iterator.remove();
            }
        }
    }
    public Vector<IMoney> getFMonies (){
        return this.fMonies;
    }
    @Override
    public int amount() {
        int totalAmount = 0;
        for (IMoney money : fMonies) {
            totalAmount += money.amount();
        }
        return totalAmount;
    }

    @Override
    public String currency() {
        if (!fMonies.isEmpty()) {
            return fMonies.get(0).currency(); // Return currency of the first money in the bag
        }
        return ""; // Return empty string if bag is empty (you might want to handle this differently)
    }

    @Override
     public IMoney add(IMoney m) {
        System.out.print("Bag ");
        if (m.currency().equals(currency())){
        System.out.print("cur eq ");
            if (m instanceof MoneyBag) {
                MoneyBag result = (MoneyBag) m;
                for (IMoney mon :  result.getFMonies()){
                    appendMoney(mon);
                }
                return this;
            }
            
        System.out.println("Money ");
           
            for (IMoney mon :  getFMonies()){
                if(mon.currency() == m.currency() && (mon.amount() * -1) == m.amount()){
                    ElimineElement(mon.currency());
                }
            }
            return new Money(amount() + m.amount(), currency());
        }
        System.out.print("Money ");
                   
        appendMoney(m);
        System.out.print(amount());
    // If m is a Money object, create a new MoneyBag containing both Money objects
        return this;
        
    }
     
    @Override
    public String typeOf(){
        return "Money";
    }
    @Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    MoneyBag other = (MoneyBag) obj;
    Vector<IMoney> thisMonies = this.getFMonies();
    Vector<IMoney> otherMonies = other.getFMonies();
    
    // Compare the sizes of the vectors
    if (thisMonies.size() != otherMonies.size()) {
        return false;
    }
    
    // Compare each IMoney object in the vectors
    for (int i = 0; i < thisMonies.size(); i++) {
        if (!thisMonies.get(i).equals(otherMonies.get(i))) {
            return false;
        }
    }
    return true;
}

    
}
