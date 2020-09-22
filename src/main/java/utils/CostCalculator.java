package utils;

import java.util.List;
import java.util.Map;

import domains.FixedCost;
import domains.PromotionalItem;
import service.Promotion;

public class CostCalculator {
	public CostCalculator() {

	}

	public double findTotalCost(Map<String, FixedCost> individualItemCostMap, List<PromotionalItem> inputPromotionitems,
			List<Promotion> promotions) {
		double totalCost = 0.0;
		for (Promotion promotionType : promotions) {
			totalCost =  this.findPromotionCost(totalCost, promotionType, inputPromotionitems);

		}
		for (PromotionalItem item : inputPromotionitems) {
			if (item.getUnits() > 0) {
				System.out.println("Applying individual cost to units and item: "+item.getUnits()+":"+item.getId());
				double cost= (item.getUnits() * individualItemCostMap.get(item.getId()).getCost());
				System.out.println("Applying cost: "+cost); 
				totalCost = totalCost + cost;
			}
		}
		System.out.println("total cost: "+totalCost); 
		return totalCost;
	}

	private double findPromotionCost(double totalCost, Promotion promotion, List<PromotionalItem> inputPromotionitems) {
		Integer comboPromotionId = null;

		do {
			comboPromotionId = promotion.findPromotionId(inputPromotionitems);
			if (comboPromotionId != null) {
				Double promotionCost = promotion.getCost(comboPromotionId);
				if (promotionCost != null)
					totalCost = totalCost + promotionCost;
			}

		} while (comboPromotionId != null);
		return totalCost;
	}

}
