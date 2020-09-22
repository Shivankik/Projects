package domains;

import java.util.List;

import service.CostType;

public class PromotionDetails {
	List<PromotionalItem> promotionalItems;
	CostType costType;
	public List<PromotionalItem> getPromotionalItems() {
		return promotionalItems;
	}
	public void setPromotionalItems(List<PromotionalItem> promotionalItems) {
		this.promotionalItems = promotionalItems;
	}
	public CostType getCostType() {
		return costType;
	}
	public void setCostType(CostType costType) {
		this.costType = costType;
	}
	

}
