import java.awt.image.BufferedImage;

/**
 * 可移动对象类,包含子类HeroTank我方坦克，EnemyTank敌方坦克和Bullet子弹三个子类
 */
public class MovingObject {
	protected Direction d;
	protected BufferedImage image;
	protected int width = 48;
	protected int height = 48;
	protected int x;
	protected int y;

	public MovingObject() {
	};// 应例行定义一个空的无参构造函数

	public MovingObject(int x, int y) {
		this.x = x;
		this.y = y;
		width = 48;
		height = 48;
	}

	/**
	 * @return 判定一个移动对象是否越界
	 */
	protected boolean outOfBounds() {
		if (x < 0 || x + width > TankWar.GAME_FRAME_WIDTH || y < 0
				|| y + height > TankWar.GAME_FRAME_HEIGHT)
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param x
	 *            横坐标
	 * @param y
	 *            纵坐标
	 * @return 判定一个移动对象是否与一个像素点(x，y)发生碰撞
	 */
	public boolean collideWith(int x, int y) {
		if ((x >= this.x) && (x <= this.x + this.width) && (y >= this.y)
				&& (y <= this.y + this.height))
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param other
	 *            另一个移动对象
	 * @return 判定一个移动对象是否与另一个移动对象发生碰撞
	 */
	public boolean collideWith(MovingObject other) {
		if (other == null) {
			return false;
		}
		return (other.collideWith(x, y) || other.collideWith(x + width, y)
				|| other.collideWith(x, y + height)
				|| other.collideWith(x + width, y + height));
	}

	/**
	 * 
	 * @param map
	 *            获取的地图句柄
	 * @return 判定this对象是否在前进方向上与地图元素发生碰撞
	 * @param OFFSET
	 *            调整值，减少碰撞体积，以免卡死
	 */
	private static final int OFFSET = 6;

	public boolean blocked(Map map) {
		MapObject m1, m2, m3;
		int speed = 2;
		int[] n = null;
		switch (d) {
		case L:
			n = new int[] { -speed  + OFFSET, -speed  + OFFSET,
					-speed  + OFFSET, OFFSET,
					this.height - OFFSET, this.height / 2 };
			break;
		case R:
			n = new int[] { 48 + speed - OFFSET,
					48 + speed - OFFSET, 48 + speed - OFFSET,
					OFFSET, this.height - OFFSET,
					this.height / 2 };
			break;
		case U:
			n = new int[] { OFFSET, this.width - OFFSET,
					this.width / 2, -speed  + OFFSET,
					-speed  + OFFSET, -speed  + OFFSET };
			break;
		case D:
			n = new int[] { OFFSET, this.width - OFFSET,
					this.width / 2, 48 + speed - OFFSET,
					48 + speed - OFFSET, 48 + speed - OFFSET };
			break;
		}

		m1 = map.getTileByXY(this.x + n[0], this.y + n[3]);
		m2 = map.getTileByXY(this.x + n[1], this.y + n[4]);
		m3 = map.getTileByXY(this.x + n[2], this.y + n[5]);
		if (m1 instanceof BrickWall || m1 instanceof SteelWall
				|| m1 instanceof River || m1 instanceof Base
				|| m2 instanceof BrickWall || m2 instanceof SteelWall
				|| m2 instanceof River || m2 instanceof Base
				|| m3 instanceof BrickWall || m3 instanceof SteelWall
				|| m3 instanceof River || m3 instanceof Base) {
			return true;
		}
		return false;
	}
}
