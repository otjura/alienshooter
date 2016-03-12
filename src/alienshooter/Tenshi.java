package alienshooter;

/**
 * Stronger and slower craft. 
 */
public class Tenshi extends Craft {
    private int hitpoints = 100;
    private final int SPEED = 2;
    private final String PICTURE = "images/tenshi.png";
    
    
    public Tenshi(int x, int y) {
        super(x, y);
        this.hitpoints = hitpoints;
        loadImage(PICTURE);
        getImageDimensions();
    }
    
}
