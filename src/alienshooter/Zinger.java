package alienshooter;

public class Zinger extends Weapon {
    protected static final String MISSILE = "images/zinger.png";
    protected static final int DAMAGE = 30;
    protected static final int FIRERATE = 1;
    
    public Zinger() {
        super(Weapontype.ZINGER, 30, 1);
    }
    
    public String getMissile() {
        return MISSILE;
    }
}
