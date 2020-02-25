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
	
	public Player(float xArg, float yArg){

		xPos = xArg;
		yPos = yArg;

	}
	public static final float PLAYER_START_X = 1280/2;
	public static final float PLAYER_START_Y = 720/2;
	
	public static final float PLAYER_WIDTH = 25;
	public static final float PLAYER_HEIGHT = 50;
	private float xPos = 1280/2;
	private float yPos = 720 / 2;
	private float xspeedm = 1;
			
	private float yspeedm = 1;
	private float xspeedp = 1;
	private float yspeedp = 1;
	private float accel = 5;
	private int playerTexture = 0;


	public void update(float delta) {
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xspeedm = xspeedm + delta*accel;
		} else {
			xspeedm = 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xspeedp = xspeedp + delta*accel;
		} else {
			xspeedp = 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			yspeedp = yspeedp + delta*accel;
		} else {
			yspeedp = 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			yspeedm = yspeedm + delta*accel;
		} else {
			yspeedm = 1;
		}
		if( xspeedm > 3){
			xspeedm = 3;
			}
		if(xspeedp > 3) {
			xspeedp = 3;
		}
		if(yspeedp > 3) {
			yspeedp = 3;
		}
		if(yspeedm > 3) {
			yspeedm = 3;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			yPos = yPos - 1*yspeedm;
			playerTexture = 0;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			yPos = yPos + 1*yspeedp;
			playerTexture = 3;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xPos = xPos - 1*xspeedm;
			playerTexture = 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xPos = xPos + 1*xspeedp;
			playerTexture = 2;
		}
		if(xPos > 1270) {
			xPos = 1270;} 
		if(xPos < 10) {
			xPos =10;}
		if(yPos > 710) {
			yPos = 710;}
		if(yPos < 10) {
			yPos = 10;}
	}
	
	public void draw(float delta){
		
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






		
}
