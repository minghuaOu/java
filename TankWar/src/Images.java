import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {

	public static BufferedImage pause;
	public static BufferedImage gameover;

	public static BufferedImage shield1;
	public static BufferedImage shield2;

	public static BufferedImage base;
	public static BufferedImage base2;
	public static BufferedImage brickwall;
	public static BufferedImage forest;
	public static BufferedImage river1;
	public static BufferedImage steelwall;
	public static BufferedImage ground;

	public static BufferedImage bulletL;
	public static BufferedImage bulletR;
	public static BufferedImage bulletU;
	public static BufferedImage bulletD;

	public static BufferedImage HeroTank1L1;
	public static BufferedImage HeroTank1R1;
	public static BufferedImage HeroTank1U1;
	public static BufferedImage HeroTank1D1;
	public static BufferedImage HeroTank1L2;
	public static BufferedImage HeroTank1R2;
	public static BufferedImage HeroTank1U2;
	public static BufferedImage HeroTank1D2;

	public static BufferedImage EnemyCommonTank1L1;
	public static BufferedImage EnemyCommonTank1R1;
	public static BufferedImage EnemyCommonTank1U1;
	public static BufferedImage EnemyCommonTank1D1;
	public static BufferedImage EnemyCommonTank1L2;
	public static BufferedImage EnemyCommonTank1R2;
	public static BufferedImage EnemyCommonTank1U2;
	public static BufferedImage EnemyCommonTank1D2;

	static {
		try {
			gameover = ImageIO.read(Images.class.getResource("images/UI/interface/gameover-small.png"));
			pause = ImageIO.read(Images.class.getResource("images/UI/interface/pause.png"));

			/**
			 * bullets
			 * 
			 */
			bulletL = ImageIO.read(Images.class.getResource("images/bullet/bulletL.png"));
			bulletR = ImageIO.read(Images.class.getResource("images/bullet/bulletR.png"));
			bulletU = ImageIO.read(Images.class.getResource("images/bullet/bulletU.png"));
			bulletD = ImageIO.read(Images.class.getResource("images/bullet/bulletD.png"));
			/**
			 * Map continents
			 */
			base = ImageIO.read(Images.class.getResource("images/map/base.png"));
			base2 = ImageIO.read(Images.class.getResource("images/map/base2.png"));
			brickwall = ImageIO.read(Images.class.getResource("images/map/brickwall.png"));
			forest = ImageIO.read(Images.class.getResource("images/map/forest.png"));
			river1 = ImageIO.read(Images.class.getResource("images/map/river1.png"));
			steelwall = ImageIO.read(Images.class.getResource("images/map/steelwall.png"));
			ground = ImageIO.read(Images.class.getResource("images/map/ground.png"));

			/**
			 * Level1 tanks 1
			 */
			HeroTank1L1 = ImageIO.read(Images.class.getResource("images/tank/hero/1Player/1/m1-1-1.png"));
			HeroTank1U1 = ImageIO.read(Images.class.getResource("images/tank/hero/1Player/1/m1-2-1.png"));
			HeroTank1R1 = ImageIO.read(Images.class.getResource("images/tank/hero/1Player/1/m1-3-1.png"));
			HeroTank1D1 = ImageIO.read(Images.class.getResource("images/tank/hero/1Player/1/m1-4-1.png"));
			/**
			 * Level1 tanks 2
			 */
			HeroTank1L2 = ImageIO.read(Images.class.getResource("images/tank/hero/1Player/1/m1-1-2.png"));
			HeroTank1U2 = ImageIO.read(Images.class.getResource("images/tank/hero/1Player/1/m1-2-2.png"));
			HeroTank1R2 = ImageIO.read(Images.class.getResource("images/tank/hero/1Player/1/m1-3-2.png"));
			HeroTank1D2 = ImageIO.read(Images.class.getResource("images/tank/hero/1Player/1/m1-4-2.png"));

			/**
			 * Level1 tanks 1
			 */
			EnemyCommonTank1L1 = ImageIO.read(Images.class.getResource("images/tank/enemy/common/1/1-1-1.png"));
			EnemyCommonTank1U1 = ImageIO.read(Images.class.getResource("images/tank/enemy/common/1/1-2-1.png"));
			EnemyCommonTank1R1 = ImageIO.read(Images.class.getResource("images/tank/enemy/common/1/1-3-1.png"));
			EnemyCommonTank1D1 = ImageIO.read(Images.class.getResource("images/tank/enemy/common/1/1-4-1.png"));
			/**
			 * Level1 tanks 2
			 */
			EnemyCommonTank1L2 = ImageIO.read(Images.class.getResource("images/tank/enemy/common/1/1-1-2.png"));
			EnemyCommonTank1U2 = ImageIO.read(Images.class.getResource("images/tank/enemy/common/1/1-2-2.png"));
			EnemyCommonTank1R2 = ImageIO.read(Images.class.getResource("images/tank/enemy/common/1/1-3-2.png"));
			EnemyCommonTank1D2 = ImageIO.read(Images.class.getResource("images/tank/enemy/common/1/1-4-2.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
