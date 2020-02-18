import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

public class BulletFire {
	
public static void update(float delta,Player player) {
	Bullet Bullet1 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	Bullet Bullet2 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	Bullet Bullet3 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	Bullet Bullet4 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	Bullet Bullet5 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	Bullet Bullet6 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	Bullet Bullet7 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
	Bullet Bullet8 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),120,120);
if(Keyboard.isKeyDown(Keyboard.KEY_UP)) {
	Bullet1.draw(delta);
	Bullet1.setyPos(Bullet1.getyPos()-(120*25*delta));
	Bullet1.setxPos(Bullet1.getxPos()-(120*25*delta));
}




} //End of Update




}
