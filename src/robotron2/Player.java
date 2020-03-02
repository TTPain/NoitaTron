package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.loader.HvlLoader;
import com.osreboot.ridhvl2.loader.HvlLoaderTexture;

public class Player {

	public Player(float xArg, float yArg, boolean aliveArg) {

		xPos = xArg;
		yPos = yArg;
		alive = aliveArg;

	}

	public static final float PLAYER_START_X = 1280 / 2;
	public static final float PLAYER_START_Y = 720 / 2;
	public static final float PLAYER_WIDTH = 25;
	public static final float PLAYER_HEIGHT = 50;
	
	private float xPos = 1280 / 2;
	private float yPos = 720 / 2;
	private boolean alive = true;
	
	private float xspeedm = 1;
	private float yspeedm = 1;
	private float xspeedp = 1;
	private float yspeedp = 1;
	private float accel = 3;
	private int playerTexture = 0;
	private float respawn = 1;

	public void update(float delta) {
		
		//Death Handling
		
		if(alive==false) {
			xPos=640;
			yPos=360;
			respawn=respawn-delta;
		}
		if(respawn<0) {
			respawn=1;
			alive=true;
			//Score.score = Score.score+100;
			Score.lives = Score.lives-1; 
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xspeedm = xspeedm + (delta * accel);
		} else {
			xspeedm = 1;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xspeedp = xspeedp + (delta * accel);
		} else {
			xspeedp = 1;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			yspeedp = yspeedp + (delta * accel);
		} else {
			yspeedp = 1;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			yspeedm = yspeedm + (delta * accel);
		} else {
			yspeedm = 1;
		}
		if (xspeedm > 2) {
			xspeedm = 2;
		}
		if (xspeedp > 2) {
			xspeedp = 2;
		}
		if (yspeedp > 2) {
			yspeedp = 2;
		}
		if (yspeedm > 2) {
			yspeedm = 2;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			yPos = yPos - 1 * yspeedm;
			playerTexture = 0;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			yPos = yPos + 1 * yspeedp;
			playerTexture = 3;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xPos = xPos - 1 * xspeedm;
			playerTexture = 1;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xPos = xPos + 1 * xspeedp;
			playerTexture = 2;
		}
		if (xPos > 1120 - PLAYER_WIDTH/2) {
			xPos = 1120 - PLAYER_WIDTH/2;
		}
		if (xPos < 150 + PLAYER_WIDTH/2) {
			xPos = 150 + PLAYER_WIDTH/2;
		}
		if (yPos > 720 - PLAYER_HEIGHT/2) {
			yPos = 720;
		}
		if (yPos < 0 + PLAYER_HEIGHT/2) {
			yPos = 0 + PLAYER_HEIGHT/2;
		}
	}

	public void draw(float delta) {
		hvlDraw(hvlQuadc(xPos, yPos, PLAYER_WIDTH, PLAYER_HEIGHT), hvlTexture(playerTexture));
	}

	public float getxPos() {
		return xPos;
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

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	

}
