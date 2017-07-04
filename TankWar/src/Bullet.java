import java.awt.image.BufferedImage;
/**
 * 子弹类，衍生自移动对象
 */
public class Bullet extends MovingObject {
	/**
	 * @param images 子弹的4个方向的图片数组
	 */
	private static BufferedImage[] images = new BufferedImage[] {
			Images.bulletL, Images.bulletR, Images.bulletU, Images.bulletD };

	public Bullet(int x, int y, Direction d) {
		this.x = x;
		this.y = y;
		this.d = d;
		image = images[d.value()];
		width = image.getWidth();
		height = image.getHeight();
	}
/**
 * 
 * @param other 给定的地图块的句柄
 * @return 布尔值,判定一个地图对象是否与子弹碰撞
 * @throws GameOver Throwable实现类,判定游戏是否结束
 */
	public boolean collideWith(MapObject other) throws GameOver {
		if (other == null) {
			return false;
		}
		if (other.contains(this.x, this.y)//判定地图块是否包含子弹
				|| (other.contains(this.x, this.y + this.height))
				|| (other.contains(this.x + this.width, this.y)) || (other
						.contains(this.x + this.width, this.y + this.height))) {
			if (other instanceof Base) {//若击中基地则游戏结束
				((Base) other).gameover();
				throw new GameOver();
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
/**
 * 判定一个子弹是否消灭了一个移动对象
 * @param other 一个移动对象
 * @return 布尔值,表示是否消灭
 * @throws GameOver 抛出的Throwable实现类,判定游戏是否结束
 */
	public boolean kill(MovingObject other) throws GameOver {
		if (other == null) {
			return false;
		}
		/**
		 * 若子弹击中移动物体
		 */
		if (this.collideWith(other)) {
			if (other instanceof HeroTank) {//移动物体是我方坦克则抛出游戏结束
				throw new GameOver();
			} else {
				return true;//否则击中了子弹或敌方坦克
			}
		}
		return false;//否则没有击中
	}
}
