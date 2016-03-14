package alienshooter;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Craft class has two subclasses. It can't be initialized by itself. All crafts
 * begin with weapon laser selected first.
 * 
 */
abstract class Craft extends Sprite {
    private int dx;
    private int dy;
    private int hitpoints;
    private final int SPEED = 2;
    private ArrayList<Missile> missiles;
    private Weapon weapon;

    public Craft(int x, int y) {
        super(x, y);
        missiles = new ArrayList<>();
        weapon = new Laser();
    }
    
    public void move() {
        x += dx;
        y += dy;
        if (x < 1) x = 1;
        if (y < 1) y = 1;
        if (x > 780) x = 779;
        if (y > 580) y = 579;
    }
    
    public ArrayList getMissiles() { return missiles; }
    public int getHitpoints() { return hitpoints; }
    public int getDamage() { return weapon.getDamage(); }
    public String getWeapon() { return weapon.getWeapontype().toString(); }
    
    public void setHitpoints(int hitpoints) { this.hitpoints = hitpoints; }
    public void decreaseHitpoints(int dmg) { hitpoints -= dmg; } 
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_Z)     fire();
        if (key == KeyEvent.VK_X)     bomb();
        if (key == KeyEvent.VK_C)     changeWeapon();
        if (key == KeyEvent.VK_LEFT)  dx = -SPEED;
        if (key == KeyEvent.VK_RIGHT) dx = SPEED;
        if (key == KeyEvent.VK_UP)    dy = -SPEED;
        if (key == KeyEvent.VK_DOWN)  dy = SPEED;
        if (key == KeyEvent.VK_ENTER) pause();

    }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)  dx = 0;
        if (key == KeyEvent.VK_RIGHT) dx = 0;
        if (key == KeyEvent.VK_UP)    dy = 0;
        if (key == KeyEvent.VK_DOWN)  dy = 0;
    }
    
    /**
     * Creates new missile sprite of currently selected weaponin middle of the 
     * craft front. 
     */
    public void fire() {
        missiles.add(new Missile(x-2+width/2, 
                                 y-height/2, 
                                 weapon.getWeapontype()));
    }
    
    public void bomb() {
        fire();
    }
    
    public void changeWeapon() {
        switch(weapon.getWeapontype()) {
            case LASER: weapon = new Blaster(); break;
            case BLASTER: weapon = new Zinger(); break;
            case ZINGER: weapon = new Laser(); break;
        }         
    }
    
    protected void pause() { 
        fire();
    }
}
