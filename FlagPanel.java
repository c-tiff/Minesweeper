package MineSweeper;

import javax.swing.*;
import java.awt.*;

public class FlagPanel extends NumberPanel{

    public FlagPanel(){
        this.setLayout(new GridLayout(1,3,0,0));
        this.setSize(100,50);


        label1.setIcon(zero);
        label2.setIcon(uno);
        label3.setIcon(none);


        this.add(label3);
        this.add(label2);
        this.add(label1);
    }
}

