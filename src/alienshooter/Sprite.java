package alienshooter;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * Controls graphic object visibility and placement. 
 */
abstract class Sprite {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean vis;
    protected Image image;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        vis = true;
    }
    
    //getters
    public int getX() { return x; }
    public int getY() { return y; }
    
    public Image getImage() { return image; }
    
    protected void getImageDimensions() {
        width = image.getWidth(null);
        height = image.getHeight(null);
    }
    
    public Rectangle getBounds() { 
        return new Rectangle(x, y, width, height);
    }    
    
    //setters
    public void setVisible(Boolean visible) { vis = visible; }
    
    //others
    public boolean isVisible() { return vis; }
    
    protected void loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }
    
}
