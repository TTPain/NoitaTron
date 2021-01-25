package robotron2.terrain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LevelLoader {

	public static ArrayList<Block> blocks = new ArrayList<Block>();

	static File f;
	static FileReader r;
	static BufferedReader reader;

	static int xPos = 0;
	static int yPos = 0;
	static int blockNum = 0;


	public static void load() {
		f = new File("res/levels/FloorPlan.txt");
		try {
			r = new FileReader(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		reader = new BufferedReader(r);

		String line;

		try {
			while ((line = reader.readLine()) != null) {
				// process the line.

				xPos = 0;
				for (int k = 0; k < line.length(); k++){
					char c = line.charAt(k);   
					xPos+= Block.BLOCK_SIZE;					
						if(c == '0') {
							blocks.add(new Block(xPos, yPos, false));
							blockNum++;
						}else /*Everything that's not open air*/ {
							blocks.add(new Block(xPos, yPos, true));
							blockNum++;
						}
					}
				yPos += Block.BLOCK_SIZE;
				}			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * We can write the names of levels based on their categories. For example, Level1, Level 2, Level 3, etc..
	 * Special levels can be named in the same way so long as the first half of the name is consistent
	 * whenever we access a level, we simply have a rng call a value and then search for Level + 'Value' that can allow for random selection of level layouts
	 * set that to a value named 'level selected' then the file reader will call that level based on the value it chose.
	 * whenever we want it to go to a special level we can have the file reader swap to Special_Level + 'Value' still allowing the rng to select its design.
	 * if we want to incorporate Boss Levels, or floors that occur a set number of levels all we would have to do is set an exception for when our Game's 
	 * Level is Mod% some number. Current Level will increment each time a door is entered or an exit is taken. If we still want some form of consistency,
	 * we can divide the numbers of levels by 20 like we were saying for the 5 different directions that we can enter and exit from. and have the rng only 
	 * select from certain ranges based upon which exit was taken. Boss levels could also have randomized layouts, AND whatever number is chosen can also 
	 * correlate to which boss is selected through either Mod% some number or directly creating an equal number of bosses as boss level types.
	 * 
	 * 
	 * 
	 */


}
