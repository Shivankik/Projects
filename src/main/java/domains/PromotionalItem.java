package domains;

public class PromotionalItem {
	private String id;
	private int units;
	
	public PromotionalItem(String id, int units){
		this.id=id;
		this.units=units;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}

	

}
