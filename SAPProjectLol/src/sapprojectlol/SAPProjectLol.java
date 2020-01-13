/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sapprojectlol;

import fileLogic.StorageHandler;
import fileLogic.UserHandler;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import profileLogic.MD5;
import profileLogic.NonAdministratorUser;
import profileLogic.ProfileManager;
import profileLogic.User;
import storeLogic.BlackFriday;
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
//        Product carrot = new Product(20, true, "Carrot", 1, 9.99, 9.98);
//        Product diamond = new Product(0, false, "Diamond", 2, 9.99, 9.98);
//        Product stick = new Product(2, true, "Stick", 3, 25.99, 1.00);
//        System.out.println("Amount of carrots: " + carrot.getStock());
//        carrot.buy(0);
//        System.out.println("Amount of carrots: " + carrot.getStock());
//        carrot.buy(3);
//        System.out.println("Amount of carrots: " + carrot.getStock());
//        carrot.buy(3);
//        System.out.println("Amount of carrots: " + carrot.getStock());
//
//        Storage storage = new Storage();
//        storage.addProduct(carrot);
//        storage.addProduct(diamond);
//        storage.addProduct(diamond);
//        System.out.println(storage.getProduct("Carrot").getName());
//        storage.remove(1);
//        System.out.println(storage.getProduct(1));
//        System.out.println(storage.getProduct("Carrot"));
//        System.out.println("");
//
//        storage.addProduct(carrot);
//        System.out.println(storage.getProduct("Carrot").getMinPrice());
//        carrot.setMinPrice(2.33);
//        System.out.println(storage.getProduct("Carrot").getMinPrice());
//
//        System.out.println(storage.getProduct(1).getPrice());
//        storage.setPrice(1, 0.43);
//        System.out.println(storage.getProduct(1).getPrice());
//        System.out.println(storage.getProduct("Carrot").getMinPrice());
//        storage.setMinPrice(1, 4.88);
//        System.out.println(carrot.getMinPrice());
//
//        storage.addProduct(stick);
//        System.out.println("");
//        System.out.println(storage.allAvailable());
//        System.out.println(storage.allAvailableBlackFriday());
//        System.out.println(storage.allBlackFriday());
//
//        Store store = new Store(storage);
//        System.out.println("");
//        System.out.println(store.enoughMoney("Carrot", 0.43));
//        System.out.println(store.enoughProducts(111, "Stick"));
//        System.out.println(store.objectExists("carrot"));
//        System.out.println("");
//        double money = 43.33;
//        System.out.println("Store money: " + store.getMoney());
//        try {
//            //test buySingle()
//            money = store.buySingle("Carrot", money);
//            System.out.println(carrot);
//            System.out.println(money);
////            test when you have an unexisting product
//            money = store.buySingle("carrot", money);
//            System.out.println(carrot);
//            System.out.println(money);
//            money = 23.43;
////test when you don't have enough money
//            money = store.buySingle("Stick", money);
//            System.out.println(stick);
//            System.out.println(money);
//            money = 23.43;
//            //test when you don't have enough stock
//
//            money = store.buySingle("Diamond", money);
//            System.out.println(diamond);
//            System.out.println(money);
//            store.buySingle("Carrot", 100);
//            store.buySingle("Carrot", 100);
//            store.buySingle("Carrot", 100);
//
//        } catch (Exception ex) {
//            Logger.getLogger(SAPProjectLol.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("Store money: " + store.getMoney());
//        System.out.println("Account: " + store.getAccount());
//        System.out.println(store.createDate(12, 12, 12));
//        System.out.println(store.createDateAndTime(12, 12, 21, 12, 12));
//        System.out.println(store.createTime(12, 12));
//
//        System.out.println("");
//        //TESTING THE DATE TIME SHANENIGANS
//        System.out.println(store.getAccountsWithinRange(store.createTime(17, 44), store.createTime(17, 46)));
//        
//        
//storage.setPrice(1, 9.98);
//storage.setMinPrice(1, 9.98);
//        System.out.println("Price before bf: ");
//        System.out.println(carrot);
//        System.out.println("Min price "+carrot.getMinPrice());
//        System.out.println(diamond);
//        System.out.println("Min price "+diamond.getMinPrice());
//        System.out.println(stick);
//        System.out.println("Min price "+stick.getMinPrice());
//        carrot.startBlackFriday(20);
//        diamond.startBlackFriday(20);
//        stick.startBlackFriday(20);
//        System.out.println("");
//        System.out.println("Price after bf: ");
//        System.out.println(carrot);
//        System.out.println(diamond);
//        System.out.println(stick);
//        carrot.stopBlackFriday(20);
//        diamond.stopBlackFriday(20);
//        stick.stopBlackFriday(20);
//        System.out.println("");
//        System.out.println("Price after bf ends: ");
//            System.out.println(carrot);
//        System.out.println("Min price "+carrot.getMinPrice());
//        System.out.println(diamond);
//        System.out.println("Min price "+diamond.getMinPrice());
//        System.out.println(stick);
//        System.out.println("Min price "+stick.getMinPrice());
//        
//        
//        BlackFriday b = new BlackFriday(32);
//        System.out.println("");
//        System.out.println("Price before bf: ");
//        System.out.println(carrot);
//        System.out.println("Min price "+carrot.getMinPrice());
//        System.out.println(diamond);
//        System.out.println("Min price "+diamond.getMinPrice());
//        System.out.println(stick);
//        System.out.println("Min price "+stick.getMinPrice());
//        b.startCampain(storage);
//        b.startCampain(storage);
//        System.out.println("");
//        System.out.println("Price during bf: ");
//        System.out.println(carrot);
//        System.out.println("Min price "+carrot.getMinPrice());
//        System.out.println(diamond);
//        System.out.println("Min price "+diamond.getMinPrice());
//        System.out.println(stick);
//        System.out.println("Min price "+stick.getMinPrice());
//        b.endCampain(storage);
//        b.endCampain(storage);
//        System.out.println("");
//         System.out.println("Price after bf: ");
//        System.out.println(carrot);
//        System.out.println("Min price "+carrot.getMinPrice());
//        System.out.println(diamond);
//        System.out.println("Min price "+diamond.getMinPrice());
//        System.out.println(stick);
//        System.out.println("Min price "+stick.getMinPrice());
        Product carrot = new Product(20, true, "Carrot", 1, 9.99, 9.98);
        Product diamond = new Product(0, false, "Diamond", 2, 9.99, 9.98);
        Product stick = new Product(2, true, "Stick", 3, 25.99, 1.00);
        StorageHandler f = new StorageHandler();

        Storage s = new Storage();
        s.addProduct(stick);
        s.addProduct(carrot);
        s.addProduct(diamond);
        Store store = new Store(s);
        try {
            store.buySingle("Carrot", 10.00);
        } catch (Exception ex) {
            Logger.getLogger(SAPProjectLol.class.getName()).log(Level.SEVERE, null, ex);
        }
        f.saveListOfProducts(s.allProducts());
        Storage s2 = new Storage();
        s2.addProducts(f.retrieveListOfProducts());
        System.out.println(s2.allProducts());
        s.addProducts(f.retrieveListOfProducts());
        System.out.println(s.allProducts());
        try {
            store.buySingle("Stick", 30.00);
        } catch (Exception ex) {
            Logger.getLogger(SAPProjectLol.class.getName()).log(Level.SEVERE, null, ex);
        }
        f.saveListOfProducts(s.allProducts());
        s.addProducts(f.retrieveListOfProducts());
        System.out.println(s.allProducts());
        System.out.println(MD5.getMd5("332"));
        System.out.println(MD5.getMd5("333"));

