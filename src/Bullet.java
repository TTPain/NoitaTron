import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;


public class Bullet {
	
	public static final float BULLET_SIZE = 6;
	private float xPos;
	private float yPos;
	private float xSpeed;
	private float ySpeed;
	private float bulletTime;
	private int bulletDirection;
	private static boolean bulletDrawn = false;
	private static boolean bulletTwice = false;
	private boolean flagFireNorth = false;
	private boolean flagFireNorthEast = false;
	private boolean flagFireEast = false;
	private boolean flagFireSouthEast = false;
	private boolean flagFireSouth = false;
	private boolean flagFireSouthWest = false;
	private boolean flagFireWest = false;
	private boolean flagFireNorthWest = false;
	private boolean fired = false;
public Bullet(float xArg, float yArg, float xSpeedArg,float ySpeedArg){
		xSpeed=xSpeedArg;
		ySpeed=ySpeedArg;
		xPos = xArg;
		yPos = yArg;

	}
	public void fire(float xSpeedArg, float ySpeedArg) {
		xSpeed=xSpeedArg;
		ySpeed=ySpeedArg;
	}
/* public void update(float delta, Player player) {
		if(Keyboard.isKeyDown(Keyboard.KEY_UP) && !(Keyboard.isKeyDown(Keyboard.KEY_LEFT))  && !(Keyboard.isKeyDown(Keyboard.KEY_DOWN))  && !(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) && bulletTime == 1 ) {
			yPos = (player.getyPos() - 5);
			xPos = (player.getxPos());
			fired = true;
			bulletDirection = 2;
			
		//Up/Left
		} 
		if(Keyboard.isKeyDown(Keyboard.KEY_UP) && Keyboard.isKeyDown(Keyboard.KEY_LEFT) && bulletTwice == false && bulletTime == 1 ) {
			bulletDrawn = true;
			yPos =(player.getyPos() - 5);
			xPos =(player.getxPos() - 5);
			bulletDirection = 1;
			if((Keyboard.isKeyDown(Keyboard.KEY_DOWN)  || (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)))) {
				bulletTwice = true;
				fired = true;
				bulletDirection = 1;
			}
		}
		//Left
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT) && !(Keyboard.isKeyDown(Keyboard.KEY_UP))  && !(Keyboard.isKeyDown(Keyboard.KEY_DOWN))  && !(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) && bulletTime == 1 ) {
			xPos =(player.getxPos() - 5);
			yPos =(player.getyPos());
			fired=true;
			bulletDirection = 8;
		//Down/Left
		}  
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT) && Keyboard.isKeyDown(Keyboard.KEY_DOWN) && bulletTwice == false  && bulletTime == 1) {
			bulletDrawn = true;
			yPos =(player.getyPos() + 5);
			xPos =(player.getxPos() - 5);
			bulletDirection = 7;
			if((Keyboard.isKeyDown(Keyboard.KEY_UP)  || (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)))) {
				bulletTwice = true;
				fired=true;
			}
		}
		//Down
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) && !(Keyboard.isKeyDown(Keyboard.KEY_UP))  && !(Keyboard.isKeyDown(Keyboard.KEY_LEFT))  && !(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) && bulletTime == 1 ) {
			yPos =(player.getyPos() + 5);
			xPos =(player.getxPos());
			fired=true;
			bulletDirection = 6;
		//Down/Right
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) && Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && bulletTwice == false && bulletTime == 1 ) {
			bulletDrawn = true;
			yPos =(player.getyPos() + 5);
			xPos =(player.getxPos() + 5);
			bulletDirection = 5;
			if((Keyboard.isKeyDown(Keyboard.KEY_UP)  || (Keyboard.isKeyDown(Keyboard.KEY_LEFT)))) {
				bulletTwice = true;
				fired=true;
			}
		}
		
		//Right
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && !(Keyboard.isKeyDown(Keyboard.KEY_UP))  && !(Keyboard.isKeyDown(Keyboard.KEY_LEFT))  && !(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) && bulletTime == 1 ) {
			xPos =(player.getxPos() + 5);
			yPos =(player.getyPos());
			fired=true;
			bulletDirection = 4;
		//Up/Right
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_UP) && Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && bulletDrawn == false && bulletTime == 1 ) {
			bulletDrawn = true;
			yPos =(player.getyPos() - 5);
			xPos =(player.getxPos() + 5);
			bulletDirection = 3;
			if((Keyboard.isKeyDown(Keyboard.KEY_DOWN)  || (Keyboard.isKeyDown(Keyboard.KEY_LEFT)))) {
				bulletTwice = true;
				fired=true;
			}
		}
		if(!(Keyboard.isKeyDown(Keyboard.KEY_UP)) && !(Keyboard.isKeyDown(Keyboard.KEY_LEFT))  && !(Keyboard.isKeyDown(Keyboard.KEY_DOWN))  && !(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))) {
			bulletDrawn = false;
			bulletTwice = false;
			//fired=false;
			
			
		//Bullet Despawn
		if(fired==true) {
			bulletTime = bulletTime-(delta)*4;}
			else {
				bulletTime=1f;
			}
		}
		if(bulletTime<0) {
			bulletTime=1;
		}

		System.out.println(bulletTime);
		if(bulletDirection == 1) {
			ySpeed = -25;
			xSpeed = -25;
		}else if(bulletDirection == 2) {
			ySpeed = -25;
			xSpeed = 0;
		}else if(bulletDirection == 3) {
			ySpeed = -25;
			xSpeed = 25;
		}else if(bulletDirection == 4) {
			ySpeed = 0;
			xSpeed = 25;
		}else if(bulletDirection == 5) {
			ySpeed = 25;
			xSpeed = 25;
		}else if(bulletDirection == 6) {
			ySpeed = 25;
			xSpeed = 0;
		}else if(bulletDirection == 7) {
			ySpeed = 25;
			xSpeed = -25;
		}else if(bulletDirection == 8) {
			ySpeed = 0;
			xSpeed = -25;
		}
		else {
			bulletDirection=0;
		}
		
		if(bulletDirection != 0) {
			xPos=xPos+(120*(xSpeed)*delta);
			yPos=yPos+(120*(ySpeed)*delta);
		}
		
		
		System.out.println(bulletTime);
	} */

public int getBulletDirection() {
		return bulletDirection;
	}

public void setBulletDirection(int bulletDirection) {
		this.bulletDirection = bulletDirection;
	}

public boolean isOnScreen() {
	if((xPos > 0 && xPos < 1280) && (yPos > 0 && yPos < 720)) {
		return true;
	}else {
		return false;
	}
}
	
public void draw(float delta){
	if(xPos>0 && xPos <1280 && yPos > 0 && yPos < 720) {	
	hvlDraw(hvlQuadc(xPos, yPos, BULLET_SIZE, BULLET_SIZE), Color.white);
	}
	
	}

public float getBulletTime() {
	return bulletTime;
}

public void setBulletTime(float bulletTime) {
	this.bulletTime = bulletTime;
}

public static boolean isBulletDrawn() {
	return bulletDrawn;
}

public static void setBulletDrawn(boolean bulletDrawn) {
	Bullet.bulletDrawn = bulletDrawn;
}

public static boolean isBulletTwice() {
	return bulletTwice;
}

public static void setBulletTwice(boolean bulletTwice) {
	Bullet.bulletTwice = bulletTwice;
}

public boolean isFired() {
	return fired;
}

public void setFired(boolean fired) {
	this.fired = fired;
}

public float getxPos() {
	return xPos;
}

public float getxSpeed() {
	return xSpeed;
}

public void setxSpeed(float xSpeed) {
	this.xSpeed = xSpeed;
}

public float getySpeed() {
	return ySpeed;
}

public void setySpeed(float ySpeed) {
	this.ySpeed = ySpeed;
}

public void setxPos(float xPos) {
	this.xPos = xPos;
}

public float getyPos() {
	return yPos;
}

public void setyPos(float yPos) {
	this.yPos = yPos;
}
	
}

