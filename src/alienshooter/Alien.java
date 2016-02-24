package alienshooter;

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
        boolean dead = false;
        if(hitpoints <= 0) dead = true;
        return dead;
    }
    
    public void move() {
        if (y < 0) y = INITIAL_Y;
        y += 1;
    }
}
