package alienshooter;

public class Xeno extends Alien {
    private final int INITIAL_Y = 400;
    private final Alientype TYPE = Alientype.XENO;
    private int hitpoints = 40;
    
    public Xeno(int x, int y) {
        super(x, y);
        this.hitpoints = hitpoints;
        loadImage("images/xeno.png");
        getImageDimensions();
    }
}
