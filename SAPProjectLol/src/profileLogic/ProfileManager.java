/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profileLogic;

import fileLogic.UserHandler;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author x
 */
public class ProfileManager {

    UserHandler f;

    public ProfileManager(boolean isAdministrator) {
        
        f = new UserHandler(isAdministrator);
        
        
    }

    public boolean containsName(String s) {
        if(!fileExists()){
            return false;
        }
        if (f.getUsernames().contains(s)) {
            return true;
        }
        return false;
    }
    public boolean fileExists(){
       return Files.exists(Paths.get(f.getJson()));
                   
    }
    public boolean login(User user) {
                

        if (f.getUsers().contains(user)) {
            return true;
        }
        return false;
    }

    public boolean createProfile(User user) {
         if(!fileExists()){
            f.addUser(user);
        }
        if (containsName(user.getUsername())) {
            return false;
        } else {
            f.addUser(user);
        }
        return true;
    }
}
