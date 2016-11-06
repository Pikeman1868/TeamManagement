/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import teammanagement.*;
import Database.Database;
import Logger.Logger;

/**
 *
 * @author PikeMobile
 */
public class Controller {
    
    Logger l = null;
    Database db = null;
    TeamManagement tm = null;
    //public User user = null;

    public Controller(TeamManagement TM)
    {
        tm = TM;
    }
    
    public void registerUser(User u)
    {
        tm.registerUser(u);
    }
    
    public void setDB(Database DB)
    {
        db = DB;
    }
    
    public void setLogger(Logger L)
    {
        l = L;
    }
    
    public void registerTeam(Team t)
    {
        tm.insert(t);
    }
    
    public void signIn(String username, String password)
    {
        User u = tm.signIn(username, password);
        if(u == null)
        {
            l.log("User Null");
            l.log("Incorrect Username and Password");
        }
        try{
            tm.setUser(u);
        }
        catch(Exception e)
        {
            //Notification
            l.log("Incorrect Username and Password");
        }
    }
    
    public void quitApp()
    {
        System.exit(0);
    }
    
    public enum STATE
    {
        SIGNIN ("SIGNIN"),
        REGISTER ("REGISTER"), 
        HOME ("HOME");

       private final String state;       

       private STATE(String s) {
           state = s;
       }

       public boolean equalsName(String otherName) {
           return (otherName == null) ? false : state.equalsIgnoreCase(otherName);
       }

       public String toString() {
          return this.state;
       }
      
    };
    
    
    
}
