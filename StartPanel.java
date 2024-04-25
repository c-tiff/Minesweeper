package MineSweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel implements ActionListener {
    ImageIcon smile, sad, cool;
    JButton smiley;

    JPanel top;
    JFrame frame;
    GamePanel game;

    public StartPanel(JFrame frame,JPanel top, GamePanel game){
            this.frame = frame;
            this.game = game;
            this.top = top;
            //panel setup
            // start button icons
            smile = new ImageIcon(new ImageIcon("images/smile.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            sad = new ImageIcon(new ImageIcon("images/sad.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            cool = new ImageIcon(new ImageIcon("images/cool.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

            smiley = new JButton();
            smiley.setSize(50, 50);
            smiley.setIcon(smile);
            smiley.addActionListener(this);
            smiley.setSize(50, 50);
            this.add(smiley);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == smiley) {
            top.remove(game.getFlagPanel());
            top.remove(smiley);
            top.remove(game.getStopwatch());
            frame.remove(game);
            game = new GamePanel();
            frame.add(game, BorderLayout.SOUTH);
            top.add(game.getFlagPanel());
            top.add(smiley);
            top.add(game.getStopwatch());
            SwingUtilities.updateComponentTreeUI(top);
            SwingUtilities.updateComponentTreeUI(frame);

        }
    }
}
