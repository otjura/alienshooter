package alienshooter;

public class Zinger extends Weapon {
    private final int DAMAGE = 30;
    private final int FIRERATE = 1;
     private final String MISSILE = "images/zinger.png";
    
    public Zinger() {
        super(Weapontype.ZINGER, 30, 1);
    }
    
    public String getMissile() {
        return MISSILE;
    }
}
