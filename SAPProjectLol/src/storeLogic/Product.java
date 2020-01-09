/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeLogic;

import java.util.Objects;
import moneyLogic.Money;

/**
 *
 * @author x
 */
//NOTES:
//1: ADD HASH MAP AND THE OTHER THING WHEN YOU'RE FINISHED HERE'
public class Product {

    private int stock;
    private boolean blackFriday;
    private String name;
    private int id;
    private Money price;
    private Money minPrice;
//NOTES:
//    1: You'll have to take money input as a string like "9.99" razdelqash stringa za tochkata i sazdavash nov
//    Money obekt

    public Product(int stock, boolean blackFriday, String name, int id, String money, String minPrice) {
        this.stock = stock;
        this.blackFriday = blackFriday;
        this.name = name;
        this.id = id;
        this.price = Money.toMoney(money);
        this.minPrice = Money.toMoney(minPrice);
    }

    public Money getPrice() {
        return price;
    }

    public Money getMinPrice() {
        return minPrice;
    }

    public void setPrice(String price) {
        this.price = Money.toMoney(price);
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = Money.toMoney(minPrice);
    }

    public void setMoney(Money money) {
        this.price = money;
    }

    public void setMinPrice(Money minPrice) {
        this.minPrice = minPrice;
    }

    public int getStock() {
        return stock;
    }

    //returns number or returns stock if not enough products 
//    the idea is to check if number is the same as buy()'s return
    //you don't buy anything if not enough stock you ask your client and then you can buy what's left
    public int buy(int number) {
        if (number > stock) {
            return stock;
        }
        stock -= number;
        return number;
    }

    public void addStock(int number) {
        stock += number;
    }

    public boolean isBlackFriday() {
        return blackFriday;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public boolean available(){
        if(stock>0){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.stock;
        hash = 37 * hash + (this.blackFriday ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.price);
        hash = 37 * hash + Objects.hashCode(this.minPrice);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.stock != other.stock) {
            return false;
        }
        if (this.blackFriday != other.blackFriday) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.minPrice, other.minPrice)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id+": "+name+", stock: "+stock+", price: "+price;
    }
    
    
}
