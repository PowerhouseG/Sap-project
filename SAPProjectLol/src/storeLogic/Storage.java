/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeLogic;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author x
 */
public class Storage {
    

    private Map<Integer, Product> getProductById;
    private Map<String, Product> getProductByName;
    

    public Storage() {
        getProductByName = new HashMap<>();
        getProductById = new HashMap<>();
    }

    public void addProducts(List<Product> products){
        for(Product p : products){
            addProduct(p);
        }
    }

    public void addProduct(Product product) {
        if (!getProductByName.containsValue(product)) {
            if (!getProductById.containsValue(product)) {
                getProductByName.put(product.getName(), product);
                getProductById.put(product.getId(), product);
            }
        }

    }

    public Map<String, Product> getGetProductByName() {
        return getProductByName;
    }

    public Map<Integer, Product> getGetProductById() {
        return getProductById;
    }
    

    public Product getProduct(String name) {
        for (String p : getProductByName.keySet()) {
            if (p.equals(name)) {
                return getProductByName.get(p);
            }
        }
        return null;
    }

    public Product getProduct(int id) {
        for (int i : getProductById.keySet()) {
            if (i == id) {
                return getProductById.get(i);
            }
        }
        return null;
    }

    public void remove(String name) {
        if (getProductByName.containsKey(name)) {
            Product temp = getProductByName.get(name);
            getProductByName.remove(name);
            if (getProductById.containsValue(temp)) {
                remove(temp.getId());
            }
        }
    }

    public void remove(int id) {
        if (getProductById.containsKey(id)) {
            Product temp = getProductById.get(id);
            getProductById.remove(id);
            if (getProductByName.containsValue(temp)) {
                remove(temp.getName());
            }
        }
    }

    public Map<Product, Integer> getStock() {
        Map<Product, Integer> stocks = new HashMap<>();
        for (Product p : getProductByName.values()) {
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

    public void setPrice(String name, double price) {
        getProduct(name).setPrice(price);
    }

    public void setPrice(int id, double price) {
        getProduct(id).setPrice(price);
    }

    public void setMinPrice(int id, double price) {
        getProduct(id).setMinPrice(price);
    }

    public void setMinPrice(String name, double price) {
        getProduct(name).setMinPrice(price);
    }
    public List<Product> allProducts(){
        return new ArrayList<>(getProductByName.values());
    }
    public List<Product> allAvailable() {
        List<Product> products = new ArrayList<>();
        for (Product p : getProductByName.values()) {
            if (p.available()) {
                products.add(p);
            }
        }
        return products;
    }

    public List<Product> allAvailableBlackFriday() {
        List<Product> products = allAvailable();
        List<Product> black = new ArrayList<>();
        for (Product p : products) {
            if (p.isBlackFriday()) {
                black.add(p);
            }
        }
        return black;
    }
    public List<Product> allBlackFriday() {
        List<Product> black = new ArrayList<>();
        for (Product p : getProductByName.values()) {
            if (p.isBlackFriday()) {
                black.add(p);
            }
        }
        return black;
    }
}
