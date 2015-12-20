package security.full.builder;

import java.util.UUID;

import security.Key;

public class KeyBuilder {

	private int _keyId;
	private UUID _keyToken;
	
	private KeyBuilder()
	{
		_keyId = -1;
		_keyToken = null;
	}
	
	public static KeyBuilder New(){
		return new KeyBuilder();
	}
	
	public Key Make(){
		return new Key(_keyId,_keyToken);
	}
	
	public KeyBuilder WithId(int keyId){
		_keyId = keyId;
		return this;
	}
	
	public KeyBuilder WithToken(UUID token){
		_keyToken = token;
		return this;
	}	
}
