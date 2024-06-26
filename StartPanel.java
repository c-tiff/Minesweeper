package MineSweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartPanel extends JPanel implements MouseListener {
    private final ImageIcon smilepressed, smile, sad, cool;
    private final JLabel smiley;

    private JPanel top;
    private final JFrame frame;
    private GamePanel game;

    private final MineSweeper minesweeper;
    public StartPanel(MineSweeper minesweeper){
        this.minesweeper = minesweeper;
        this.frame = minesweeper.getWindow();
        this.game = minesweeper.getGame();
        this.top = minesweeper.getTopPanel();
        //panel setup
        // start button icons
        smile = new ImageIcon(new ImageIcon("images/smile.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        sad = new ImageIcon(new ImageIcon("images/sad.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        cool = new ImageIcon(new ImageIcon("images/cool.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        smilepressed =  new ImageIcon(new ImageIcon("images/smilepressed.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));


        smiley = new JLabel();
            smiley.setSize(50, 50);
            smiley.setIcon(smile);
            smiley.addMouseListener(this);
            smiley.setSize(50, 50);
            this.add(smiley);

    }
    // setter
    public void setSmiley(int i){
        switch(i){
            case 0:
                smiley.setIcon(smile);
                break;
            case 1:
                smiley.setIcon(sad);
                break;
            case 2:
                smiley.setIcon(cool);
        }

    }


    // reset game
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == smiley) {
            frame.remove(game);
            frame.remove(top);
            game = new GamePanel(minesweeper);
            top = new TopPanel();
            top.add(game.getFlagPanel());
            top.add(minesweeper.getStartPanel());
            top.add(game.getStopwatch());
            frame.add(game, BorderLayout.SOUTH);
            frame.add(top,BorderLayout.NORTH);

            SwingUtilities.updateComponentTreeUI(top);
            SwingUtilities.updateComponentTreeUI(frame);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        smiley.setIcon(smilepressed);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        smiley.setIcon(smile);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
