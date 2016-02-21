package alienshooter;

public class Weapon {
    
    private Sprite missile;
    private int damage;
    private int firerate;
    private Weapontype weapontype;
    
    public Weapon(Weapontype weapontype) {
        this.weapontype = weapontype;
    }
    
    public Weapon(Weapontype weapontype, int damage, int firerate) {
        this.weapontype = weapontype;
        this.damage = damage;
        this.firerate = firerate;
    }
    
    public Weapontype getWeapontype() { return weapontype; }
    public int getDamage() { return damage; }
    public int getFirerate() { return firerate; }
    
    public void setWeapontype(Weapontype w) { weapontype = w; }
    
    
}
