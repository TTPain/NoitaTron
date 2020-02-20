import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

public class BulletFire {
	private static boolean Fire = false;
	private static int bulletDirection;

	static Bullet Bullet1 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	static Bullet Bullet2 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	static Bullet Bullet3 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	static Bullet Bullet4 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	static Bullet Bullet5 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	static Bullet Bullet6 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	static Bullet Bullet7 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	static Bullet Bullet8 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
public static void update(float delta,Player player) {

if(Keyboard.isKeyDown(Keyboard.KEY_UP)) {
	bulletDirection=1;
}
if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
	bulletDirection=5;
}
if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
	bulletDirection=7;
}
if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
	bulletDirection=3;
}
if(Keyboard.isKeyDown(Keyboard.KEY_UP) && (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))) {
	bulletDirection=2;
}
if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) && (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))) {
	bulletDirection=4;
}
if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) && (Keyboard.isKeyDown(Keyboard.KEY_LEFT))) {
	bulletDirection=6;
}
if(Keyboard.isKeyDown(Keyboard.KEY_UP) && (Keyboard.isKeyDown(Keyboard.KEY_LEFT))) {
	bulletDirection=8;
}


System.out.println(bulletDirection);

} //End of Update




}
