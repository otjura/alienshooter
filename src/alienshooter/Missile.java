package alienshooter;

public class Missile extends Sprite {
    private final int BOARD_WIDTH = 790;
    private final int BOARD_HEIGHT = 590;
    private final int MISSILE_SPEED = 3;

    public Missile(int x, int y) {
        super(x, y);
        initMissile();
    }
    
    private void initMissile() {    
        loadImage("images/missile.png");
        getImageDimensions();        
    }

    public void move() {        
        y -= MISSILE_SPEED;
        if (x > BOARD_WIDTH || y > BOARD_HEIGHT)
            vis = false;
    }
}
