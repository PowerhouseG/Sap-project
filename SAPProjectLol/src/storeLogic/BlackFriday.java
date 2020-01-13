/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeLogic;

import java.util.List;

/**
 *
 * @author x
 */
public class BlackFriday {

    private int discount;
    private boolean isOn;

    public BlackFriday(int discount) {
        this.discount = discount;
        isOn = false;
    }

    public void startCampain(Storage storage) {
        if (!isOn) {
            isOn = true;
            List<Product> products = storage.allBlackFriday();
            for(Product p : products){
                p.startBlackFriday(discount);
            }
        }

    }
    public void endCampain(Storage storage){
        if(isOn){
            List<Product> products = storage.allBlackFriday();
            for(Product p : products){
                p.stopBlackFriday(discount);
            }
        }
    }
    
}
