package alienshooter;

public class Goro extends Alien {
    private static final String PICTURE = "images/goro.png";
    private static final Alientype TYPE = Alientype.GORO;
    private int hitpoints = 20;
    
    public Goro(int x, int y) {
        super(x, y);
        this.hitpoints = hitpoints;
        loadImage(PICTURE);
        getImageDimensions();
    }
    
    public String getType() {
        return TYPE.toString();
    }

}
