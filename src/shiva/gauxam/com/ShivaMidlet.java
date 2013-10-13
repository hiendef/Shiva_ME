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
import javax.microedition.io.Connection;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.midlet.*;

/**
 * @author hien
 */
public class ShivaMidlet extends MIDlet {
    private String serverName;
    private String serverPort;
    private DataInputStream dataIn;
    private Form f;
    private UIBuilder b;
    public ShivaMidlet()
    {
        this.serverName="socket://127.0.0.1";
        this.serverPort="9009";
    }
    public void startApp() {
        Display.init(this);
        Resources res = null;
        try {
            res = Resources.open("/gui/GUI_240x320.res");
            // Hien thi form ket noi
            UIManager.getInstance().setThemeProps(res.getTheme("Connect_THEME"));
            b=new UIBuilder();
            b.setResourceFilePath("/gui/GUI_240x320.res");
            f=b.showForm("Connect_GUI", null);
            f.show();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            dataIn=(DataInputStream)Connector.openDataInputStream(serverName+":"+serverPort);
            // Hien thi form Gauxam
            UIManager.getInstance().setThemeProps(Resources.open("/gui/GUI_240x320.res").getTheme("Gauxam_THEME"));
            f=b.showForm("Gauxam_GUI", null);
            f.removeAllCommands();
            f.show();
            // Hien thi form Login
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            UIManager.getInstance().setThemeProps(Resources.open("/gui/GUI_240x320.res").getTheme("Login_THEME"));
            f=b.showForm("Login_GUI", null);
            f.removeAllCommands();
            f.show();
            
        } catch (IOException ex) {
            try {
                UIManager.getInstance().setThemeProps(Resources.open("/gui/GUI_240x320.res").getTheme("ErrorConnect_THEME"));
                f=b.showForm("ErrorConnect_GUI", null);
                f.removeAllCommands();
                f.show();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex1) {
                    ex1.printStackTrace();
                }
                notifyDestroyed();
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }
    
    public void pauseApp() {
        
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
