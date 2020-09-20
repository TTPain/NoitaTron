package robotron2.terrain;

public class Block {

	public static final float BLOCK_SIZE = 100;

	private float xPos;
	private float yPos;
	private boolean collidable;

	public Block(float xArg, float yArg, boolean isCollidable) {

		xPos = xArg;
		yPos = yArg;
		collidable = isCollidable;

	}
	
}
/*
 * Levels are room based with randomly placed obstacles
 * After completing a room the player is given a choice of new rooms
 * Player has a general idea of what the next room contains/how difficult it is
 * Harder rooms give more rewards, shops and upgrades are semi-random
 * All paths converge to a final room(?)
 * Map system similar to slay the spire
 */
