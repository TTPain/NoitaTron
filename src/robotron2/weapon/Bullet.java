package robotron2.weapon;

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
	private boolean bulletDrawn = false;
	private boolean fired = false;
	private int directionFired;

	public Bullet(float xArg, float yArg, float xSpeedArg, float ySpeedArg, boolean firedArg, boolean drawnArg, int directionFiredArg) {
		xSpeed = xSpeedArg;
		ySpeed = ySpeedArg;
		xPos = xArg;
		yPos = yArg;
		fired = firedArg;
		bulletDrawn = drawnArg;
		directionFired = directionFiredArg;
	}

	public void fire(float xSpeedArg, float ySpeedArg) {
		xSpeed = xSpeedArg;
		ySpeed = ySpeedArg;
	}

	public int getBulletDirection() {
		return bulletDirection;
	}

	public void setBulletDirection(int bulletDirection) {
		this.bulletDirection = bulletDirection;
	}

	public boolean isOnScreen() {
		if ((xPos > 160 && xPos < 1920-160) && (yPos > 0 && yPos < 1080)) {
			return true;
		} else {
			return false;
		}
	}

	public void draw(float delta) {
		if (xPos > 160 && xPos < 1920-160 && yPos > 0 && yPos < 1080) {
			hvlDraw(hvlQuadc(xPos, yPos, BULLET_SIZE, BULLET_SIZE), Color.white);
		}

	}

	public float getBulletTime() {
		return bulletTime;
	}

	public void setBulletTime(float bulletTime) {
		this.bulletTime = bulletTime;
	}

	public boolean isBulletDrawn() {
		return bulletDrawn;
	}

	public void setBulletDrawn(boolean bulletDrawn) {
		this.bulletDrawn = bulletDrawn;
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

	public int getDirectionFired() {
		return directionFired;
	}

	public void setDirectionFired(int directionFired) {
		this.directionFired = directionFired;
	}
	
	

}
