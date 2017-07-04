import java.awt.image.BufferedImage;

/**
 * 所有地图块对象（包括地面Ground,泥墙BrickWall,钢墙SteelWall,树林Forest,河流River,基地Base）的基类，
 * 
 */
public class MapObject {
	public BufferedImage image;// 地图块的图片
	protected int width = 48;// 固定大小48
	protected int height = 48;// 固定大小48
	protected int x;
	protected int y;

	public MapObject(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 48;
		this.height = 48;
	}

	/**
	 * 判定一个地图块是否包含坐标为（x，y）的点
	 * 
	 * @param x
	 *            x坐标
	 * @param y
	 *            y坐标
	 * @return 布尔值,表示是否包含坐标为(x,y)的点
	 */
	public boolean contains(int x, int y) {
		if ((x >= this.x) && (x <= this.x + width) && (y >= this.y)
				&& (y <= this.y + height))
			return true;
		else
			return false;
	}
}
