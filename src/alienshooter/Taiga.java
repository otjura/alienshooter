package alienshooter;

/**
 * Weaker and faster craft.
 */
class Taiga extends Craft {
    protected int hitpoints = 50;
    private final int SPEED = 4;
    private final String PICTURE = "images/taiga.png";
    
    
    public Taiga(int x, int y) {
        super(x, y);
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
