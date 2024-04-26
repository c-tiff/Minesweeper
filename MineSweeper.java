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
    private TopPanel topPanel;

    public MineSweeper() {
        // frame implementation
        window = new JFrame();
        window.setTitle("Minesweeper");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(450, 500);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout());
        window.setIconImage(icon.getImage());


        // game panel
        game = new GamePanel(this);

        // top panel & start panel
        topPanel = new TopPanel();
        startPanel = new StartPanel(this);
        topPanel.add(game.getFlagPanel());
        topPanel.add(startPanel);
        topPanel.add(game.getStopwatch());

        // add panels to window
        window.add(topPanel, BorderLayout.NORTH);
        window.add(game, BorderLayout.SOUTH);

        window.pack();
        window.setVisible(true);
    }

    // getters
    public GamePanel getGame() { return game; }
    public TopPanel getTopPanel() { return topPanel;}
    public StartPanel getStartPanel(){
        return startPanel;
    }
    public JFrame getWindow(){
        return window;
    }
}