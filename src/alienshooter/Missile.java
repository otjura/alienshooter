package alienshooter;

class Missile extends Sprite {
    private final int BOARD_WIDTH = 790;
    private final int BOARD_HEIGHT = 590;
    private final int MISSILE_SPEED = 4;
    protected int damage;
    private Weapontype weapontype;

    public Missile(int x, int y, Weapontype weapontype) {
        super(x, y);
        switch(weapontype) {
            case LASER: loadImage(Laser.MISSILE); break;
            case BLASTER: loadImage(Blaster.MISSILE); break;
            case ZINGER: loadImage(Zinger.MISSILE); break;
            default: loadImage("images/missile.png"); break;
        }
        getImageDimensions();        
    }
    
    public int getDamage() {
        switch(weapontype) {
            case LASER: damage = Laser.DAMAGE; break;
            case BLASTER: damage = Blaster.DAMAGE; break;
            case ZINGER: damage = Zinger.DAMAGE; break;
        }    
        return damage; 
    }

    public void move() {        
        y -= MISSILE_SPEED;
        if (x > BOARD_WIDTH || y > BOARD_HEIGHT) vis = false;
    }
    
}
