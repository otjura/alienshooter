package alienshooter;

import java.io.File;
import java.io.IOException;

public class Highscore {
    
    private int highscore;
    
    public Highscore() {
        
    }
    
    public int getHighscore() { return highscore; }
    
    public int readHighscoreFromDisk() {
        
        return highscore;
    }
    
    public void writeHighscoreToDisk() {
        File hs = new File("highscore.xd");
        if(!hs.exists()) {
            try {
                hs.createNewFile();
            } catch(IOException e) {
                System.out.println("Can not make file");
                System.exit(0);
            }
        }        
    }
}
