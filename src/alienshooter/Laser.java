package alienshooter;

public class Laser extends Weapon {
    
    private final int DAMAGE = 10;
    private final int FIRERATE = 3;
    private final String MISSILE = "images/laser.png";
    
    public Laser() {
        super(Weapontype.LASER, 10, 3);
    }
    
    public String getMissile() {
        return MISSILE;
    }
}
