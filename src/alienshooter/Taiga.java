package alienshooter;

/**
 * Weaker and faster craft.
 */
public class Taiga extends Craft {
    private int hitpoints = 50;
    private final int SPEED = 4;
    private final String PICTURE = "images/taiga.png";
    
    
    public Taiga(int x, int y) {
        super(x, y);
        this.hitpoints = hitpoints;
        loadImage(PICTURE);
        getImageDimensions();
    }
}
