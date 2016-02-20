package alienshooter;

public class Blaster extends Weapon {
    private final int DAMAGE = 20;
    private final int FIRERATE = 2;
     private final String MISSILE = "images/blaster.png";
    
    public Blaster() {
        super(Weapontype.BLASTER, 20, 2);
    }
    
    public String getMissile() {
        return MISSILE;
    }
}
