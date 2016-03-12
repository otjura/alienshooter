package alienshooter;

/**
 * Alien class has three subclasses, representing alien types. It can't be 
 * initialized by itself.
 * @author Otso
 */
abstract class Alien extends Sprite {
    private final int INITIAL_Y = 400;
    private int hitpoints;

    public Alien(int x, int y) {
        super(x, y);
        hitpoints = 20;
        loadImage("images/alien.png");
        getImageDimensions();
    }
    
    public int getHitpoints() { return hitpoints; }
    
    public void hit(int dmg) { hitpoints -= dmg; }
    
    public boolean isDead() {
        if(hitpoints <= 0) return true;
        return false;
    }
    
    public void move() {
        if (y < 0) y = INITIAL_Y;
        y += 1;
    }
}
