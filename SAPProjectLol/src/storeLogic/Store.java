/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeLogic;

import java.util.Date;
import java.util.Map;
import moneyLogic.Money;

/**
 *
 * @author x
 */
public class Store {

    private Money money;
    private Storage storage;
    private Map<Date,Money> accounts;

    public Store() {
        this(new Money(0, 0), new Storage());
    }

    public Store(Storage storage) {
        this(new Money(0, 0), storage);
    }
    public Store(Money money){
        this(money, new Storage());
    }

    public Store(Money money, Storage storage) {
        this.money = money;
        this.storage = storage;
    }

    public Money getMoney() {
        return money;
    }

    public Money buySingle(String name, Money money) throws Exception {
        if (!objectExists(name)) {
            //throw new CantFindProductException(name);
            System.out.println("doesn't exist");
        } else if (!enoughMoney(name, money)) {
            //throw new NotEnoughMoneyException(storage.getProduct(name).getPrice(),money);
            System.out.println("doesn't money");
        } else if (!enoughProducts(1, name)) {
            //throw new NotEnoughProductsException(name);
            System.out.println("doesn't products");
        } else {
            Money toPay = storage.getProduct(name).getPrice();
            money = money.minus(toPay);
            storage.getProduct(name).buy(1);
            this.money = this.money.plus(toPay);
            return money;
        }
        return null;
    }

    public boolean enoughMoney(String name, Money money) {
        if (money.less(storage.getProduct(name).getPrice())) {
            return false;
        }
        return true;
    }

    public boolean enoughProducts(int num, String name) {
        if (storage.getProduct(name).getStock() < num) {
            return false;
        }
        return true;
    }

    public boolean objectExists(String name) {
        if (storage.getProduct(name) == null) {
            return false;
        }
        return true;
    }
}
