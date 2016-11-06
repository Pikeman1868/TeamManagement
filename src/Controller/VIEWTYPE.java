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
    public enum VIEWTYPE 
    {
        LITE ("LITE"),
        FULL ("FULL"),
        BACKEND ("BACKEND");

        private final String name;       

        private VIEWTYPE(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return (otherName == null) ? false : name.equals(otherName);
        }
        
        public VIEWTYPE getEnum(String str)
    {
        if(str.equalsIgnoreCase(LITE.toString()))
        {
            return LITE;
        }
        else if(str.equalsIgnoreCase(FULL.toString()))
        {
            return FULL;
        }
        else if(str.equalsIgnoreCase(BACKEND.toString()))
        {
            return BACKEND;
        } 
        else
        {
            return LITE;
        }
    }

        public String toString() {
           return this.name;
        }
    }
