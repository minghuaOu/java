import java.awt.image.BufferedImage;

public class Base extends MapObject {
	public Base(int x, int y) {
		super(x, y);
		image = images[0];
	}

	private static BufferedImage[] images = new BufferedImage[] { Images.base, Images.base2 };

	public void gameover() {
		image=images[1];
	}
}
