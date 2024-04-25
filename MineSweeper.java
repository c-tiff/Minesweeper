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

    private TopPanel topPanel;
    private StartPanel startPanel;

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

        game = new GamePanel(window);
        // top panel initialization
        // game panel initialization

        topPanel = new TopPanel(window,game);
        // add panels to window
        window.add(topPanel, BorderLayout.NORTH);
        window.add(game, BorderLayout.SOUTH);

        window.pack();
        window.setVisible(true);

    }
}