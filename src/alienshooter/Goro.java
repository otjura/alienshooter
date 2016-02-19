package alienshooter;

public class Goro extends Alien {
    private final int INITIAL_Y = 400;
    private final Alientype TYPE = Alientype.GORO;
    private int hitpoints = 20;
    
    public Goro(int x, int y) {
        super(x, y);
        this.hitpoints = hitpoints;
        loadImage("images/goro.png");
        getImageDimensions();
    }

}
