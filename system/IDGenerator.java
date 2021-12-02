package system;

public class IDGenerator {
	private static IDGenerator generator = null;
	private int userID;
	
	private IDGenerator(){
		this.userID = 1;
	}
	
	public static IDGenerator getInstance(){
		if(null == generator)
			generator = new IDGenerator();
		return generator;
	}
	
	
	public ID getAnID(){
		ID id = new ID (this.userID);
		this.userID++;
		return id; 
	}

}
