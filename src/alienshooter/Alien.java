package alienshooter;

/**
 * Alien class has three subclasses, representing alien types. It can't be 
 * instantiated by itself.
 */
abstract class Alien extends Sprite {
    private final int INITIAL_Y = 400;
    private int hitpoints;

    public Alien(int x, int y) {
        super(x, y);
    }
    
    public int getHitpoints() { return hitpoints; }
    
    public void hit(int dmg) { hitpoints -= dmg; }
    
    /**
     * Checks if alien has hitpoints left and returns boolean.
     * @return true IF hitpoints <= 0
     */
    public boolean isDead() {
        if(hitpoints <= 0) return true;
        return false;
    }
    
    /**
     * Movement pattern of initialized alien.
     */
    public void move() {
        if (y < 0) y = INITIAL_Y;
        y += 1;
    }
}
