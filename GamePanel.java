package MineSweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public final class GamePanel extends JPanel  implements MouseListener {
    private final ImageIcon flag, clickable, mine, clicked_mine,empty,one,two,three,four,five,six,seven,eight;
    private final Random rand = new Random();
    private int flags; // number of flags available
    private boolean gamestarted; // "is game started?" condition for stopwatch
    private final FlagPanel flagpanel;
    private final StopwatchPanel stopwatch;
    private final MineSweeper minesweeper;

    private final Set<Integer> locations; // positions of mines
    private final JLabel[] labels = new JLabel[81]; // tiles
    private final int[] surroundings = {-10,-9,-8,-1,1,8,9,10}; // to be summed to indexes to check the adjacent tiles

    public GamePanel(MineSweeper minesweeper){
        //sprites
        flag = new ImageIcon(new ImageIcon("images/flag.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        clickable = new ImageIcon(new ImageIcon("images/clickablecell.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        mine = new ImageIcon(new ImageIcon("images/mine.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        clicked_mine = new ImageIcon(new ImageIcon("images/mineclicked.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        empty = new ImageIcon(new ImageIcon("images/emptycell.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        one = new ImageIcon(new ImageIcon("images/one.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        two = new ImageIcon(new ImageIcon("images/two.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        three = new ImageIcon(new ImageIcon("images/three.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        four = new ImageIcon(new ImageIcon("images/four.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        five = new ImageIcon(new ImageIcon("images/five.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        six = new ImageIcon(new ImageIcon("images/six.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        seven = new ImageIcon(new ImageIcon("images/seven.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        eight= new ImageIcon(new ImageIcon("images/eight.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));

        // panel setup
        this.setLayout(new GridLayout(9,9));
        this.setBackground(Color.BLACK);

        // initializations
        this.minesweeper = minesweeper;
        flags = 10;
        flagpanel = new FlagPanel();
        stopwatch = new StopwatchPanel();
        boolean gamestarted = false;
        locations = new HashSet<>();

        // making the individual tiles
        for(int i = 0; i<81; i++){
            labels[i] = new JLabel();
            labels[i].setBackground(Color.BLACK);
            labels[i].addMouseListener(this);
            labels[i].setIcon(clickable);
            this.add(labels[i]);

        }
        genMines();

    }
    // generate mine positions
    public void genMines() {
        while(locations.size()<10){
            locations.add(rand.nextInt(81));
        }
    }

    // check adjacent tiles and set value to current tile

    private int getAmount(int i) {
        int amount = 0;
        for(int j: surroundings){
            if((i+1)%9 == 0 && ((j==1) || (j == -8) || (j == 10))){
                continue;
            }
            if(((i % 9) == 0) && ((j == -1) || (j == 8) || (j == -10))){
                continue;
            }
            if(locations.contains(i+j)){
                amount++;
            }
        }
        return amount;
    }
    private void check(int i){
        if(!locations.contains(i)) {
            int amount = getAmount(i);
            switch (amount) {
                default:
                    labels[i].setIcon(empty);
                    for (int j : surroundings) {
                        // right border
                        if ((i + 1) % 9 == 0 && (j == 1 || j == -8 || j == 10)){
                            continue;
                        }
                        // left border
                        if ((i % 9) == 0 && (j == -1 || j == 8 || j == -10)) {
                            continue;
                        }
                        if ((i + j) <= 80 && (i + j) >= 0 && labels[i+j].getIcon() == clickable) {
                            check(i + j);
                        }
                    }
                    break;
                case 1:
                    labels[i].setIcon(one);
                    break;
                case 2:
                    labels[i].setIcon(two);
                    break;
                case 3:
                    labels[i].setIcon(three);
                    break;
                case 4:
                    labels[i].setIcon(four);
                    break;
                case 5:
                    labels[i].setIcon(five);
                    break;
                case 6:
                    labels[i].setIcon(six);
                    break;
                case 7:
                    labels[i].setIcon(seven);
                    break;
                case 8:
                    labels[i].setIcon(eight);
                    break;
            }
            labels[i].removeMouseListener(this);
        }
    }


    // check game over conditions and implementation
    private void gameOver(int i){
        if(locations.contains(i)){
            stopwatch.stop();
            minesweeper.getStartPanel().setSmiley(1);
            labels[i].setIcon(clicked_mine);
            for(int l:locations){
                if(l!=i){
                    labels[l].setIcon(mine);
                }
            }
            for(int k = 0;k<81;k++){
                labels[k].removeMouseListener(this);
            }
        }

    }

    // check winning conditions
    private void win(){
        if (flags == 0){
            boolean won = false;
            for( int j = 0; j<81; j++){
                if (!locations.contains(j) && labels[j].getIcon()== clickable){
                    won = true;
                }
            }
            if(won){
                minesweeper.getStartPanel().setSmiley(2);
                stopwatch.stop();
                for(int l:locations){
                    labels[l].setIcon(mine);
                }
            }

        }
    }

    // getters
    public FlagPanel getFlagPanel() {
        return flagpanel;
    }
    public StopwatchPanel getStopwatch(){
        return stopwatch;
    }

    // when a tile i clicked:
    @Override
    public void mouseClicked(MouseEvent e) {
        // left mouse to reveal a tile
        if(SwingUtilities.isLeftMouseButton(e)){
            for(int i = 0; i < 81; i++){
                if(e.getSource() == labels[i]){
                    if(!gamestarted){
                        stopwatch.start();
                        gamestarted  = true;
                }
                    win();
                    gameOver(i);
                    check(i);

                }
            }
        }
        // right mouse to flag a tile
        else if(SwingUtilities.isRightMouseButton(e)){
            for(int i = 0; i < 81; i++) {
                if (e.getSource() == labels[i]) {
                    win();
                    if(!gamestarted){
                        stopwatch.start();
                        gamestarted  = true;
                    }
                    if (labels[i].getIcon() == flag){
                        labels[i].setIcon(clickable);
                        flags++;
                        String digits = Integer.toString(flags);
                        switch(digits.length()){
                            case 2:
                            flagpanel.setLabel1('0');
                            flagpanel.setLabel2('1');
                            break;
                            case 1:
                                flagpanel.setLabel1(digits.charAt(0));
                                flagpanel.setLabel2('-');
                                break;
                        }

                    }
                    else{
                        if(!(flags <= 0)){
                            labels[i].setIcon(flag);
                            flags--;
                            win();
                            String digits = Integer.toString(flags);
                            switch(digits.length()){
                                case 2:
                                    flagpanel.setLabel1('0');
                                    flagpanel.setLabel2('1');
                                    break;
                                case 1:
                                    flagpanel.setLabel1(digits.charAt(0));
                                    flagpanel.setLabel2('-');
                                    break;
                            }
                        }
                    }

                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
