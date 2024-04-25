package MineSweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel implements ActionListener {
    ImageIcon smile, sad, cool;
    JButton smiley;
    JFrame frame;
    GamePanel game;

    public TopPanel(JFrame frame, GamePanel game) {

        this.frame = frame;
        this.game = game;
        //panel setup
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // start button icons
        smile = new ImageIcon(new ImageIcon("images/smile.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        sad = new ImageIcon(new ImageIcon("images/sad.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        cool = new ImageIcon(new ImageIcon("images/cool.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        // start button
        smiley = new JButton();
        smiley.setSize(50, 50);
        smiley.setIcon(smile);
        smiley.addActionListener(this);
        smiley.setSize(50, 50);

        // add to panels
        this.add(game.getFlagPanel());
        this.add(smiley);
        this.add(game.getStopwatch());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == smiley) {
            this.remove(game.getFlagPanel());
            this.remove(smiley);
            this.remove(game.getStopwatch());
            frame.remove(game);
            game = new GamePanel();
            frame.add(game, BorderLayout.SOUTH);
            this.add(game.getFlagPanel());
            this.add(smiley);
            this.add(game.getStopwatch());
            SwingUtilities.updateComponentTreeUI(this);
            SwingUtilities.updateComponentTreeUI(frame);

        }
    }
}
