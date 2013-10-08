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
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Hashtable;
import javax.microedition.io.Connector;
import javax.microedition.midlet.*;

/**
 * @author hien
 */
public class ShivaMidlet extends MIDlet {
    private String serverName;
    private String serverPort;
    public ShivaMidlet()
    {
        this.serverName="http://127.0.0.1";
        this.serverPort="9009";
    }
    public void startApp() {
        Display.init(this);
        Resources res = null;
        try {
            res = Resources.open("/gui/GUI_240x320.res");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        UIManager.getInstance().setThemeProps(res.getTheme("Connect_THEME"));
        UIBuilder b=new UIBuilder();
        b.setResourceFilePath("/gui/GUI_240x320.res");
        Form f=b.showForm("Connect_GUI", null);
        f.show();
        try {
            // connect to server_name: localhost_port: 9009
            DataInputStream dataIn= Connector.openDataInputStream(serverName+":"+serverPort);
            if(true)
            {
                f=null;
                f.repaint();
                Display.init(this);
                f=b.showForm("Gauxam_GUI", null);
                f.show();
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void pauseApp() {
        
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
