package alienshooter;

public class Missile extends Sprite {
    private final int BOARD_WIDTH = 790;
    private final int BOARD_HEIGHT = 590;
    private final int MISSILE_SPEED = 3;
    private Weapontype weapontype;

    public Missile(int x, int y) {
        super(x, y);
        switch(weapontype) {
            case LASER: loadImage("images/laser.png"); break;
            case BLASTER: loadImage("images/blaster.png"); break;
            case ZINGER: loadImage("images/zinger.png"); break;
            default: loadImage("images/missile.png"); break;
        }    
        getImageDimensions();        
    }

    public void move() {        
        y -= MISSILE_SPEED;
        if (x > BOARD_WIDTH || y > BOARD_HEIGHT)
            vis = false;
    }
}
