import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EnemyTank extends MovingObject {

	private static final int SPEED = 2;
	private static final int BULLET_SPEED = 3;
	private static final double CHANGE_DIRECTION_FREQUENCY = 0.002;
	private static final double AGGRESSIVENESS = 0.7;
	Bullet bullet = null;

	private int imageIndex = 0;

	{
		width = 48;
		height = 48;
	}

	public EnemyTank() {
		d = Direction.D;
		y = 0;
		image = images[3];
		int i = (int) (Math.random() * 3);
		x = i * 287;
	}

	private static BufferedImage[] images = new BufferedImage[] {

			Images.EnemyCommonTank1L1, Images.EnemyCommonTank1R1,
			Images.EnemyCommonTank1U1, Images.EnemyCommonTank1D1,
			Images.EnemyCommonTank1L2, Images.EnemyCommonTank1R2,
			Images.EnemyCommonTank1U2, Images.EnemyCommonTank1D2, };

	private void updateImg() {
		image = images[d.value()];
	}

	private void toL() {
		d = Direction.L;
		updateImg();
	}

	private void toR() {
		d = Direction.R;
		updateImg();
	}

	private void toU() {
		d = Direction.U;
		updateImg();
	}

	private void toD() {
		d = Direction.D;
		updateImg();
	}

	public void move(Map map) {
		int[] n = { -SPEED, SPEED, 0, 0, 0, 0, -SPEED, SPEED };
		switch (d) {
		case L:
			if (x <= SPEED) {
				x = 0;
				if (y <= SPEED) {
					toD();
					return;
				}
				if (y >= TankWar.GAME_FRAME_HEIGHT - 48 - SPEED) {
					toU();
					return;
				}
				if (Math.random() < AGGRESSIVENESS) {
					toD();
					return;
				} else {
					toU();
					return;
				}
			}
			break;
		case R:
			if (x > TankWar.GAME_FRAME_WIDTH - 48 - SPEED) {
				x = TankWar.GAME_FRAME_WIDTH - 48;
				if (y <= SPEED) {
					toD();
					return;
				}
				if (y >= TankWar.GAME_FRAME_HEIGHT - 48 - SPEED) {
					toU();
					return;
				}
				if (Math.random() < AGGRESSIVENESS) {
					toD();
				} else {
					toU();
				}
				return;
			}
			break;
		case U:
			if (y <= SPEED) {
				y = 0;
				if (x <= SPEED) {
					toR();
					return;
				}
				if (x >= TankWar.GAME_FRAME_WIDTH - 48 - SPEED) {
					toL();
					return;
				}
				if (Math.random() < 0.5) {
					toL();
					return;
				} else {
					toR();
					return;
				}
			}
			break;
		case D:
			if (y > TankWar.GAME_FRAME_HEIGHT - 48 - 29) {
				y = TankWar.GAME_FRAME_HEIGHT - 48 - 29;
				if (Math.random() < 0.5) {
					toL();
				} else {
					toR();
				}
				return;
			}
			break;
		}

		if (this.blocked(map)) {
			if (d.value() < 2) {
				if (Math.random() < AGGRESSIVENESS) {
					toD();
				} else {
					toU();
				}
			} else {
				if (Math.random() < 0.5) {
					toL();
				} else {
					toR();
				}
			}
			return;
		} else {
			if (imageIndex < 4 + d.value()) {
				imageIndex = 4 + d.value();
			} else {
				imageIndex = 0 + d.value();
			}
			image = images[imageIndex];
			x = x + n[d.value()];
			y = y + n[d.value() + 4];
			if(Math.random()<CHANGE_DIRECTION_FREQUENCY){
				Direction[] ds = {Direction.L, Direction.R, Direction.U, Direction.D};
				d =ds[(int)(Math.random()*4)];
				updateImg();
			}
		}
	}

	private static final int FIRE_INTERVAL = 50;
	private int fireIndex = 0;

	public void fire() {
		if (bullet == null && fireIndex++ > FIRE_INTERVAL) {
			fireIndex = 0;
			switch (d) {
			case L:
				bullet = new Bullet(x, y + 19, Direction.L);
				return;
			case R:
				bullet = new Bullet(x + 48 - 12, y + 19, Direction.R);
				return;
			case U:
				bullet = new Bullet(x + 19, y, Direction.U);
				return;
			case D:
				bullet = new Bullet(x + 19, y + 48 - 12, Direction.D);
				return;
			}
		}
	}

	public void moveBullet(HeroTank hero, Map map) throws GameOver {
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
			bullet = null;
			return;
		}
		if (m instanceof BrickWall) {
			map.maptiles[map.getIndex(bullet.x + 6, bullet.y + 4)] = new Ground(
					m.x, m.y);
			bullet = null;
			return;
		}
		if (m instanceof Base) {
			((Base) m).gameover();
			throw new GameOver();
		}
		if (bullet != null && bullet.collideWith(hero)) {
			throw new GameOver();
		}
	}

	public void paint(Graphics g) {
		g.drawImage(image, x, y, null);
		if (bullet != null) {
			g.drawImage(bullet.image, bullet.x, bullet.y, null);
		}
	}
}
