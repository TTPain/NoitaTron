package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlLine;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.HvlCoord;
import com.osreboot.ridhvl2.loader.HvlLoader;
import com.osreboot.ridhvl2.loader.HvlLoaderTexture;

import robotron2.terrain.Block;
import robotron2.terrain.TerrainGeneration;
import robotron2.util.Utility;

public class Player {

	public Player(float xArg, float yArg, boolean aliveArg) {

		xPos = xArg;
		yPos = yArg;
		alive = aliveArg;


	}

	public static final float PLAYER_START_X = 1920/2;
	public static final float PLAYER_START_Y = 1080/2;
	public static final float PLAYER_WIDTH = 22;
	public static final float PLAYER_HEIGHT = 25;
	public static final float ACCELERATION = 500;
	public static final float PIXELWALK_BUFFER = 3;
	public static float MAX_SPEED = 250;

	// Make sure to make his starting position coincide with level entry in future
	private float xPos = 1920/2;
	private float yPos = 1080/2;
	private float newyPos;
	private float newxPos;
	private boolean alive = true;

	private float xspeedm = 0;
	private float yspeedm = 0;
	private float xspeedp = 0;
	private float yspeedp = 0;

	private float xSpeed = 0;
	private float ySpeed = 0;

	private int playerTexture = 0;
	private float respawn = 1;

	private HvlCoord playerPos = new HvlCoord(0, 0);

	public void reset() {
		xPos = Block.BLOCK_SIZE;
		yPos = Block.BLOCK_SIZE;
		alive = true;

		xspeedm = 0;
		yspeedm = 0;
		xspeedp = 0;
		yspeedp = 0;
		playerTexture = 0;
		respawn = 1;
	}

