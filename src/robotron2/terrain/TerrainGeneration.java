package robotron2.terrain;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlLine;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.HvlCoord;
import com.osreboot.ridhvl2.HvlMath;
import com.osreboot.ridhvl2.menu.HvlMenu;

import robotron2.Game;
import robotron2.menu.MenuManager;

public class TerrainGeneration {

	public static ArrayList<Block> blocks = new ArrayList<Block>();
	
	public static Block sampleBlock = new Block(1920/2, 1080/2, true);
	
	public static void initialize() {
		blocks.add(sampleBlock);
	}
	
	public static void update() {
		if(HvlMenu.top() == MenuManager.game) {
			for(int i = 0; i < blocks.size(); i++) {
				hvlDraw(hvlQuadc(blocks.get(i).getxPos(), blocks.get(i).getyPos(), Block.BLOCK_SIZE, Block.BLOCK_SIZE), Color.blue);
				//DEV LINES
				if(Game.devMode) {
				hvlDraw(hvlLine(new HvlCoord(blocks.get(i).getxPos() - (Block.BLOCK_SIZE/2), blocks.get(i).getyPos() - (Block.BLOCK_SIZE/2)), new HvlCoord(blocks.get(i).getxPos() + (Block.BLOCK_SIZE/2), blocks.get(i).getyPos() + (Block.BLOCK_SIZE/2)), 3), Color.orange);
				hvlDraw(hvlLine(new HvlCoord(blocks.get(i).getxPos() - (Block.BLOCK_SIZE/2), blocks.get(i).getyPos() + (Block.BLOCK_SIZE/2)), new HvlCoord(blocks.get(i).getxPos() + (Block.BLOCK_SIZE/2), blocks.get(i).getyPos() - (Block.BLOCK_SIZE/2)), 3), Color.orange);
				}
				//////////
			}
		}
		

	}
	
}
