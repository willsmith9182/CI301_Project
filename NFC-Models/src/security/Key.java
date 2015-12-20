package security;

import java.util.UUID;

public class Key {
	private final int _keyId;
	private final UUID _keyTokenValue;
	
	public Key(int keyId, UUID keyToken){
		_keyId=keyId;
		_keyTokenValue = keyToken;
				
	}

	public UUID get_keyTokenValue() {
		return _keyTokenValue;
	}

	public int get_keyId() {
		return _keyId;
	}
	
}
