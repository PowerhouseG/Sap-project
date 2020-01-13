/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileLogic;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import profileLogic.User;

/**
 *
 * @author x
 */
public class UserHandler {
    private boolean administrator;
    String json;

    public UserHandler(boolean administrator) {
        this.administrator = administrator;
        if(this.administrator){
            json = "src/passwords.json";
        }
        else{
            json = "src/clientPasswords.json";
        }
    }

    public String getJson() {
        return json;
    }

   
    

    public boolean addUser(User user) {
        if (Files.exists(Paths.get(json))) {
            List<User> users = getUsers();
            List<User> u = new ArrayList<>();
            for (User theUser : users) {
                u.add(theUser);

            }
            if(u.contains(user)){
                return false;
            }
            u.add(user);
            
            addUsers(u);
        } else {
            List<User> users = new ArrayList<>();
            
            users.add(user);
            addUsers(users);
        }
        return true;
    }

    public void addUsers(List<User> users) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get(json).toFile(), users);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<User> getUsers() {
        List<User> users;
        ObjectMapper mapper = new ObjectMapper();

        try {
            users = Arrays.asList(mapper.readValue(Paths.get(json).toFile(), User[].class));
            return users;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<User>();
    }
    public List<String> getUsernames(){
        List<User> users = getUsers();
        List<String> usernames = new ArrayList<>();
        for(User u : users){
            usernames.add(u.getUsername());
        }
        return usernames;
    }

}
