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
public class Team {
    
    public Team(String Name, String Leader, String City, String State)
    {
        name = Name;
        leader = Leader;
        city = City;
        state = State;
    }
    
    public String getName(){
        return name;
    }
    
    public String getLeader(){
        return leader;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public String getState(){
        return state;
    }
    
    public void setID(int i)
    {
        ID = i;
    }
    
    @Override
    public String toString()
    {
        String str = name + " " + city + ", " + state + " " + leader;
        return str;
    }
    
    String name, leader, city, state;
    int ID;
            
}
