import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

public class BulletFire {
	
	private static boolean fire1 = false;
	private static boolean fire2 = false;
	private static boolean fire3 = false;
	private static boolean fire4 = false;
	private static boolean fire5 = false;
	private static boolean fire6 = false;
	private static boolean fire7 = false;
	private static boolean fire8 = false;
	
	private static boolean buffer = false;
	private static boolean b1drawn = false;

	private static int bulletDirection=0;
	private static float cooldown = 0.0f;

	static Bullet bullet1 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet2 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet3 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet4 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet5 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet6 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet7 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet8 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	
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
if(cooldown>0) {
		cooldown = cooldown-(delta*4);
	}
if(cooldown<0) {
		cooldown=0;
	}
if(b1drawn==true && cooldown==0) {
	cooldown=1;
}


if(fire1==false && bulletDirection>0 && cooldown==0) {
	fire1=true;
	
	if(bulletDirection==1) {
		bullet1.setySpeed(-1000);
		bullet1.setxSpeed(0);
	}
	else if(bulletDirection==2) {
		bullet1.setySpeed(-707);
		bullet1.setxSpeed(707);
	}
	else if(bulletDirection==3) {
		bullet1.setySpeed(0);
		bullet1.setxSpeed(1000);
	}
	else if(bulletDirection==4) {
		bullet1.setySpeed(707);
		bullet1.setxSpeed(707);
	}
	else if(bulletDirection==5) {
		bullet1.setySpeed(1000);
		bullet1.setxSpeed(0);
	}
	else if(bulletDirection==6) {
		bullet1.setySpeed(707);
		bullet1.setxSpeed(-707);
	}
	else if(bulletDirection==7) {
		bullet1.setySpeed(0);
		bullet1.setxSpeed(-1000);
	}
	else if(bulletDirection==8) {
		bullet1.setySpeed(-707);
		bullet1.setxSpeed(-707);
	}
}
	
if(b1drawn==true && fire1==true && fire2==false && bulletDirection>0 && cooldown==0 ) {
	fire2=true;
	if(bulletDirection==1) {
		bullet2.setySpeed(-1000);
		bullet2.setxSpeed(0);
	}
	else if(bulletDirection==2) {
		bullet2.setySpeed(-707);
		bullet2.setxSpeed(707);
	}
	else if(bulletDirection==3) {
		bullet2.setySpeed(0);
		bullet2.setxSpeed(1000);
	}
	else if(bulletDirection==4) {
		bullet2.setySpeed(707);
		bullet2.setxSpeed(707);
	}
	else if(bulletDirection==5) {
		bullet2.setySpeed(1000);
		bullet2.setxSpeed(0);
	}
	else if(bulletDirection==6) {
		bullet2.setySpeed(707);
		bullet2.setxSpeed(-707);
	}
	else if(bulletDirection==7) {
		bullet2.setySpeed(0);
		bullet2.setxSpeed(-1000);
	}
	else if(bulletDirection==8) {
		bullet2.setySpeed(-707);
		bullet2.setxSpeed(-707);
	}
	}

if(bullet1.isOnScreen()) {
	bullet1.setyPos(bullet1.getyPos()+(delta*bullet1.getySpeed()));
	bullet1.setxPos(bullet1.getxPos()+(delta*bullet1.getxSpeed()));
}
if(bullet1.isOnScreen() && fire1==true) {
	bullet1.draw(delta);
	b1drawn=true;
}
else {
	fire1=false;
	bullet1.setxPos(player.getxPos());
	bullet1.setyPos(player.getyPos());
	bullet1.setxSpeed(0);
	bullet1.setySpeed(0);
	bulletDirection=0;
	b1drawn=false;
}
if(bullet2.isOnScreen()) {
	bullet2.setyPos(bullet2.getyPos()+(delta*bullet2.getySpeed()));
	bullet2.setxPos(bullet2.getxPos()+(delta*bullet2.getxSpeed()));
}
if(bullet2.isOnScreen() && fire2==true) {
	bullet2.draw(delta);
}
else {
	fire2=false;
	bullet2.setxPos(player.getxPos());
	bullet2.setyPos(player.getyPos());
	bullet2.setxSpeed(0);
	bullet2.setySpeed(0);
	bulletDirection=0;
}
	
//System.out.println(bullet1.getxSpeed());
System.out.println(cooldown);
} //End of Update



}

