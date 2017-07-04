import java.awt.Graphics;

public class Map {
	public Map(int i) {
		maptiles = generateStage(i);
	}

	public MapObject[] maptiles = null;
	private final int width = TankWar.UNIT_LENGTH;
	private final int num = TankWar.TILE_COUNT;

	/**
	 * 获取坐标为(x,y)的地图的下标
	 * 
	 * @param x
	 *            第x像素
	 * 
	 * @param y
	 *            第y像素
	 * 
	 */
	public int getIndex(int x, int y) {
		int n = x / width + (y / width) * num;
		if (n < 0)
			return 0;
		if (n >= maptiles.length) {
			return maptiles.length - 1;
		}
		return n;
	}

	/**
	 * 获取位置(!)在(i,j)上的的地图块
	 * 
	 * @param i
	 *            0-12之间的整数
	 * @param j
	 *            0-12之间的整数
	 */
	public MapObject getTileByIJ(int i, int j) {
		int n = i + j * num;
		if (n < 0)
			return maptiles[0];
		if (n >= maptiles.length) {
			return maptiles[maptiles.length - 1];
		}
		return maptiles[n];
	}

	/**
	 * 获取坐标为(x,y)处的地图块
	 * 
	 * @param x
	 *            第x像素
	 * @param y
	 *            第y像素
	 */
	public MapObject getTileByXY(int x, int y) {
		return maptiles[getIndex(x, y)];
	}

	/**
	 * 画出非树林地块
	 */
	public void paintMap(Graphics g) {
		for (MapObject m : maptiles) {
			if (!(m instanceof Forest))
				g.drawImage(m.image, m.x, m.y, null);
		}
	}

	/**
	 * 画出树林地块
	 */
	public void paintForests(Graphics g) {
		for (MapObject m : maptiles) {
			if (m instanceof Forest) {
				g.drawImage(m.image, m.x, m.y, null);
			}
		}
	}

