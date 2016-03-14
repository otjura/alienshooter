package alienshooter;

/**
 * Weaker and faster craft.
 */
class Taiga extends Craft {
    protected int hitpoints;
    private final int SPEED = 4;
    private final String PICTURE = "images/taiga.png";
    
    
    public Taiga(int x, int y) {
        super(x, y);
        hitpoints = 50;
        loadImage(PICTURE);
        getImageDimensions();
    }
    
    @Override
    public int getHitpoints() { return hitpoints; }
    
    @Override
    public void setHitpoints(int hitpoints) { this.hitpoints = hitpoints; }
    
    @Override
    public void decreaseHitpoints(int dmg) { hitpoints -= dmg; } 
}
