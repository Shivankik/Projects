package domains;

public class PercentageCost implements CostType {
	private FixedCost cost;
	private int percentage;

	public PercentageCost(FixedCost cost, int percentage) {
		this.cost = cost;
		this.percentage = percentage;
	}

	
	public double getCost() {
		return cost.getCost() * (double) (percentage / 100.0);
	}

}
