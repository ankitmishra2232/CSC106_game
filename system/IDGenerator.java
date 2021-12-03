package system;

/**
 * This class is an ID Generator. It's unique 
 */
public class IDGenerator {
	private static IDGenerator generator = null;
	private int userID;
	private ID id;
	
	private IDGenerator(){
		id = new ID(1);
		this.userID = id.getID();
	}
	
	/**
	 * Create an unique instance of this class with the limit defined.
	 * returns a reference to the unique IDGenerator object.
	 */
	public static IDGenerator getInstance(){
		if(null == generator)
			generator = new IDGenerator();
		return generator;
	}
	
	/**
	 * Get an ID.
	 * return an ID.
	 */
	public Integer getAnID(){
		return userID++;
	}
}
