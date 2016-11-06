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
public class InvaildSigninExceptions extends Exception{
    
    public InvaildSigninExceptions()
    {
        super();
    }
    
    @Override
    public String getMessage()
    {
        return "Invaild User information";
    }
}
