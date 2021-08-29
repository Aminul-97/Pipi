import java.awt.*;
import javax.swing.*;

class Pipi
{
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){}
        Run run = new Run();
        Server sr = new Server();
        Web wb = new Web();
        run.setPriority(10);
        sr.setPriority(1);
        wb.setPriority(1);
        run.start();
        sr.start();
        wb.start();
    }
}
