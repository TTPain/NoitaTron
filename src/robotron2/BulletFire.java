package robotron2;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlSound;

import java.util.ArrayList;

import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;

import com.osreboot.ridhvl2.loader.HvlLoaderSound;

public class BulletFire {

	private static float bSpeedC = 1200;
	private static float bSpeedD = 700;
	private static float soundPitch= 1;
	private static int bulletDirection = 0;

	private static float cooldown = 0.0f;
	private static float cooldownSpeed = 12;

	public static ArrayList<Bullet> bullets = new ArrayList<>();

	// xArg, yArg, xSpeed, ySpeed, fired, drawn
	public static Bullet bullet1 = new Bullet(Game.player.getxPos(), Game.player.getyPos(), 0, 0, false, false, 0);
	public static Bullet bullet2 = new Bullet(Game.player.getxPos(), Game.player.getyPos(), 0, 0, false, false, 0);
	public static Bullet bullet3 = new Bullet(Game.player.getxPos(), Game.player.getyPos(), 0, 0, false, false, 0);
	public static Bullet bullet4 = new Bullet(Game.player.getxPos(), Game.player.getyPos(), 0, 0, false, false, 0);
	public static Bullet bullet5 = new Bullet(Game.player.getxPos(), Game.player.getyPos(), 0, 0, false, false, 0);
	public static Bullet bullet6 = new Bullet(Game.player.getxPos(), Game.player.getyPos(), 0, 0, false, false, 0);
	public static Bullet bullet7 = new Bullet(Game.player.getxPos(), Game.player.getyPos(), 0, 0, false, false, 0);
	public static Bullet bullet8 = new Bullet(Game.player.getxPos(), Game.player.getyPos(), 0, 0, false, false, 0);

	public static void initialize() {
		bullets.add(bullet1);
		bullets.add(bullet2);
		bullets.add(bullet3);
		bullets.add(bullet4);
		bullets.add(bullet5);
		bullets.add(bullet6);
		bullets.add(bullet7);
		bullets.add(bullet8);
	}
	public static void reset(Player player) {
		for(Bullet b : bullets) {
			
			b.setxPos(player.getxPos());
			b.setyPos(player.getyPos());
			b.setFired(false);
			b.setBulletDrawn(false);
			b.setxSpeed(0);
			b.setySpeed(0);
			
		}
	}

