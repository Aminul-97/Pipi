import java.io.*;
import java.net.*;
import javax.swing.*;

class Web extends Thread
{
   public void run(){
       int l=0;
       while(l==0){
       try{
           URL url = new URL("http://www.pipi.arcs12.com");
           BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }
            int s = sb.toString().length();
            if(s>2) { JOptionPane.showMessageDialog(null,sb); l=1;}
            
        }catch(Exception e){}
     }
    }
}
