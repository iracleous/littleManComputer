package little.man.computer;

import javax.swing.*;
import java.awt.*;

public class Main {

   public static void main(String[] args) {
       JOptionPane.showMessageDialog(null,
               "Little man Computer started");

       JFrame myFrame= new JFrame();
       myFrame.setSize ( new Dimension(300,300));
       JTextArea jTextArea = new JTextArea();
       myFrame.add( jTextArea );

       myFrame.setVisible(true);

        Cpu cpu = new Cpu( jTextArea );
        cpu.loadProgram("code.txt");
        cpu.executeProgram();
        cpu.printMemory();
    }

}
