/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import teammanagement.User;
import View.LiteView.*;
import javax.swing.*;
import Database.*;

/**
 *
 * @author PikeMobile
 */
public class LiteController extends Controller{
    
    /**
     * 
     */
    public LiteController()
    {
          f = new JFrame("Team Manager Lite");  
          f.setSize(width, heigth);
          f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
          state = STATE.SIGNIN;
          viewState();
    }
    
    
    @Override
    /**
     * 
     */
    public void signIn(String username, String password)
    {
        User u = mc.signIn(username, password);
        if(u == null)
        {
            l.log("User Null");
        }
        try{
            //System.out.println(u.toString());
        
            user = u;
            state = STATE.HOME;
            viewState(); 

        }
        catch(Exception e)
        {
            notify("Sign In Error");
        }
    }
    
    /**
     * 
     */
    public void viewState()
    {
        if(p != null)
        {
            f.remove(p);
        }
        
      switch (state)
      {
        case SIGNIN: 
            p = new LiteSignIn(this);
            break;
        case REGISTER:
            p = new LiteRegister(this);
            break;
        case HOME:
            p = new LiteHome(this);
            break;
        default:
            p = new LiteSignIn(this);
      }
              
          f.add(p);
           this.show();
    }
    
    public void show()
    {
        p.setVisible(true);
        f.setVisible(true);
    }
    
    
    
    public void notify(String msg)
    {
        Notification n = new Notification(f, true, msg);
          n.setSize(width, heigth/4);
          n.setVisible(true);
    }
    
    public void changeState(STATE s)
    {
        state = s;
    }
    
    public void setDB(Database newDB)
    {
        db = newDB;    
    }
    
    public void register(String email, String first, String last, String password, String phone)
    {
        User u = new User(email, password, first, last, phone);
        try{
            db.insert(u);
        state = STATE.SIGNIN;
        viewState();
        }
        catch(Exception e)
        {
            state = STATE.REGISTER;
            viewState();
        }
    }
    
    public void nextState()
    {
        switch (state)
      {
        case SIGNIN: 
            state = STATE.REGISTER;
            break;
        case REGISTER:
            state = STATE.SIGNIN;
            break;
        case HOME:
            state = STATE.SIGNIN;
            break;
        default:
            state = STATE.SIGNIN;
      }
        viewState();
    }
    
    private JFrame f;
    private int width = 300;
    private int heigth = 400;
    private STATE state;
    //private Database db;
    private JPanel p = null;
    private User user;
    
}

