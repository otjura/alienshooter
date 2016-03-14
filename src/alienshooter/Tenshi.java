package alienshooter;

/**
 * Stronger and slower craft. 
 */
class Tenshi extends Craft {
    private int hitpoints;
    private final int SPEED = 2;
    private final String PICTURE = "images/tenshi.png";
    
    
    public Tenshi(int x, int y) {
        super(x, y);
        hitpoints = 100;
        loadImage(PICTURE);
        getImageDimensions();
    }
    
    @Override
    public int getSpeed() { return SPEED; }
    
    @Override
    public int getHitpoints() { return hitpoints; }
    
    @Override
    public void setHitpoints(int hitpoints) { this.hitpoints = hitpoints; }
    
    @Override
    public void decreaseHitpoints(int dmg) { hitpoints -= dmg; } 
    
}
