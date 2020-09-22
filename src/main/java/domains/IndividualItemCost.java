package domains;


public class IndividualItemCost {
	private String id;
	private FixedCost cost;
	public IndividualItemCost(String id, FixedCost cost) {
		this.id=id;
		this.cost=cost;
				
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public FixedCost getCost() {
		return cost;
	}
	public void setCost(FixedCost cost) {
		this.cost = cost;
	}
	
}
