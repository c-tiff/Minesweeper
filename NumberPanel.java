package MineSweeper;

import javax.swing.*;
import java.awt.*;

public abstract class NumberPanel extends JPanel{
    protected final ImageIcon zero,uno,due,tre,quattro,cinque,sei,sette,otto,nove,none;
    protected final JLabel label1,label2,label3;
    public NumberPanel(){
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
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

        this.add(label1);
        this.add(label2);
        this.add(label3);
    }
    public void setLabel1(char c){
        switch(c){
            case '1':
                label1.setIcon(uno);
                break;
            case '2':
                label1.setIcon(due);
                break;
            case '3':
                label1.setIcon(tre);
                break;
            case '4':
                label1.setIcon(quattro);
                break;
            case '5':
                label1.setIcon(cinque);
                break;
            case '6':
                label1.setIcon(sei);
                break;
            case '7':
                label1.setIcon(sette);
                break;
            case '8':
                label1.setIcon(otto);
                break;
            case '9':
                label1.setIcon(nove);
                break;
            case '0':
                label1.setIcon(zero);
                break;
            default:
                label1.setIcon(none);
                break;
        }
    }
    public void setLabel2(char c){
        switch(c){
            case '1':
                label2.setIcon(uno);
                break;
            case '2':
                label2.setIcon(due);
                break;
            case '3':
                label2.setIcon(tre);
                break;
            case '4':
                label2.setIcon(quattro);
                break;
            case '5':
                label2.setIcon(cinque);
                break;
            case '6':
                label2.setIcon(sei);
                break;
            case '7':
                label2.setIcon(sette);
                break;
            case '8':
                label2.setIcon(otto);
                break;
            case '9':
                label2.setIcon(nove);
                break;
            case '0':
                label2.setIcon(zero);
                break;
            default:
                label2.setIcon(none);
                break;
        }
    }
    public void setLabel3(char c){
        switch(c){
            case '1':
                label3.setIcon(uno);
                break;
            case '2':
                label3.setIcon(due);
                break;
            case '3':
                label3.setIcon(tre);
                break;
            case '4':
                label3.setIcon(quattro);
                break;
            case '5':
                label3.setIcon(cinque);
                break;
            case '6':
                label3.setIcon(sei);
                break;
            case '7':
                label3.setIcon(sette);
                break;
            case '8':
                label3.setIcon(otto);
                break;
            case '9':
                label3.setIcon(nove);
                break;
            case '0':
                label3.setIcon(zero);
                break;
            default:
                label3.setIcon(none);
                break;
        }
    }
}

