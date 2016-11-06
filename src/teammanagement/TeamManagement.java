/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teammanagement;
import Controller.*;
import Logger.*;
import Database.*;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author PikeMobile
 */
public class TeamManagement {

    /**
     * @param args the command line arguments
     * Arguments looking for Database Type
     * Viewer Type
     * Logging Features 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Defualts if No Arguments Provided
       DBTYPE DBType = DBTYPE.SQLITE; // Type of Database used
       VIEWTYPE ViewerType = VIEWTYPE.LITE; // Type of View to produce
       LOGGERTYPE LoggingType = LOGGERTYPE.NONE; // Type of Logging to perform
       
       if(args.length > 0)
       {
            for(int i =0; i < args.length; i++)
            {
                //chcek for database string type
                if(args[i].equalsIgnoreCase(DBTYPE.MYSQL.toString()) || args[i].equalsIgnoreCase(DBTYPE.SQLITE.toString()))
                {
                   DBType = DBType.getEnum(args[i].toUpperCase());
                   System.out.println(DBType.toString());
                }
                else if(args[i].equalsIgnoreCase(VIEWTYPE.FULL.toString()) || 
                        args[i].equalsIgnoreCase(VIEWTYPE.LITE.toString()) || 
                        args[i].equalsIgnoreCase(VIEWTYPE.BACKEND.toString()))
                {
                    ViewerType = ViewerType.getEnum(args[i].toUpperCase());
                    System.out.println(ViewerType.toString());
                }
                else if(args[i].equalsIgnoreCase(LOGGERTYPE.BREIF.toString()) || 
                        args[i].equalsIgnoreCase(LOGGERTYPE.NONE.toString()) ||
                        args[i].equalsIgnoreCase(LOGGERTYPE.VERBOSE.toString()))
                {
                    LoggingType = LoggingType.getEnum(args[i].toUpperCase());
                    System.out.println(LoggingType.toString());
                }     
            }
       }
       
       //Create Logger
        l = Logger.getInstance();
        
       //create DB Class
       DatabaseFactory df = new DatabaseFactory();
       db = df.getDatabase(DBType);
        
        //create ViewController
        ControllerFactory cf = new ControllerFactory();
        c = cf.getController(ViewerType);
        c.setDB(db);
        c.setLogger(l);
       
    }
    
    private void init()
    {
        //get Teams that user is a part of
        //get Events for the teams
    }
    
    /**
     * Insert User into the database
     * @param U 
     */
    public void insert(User U)
    {
        String sql = "INSERT INTO USERS (Email, Password, First, Last, Phone) VALUES(?1,?2,?3,?4,?5)";
        try{
            db.insert(sql, U.getData());

        }
        catch(DatabaseInsertException e)
        {
            l.log(e.getMessage());
        }
        catch(Exception e)
        {
            
        } 
    }
    
    /**
     * Get Event ID from database
     * @param event
     * @return 
     */
    public int getID(Event event)
    {
        int i;
        String str = "SELECT ID FROM Events WHERE "
                + "Team = '" + event.eventName + "', "
                + "City = '" + event.teamName + "', "
                + "State = '" + event.team.state + "';";
        try{
            ResultSet rs = db.sendQuery(str);
            while(rs.next())
            {
                i = rs.getInt("ID");
                event.setID(i); 
            }
        }
        catch(SQLException e)
        {
            l.log(e.getMessage());
        }
    }
    
    /**
     * Get Id for the given team
     * @param t
     * @return 
     */
    public int getID(Team t)
    {
        String str = "SELECT ID FROM Teams WHERE "
                + "Team = '" + t.getName() + "', "
                + "City = '" + t.getCity() + "', "
                + "State = '" + t.getState() + "';";
        try{
            ResultSet rs = db.sendQuery(str);
            while(rs.next())
            {
               i = rs.getInt("ID");
               return i; 
            }
        }
        catch(SQLException e)
        {
            l.log(e.getMessage());
        }
        return i;
    }
    
    public User signIn(String u, String p)
    {
        try{
            String str = "SELECT Email, Password, First, Last , Phone "
                    + "FROM Users WHERE Email = '" + u + "';"; 
            ResultSet rs = db.sendQuery(str);

            while(rs.next())
            {
                String tempUser = rs.getString("Email");
                String tempPass = rs.getString("Password");
                String tempFirst = rs.getString("First");
                String tempLast = rs.getString("Last");
                String tempPhone = rs.getString("Phone");
                //l.log(tempUser + " " + tempPass + " " + tempFirst + " " + tempLast + " " + tempPhone);
                //l.log(u + " " + p);
                if(tempUser.equals(u) && tempPass.equals(p))
                {
                    l.log("Accepted Loggin");
                   return new User(tempUser, tempPass, tempFirst, tempLast, tempPhone);
                }
            }
        }
        catch(SQLException e)
        {
            l.log(e.getMessage());
        }
            
        return null;

    }
    
    
    /**
     * 
     * @return 
     */
    public Teams getAllTeams()
    {
        String sql = "INSERT INTO Teams (Name, Leader, City, State) VALUES(?1,?2,?3,?4)";
        ResultSet rs = db.sendQuery(sql);
        try{
        while(rs.next())
            {
                Team t = new Team(rs.getString("Name"), rs.getString("Leader"), rs.getString("City"), rs.getString("State"));
                t.setID(rs.getInt("ID"));
                teams.add(t);
            }
        }
        catch(Exception e)
        {
            l.log(e.getMessage());
        }
        return teams;
    }
    
    private static Database db;
    private Logger l;
    Teams teams;
    User u;
    private Controller c;
}
