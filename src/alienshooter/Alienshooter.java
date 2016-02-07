package alienshooter;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Alienshooter extends JFrame {
    
    public Alienshooter() {     
        initUI();
    }
    
    private void initUI() {      
        add(new Board());
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