/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeLogic;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import moneyLogic.Money;

/**
 *
 * @author x
 */
public class Store {

    private Money money;
    private Storage storage;
    private Map<Money, Date> account;

    public Store() {
        this(new Money(0, 0), new Storage());
    }

    public Store(Storage storage) {
        this(new Money(0, 0), storage);
    }

    public Store(Money money) {
        this(money, new Storage());
    }

    public Store(Money money, Storage storage) {
        this.money = money;
        this.storage = storage;
        account = new HashMap<>();
    }

    public void saveAccount(Date date, Money money) {
        account.put(money, date);
    }

    public boolean isWithinRange(Date testDate, Date startDate, Date endDate) {
        return testDate.after(startDate) && testDate.before(endDate);
    }

    public boolean isAfter(Date testDate, Date startDate) {
        return testDate.after(startDate);
    }

    public boolean isBefore(Date testDate, Date endDate) {
        return testDate.before(endDate);
    }

    public Date createDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        return cal.getTime();
    }

    public Date createTime(int hour, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        return cal.getTime();
    }

    public Date createDateAndTime(int year, int month, int day, int hour, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, hour, minutes, 0);
        return cal.getTime();
    }

    public Map<Money, Date> getAccountsWithinRange(Date startDate, Date endDate) {
        Map<Money, Date> ac = new HashMap<>();
        for (Money m : account.keySet()) {
            if (isWithinRange(account.get(m), startDate, endDate)) {
                ac.put(m, account.get(m));
            }
        }
        return ac;
    }

    public Map<Money, Date> getAccountsAfter(Date startDate) {
        Map<Money, Date> ac = new HashMap<>();
        for (Money m : account.keySet()) {
            if (isAfter(account.get(m), startDate)) {
                ac.put(m, account.get(m));
            }
        }
        return ac;
    }

    public Map<Money, Date> getAccountsBefore(Date endDate) {
        Map<Money, Date> ac = new HashMap<>();
        for (Money m : account.keySet()) {
            if (isBefore(account.get(m), endDate)) {
                ac.put(m, account.get(m));
            }
        }
        return ac;
    }

    public Map<Money, Date> getAccount() {
        return account;
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
            saveAccount(new Date(), this.money);
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
