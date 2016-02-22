package alienshooter;

public class Laser extends Weapon {
    
    protected static final int DAMAGE = 10;
    protected static final int FIRERATE = 3;
    protected static final String MISSILE = "images/laser.png";
    
    public Laser() {
        super(Weapontype.LASER, 10, 3);
    }
    
    public String getMissile() {
        return MISSILE;
    }
}
