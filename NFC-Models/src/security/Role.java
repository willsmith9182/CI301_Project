package security;

import java.util.ArrayList;

public class Role {
	private final int _roleId;
	private final String _roleDesc;
	private final ArrayList<DoorGroup> _doorGroups;

	public Role(int roleId, String roleDesc, ArrayList<DoorGroup> doorGroups){
		_doorGroups = doorGroups;
		_roleId=roleId;
		_roleDesc = roleDesc;
	}
	
		
	public ArrayList<DoorGroup> getDoorGroups() {
		return _doorGroups;
	}


	public String get_roleDesc() {
		return _roleDesc;
	}


	public int get_roleId() {
		return _roleId;
	}
}
