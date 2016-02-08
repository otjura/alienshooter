package alienshooter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Highscore {
    
    private int highscore;
    
    public Highscore() {
        
    }
    
    public int getHighscore() { return highscore; }
    
    public int readHighscoreFromDisk() {
        
        return highscore;
    }
    
    public void writeHighscoreToDisk() {
        
    }
    
}
