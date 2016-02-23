package alienshooter;

public class Blaster extends Weapon {
    protected static final String MISSILE = "images/blaster.png";
    protected static final int DAMAGE = 20;
    protected static final int FIRERATE = 2;
    
    public Blaster() {
        super(Weapontype.BLASTER, 20, 2);
    }
    
    public String getMissile() {
        return MISSILE;
    }
}
