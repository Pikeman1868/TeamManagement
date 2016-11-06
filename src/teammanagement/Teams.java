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
public class Teams{
    
    public Teams()
    {
        i = 0;
    }
    
    public int size()
    {
        return i;
    }
    
    public Team get(int i)
    {
        return list[i];
    }
    
    public void add(Team t)
    {
        list[i] = t;
        i++;
    }
    
    
   private int i;
   private Team[] list;
    
  public class Iterator{
      
        public Iterator(Teams t)
        {
             team = t; 
             i = 0;  
        } 
        
        public boolean hasNext()
        {
            if(i <= team.size())
            {
                return true;   
            }
            else
            {
                return false;
            }
        }
        
        public Team next()
        {
            if(hasNext())
            {
                i++;
                return team.get(i);
            }
            else
            {
                return null;
            }
           
        }
        
        private Teams team;
        private int i;
  }
  
  
}

