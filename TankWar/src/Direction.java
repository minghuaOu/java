import java.awt.event.KeyEvent;

/**
 * 方向的枚举类
 * 
 * @author Kuphrer
 *
 */
public enum Direction {
	/**
	 * 枚举4个方向并赋值为四个整数
	 */
	L(0), R(1), U(2), D(3);
	/**
	 * 存放相应的整数
	 */
	private final int value;

	/**
	 * 构造方法，可以获得一个整数对应的方向
	 * 
	 * @param value
	 *            0-3之间的一个整数
	 */
	Direction(int value) {
		this.value = value;//
	}

	/**
	 * 公有方法，可以直接获得某个方向对应的整数
	 * 
	 * @return 某个方向对应的整数
	 */
	public int value() {
		return value;
	}

	/**
	 * 静态方法，将一个键盘事件（方向键）转化为相应的方向
	 */
	public static Direction press(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			return Direction.L;
		case KeyEvent.VK_RIGHT:
			return Direction.R;
		case KeyEvent.VK_UP:
			return Direction.U;
		case KeyEvent.VK_DOWN:
			return Direction.D;
		}
		throw new RuntimeException("No Such Direction.");// 若无此方向则抛出异常
	}
}
