/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logger;

/**
 *
 * @author PikeMobile
 */
public enum LOGGERTYPE {

        NONE ("NONE"),
        VERBOSE ("VERBOSE"),
        BREIF ("BREIF");

        private final String name;       

        private LOGGERTYPE(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return (otherName == null) ? false : name.equals(otherName);
        }
        
        public LOGGERTYPE getEnum(String str)
        {
            if(str.equalsIgnoreCase(NONE.toString()))
            {
                return NONE;
            }
            else if(str.equalsIgnoreCase(VERBOSE.toString()))
            {
                return VERBOSE;
            }
            else if(str.equalsIgnoreCase(BREIF.toString()))
            {
                return BREIF;
            } 
            else
            {
                return NONE;
            }
        }

        public String toString() {
           return this.name;
        }
}
