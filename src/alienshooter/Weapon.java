package alienshooter;

abstract class Weapon {
    
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
    public int getDamage() { 
        switch(weapontype) {
            case LASER: damage = Laser.DAMAGE; break;
            case BLASTER: damage = Blaster.DAMAGE; break;
            case ZINGER: damage = Zinger.DAMAGE; break;
        }    
        return damage; 
    }
    
    public int getFirerate() { 
        switch(weapontype) {
            case LASER: firerate = Laser.FIRERATE; break;
            case BLASTER: firerate = Blaster.FIRERATE; break;
            case ZINGER: firerate = Zinger.FIRERATE; break;
        }
        return firerate; 
    }
    
    public void setWeapontype(Weapontype w) { weapontype = w; }
    
    
}
