package MineSweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel {
    StopwatchPanel stopwatch;
    FlagPanel flag;
    StartPanel smile;
    GamePanel game;
    public TopPanel(JFrame frame, GamePanel game){
        this.game = game;
        this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        this.setSize(450,50);
        stopwatch = game.getStopwatch();
        flag = game.getFlagPanel();
        smile = new StartPanel(frame,this,game);
        this.add(flag);
        this.add(smile);
        this.add(stopwatch);
    }
}
