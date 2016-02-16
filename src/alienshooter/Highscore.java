package alienshooter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Highscore {
    
    private final String SCOREFILE = "highscore.xd";
    private int highscore;
    
    public Highscore() {
        highscore = readHighscoreFromDisk();
    }
    
    public int getHighscore() { return highscore; }
    
    public void setHighscore(int newscore) { highscore = newscore; } 
    
    public int readHighscoreFromDisk() {
        File hs = new File(SCOREFILE);
        try {
            Scanner sco = new Scanner(hs);
            highscore = Integer.parseInt(sco.nextLine());
        } catch(FileNotFoundException e) {
            try {
                hs.createNewFile();
                FileWriter fw = new FileWriter(hs, false);
                fw.write("0");
                fw.close();
                highscore = 0;
            } catch(IOException f) {
                System.out.println("Everything fails today :(");
            }
        }   
        return highscore;
    }
    
    /**
     * @pre SCOREFILE exists && can write to disk
     * @param score
     * @throws IOException 
     */
    public void writeHighscoreToDisk(int score) throws IOException {
        File hs = new File(SCOREFILE);
        FileWriter fw = new FileWriter(hs, false);
        fw.write(Integer.toString(score));
        fw.close();
    }
}
