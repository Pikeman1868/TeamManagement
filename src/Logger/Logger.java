/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logger;
import java.lang.System.*;

/**
 *
 * @author PikeMobile
 */
public class Logger {
    
    private Logger()
    {
        
    }
    
    private static Logger instance = null;
    
    public static Logger getInstance()
    {
        if(instance == null)
        {
            instance = new Logger();
        }
        return instance;
    }
    
    public void log(String msg)
    {
        System.out.println(msg);
    }
}
