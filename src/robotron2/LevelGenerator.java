package robotron2;

import java.util.ArrayList;

import com.osreboot.ridhvl2.menu.HvlMenu;

import robotron2.menu.MenuManager;


public class LevelGenerator {
	
	public static ArrayList<Room> roomList = new ArrayList<>();
	public static Room currentRoom;
	
	public static void initialize() {
	
		//currentRoom = new Room(-1, 0, false, false, false);
		
	}

	
	public static void reset() {
		roomList.clear();
		if ((Game.selected_level == 1)) {
			// Level, Contents, Visited, Cleared, Completed
			roomList.add(new Room(0, 0, false, false, false));
			roomList.add(new Room(1, 0, false, false, false));
			roomList.add(new Room(2, 0, false, false, false));
			roomList.add(new Room(2, 0, false, false, false));
			roomList.add(new Room(3, 0, false, false, false));
			roomList.add(new Room(3, 0, false, false, false));
			roomList.add(new Room(3, 0, false, false, false));
			roomList.add(new Room(3, 0, false, false, false));
		}
	}
	
	public static void update(float delta) {
		
		for(Room r : roomList) {
			if(HvlMenu.top() == MenuManager.game && (r.getRoomLevel() == 0 && r.getRoomCompleted() == false)) {
				r.setRoomVisited(true);
				currentRoom = r;
			}
			
		}
		
		//System.out.println(currentRoom.getRoomLevel());
		
	}

}
