/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teammanagement;

/**
 *
 * @author PikeMobile
 */
public class User {
    
    public User(String u, String p, String f, String l, String ph)
    {
        username = u;
        password = p;
        first = f;
        last = l;
        phone = ph;
        
    }
    
    public void setTeams(Teams t)
    {
        teams = t;
    }
    
    public Teams getTeams()
    {
        return teams;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getFirstName()
    {
        return first;
    }
    
    public String getLastName()
    {
        return last;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public String toString()
    {
        return username + " " + password + " " + first + " " + last + " " + phone;
    }
    
    public Object[] getData()
    {
        Object[] o;
        o[0] = username;
        o[1] = password;
        o[2] = first;
        o[3] = last;
        o[4] = phone;
        
        return o;
    }
    
    private String username;
    private String password;
    private String first;
    private String last;
    private Teams teams;
    private String phone;
    
}
