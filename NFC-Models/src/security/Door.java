package security;

import java.util.UUID;

public class Door {
	private final int _doorId;
	private final String _doorDesc;
	private final UUID _doorToken;
	
	public Door(int doorId, String doorDesc, UUID doorToken){
		_doorId = doorId;
		_doorDesc = doorDesc;
		_doorToken = doorToken;
	}

	public String get_doorDesc() {
		return _doorDesc;
	}

	public int get_doorId() {
		return _doorId;
	}

	public UUID get_doorToken() {
		return _doorToken;
	}
	
}
