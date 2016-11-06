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
public class SigninMismatchException extends Exception {
    
    public SigninMismatchException()
    {
        super();
    }
    
    @Override
    public String getMessage()
    {
        return "Username and Password do not match";
    }
}
