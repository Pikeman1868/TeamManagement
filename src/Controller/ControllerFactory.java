/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author PikeMobile
 */
public class ControllerFactory {
    
    public Controller getController(VIEWTYPE vt)
    {
        Controller c = null;
        if(vt == VIEWTYPE.FULL)
        {
            c = new FullController();
        }
        else if(vt == VIEWTYPE.LITE)
        {
            c = new LiteController();
        }
        else if(vt == VIEWTYPE.BACKEND)
        {
            
        }
        
        return c;
    }
    
}