	public static void update(float delta, Player player) {
		
		//DANGER ZONE
		if(Keyboard.isKeyDown(Keyboard.KEY_E)) {
		    for(double d = 0; d < 360; d += 15) {
		        double d2 = d + Main.newest().getTimer().getTotalTime() * 100f;
		        float speed = 100;
		        float xs = (float)Math.cos(Math.toRadians(d2)) * speed;
		        float ys = (float)Math.sin(Math.toRadians(d2)) * speed;
		        bullets.add(new Bullet(Game.player.getxPos(), Game.player.getyPos(), xs, ys, true, false, 0));
		    }
		}
		//E
		
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			bulletDirection = 1;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			bulletDirection = 5;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			bulletDirection = 7;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			bulletDirection = 3;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_UP) && (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))) {
			bulletDirection = 2;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN) && (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))) {
			bulletDirection = 4;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN) && (Keyboard.isKeyDown(Keyboard.KEY_LEFT))) {
			bulletDirection = 6;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_UP) && (Keyboard.isKeyDown(Keyboard.KEY_LEFT))) {
			bulletDirection = 8;
		}

		if (cooldown > 0) {
			cooldown = cooldown - (delta * cooldownSpeed);
		}

		if (cooldown < 0) {
			cooldown = 0;
		}

		// draw bullet if it is in playfield and make it move in the direction
		// specified, below

		if (bullet1.isFired() == false && bulletDirection > 0 && (cooldown == 0)) {
			bullet1.setFired(true);
			bullet1.setDirectionFired(bulletDirection);
			hvlSound(0).playAsSoundEffect(soundPitch, 1, false);
			if (cooldown == 0) {
				cooldown = 1;
			}
			
			if (bulletDirection == 1) {
				bullet1.setySpeed(-bSpeedC);
				bullet1.setxSpeed(0);
			} else if (bulletDirection == 2) {
				bullet1.setySpeed(-bSpeedD);
				bullet1.setxSpeed(bSpeedD);
			} else if (bulletDirection == 3) {
				bullet1.setySpeed(0);
				bullet1.setxSpeed(bSpeedC);
			} else if (bulletDirection == 4) {
				bullet1.setySpeed(bSpeedD);
				bullet1.setxSpeed(bSpeedD);
			} else if (bulletDirection == 5) {
				bullet1.setySpeed(bSpeedC);
				bullet1.setxSpeed(0);
			} else if (bulletDirection == 6) {
				bullet1.setySpeed(bSpeedD);
				bullet1.setxSpeed(-bSpeedD);
			} else if (bulletDirection == 7) {
				bullet1.setySpeed(0);
				bullet1.setxSpeed(-bSpeedC);
			} else if (bulletDirection == 8) {
				bullet1.setySpeed(-bSpeedD);
				bullet1.setxSpeed(-bSpeedD);
			}
		}

		if (bullet1.isBulletDrawn() && (bullet1.isFired()) && !(bullet2.isFired()) && bulletDirection > 0
				&& cooldown == 0) {
			bullet2.setFired(true);
			bullet2.setDirectionFired(bulletDirection);
			hvlSound(0).playAsSoundEffect(soundPitch, 1, false);
			if (cooldown == 0) {
				cooldown = 1;
			}
			if (bulletDirection == 1) {
				bullet2.setySpeed(-bSpeedC);
				bullet2.setxSpeed(0);
			} else if (bulletDirection == 2) {
				bullet2.setySpeed(-bSpeedD);
				bullet2.setxSpeed(bSpeedD);
			} else if (bulletDirection == 3) {
				bullet2.setySpeed(0);
				bullet2.setxSpeed(bSpeedC);
			} else if (bulletDirection == 4) {
				bullet2.setySpeed(bSpeedD);
				bullet2.setxSpeed(bSpeedD);
			} else if (bulletDirection == 5) {
				bullet2.setySpeed(bSpeedC);
				bullet2.setxSpeed(0);
			} else if (bulletDirection == 6) {
				bullet2.setySpeed(bSpeedD);
				bullet2.setxSpeed(-bSpeedD);
			} else if (bulletDirection == 7) {
				bullet2.setySpeed(0);
				bullet2.setxSpeed(-bSpeedC);
			} else if (bulletDirection == 8) {
				bullet2.setySpeed(-bSpeedD);
				bullet2.setxSpeed(-bSpeedD);
			}
		}

		if (bullet1.isBulletDrawn() && bullet2.isBulletDrawn() && bullet1.isFired() && bullet2.isFired()
				&& !(bullet3.isFired()) && bulletDirection > 0 && cooldown == 0) {
			bullet3.setFired(true);
			bullet3.setDirectionFired(bulletDirection);
			hvlSound(0).playAsSoundEffect(soundPitch, 1, false);
			if (cooldown == 0) {
				cooldown = 1;
			}
			if (bulletDirection == 1) {
				bullet3.setySpeed(-bSpeedC);
				bullet3.setxSpeed(0);
			} else if (bulletDirection == 2) {
				bullet3.setySpeed(-bSpeedD);
				bullet3.setxSpeed(bSpeedD);
			} else if (bulletDirection == 3) {
				bullet3.setySpeed(0);
				bullet3.setxSpeed(bSpeedC);
			} else if (bulletDirection == 4) {
				bullet3.setySpeed(bSpeedD);
				bullet3.setxSpeed(bSpeedD);
			} else if (bulletDirection == 5) {
				bullet3.setySpeed(bSpeedC);
				bullet3.setxSpeed(0);
			} else if (bulletDirection == 6) {
				bullet3.setySpeed(bSpeedD);
				bullet3.setxSpeed(-bSpeedD);
			} else if (bulletDirection == 7) {
				bullet3.setySpeed(0);
				bullet3.setxSpeed(-bSpeedC);
			} else if (bulletDirection == 8) {
				bullet3.setySpeed(-bSpeedD);
				bullet3.setxSpeed(-bSpeedD);
			}
		}

		if (bullet1.isBulletDrawn() && bullet2.isBulletDrawn() && bullet3.isBulletDrawn() && bullet1.isFired()
				&& bullet2.isFired() && bullet3.isFired() && !(bullet4.isFired()) && bulletDirection > 0
				&& cooldown == 0) {
			bullet4.setFired(true);
			bullet4.setDirectionFired(bulletDirection);
			hvlSound(0).playAsSoundEffect(soundPitch, 1, false);
			if (bulletDirection == 1) {
				bullet4.setySpeed(-bSpeedC);
				bullet4.setxSpeed(0);
			} else if (bulletDirection == 2) {
				bullet4.setySpeed(-bSpeedD);
				bullet4.setxSpeed(bSpeedD);
			} else if (bulletDirection == 3) {
				bullet4.setySpeed(0);
				bullet4.setxSpeed(bSpeedC);
			} else if (bulletDirection == 4) {
				bullet4.setySpeed(bSpeedD);
				bullet4.setxSpeed(bSpeedD);
			} else if (bulletDirection == 5) {
				bullet4.setySpeed(bSpeedC);
				bullet4.setxSpeed(0);
			} else if (bulletDirection == 6) {
				bullet4.setySpeed(bSpeedD);
				bullet4.setxSpeed(-bSpeedD);
			} else if (bulletDirection == 7) {
				bullet4.setySpeed(0);
				bullet4.setxSpeed(-bSpeedC);
			} else if (bulletDirection == 8) {
				bullet4.setySpeed(-bSpeedD);
				bullet4.setxSpeed(-bSpeedD);
			}
			if (cooldown == 0) {
				cooldown = 1;
			}
		}

		if (bullet1.isBulletDrawn() && bullet2.isBulletDrawn() && bullet3.isBulletDrawn() && bullet4.isBulletDrawn()
				&& bullet1.isFired() && bullet2.isFired() && bullet3.isFired() && bullet4.isFired()
				&& !(bullet5.isFired()) && bulletDirection > 0 && cooldown == 0) {
			bullet5.setFired(true);
			bullet5.setDirectionFired(bulletDirection);
			hvlSound(0).playAsSoundEffect(soundPitch, 1, false);
			if (bulletDirection == 1) {
				bullet5.setySpeed(-bSpeedC);
				bullet5.setxSpeed(0);
			} else if (bulletDirection == 2) {
				bullet5.setySpeed(-bSpeedD);
				bullet5.setxSpeed(bSpeedD);
			} else if (bulletDirection == 3) {
				bullet5.setySpeed(0);
				bullet5.setxSpeed(bSpeedC);
			} else if (bulletDirection == 4) {
				bullet5.setySpeed(bSpeedD);
				bullet5.setxSpeed(bSpeedD);
			} else if (bulletDirection == 5) {
				bullet5.setySpeed(bSpeedC);
				bullet5.setxSpeed(0);
			} else if (bulletDirection == 6) {
				bullet5.setySpeed(bSpeedD);
				bullet5.setxSpeed(-bSpeedD);
			} else if (bulletDirection == 7) {
				bullet5.setySpeed(0);
				bullet5.setxSpeed(-bSpeedC);
			} else if (bulletDirection == 8) {
				bullet5.setySpeed(-bSpeedD);
				bullet5.setxSpeed(-bSpeedD);
			}
			if (cooldown == 0) {
				cooldown = 1;
			}
		}

		if (bullet1.isBulletDrawn() && bullet2.isBulletDrawn() && bullet3.isBulletDrawn() && bullet4.isBulletDrawn()
				&& bullet5.isBulletDrawn() && bullet1.isFired() && bullet2.isFired() && bullet3.isFired()
				&& bullet4.isFired() && bullet5.isFired() && !(bullet6.isFired()) && bulletDirection > 0
				&& cooldown == 0) {
			bullet6.setFired(true);
			bullet6.setDirectionFired(bulletDirection);
			hvlSound(0).playAsSoundEffect(soundPitch, 1, false);
			if (bulletDirection == 1) {
				bullet6.setySpeed(-bSpeedC);
				bullet6.setxSpeed(0);
			} else if (bulletDirection == 2) {
				bullet6.setySpeed(-bSpeedD);
				bullet6.setxSpeed(bSpeedD);
			} else if (bulletDirection == 3) {
				bullet6.setySpeed(0);
				bullet6.setxSpeed(bSpeedC);
			} else if (bulletDirection == 4) {
				bullet6.setySpeed(bSpeedD);
				bullet6.setxSpeed(bSpeedD);
			} else if (bulletDirection == 5) {
				bullet6.setySpeed(bSpeedC);
				bullet6.setxSpeed(0);
			} else if (bulletDirection == 6) {
				bullet6.setySpeed(bSpeedD);
				bullet6.setxSpeed(-bSpeedD);
			} else if (bulletDirection == 7) {
				bullet6.setySpeed(0);
				bullet6.setxSpeed(-bSpeedC);
			} else if (bulletDirection == 8) {
				bullet6.setySpeed(-bSpeedD);
				bullet6.setxSpeed(-bSpeedD);
			}
			if (cooldown == 0) {
				cooldown = 1;
			}
		}

		if (bullet1.isBulletDrawn() && bullet2.isBulletDrawn() && bullet3.isBulletDrawn() && bullet4.isBulletDrawn()
				&& bullet5.isBulletDrawn() && bullet6.isBulletDrawn() && bullet1.isFired() && bullet2.isFired()
				&& bullet3.isFired() && bullet4.isFired() && bullet5.isFired() && bullet6.isFired()
				&& !(bullet7.isFired()) && bulletDirection > 0 && cooldown == 0) {
			bullet7.setFired(true);
			bullet7.setDirectionFired(bulletDirection);
			hvlSound(0).playAsSoundEffect(soundPitch, 1, false);
			if (bulletDirection == 1) {
				bullet7.setySpeed(-bSpeedC);
				bullet7.setxSpeed(0);
			} else if (bulletDirection == 2) {
				bullet7.setySpeed(-bSpeedD);
				bullet7.setxSpeed(bSpeedD);
			} else if (bulletDirection == 3) {
				bullet7.setySpeed(0);
				bullet7.setxSpeed(bSpeedC);
			} else if (bulletDirection == 4) {
				bullet7.setySpeed(bSpeedD);
				bullet7.setxSpeed(bSpeedD);
			} else if (bulletDirection == 5) {
				bullet7.setySpeed(bSpeedC);
				bullet7.setxSpeed(0);
			} else if (bulletDirection == 6) {
				bullet7.setySpeed(bSpeedD);
				bullet7.setxSpeed(-bSpeedD);
			} else if (bulletDirection == 7) {
				bullet7.setySpeed(0);
				bullet7.setxSpeed(-bSpeedC);
			} else if (bulletDirection == 8) {
				bullet7.setySpeed(-bSpeedD);
				bullet7.setxSpeed(-bSpeedD);
			}
			if (cooldown == 0) {
				cooldown = 1;
			}
		}

		if (bullet1.isBulletDrawn() && bullet2.isBulletDrawn() && bullet3.isBulletDrawn() && bullet4.isBulletDrawn()
				&& bullet5.isBulletDrawn() && bullet6.isBulletDrawn() && bullet7.isBulletDrawn() && bullet1.isFired()
				&& bullet2.isFired() && bullet3.isFired() && bullet4.isFired() && bullet5.isFired() && bullet6.isFired()
				&& bullet7.isFired() && !(bullet8.isFired()) && bulletDirection > 0 && cooldown == 0) {
			bullet8.setFired(true);
			bullet8.setDirectionFired(bulletDirection);
			hvlSound(0).playAsSoundEffect(soundPitch, 1, false);
			if (bulletDirection == 1) {
				bullet8.setySpeed(-bSpeedC);
				bullet8.setxSpeed(0);
			} else if (bulletDirection == 2) {
				bullet8.setySpeed(-bSpeedD);
				bullet8.setxSpeed(bSpeedD);
			} else if (bulletDirection == 3) {
				bullet8.setySpeed(0);
				bullet8.setxSpeed(bSpeedC);
			} else if (bulletDirection == 4) {
				bullet8.setySpeed(bSpeedD);
				bullet8.setxSpeed(bSpeedD);
			} else if (bulletDirection == 5) {
				bullet8.setySpeed(bSpeedC);
				bullet8.setxSpeed(0);
			} else if (bulletDirection == 6) {
				bullet8.setySpeed(bSpeedD);
				bullet8.setxSpeed(-bSpeedD);
			} else if (bulletDirection == 7) {
				bullet8.setySpeed(0);
				bullet8.setxSpeed(-bSpeedC);
			} else if (bulletDirection == 8) {
				bullet8.setySpeed(-bSpeedD);
				bullet8.setxSpeed(-bSpeedD);
			}
			if (cooldown == 0) {
				cooldown = 1;
			}
		}

		for (Bullet bullet : bullets) {
			if (bullet.isOnScreen()) {
				bullet.setyPos(bullet.getyPos() + (delta * bullet.getySpeed()));
				bullet.setxPos(bullet.getxPos() + (delta * bullet.getxSpeed()));
			}
			if (bullet.isOnScreen() && bullet.isFired()) {
				bullet.draw(delta);
				bullet.setBulletDrawn(true);
			} else {
				bullet.setFired(false);
				bullet.setxPos(player.getxPos());
				bullet.setyPos(player.getyPos());
				bullet.setxSpeed(0);
				bullet.setySpeed(0);
				bullet.setBulletDrawn(false);
				bulletDirection = 0;
			}
		}
	} // End of Update

}
