/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profileLogic;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author x
 */
public class NonAdministratorUser {
    private double money;
    private User user;

    public NonAdministratorUser(String username, String password) {
        money = 100.00;
        user = new User(username, password);
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double money){
        this.money+=money;
    }

    public User getUser() {
        return user;
    }
    
}
