/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shiva.gauxam.com;

import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import javax.microedition.midlet.*;

/**
 * @author hien
 */
public class ShivaMidlet extends MIDlet {

    public void startApp() {
        Display.init(this);
        
    }
    
    public void pauseApp() {
        
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
