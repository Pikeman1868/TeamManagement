/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teammanagement;
import java.time.*;
import Database.*;

/**
 *
 * @author PikeMobile
 */
public class Event {
    
    public Event(int ID, String Name, String Team, int Month, int Day, int Year, int Time, Database DB)
    {
        id = ID;
        eventName = Name;
        teamName = Team;
        month = Month;
        day = Day;
        year = Year;
        time = Time;
        //Date = new LocalDate(year,month,day);
    }
    
    public Event(String Name, String Team, int Month, int Day, int Year, int Time_)
    {
        eventName = Name;
        teamName = Team;
        month = Month;
        day = Day;
        year = Year;
        time = Time_;
        //get ID
        //db.
    }
    
    public void setID(int i)
    {
        id = i;
    }

    private int id, month, day,year,time;
    public LocalDateTime DateTime;
    private LocalDate Date;
    public LocalTime Time;
    public String eventName, teamName;
    public Team team;
}