	/**
	 * 
	 * @param i
	 *            生成第i关
	 */
	public MapObject[] generateStage(int i) {
		if (i == 1) {
			return new MapObject[] {
					// Row1
					new Ground(width * 0, 0), new Ground(width * 1, 0),
					new Ground(width * 2, 0), new Ground(width * 3, 0),
					new Ground(width * 4, 0), new Ground(width * 5, 0),
					new Ground(width * 6, 0), new Ground(width * 7, 0),
					new Ground(width * 8, 0), new Ground(width * 9, 0),
					new Ground(width * 10, 0), new Ground(width * 11, 0),
					new Ground(width * 12, 0),
					// Row2
					new Ground(width * 0, width), new Ground(width * 1, width),
					new Ground(width * 2, width),
					new BrickWall(width * 3, width),
					new BrickWall(width * 4, width),
					new BrickWall(width * 5, width),
					new Ground(width * 6, width),
					new BrickWall(width * 7, width),
					new BrickWall(width * 8, width),
					new BrickWall(width * 9, width),
					new Ground(width * 10, width),
					new Ground(width * 11, width),
					new Ground(width * 12, width),
					// Row3
					new Ground(width * 0, width * 2),
					new Ground(width * 1, width * 2),
					new Ground(width * 2, width * 2),
					new BrickWall(width * 3, width * 2),
					new Ground(width * 4, width * 2),
					new BrickWall(width * 5, width * 2),
					new Ground(width * 6, width * 2),
					new BrickWall(width * 7, width * 2),
					new Ground(width * 8, width * 2),
					new BrickWall(width * 9, width * 2),
					new Ground(width * 10, width * 2),
					new Ground(width * 11, width * 2),
					new Ground(width * 12, width * 2),
					// Row4
					new Ground(width * 0, width * 3),
					new Ground(width * 1, width * 3),
					new Ground(width * 2, width * 3),
					new BrickWall(width * 3, width * 3),
					new BrickWall(width * 4, width * 3),
					new BrickWall(width * 5, width * 3),
					new Ground(width * 6, width * 3),
					new BrickWall(width * 7, width * 3),
					new Ground(width * 8, width * 3),
					new BrickWall(width * 9, width * 3),
					new Ground(width * 10, width * 3),
					new Ground(width * 11, width * 3),
					new Ground(width * 12, width * 3),
					// Row5
					new Ground(width * 0, width * 4),
					new Ground(width * 1, width * 4),
					new Ground(width * 2, width * 4),
					new Ground(width * 3, width * 4),
					new Ground(width * 4, width * 4),
					new BrickWall(width * 5, width * 4),
					new Ground(width * 6, width * 4),
					new BrickWall(width * 7, width * 4),
					new Ground(width * 8, width * 4),
					new BrickWall(width * 9, width * 4),
					new Ground(width * 10, width * 4),
					new Ground(width * 11, width * 4),
					new Ground(width * 12, width * 4),
					// Row6
					new Ground(width * 0, width * 5),
					new Ground(width * 1, width * 5),
					new Ground(width * 2, width * 5),
					new BrickWall(width * 3, width * 5),
					new BrickWall(width * 4, width * 5),
					new BrickWall(width * 5, width * 5),
					new Ground(width * 6, width * 5),
					new BrickWall(width * 7, width * 5),
					new BrickWall(width * 8, width * 5),
					new BrickWall(width * 9, width * 5),
					new Ground(width * 10, width * 5),
					new Ground(width * 11, width * 5),
					new Ground(width * 12, width * 5),
					// Row7
					new Ground(width * 0, width * 6),
					new Ground(width * 1, width * 6),
					new Ground(width * 2, width * 6),
					new Ground(width * 3, width * 6),
					new Ground(width * 4, width * 6),
					new Ground(width * 5, width * 6),
					new Ground(width * 6, width * 6),
					new Ground(width * 7, width * 6),
					new Ground(width * 8, width * 6),
					new Ground(width * 9, width * 6),
					new Ground(width * 10, width * 6),
					new Ground(width * 11, width * 6),
					new Ground(width * 12, width * 6),
					// Row8
					new SteelWall(width * 0, width * 7),
					new Ground(width * 1, width * 7),
					new Ground(width * 2, width * 7),
					new Ground(width * 3, width * 7),
					new Ground(width * 4, width * 7),
					new Ground(width * 5, width * 7),
					new SteelWall(width * 6, width * 7),
					new Ground(width * 7, width * 7),
					new Ground(width * 8, width * 7),
					new Ground(width * 9, width * 7),
					new Ground(width * 10, width * 7),
					new Ground(width * 11, width * 7),
					new SteelWall(width * 12, width * 7),
					// Row9
					new Forest(width * 0, width * 8),
					new BrickWall(width * 1, width * 8),
					new Ground(width * 2, width * 8),
					new BrickWall(width * 3, width * 8),
					new Ground(width * 4, width * 8),
					new BrickWall(width * 5, width * 8),
					new BrickWall(width * 6, width * 8),
					new BrickWall(width * 7, width * 8),
					new Ground(width * 8, width * 8),
					new BrickWall(width * 9, width * 8),
					new Ground(width * 10, width * 8),
					new BrickWall(width * 11, width * 8),
					new Forest(width * 12, width * 8),
					// Row10
					new Forest(width * 0, width * 9),
					new BrickWall(width * 1, width * 9),
					new SteelWall(width * 2, width * 9),
					new BrickWall(width * 3, width * 9),
					new SteelWall(width * 4, width * 9),
					new BrickWall(width * 5, width * 9),
					new BrickWall(width * 6, width * 9),
					new BrickWall(width * 7, width * 9),
					new SteelWall(width * 8, width * 9),
					new BrickWall(width * 9, width * 9),
					new SteelWall(width * 10, width * 9),
					new BrickWall(width * 11, width * 9),
					new Forest(width * 12, width * 9),
					// Row11
					new Forest(width * 0, width * 10),
					new BrickWall(width * 1, width * 10),
					new Ground(width * 2, width * 10),
					new BrickWall(width * 3, width * 10),
					new Ground(width * 4, width * 10),
					new Ground(width * 5, width * 10),
					new Ground(width * 6, width * 10),
					new Ground(width * 7, width * 10),
					new Ground(width * 8, width * 10),
					new BrickWall(width * 9, width * 10),
					new Ground(width * 10, width * 10),
					new BrickWall(width * 11, width * 10),
					new Forest(width * 12, width * 10),
					// Row12
					new Forest(width * 0, width * 11),
					new BrickWall(width * 1, width * 11),
					new Ground(width * 2, width * 11),
					new BrickWall(width * 3, width * 11),
					new Ground(width * 4, width * 11),
					new BrickWall(width * 5, width * 11),
					new BrickWall(width * 6, width * 11),
					new BrickWall(width * 7, width * 11),
					new Ground(width * 8, width * 11),
					new BrickWall(width * 9, width * 11),
					new Ground(width * 10, width * 11),
					new BrickWall(width * 11, width * 11),
					new Forest(width * 12, width * 11),
					// Row13
					new Forest(width * 0, width * 12),
					new Forest(width * 1, width * 12),
					new Forest(width * 2, width * 12),
					new Ground(width * 3, width * 12),
					new Ground(width * 4, width * 12),
					new BrickWall(width * 5, width * 12),
					new Base(width * 6, width * 12),
					new BrickWall(width * 7, width * 12),
					new Ground(width * 8, width * 12),
					new Ground(width * 9, width * 12),
					new Forest(width * 10, width * 12),
					new Forest(width * 11, width * 12),
					new Forest(width * 12, width * 12) };
		}
		if (i == 2) {
			return new MapObject[] {
					// Row1
					new Ground(width * 0, 0), new Ground(width * 1, 0),
					new Ground(width * 2, 0), new Ground(width * 3, 0),
					new Ground(width * 4, 0), new Ground(width * 5, 0),
					new Ground(width * 6, 0), new Ground(width * 7, 0),
					new Ground(width * 8, 0), new Ground(width * 9, 0),
					new Ground(width * 10, 0), new Ground(width * 11, 0),
					new Ground(width * 12, 0),
					// Row2
					new Ground(width * 0, width), new Ground(width * 1, width),
					new Ground(width * 2, width),
					new BrickWall(width * 3, width),
					new BrickWall(width * 4, width),
					new BrickWall(width * 5, width),
					new Ground(width * 6, width),
					new BrickWall(width * 7, width),
					new BrickWall(width * 8, width),
					new BrickWall(width * 9, width),
					new Ground(width * 10, width),
					new Ground(width * 11, width),
					new Ground(width * 12, width),
					// Row3
					new Ground(width * 0, width * 2),
					new Ground(width * 1, width * 2),
					new Ground(width * 2, width * 2),
					new BrickWall(width * 3, width * 2),
					new Ground(width * 4, width * 2),
					new BrickWall(width * 5, width * 2),
					new Ground(width * 6, width * 2),
					new BrickWall(width * 7, width * 2),
					new Ground(width * 8, width * 2),
					new BrickWall(width * 9, width * 2),
					new Ground(width * 10, width * 2),
					new Ground(width * 11, width * 2),
					new Ground(width * 12, width * 2),
					// Row4
					new Ground(width * 0, width * 3),
					new Ground(width * 1, width * 3),
					new Ground(width * 2, width * 3),
					new BrickWall(width * 3, width * 3),
					new BrickWall(width * 4, width * 3),
					new BrickWall(width * 5, width * 3),
					new Ground(width * 6, width * 3),
					new BrickWall(width * 7, width * 3),
					new Ground(width * 8, width * 3),
					new BrickWall(width * 9, width * 3),
					new Ground(width * 10, width * 3),
					new Ground(width * 11, width * 3),
					new Ground(width * 12, width * 3),
					// Row5
					new Ground(width * 0, width * 4),
					new Ground(width * 1, width * 4),
					new Ground(width * 2, width * 4),
					new Ground(width * 3, width * 4),
					new Ground(width * 4, width * 4),
					new BrickWall(width * 5, width * 4),
					new Ground(width * 6, width * 4),
					new BrickWall(width * 7, width * 4),
					new Ground(width * 8, width * 4),
					new BrickWall(width * 9, width * 4),
					new Ground(width * 10, width * 4),
					new Ground(width * 11, width * 4),
					new Ground(width * 12, width * 4),
					// Row6
					new Ground(width * 0, width * 5),
					new Ground(width * 1, width * 5),
					new Ground(width * 2, width * 5),
					new BrickWall(width * 3, width * 5),
					new BrickWall(width * 4, width * 5),
					new BrickWall(width * 5, width * 5),
					new Ground(width * 6, width * 5),
					new BrickWall(width * 7, width * 5),
					new BrickWall(width * 8, width * 5),
					new BrickWall(width * 9, width * 5),
					new Ground(width * 10, width * 5),
					new Ground(width * 11, width * 5),
					new Ground(width * 12, width * 5),
					// Row7
					new Ground(width * 0, width * 6),
					new Ground(width * 1, width * 6),
					new Ground(width * 2, width * 6),
					new Ground(width * 3, width * 6),
					new Ground(width * 4, width * 6),
					new Ground(width * 5, width * 6),
					new Ground(width * 6, width * 6),
					new Ground(width * 7, width * 6),
					new Ground(width * 8, width * 6),
					new Ground(width * 9, width * 6),
					new Ground(width * 10, width * 6),
					new Ground(width * 11, width * 6),
					new Ground(width * 12, width * 6),
					// Row8
					new SteelWall(width * 0, width * 7),
					new Ground(width * 1, width * 7),
					new Ground(width * 2, width * 7),
					new Ground(width * 3, width * 7),
					new Ground(width * 4, width * 7),
					new Ground(width * 5, width * 7),
					new SteelWall(width * 6, width * 7),
					new Ground(width * 7, width * 7),
					new Ground(width * 8, width * 7),
					new Ground(width * 9, width * 7),
					new Ground(width * 10, width * 7),
					new Ground(width * 11, width * 7),
					new SteelWall(width * 12, width * 7),
					// Row9
					new Forest(width * 0, width * 8),
					new BrickWall(width * 1, width * 8),
					new Ground(width * 2, width * 8),
					new BrickWall(width * 3, width * 8),
					new Ground(width * 4, width * 8),
					new BrickWall(width * 5, width * 8),
					new BrickWall(width * 6, width * 8),
					new BrickWall(width * 7, width * 8),
					new Ground(width * 8, width * 8),
					new BrickWall(width * 9, width * 8),
					new Ground(width * 10, width * 8),
					new BrickWall(width * 11, width * 8),
					new Forest(width * 12, width * 8),
					// Row10
					new Forest(width * 0, width * 9),
					new BrickWall(width * 1, width * 9),
					new SteelWall(width * 2, width * 9),
					new BrickWall(width * 3, width * 9),
					new SteelWall(width * 4, width * 9),
					new BrickWall(width * 5, width * 9),
					new BrickWall(width * 6, width * 9),
					new BrickWall(width * 7, width * 9),
					new SteelWall(width * 8, width * 9),
					new BrickWall(width * 9, width * 9),
					new SteelWall(width * 10, width * 9),
					new BrickWall(width * 11, width * 9),
					new Forest(width * 12, width * 9),
					// Row11
					new Forest(width * 0, width * 10),
					new BrickWall(width * 1, width * 10),
					new Ground(width * 2, width * 10),
					new BrickWall(width * 3, width * 10),
					new Ground(width * 4, width * 10),
					new Ground(width * 5, width * 10),
					new Ground(width * 6, width * 10),
					new Ground(width * 7, width * 10),
					new Ground(width * 8, width * 10),
					new BrickWall(width * 9, width * 10),
					new Ground(width * 10, width * 10),
					new BrickWall(width * 11, width * 10),
					new Forest(width * 12, width * 10),
					// Row12
					new Forest(width * 0, width * 11),
					new BrickWall(width * 1, width * 11),
					new Ground(width * 2, width * 11),
					new BrickWall(width * 3, width * 11),
					new Ground(width * 4, width * 11),
					new SteelWall(width * 5, width * 11),
					new SteelWall(width * 6, width * 11),
					new SteelWall(width * 7, width * 11),
					new Ground(width * 8, width * 11),
					new BrickWall(width * 9, width * 11),
					new Ground(width * 10, width * 11),
					new BrickWall(width * 11, width * 11),
					new Forest(width * 12, width * 11),
					// Row13
					new Forest(width * 0, width * 12),
					new Forest(width * 1, width * 12),
					new Forest(width * 2, width * 12),
					new Ground(width * 3, width * 12),
					new Ground(width * 4, width * 12),
					new SteelWall(width * 5, width * 12),
					new Base(width * 6, width * 12),
					new SteelWall(width * 7, width * 12),
					new Ground(width * 8, width * 12),
					new Ground(width * 9, width * 12),
					new Forest(width * 10, width * 12),
					new Forest(width * 11, width * 12),
					new Forest(width * 12, width * 12) };
		}
		return null;
	}
}