	public void update(float delta) {

System.out.println(xPos);
System.out.println(yPos);

		playerPos.x = xPos;
		playerPos.y = yPos;



		//Draw Player
		if(Game.player.isAlive()==true && Score.lives>=0){
			Game.player.draw(delta);
		}

		//Death Handling
		if(alive==false) {
			xPos=Block.BLOCK_SIZE;
			yPos=Block.BLOCK_SIZE;	
			respawn = respawn - delta*2f;
		}
		if(respawn<0) {
			respawn=1;
			alive=true;
			Score.lives --; 
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			MAX_SPEED = 750;
		}else {MAX_SPEED = 250;

		}


		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xspeedm = xspeedm + (delta * ACCELERATION);
		} else {
			xspeedm = 0;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xspeedp = xspeedp + (delta * ACCELERATION);
		} else {
			xspeedp = 0;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			yspeedp = yspeedp + (delta * ACCELERATION);
		} else {
			yspeedp = 0;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			yspeedm = yspeedm + (delta * ACCELERATION);
		} else {
			yspeedm = 0;
		}
		if (xspeedm > MAX_SPEED) {
			xspeedm = MAX_SPEED;
		}
		if (xspeedp > MAX_SPEED) {
			xspeedp = MAX_SPEED;
		}
		if (yspeedp > MAX_SPEED) {
			yspeedp = MAX_SPEED;
		}
		if (yspeedm > MAX_SPEED) {
			yspeedm = MAX_SPEED;
		}
		xSpeed = xspeedp - xspeedm;
		ySpeed = yspeedp - yspeedm;

		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			playerTexture = 0;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			playerTexture = 3;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			playerTexture = 1;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			playerTexture = 2;
		}
		/*

		if (xPos > 1920-160 - PLAYER_WIDTH/2) {
			xPos = 1920-160 - PLAYER_WIDTH/2;
		}
		if (xPos < 160 + PLAYER_WIDTH/2) {
			xPos = 160 + PLAYER_WIDTH/2;
		}
		if (yPos > 1080 - PLAYER_HEIGHT/2) {
			yPos = 1080 - PLAYER_HEIGHT/2;
		}
		if (yPos < 0 + PLAYER_HEIGHT/2) {
			yPos = 0 + PLAYER_HEIGHT/2;
		}*/

		//Represents the player's position on the next frame.
		newyPos = yPos + (delta * ySpeed);
		newxPos = xPos + (delta * xSpeed);

		checkForBlockCollision(delta);

		xPos = newxPos;
		yPos = newyPos;
	}

	public void draw(float delta) {
		Utility.getCurrentTile(xPos, yPos);
		PlayerAimIndicator.draw(Game.player);
		hvlDraw(hvlQuadc(xPos, yPos, PLAYER_WIDTH, PLAYER_HEIGHT), hvlTexture(playerTexture));
	}

	public void checkForBlockCollision(float delta) {
		for(Block b : TerrainGeneration.blocks) {

								//Devmode Lines
			if(Game.devMode) {
				//hvlDraw(hvlLine(new HvlCoord(b.getxPos() - (Block.BLOCK_SIZE/2), b.getyPos() - (Block.BLOCK_SIZE/2)), new HvlCoord(b.getxPos() + (Block.BLOCK_SIZE/2), b.getyPos() - (Block.BLOCK_SIZE/2)), 3), Color.orange);
				//hvlDraw(hvlLine(new HvlCoord(b.getxPos() - (Block.BLOCK_SIZE/2), b.getyPos() - (Block.BLOCK_SIZE/2)), new HvlCoord(b.getxPos() - (Block.BLOCK_SIZE/2), b.getyPos() + (Block.BLOCK_SIZE/2)), 3), Color.orange);
				hvlDraw(hvlLine(new HvlCoord(b.getxPos() + (Block.BLOCK_SIZE/2), b.getyPos() + (Block.BLOCK_SIZE/2)), new HvlCoord(b.getxPos() - (Block.BLOCK_SIZE/2), b.getyPos() + (Block.BLOCK_SIZE/2)), 3), Color.orange);
				hvlDraw(hvlLine(new HvlCoord(b.getxPos() + (Block.BLOCK_SIZE/2), b.getyPos() + (Block.BLOCK_SIZE/2)), new HvlCoord(b.getxPos() + (Block.BLOCK_SIZE/2), b.getyPos() - (Block.BLOCK_SIZE/2)), 3), Color.orange);
			}

			if(b.getCollidable()) {

				//Determining which side of the block the player is currently on.
				boolean plLeft  = (xPos <= b.getxPos() - (Block.BLOCK_SIZE/2) - ((Player.PLAYER_WIDTH/2) - PIXELWALK_BUFFER));
				boolean plRight = (xPos >= b.getxPos() + (Block.BLOCK_SIZE/2) + ((Player.PLAYER_WIDTH/2) - PIXELWALK_BUFFER));
				boolean plAbove = (yPos <= b.getyPos() - (Block.BLOCK_SIZE/2) - ((Player.PLAYER_HEIGHT/2) - PIXELWALK_BUFFER));
				boolean plBelow = (yPos >= b.getyPos() + (Block.BLOCK_SIZE/2) + ((Player.PLAYER_HEIGHT/2) - PIXELWALK_BUFFER));

				//Determining if a collision will occur on the next frame.
				if(newyPos >= b.getyPos() - (Block.BLOCK_SIZE/2) - Player.PLAYER_HEIGHT/2 && newyPos <= b.getyPos() + (Block.BLOCK_SIZE/2) + Player.PLAYER_HEIGHT/2 && 
						newxPos >= b.getxPos() - (Block.BLOCK_SIZE/2) - Player.PLAYER_WIDTH/2 && newxPos <= b.getxPos() + (Block.BLOCK_SIZE/2)+Player.PLAYER_WIDTH/2){

					if(plLeft && !plRight && !plAbove && !plBelow) { //Player is to the left
						if(xSpeed > 0) {
							xSpeed = 0;
						}
						newxPos = b.getxPos() - Block.BLOCK_SIZE/2 - Player.PLAYER_WIDTH/2;
					}
					else if(!plLeft && plRight && !plAbove && !plBelow) { //Player is to the right
						if(xSpeed < 0) {
							xSpeed = 0;
						}
						newxPos = b.getxPos() + Block.BLOCK_SIZE/2 + Player.PLAYER_WIDTH/2;
					}
					else if(!plLeft && !plRight && plAbove && !plBelow) { //Player is above
						if(ySpeed > 0) {
							ySpeed = 0;
						}
						newyPos = b.getyPos() - Block.BLOCK_SIZE/2 - Player.PLAYER_HEIGHT/2;
					}
					else if(!plLeft && !plRight && !plAbove && plBelow) { //Player is below
						if(ySpeed < 0) {
							ySpeed = 0;
						}
						newyPos = b.getyPos() + Block.BLOCK_SIZE/2 + Player.PLAYER_HEIGHT/2;
					}
				}				
			}
		}
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

	public HvlCoord getPlayerPos() {
		return playerPos;
	}

	public void setPlayerPos(HvlCoord playerPos) {
		this.playerPos = playerPos;
	}




}
