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
    
    /**
     * Set the users teams
     * @param t Teams
     */
    public void setTeams(Teams t)
    {
        teams = t;
    }
    
    /**
     * Add an individual team to the Users Team List
     * @param t 
     */
    public void addTeam(Team t)
    {
        teams.add(t);
    }
    
    /**
     * Get a list of Teams that the user is connected to.
     * @return 
     */
    public Teams getTeams()
    {
        return teams;
    }
    
    /**
     * Get the User's Username
     * @return 
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * Get the User's password
     * @return String
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * Get the User's First Name
     * @return String
     */
    public String getFirstName()
    {
        return first;
    }
    
    /**
     * Get the User's Last name
     * @return String
     */
    public String getLastName()
    {
        return last;
    }
    
    /**
     * Get Phone number
     * @return String
     */
    public String getPhone()
    {
        return phone;
    }
    
    /**
     * Get a string of the user info
     * @return String
     */
    @Override
    public String toString()
    {
        return username + " " + password + " " + first + " " + last + " " + phone;
    }
    
    /**
     * Get an array of data
     * @return Object
     */
    public Object[] getData()
    {
        Object[] o = {username, password, first, last, phone};
        
        return o;
    }
    
    private String username;
    private String password;
    private String first;
    private String last;
    private Teams teams;
    private String phone;
    
}
