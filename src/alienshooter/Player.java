package alienshooter;

public class Player {
    private int score;
    
    public Player() {
        this.score = 0;
    }
    
    public int getScore() { return score; }
    public void increaseScore(int score) { this.score += score; } 
}