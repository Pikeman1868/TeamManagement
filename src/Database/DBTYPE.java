/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author PikeMobile
 */
public enum DBTYPE 
{

    SQLITE ("SQLITE"),
    MYSQL ("MYSQL");

    private final String name;       

    private DBTYPE(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equalsIgnoreCase(otherName);
    }
    
    public DBTYPE getEnum(String str)
    {
        if(str.equalsIgnoreCase(MYSQL.toString()))
        {
            return MYSQL;
        }
        else if(str.equalsIgnoreCase(SQLITE.toString()))
        {
            return SQLITE;
        }
        else
        {
            return SQLITE;
        }   
    }

    public String toString() {
       return this.name;
    }
}
