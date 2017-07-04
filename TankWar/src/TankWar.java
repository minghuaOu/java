import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TankWar extends JPanel {

	private static final long serialVersionUID = 4130391927874952955L;
	private static final int TIMER_TASK_INTERVAL = 8;
	public static final int UNIT_LENGTH = 48;
	public static final int TILE_COUNT = 13;
	public static final int GAME_FRAME_WIDTH = 13 * UNIT_LENGTH + 7;
	public static final int GAME_FRAME_HEIGHT = 13 * UNIT_LENGTH + 29;
	protected static final int GAMERUNNING = 0;
	protected static final int PAUSED = 1;
	protected static final int GAMEOVER = 2;
	public static int stage = 1;

	JFrame frame;
	HeroTank hero = null;
	Map map = null;
	Vector<EnemyTank> EnemyTanks = new Vector<EnemyTank>();
	Base base;
	private int tank_frequency = 600;
	private int tank_count = 10;

	public TankWar() {

		EnemyTanks = new Vector<EnemyTank>();
		EnemyTanks.add(new EnemyTank());
		EnemyTanks.add(new EnemyTank());
		EnemyTanks.add(new EnemyTank());
		hero = new HeroTank();
		map = new Map(stage);
		base = (Base) map.getTileByIJ(6, 12);

		new Audio("start");
		frame = new JFrame("坦克大战");
		frame.add(this);
		frame.setSize(GAME_FRAME_WIDTH, GAME_FRAME_HEIGHT);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (state == GAMERUNNING
						&& ((e.getKeyCode() == KeyEvent.VK_LEFT) || (e.getKeyCode() == KeyEvent.VK_RIGHT)
								|| (e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_DOWN))) {
					hero.move(map, e);
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (state == GAMERUNNING) {
						state = PAUSED;
					} else if (state == PAUSED) {
						state = GAMERUNNING;
					} else if (state == GAMEOVER) {
						state = GAMERUNNING;
					}
				}
				if (state == GAMERUNNING && e.getKeyCode() == KeyEvent.VK_SHIFT) {
					hero.fire(e);
				}
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("触发windowClosing事件");
				close();
			}
		});
	}

	public void paint(Graphics g) {
		map.paintMap(g);
		hero.paint(g);
		synchronized (EnemyTanks) {
			for (EnemyTank tank : EnemyTanks) {
				tank.paint(g);
			}
		}
		map.paintForests(g);
		if (state == PAUSED) {
			g.drawImage(Images.pause, 253, 301, null);
		}
		if (state == GAMEOVER) {
			g.drawImage(Images.gameover, 264, 300, null);
		}
	}

	protected int state;

	private void action() {
		Timer timer = new Timer();
		int interval = TIMER_TASK_INTERVAL;
		timer.schedule(new TimerTask() {
			public void run() {
				try {
					if (state == GAMERUNNING) {
						hero.moveBullet(EnemyTanks, map);
						for (EnemyTank tank : EnemyTanks) {
							tank.moveBullet(hero, map);
							tank.move(map);
							tank.fire();
						}
						if (tank_frequency-- <= 0) {
							if(tank_count>0){
								EnemyTanks.add(new EnemyTank());
								tank_count--;
								tank_frequency = 600;
							}
						}
						if (tank_count > 0 && EnemyTanks.size()<3) {
							tank_count--;
							EnemyTanks.add(new EnemyTank());
						}
						if(tank_count<=0 && EnemyTanks.size()==0){
							throw new Win();
						}
					}
					repaint();
				} catch (GameOver e) {
					System.out.println("游戏结束！");
					new Audio("die");
					JOptionPane.showMessageDialog(TankWar.this, "游戏结束，你输了！");
					base.gameover();
					state = GAMEOVER;
					repaint();
					stage = 1;
					this.cancel();
					TankWar.this.close();
					new TankWar().action();
				} catch (Win e) {
					System.out.println("通过了第" + stage + "关！");
					new Audio("win");
					JOptionPane.showMessageDialog(TankWar.this, "游戏结束，你赢了！");
					repaint();
//					stage++;
					this.cancel();
					TankWar.this.close();
					new TankWar().action();
				}
			}
		}, interval, interval);
	}

	protected void close() {
		frame.dispose();
	}

	public static void main(String[] args) {
		TankWar game = new TankWar();
		game.action();
	}
}