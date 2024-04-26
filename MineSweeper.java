package MineSweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineSweeper {
    private ImageIcon icon = new ImageIcon("images/logo.png");
    private ImageIcon smile, sad, cool;
    private JFrame window;
    private GamePanel game;
    private StartPanel startPanel;
    private FlagPanel flag;
    private StopwatchPanel stopwatch;
    private TopPanel topPanel;

    public MineSweeper() {
        // game frame implementation
        window = new JFrame();
        window.setTitle("Minesweeper");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(450, 500);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout());
        window.setIconImage(icon.getImage());

        game = new GamePanel(this);
        // top panel initialization
        // game panel initialization

        topPanel = new TopPanel();
        stopwatch = game.getStopwatch();
        flag = game.getFlagPanel();
        startPanel = new StartPanel(this,topPanel,game);
        topPanel.add(flag);
        topPanel.add(startPanel);
        topPanel.add(stopwatch);

        // add panels to window
        window.add(topPanel, BorderLayout.NORTH);
        window.add(game, BorderLayout.SOUTH);

        window.pack();
        window.setVisible(true);
    }
    public StartPanel getStartPanel(){
        return startPanel;
    }
    public JFrame getWindow(){
        return window;
    }
}