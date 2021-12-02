package system;
/*
  This class represents ID. 
  it can't be modified and it is fixed by constructor 
 */
public class ID {
    private Integer id;
	
	public ID(Integer ID){
		this.id = ID;
	}
	
	public Integer getID(){
		return this.id; 
	}
}
