package alienshooter;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Alienshooter extends JFrame {
    
    public Alienshooter() {     
        initGame();
    }
    
    /*private void initStartScreen() {
        add(new Startscreen());
        setResizable(false);
        pack();
        setTitle("Alienshooter");
        setLocationRelativeTo(null);
    }*/
    
    private void initGame() {      
        add(new Board(1));
        setResizable(false);
        pack();
        setTitle("Alienshooter");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Alienshooter ex = new Alienshooter();
                ex.setVisible(true);
            }
        });
    }
}