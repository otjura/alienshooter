package alienshooter;

public class Deme extends Alien {
    private final int INITIAL_Y = 400;
    private final Alientype TYPE = Alientype.DEME;
    private int hitpoints = 10;
    
    public Deme (int x, int y) {
        super(x, y);
        this.hitpoints = hitpoints;
        loadImage("images/goro.png");
        getImageDimensions();
    }
}
