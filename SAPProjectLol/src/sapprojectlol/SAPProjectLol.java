/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sapprojectlol;

import moneyLogic.Money;
import storeLogic.Product;
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
        Product carrot = new Product(5, true, "Carrot", 1, "9:99", "9:98");
        Product diamond = new Product(10, true, "Diamond", 2, "9:99", "9:98");
        System.out.println("Amount of carrots: " + carrot.getStock());
        carrot.buy(0);
        System.out.println("Amount of carrots: " + carrot.getStock());
        carrot.buy(3);
        System.out.println("Amount of carrots: " + carrot.getStock());
        carrot.buy(3);
        System.out.println("Amount of carrots: " + carrot.getStock());

        Store store = new Store();
        store.addProduct(carrot);
        store.addProduct(diamond);
        store.addProduct(diamond);
        System.out.println(store.getProduct("Carrot").getName());
        store.remove(1);
        System.out.println(store.getProduct(1));
        System.out.println(store.getProduct("Carrot"));
        System.out.println("");
        
        store.addProduct(carrot);
        System.out.println(store.getProduct("Carrot").getMinPrice());
        carrot.setMinPrice("2:33");
        System.out.println(store.getProduct("Carrot").getMinPrice());
 
        System.out.println(store.getProduct(1).getPrice());
        carrot.setPrice("0:33");
        System.out.println(store.getProduct(1).getPrice());
        System.out.println(store.getProduct("Carrot").getMinPrice());
        store.setMinPrice(1,"4:88lv");
        System.out.println(carrot.getMinPrice());
    }

}
