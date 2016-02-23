package alienshooter;

public class Xeno extends Alien {
    private static final String PICTURE = "images/xeno.png";
    private static final Alientype TYPE = Alientype.DEME;
    private int hitpoints = 40;
    
    public Xeno(int x, int y) {
        super(x, y);
        this.hitpoints = hitpoints;
        loadImage(PICTURE);
        getImageDimensions();
    }
    
    public String getType() {
        return TYPE.toString();
    }
}
