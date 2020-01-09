/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeLogic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author x
 */
public class Store {

    Map<Integer, Product> findByNumber;
    Map<String, Product> findByName;

    public Store() {
        findByName = new HashMap<>();
        findByNumber = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (!findByName.containsValue(product)) {
            if (!findByNumber.containsValue(product)) {
                findByName.put(product.getName(), product);
                findByNumber.put(product.getId(), product);
            }
        }

    }

    public Product getProduct(String name) {
        for (String p : findByName.keySet()) {
            if (p.equals(name)) {
                return findByName.get(p);
            }
        }
        return null;
    }

    public Product getProduct(int id) {
        for (int i : findByNumber.keySet()) {
            if (i == id) {
                return findByNumber.get(i);
            }
        }
        return null;
    }

    public void remove(String name) {
        if (findByName.containsKey(name)) {
            Product temp = findByName.get(name);
            findByName.remove(name);
            if (findByNumber.containsValue(temp)) {
                remove(temp.getId());
            }
        }
    }

    public void remove(int id) {
        if (findByNumber.containsKey(id)) {
            Product temp = findByNumber.get(id);
            findByNumber.remove(id);
            if (findByName.containsValue(temp)) {
                remove(temp.getName());
            }
        }
    }

    public Map<Product, Integer> getStock() {
        Map<Product, Integer> stocks = new HashMap<>();
        for (Product p : findByName.values()) {
            stocks.put(p, p.getStock());
        }
        return stocks;
    }

    public int getStock(int id) {
        return getProduct(id).getStock();
    }

    public int getStock(String name) {
        return getProduct(name).getStock();
    }
    
    public void setPrice(String name,String price){
        getProduct(name).setPrice(price);
    }
    public void setPrice(int id,String price){
        getProduct(id).setPrice(price);
    }
    public void setMinPrice(int id,String price){
        getProduct(id).setMinPrice(price);
    }
     public void setMinPrice(String name,String price){
        getProduct(name).setMinPrice(price);
    }

}
