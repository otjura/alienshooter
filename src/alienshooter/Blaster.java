package alienshooter;

public class Blaster extends Weapon {
    protected static final int DAMAGE = 20;
    protected static final int FIRERATE = 2;
    protected static final String MISSILE = "images/blaster.png";
    
    public Blaster() {
        super(Weapontype.BLASTER, 20, 2);
    }
    
    public String getMissile() {
        return MISSILE;
    }
}
