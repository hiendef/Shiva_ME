/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shiva.gauxam.com;

import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import com.sun.lwuit.util.UIBuilder;
import java.io.IOException;
import java.util.Hashtable;
import javax.microedition.midlet.*;

/**
 * @author hien
 */
public class ShivaMidlet extends MIDlet {

    public void startApp() {
        Display.init(this);
        UIBuilder b=new UIBuilder();
        b.setResourceFilePath("/gui/GUI_240x320.res");
        Form connect=b.showForm("Connect_GUI", null);
        connect.show();     
    }
    
    public void pauseApp() {
        
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
