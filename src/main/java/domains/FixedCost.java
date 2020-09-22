package domains;

public class FixedCost implements CostType {
	private double cost;

	public FixedCost(double cost) {
		this.cost = cost;
	}


	public double getCost() {
		return cost;
	}

}