//        System.out.println("file exists: " + Files.exists(Paths.get("src/product.json")));
//        UserHandler u = new UserHandler(true);
//        u.addUser(new User("Hans", "123"));
//        System.out.println(u.getUsers());
//        u.addUser(new User("Hans2", "1232"));
//        System.out.println(u.getUsers());
//        ProfileManager p = new ProfileManager(true);
//        System.out.println("Login successful: " + p.login(new User("Hans", "123")));
//        System.out.println("Login successful: " + p.login(new User("Hans", "12")));
//        System.out.println("Login successful: " + p.login(new User("Han", "123")));
//        System.out.println("Login successful: " + p.login(new User("Hans2", "123")));
//        System.out.println("Login successful: " + p.login(new User("Hans", "1232")));
//        System.out.println("Login successful: " + p.login(new User("Hans2", "1232")));
//        System.out.println("");
        ProfileManager p = new ProfileManager(true);
        p.createProfile(new User("Han", "234"));
        p.createProfile(new User("Han", "234"));
        System.out.println("Login: " + p.login(new User("Han", "234")));
        ProfileManager p2 = new ProfileManager(false);
        p2.createProfile(new NonAdministratorUser("Han", "234").getUser());
        System.out.println("Login: " + p2.login(new User("Han", "234")));
                p2.createProfile(new NonAdministratorUser("Hans", "234").getUser());
                        System.out.println("Login: " + p.login(new User("Hans", "234")));

                


    }

}
