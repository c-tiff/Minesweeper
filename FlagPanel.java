package MineSweeper;

import javax.swing.*;
import java.awt.*;

public class FlagPanel extends JPanel{
    ImageIcon zero,uno,due,tre,quattro,cinque,sei,sette,otto,nove,none;
    JLabel flag1, flag2;

    public FlagPanel(){
    //flag numbers
        none = (new ImageIcon(new ImageIcon("images/none.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        zero = (new ImageIcon(new ImageIcon("images/zero.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        uno = (new ImageIcon(new ImageIcon("images/uno.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        due = (new ImageIcon(new ImageIcon("images/due.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        tre = (new ImageIcon(new ImageIcon("images/tre.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        quattro = (new ImageIcon(new ImageIcon("images/quattro.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        cinque = (new ImageIcon(new ImageIcon("images/cinque.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        sei = (new ImageIcon(new ImageIcon("images/sei.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        sette = (new ImageIcon(new ImageIcon("images/sette.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        otto = (new ImageIcon(new ImageIcon("images/otto.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        nove = (new ImageIcon(new ImageIcon("images/nove.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));

        flag1 = new JLabel();
        flag2 = new JLabel();
        this.setLayout(new GridLayout(1,3,0,0));
        this.setSize(100,50);
        flag1.setIcon(zero);
        flag2.setIcon(uno);

        // add to panels
        this.add(flag2);
        this.add(flag1);


    }
    public void setFlag1(int i){
        switch(i){
            case 1:
                flag1.setIcon(uno);
                break;
            case 2:
                flag1.setIcon(due);
                break;
            case 3:
                flag1.setIcon(tre);
                break;
            case 4:
                flag1.setIcon(quattro);
                break;
            case 5:
                flag1.setIcon(cinque);
                break;
            case 6:
                flag1.setIcon(sei);
                break;
            case 7:
                flag1.setIcon(sette);
                break;
            case 8:
                flag1.setIcon(otto);
                break;
            case 9:
                flag1.setIcon(nove);
                break;
            default:
                flag1.setIcon(zero);
                break;
        }

    }
    public void setFlag2(int i){
        if (i<10){
            flag2.setIcon(zero);
        }
        else{
            flag2.setIcon(uno);
        }
    }
}

