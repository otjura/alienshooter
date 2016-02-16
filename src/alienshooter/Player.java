package alienshooter;

public class Player {
    private int score;
    private Weapon weapon;
    
    public Player() {
        this.score = 0;
        this.weapon = new Laser();
    }
    
    public int getScore() { return score; }
    public Weapon getWeapon() { return weapon; }
    
    public void setWeapon(Weapon weapon) { this.weapon = weapon; }
    public void setScore(int score) { this.score = score; } 
    
    public void increaseScore(int increase) { score += increase; } 
}
