package alienshooter;

public class Alien extends Sprite {
    private final int INITIAL_Y = 400;

    public Alien(int x, int y) {
        super(x, y);
        initAlien();
    }

    private void initAlien() {
        loadImage("images/alien.png");
        getImageDimensions();
    }

    public void move() {
        if (y < 0) {
            y = INITIAL_Y;
        }
        y += 1;
    }
}
