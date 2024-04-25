package MineSweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineSweeper {
    private ImageIcon icon = new ImageIcon("images/logo.png");
    private ImageIcon smile, sad, cool;
    private JFrame window;
    private TopPanel top;
    private GamePanel game;

    public MineSweeper() {
        // game frame implementation
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(450, 500);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout());
        window.setIconImage(icon.getImage());

        game = new GamePanel();
        // top panel initialization
        top = new TopPanel(window, game);
        // game panel initialization

        // add panels to window
        window.add(top, BorderLayout.NORTH);
        window.add(game, BorderLayout.SOUTH);

        window.pack();
        window.setVisible(true);

    }
}