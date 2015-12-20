package security;

public class Door {
	private final int _doorId;
	private final String _doorDesc;
	
	public Door(int doorId, String doorDesc){
		_doorId = doorId;
		_doorDesc = doorDesc;		
	}

	public String get_doorDesc() {
		return _doorDesc;
	}

	public int get_doorId() {
		return _doorId;
	}
	
}
