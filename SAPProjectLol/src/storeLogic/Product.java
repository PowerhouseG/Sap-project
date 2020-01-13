/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeLogic;

import java.util.Objects;

/**
 *
 * @author x
 */
public class Product {

    private int stock;
    private boolean blackFriday;
    private String name;
    private int id;
    private double price;
    private double minPrice;
    private double oldPrice;

    
   

    public Product(int stock, boolean blackFriday, String name, int id, double price, double minPrice) {
        this.stock = stock;
        this.blackFriday = blackFriday;
        this.name = name;
        this.id = id;
        this.price = price;
        this.minPrice = minPrice;
    }

    public Product() {
    }
    
    public void startBlackFriday(int discount){
        if(price - price*(double)discount/100.00<minPrice){
            double temp = price;
            price = minPrice;
            minPrice = temp;
        }
        else{
//            price -=Math.round(price*(double)discount)/100.00;
            oldPrice = price;
            price -= price*(double)discount/100.00;
            price = Math.round(price*100.00)/100.00;
        }
    }
    public void stopBlackFriday(int discount){
        if(price<=minPrice){
            double temp = price;
            price = minPrice;
            minPrice = temp;
        }
        else{
            price =oldPrice;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    
    public int getStock() {
        return stock;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
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
