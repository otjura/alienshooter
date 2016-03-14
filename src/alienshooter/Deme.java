package alienshooter;

/**
 * Weakest alien.
 *
 */
class Deme extends Alien {
    private static final String PICTURE = "images/deme.png";
    private static final Alientype TYPE = Alientype.DEME;
    private int hitpoints = 10;
    
    public Deme (int x, int y) {
        super(x, y);
        this.hitpoints = hitpoints;
        loadImage(PICTURE);
        getImageDimensions();
    }
    
    public String getType() {
        return TYPE.toString();
    }
    
     public void move() {
        if (y < 0) y = 400;
        y += 1;
    }
}
