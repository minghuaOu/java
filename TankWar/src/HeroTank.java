import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.Vector;

public class HeroTank extends MovingObject {

	private static final int SPEED = 6;
	private static final int BULLET_SPEED = 4;
	Bullet bullet = null;

	{
		d = Direction.U;
		width = 48;
		height = 48;
	}

	private int imageIndex = 0;
	private static BufferedImage[] images = new BufferedImage[] {
			Images.HeroTank1L1, Images.HeroTank1R1, Images.HeroTank1U1,
			Images.HeroTank1D1, Images.HeroTank1L2, Images.HeroTank1R2,
			Images.HeroTank1U2, Images.HeroTank1D2, };

	public HeroTank() {
		this.x = 48 * 4;
		this.y = 48 * 12;
		image = images[2];
		imageIndex = 0;
		bullet = null;
	}

	public void fire(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SHIFT && bullet == null) {
			new Audio("fire");
			switch (d) {
			case L:
				bullet = new Bullet(x, y + 19, Direction.L);
				break;
			case R:
				bullet = new Bullet(x + 48 - 12, y + 19, Direction.R);
				break;
			case U:
				bullet = new Bullet(x + 19, y, Direction.U);
				break;
			case D:
				bullet = new Bullet(x + 19, y + 48 - 12, Direction.D);
				break;
			}
		}
	}

	public void paint(Graphics g) {
		g.drawImage(image, x, y, null);
		if (bullet != null) {
			g.drawImage(bullet.image, bullet.x, bullet.y, null);
		}
	}

	public void move(Map map, KeyEvent e) {
		if(map==null||e==null){
			return;
		}
		d = Direction.press(e);
		imageIndex = (imageIndex + 1) % 2;
		image = images[imageIndex * 4 + d.value()];
		if(this.blocked(map)){
			return;
		}
		switch (d) {
		case L:
			if (x <= SPEED) {
				x = 0;
			} else {
				x -= SPEED;
			}
			break;
		case R:
			if (x <= TankWar.GAME_FRAME_WIDTH - TankWar.UNIT_LENGTH) {
			x += SPEED;
		}
			break;
		case U:
			if (y <= SPEED) {
			y = 0;
		} else {
			y -= SPEED;
		}
			break;
		case D:
			if (y <= TankWar.GAME_FRAME_HEIGHT - TankWar.UNIT_LENGTH - 29) {
				y += SPEED;
			}
			break;
		default:
			break;
		}
	}

	public void moveBullet(Vector<EnemyTank> enemyTanks, Map map) throws GameOver {
		if (bullet == null)
			return;
		if (bullet.outOfBounds()) {
			bullet = null;
			return;
		}
		switch (bullet.d) {
		case L:
			bullet.x -= BULLET_SPEED;
			break;
		case R:
			bullet.x += BULLET_SPEED;
			break;
		case U:
			bullet.y -= BULLET_SPEED;
			break;
		case D:
			bullet.y += BULLET_SPEED;
			break;
		}
		
		MapObject m;
		m = map.getTileByXY(bullet.x + 6, bullet.y + 4);
		if (m instanceof SteelWall) {
			new Audio("hit");
			bullet = null;
			return;
		}
		if (m instanceof BrickWall) {
			new Audio("hit");
			map.maptiles[map.getIndex(bullet.x + 6, bullet.y + 4)] = new Ground(
					m.x, m.y);
			bullet = null;
			return;
		}
		if(m instanceof Base){
			((Base)m).gameover();
			throw new GameOver();
		}
		if(bullet==null){
			return;
		}
		Iterator<EnemyTank> it = enemyTanks.iterator();
		while (it.hasNext()) {
			EnemyTank tank = it.next();
			if (bullet.collideWith(tank)) {
				it.remove();
				new Audio("blast");
				bullet = null;
				return;
			}
		}
	}
}
