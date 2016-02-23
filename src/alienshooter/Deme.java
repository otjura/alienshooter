package alienshooter;

public class Deme extends Alien {
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
}
