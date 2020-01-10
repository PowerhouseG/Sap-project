/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sapprojectlol;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneyLogic.Money;
import storeLogic.Product;
import storeLogic.Storage;
import storeLogic.Store;

/**
 *
 * @author x
 */
public class SAPProjectLol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        Product carrot = new Product(20, true, "Carrot", 1, "9:99", "9:98");
        Product diamond = new Product(0, false, "Diamond", 2, "9:99", "9:98");
        Product stick = new Product(2, true, "Stick", 3, "25:99", "1:00");
        System.out.println("Amount of carrots: " + carrot.getStock());
        carrot.buy(0);
        System.out.println("Amount of carrots: " + carrot.getStock());
        carrot.buy(3);
        System.out.println("Amount of carrots: " + carrot.getStock());
        carrot.buy(3);
        System.out.println("Amount of carrots: " + carrot.getStock());

        Storage storage = new Storage();
        storage.addProduct(carrot);
        storage.addProduct(diamond);
        storage.addProduct(diamond);
        System.out.println(storage.getProduct("Carrot").getName());
        storage.remove(1);
        System.out.println(storage.getProduct(1));
        System.out.println(storage.getProduct("Carrot"));
        System.out.println("");

        storage.addProduct(carrot);
        System.out.println(storage.getProduct("Carrot").getMinPrice());
        carrot.setMinPrice("2:33");
        System.out.println(storage.getProduct("Carrot").getMinPrice());

        System.out.println(storage.getProduct(1).getPrice());
        storage.setPrice(1, "0:43");
        System.out.println(storage.getProduct(1).getPrice());
        System.out.println(storage.getProduct("Carrot").getMinPrice());
        storage.setMinPrice(1, "4:88lv");
        System.out.println(carrot.getMinPrice());

        storage.addProduct(stick);
        System.out.println("");
        System.out.println(storage.allAvailable());
        System.out.println(storage.allAvailableBlackFriday());
        System.out.println(storage.allBlackFriday());

        Store store = new Store(storage);
        System.out.println("");
        System.out.println(store.enoughMoney("Carrot", Money.toMoney("0:43")));
        System.out.println(store.enoughProducts(111, "Stick"));
        System.out.println(store.objectExists("carrot"));
        System.out.println("");
        Money money = new Money(33, 43);
        System.out.println("Store money: " + store.getMoney());
        try {
            //test buySingle()
            money = store.buySingle("Carrot", money);
            System.out.println(carrot);
            System.out.println(money);
//            test when you have an unexisting product
            money = store.buySingle("carrot", money);
            System.out.println(carrot);
            System.out.println(money);
            money = new Money(23, 43);
            //test when you don't have enough money
            money = store.buySingle("Stick", money);
            System.out.println(stick);
            System.out.println(money);
            money = new Money(23, 43);
            //test when you don't have enough stock

            money = store.buySingle("Diamond", money);
            System.out.println(diamond);
            System.out.println(money);
            store.buySingle("Carrot", new Money(100,0));
            store.buySingle("Carrot", new Money(100,0));
            store.buySingle("Carrot", new Money(100,0));

        } catch (Exception ex) {
            Logger.getLogger(SAPProjectLol.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Store money: " + store.getMoney());
        System.out.println("Account: "+store.getAccount());
        System.out.println(store.createDate(12, 12, 12));
        System.out.println(store.createDateAndTime(12, 12, 21, 12, 12));
        System.out.println(store.createTime(12, 12));
        
        System.out.println("");
        //TESTING THE DATE TIME SHANENIGANS
        System.out.println(store.getAccountsWithinRange(store.createTime(14, 44), store.createTime(14, 48)));
    }

}
