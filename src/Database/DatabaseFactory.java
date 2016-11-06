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
public class DatabaseFactory {
    public Database getDatabase(DBTYPE dbEnum)
    {
        Database db = null;
        if(dbEnum == DBTYPE.MYSQL)
        {
            db = new MySQL();
        }
        else if(dbEnum == DBTYPE.SQLITE)
        {
            db = new SQLite();
        }
        return db;
    }
}
