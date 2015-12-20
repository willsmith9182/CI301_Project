package security;

import java.util.ArrayList;

public class DoorGroup {

	private final int _doorGroupId;
	private final ArrayList<Door> _doors;
	
	public DoorGroup(int doorGroupId, ArrayList<Door> doors){
		_doorGroupId = doorGroupId;
		_doors = doors;
	}

	public int get_doorGroupId() {
		return _doorGroupId;
	}

	public ArrayList<Door> get_doors() {
		return _doors;
	}
}
