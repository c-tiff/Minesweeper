package MineSweeper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopwatchPanel extends NumberPanel{
    int elapsedTime,seconds;
    String time;
    Timer timer = new Timer(1000,new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // what the timer does every 1000 millisecs ( 1 sec)
            if (seconds < 1000){
                elapsedTime += 1000;
                seconds = elapsedTime/1000;
                time = Integer.toString(seconds);
                switch(time.length()){
                    case 3:
                        setLabel1(time.charAt(2));
                        setLabel2(time.charAt(1));
                        setLabel3(time.charAt(0));
                        break;
                    case 2:
                        setLabel1(time.charAt(1));
                        setLabel2(time.charAt(0));
                        setLabel3('-');
                        break;
                    case 1:
                        setLabel1(time.charAt(0));
                        setLabel2('-');
                        setLabel3('-');
                        break;

                }
            }

        }
    });
    public StopwatchPanel(){
        this.setLayout(new GridLayout(1,3,0,0));
        label1.setIcon(none);
        label2.setIcon(none);
        label3.setIcon(none);
        this.add(label3);
        this.add(label2);
        this.add(label1);
    }
    public void start(){
        timer.start();
    }
    public void stop() {
        timer.stop();
    }
}