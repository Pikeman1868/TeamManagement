/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;
import Logger.Logger;


/**
 * Class mediate between database and application
 * @author PikeMobile
 */
public class SQLite extends Database{
    
    public SQLite()
    {
        //super();
        sendQuery(userTable);
        sendQuery(teamTable);
    }

    /**
     * 
     */
    private String dbPath = "jdbc:sqlite:/Users/PikeMobile/Programs/TeamManagement/db/management.db";
    String userTable = "CREATE TABLE IF NOT EXISTS \"Users\" (\"Email\" TEXT PRIMARY KEY  NOT NULL  UNIQUE , \"First\" TEXT NOT NULL , \"Last\" TEXT NOT NULL , \"Phone\" TEXT, \"Password\" TEXT NOT NULL );";
    String teamTable = "CREATE  TABLE  IF NOT EXISTS \"main\".\"Teams\" (\"ID\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , \"Name\" TEXT NOT NULL , \"Leader\" TEXT NOT NULL , \"City\" TEXT NOT NULL , \"State\" TEXT NOT NULL )";
    String eventsTable = "CREATE  TABLE  IF NOT EXISTS \"main\".\"Events\" (\"ID\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , \"Name\" TEXT NOT NULL , \"Team\" TEXT NOT NULL , \"Day\" INTEGER NOT NULL , \"Month\" INTEGER NOT NULL , \"Year\" INTEGER NOT NULL , \"Time\" INTEGER NOT NULL )";
    
    
}
