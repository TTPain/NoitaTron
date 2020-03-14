package robotron2;

public class Room {
	
	private boolean roomVisited;
	private boolean roomCleared;
	private boolean roomCompleted;
	private int roomLevel;
	private int roomContents;
	
	public Room( int roomLevelArg, int roomContentsArg, boolean roomVisitedArg, boolean roomClearedArg, boolean roomCompletedArg) {
		
		roomVisited = roomVisitedArg;
		roomContents = roomContentsArg;
		roomCleared = roomClearedArg;
		roomLevel = roomLevelArg;
		roomCompleted = roomCompletedArg;	
		
	}



	public int getRoomLevel() {
		return roomLevel;
	}

	public void setRoomLevel(int roomLevel) {
		this.roomLevel = roomLevel;
	}

	public int getRoomContents() {
		return roomContents;
	}

	public void setRoomContents(int roomContents) {
		this.roomContents = roomContents;
	}

	public boolean getRoomCleared() {
		return roomCleared;
	}

	public void setRoomCleared(boolean roomCleared) {
		this.roomCleared = roomCleared;
	}


	public boolean getRoomVisited() {
		return roomVisited;
	}


	public void setRoomVisited(boolean roomVisited) {
		this.roomVisited = roomVisited;
	}


	public boolean getRoomCompleted() {
		return roomCompleted;
	}


	public void setRoomCompleted(boolean roomCompleted) {
		this.roomCompleted = roomCompleted;
	}
	
	

}
