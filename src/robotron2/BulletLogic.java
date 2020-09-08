package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlSound;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;


import com.osreboot.ridhvl2.HvlCoord;

import robotron2.util.Utility;

public class BulletLogic {

	private static float bulletSpeedx;
	private static float bulletSpeedy;
	private static float cooldownClock = 0.0f;
	private static float cooldownSpeed = 12;


	//Add bullets as they are needed, add them back to queue as they leave the screen.
	public static ArrayList<Bullet> bulletTotal = new ArrayList<>();

	// xArg, yArg, xSpeed, ySpeed, fired, drawn
	public static Bullet initialBullet = new Bullet(Game.player.getxPos(), Game.player.getyPos(), 0, 0, false, false, 0);


	public static void initialize() {
		bulletTotal.add(initialBullet);
	}

	public static void reset(Player player) {
		bulletTotal.clear();
		bulletTotal.add(initialBullet);
		
		for(Bullet b : bulletTotal) {
			b.setxPos(player.getxPos());
			b.setyPos(player.getyPos());
			b.setFired(false);
			b.setBulletDrawn(false);
			b.setxSpeed(0);
			b.setySpeed(0);
		}
		
	}
	
	public static void update(float delta, Player player) {
		
		if (cooldownClock > 0) {
			cooldownClock = cooldownClock - (delta * cooldownSpeed);
		}

		if (cooldownClock < 0) {
			cooldownClock = 0;
		}
		
		if(Mouse.isButtonDown(0) && player.isAlive()) {
			//hvlDraw(hvlQuadc(Utility.getCursorX()*1.5f, ((player.getyPos())), 10, 10), Color.white);			
			bulletSpeedx =Utility.getCursorX() - (Display.getWidth()/2);
			bulletSpeedy = Utility.getCursorY() - (Display.getHeight()/2);
			
		
			HvlCoord bulletSpeed = new HvlCoord(bulletSpeedx, bulletSpeedy);
			
			
			bulletSpeed.normalize();
			
						
			bulletSpeedx = bulletSpeed.x * 750;
			bulletSpeedy = bulletSpeed.y * 750;		
					
		}	


		
	}




}
