package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domains.CostType;
import domains.FixedCost;
import domains.PercentageCost;
import domains.PromotionDetails;
import domains.PromotionalItem;

public class IndividualPromotion implements Promotion {
	HashMap<Integer, PromotionDetails> individualPromotions = new HashMap<Integer, PromotionDetails>();
	static int noOfPromotions;

	public IndividualPromotion(HashMap<Integer, PromotionDetails> comboPromotions) {
		this.individualPromotions = comboPromotions;
	}

	public void addPromotion(List<PromotionalItem> promotionalItems, CostType cost) {
		PromotionDetails details = new PromotionDetails();
		details.setCostType(cost);
		details.setPromotionalItems(promotionalItems);
		noOfPromotions++;
		individualPromotions.put(noOfPromotions, details);
	}

	public Integer findPromotionId(List<PromotionalItem> inputPromotionitems) {
		for (PromotionalItem inputPromotionItem : inputPromotionitems) {
			int tempPromotionalUnits = 0;
			PromotionalItem appliedPromotion = null;
			Integer promotionId = null;
			for (Map.Entry<Integer, PromotionDetails> entry : individualPromotions.entrySet()) {
				PromotionDetails details = entry.getValue();
				PromotionalItem promotionItem = details.getPromotionalItems().get(0);
				if (inputPromotionItem.getId().equals(promotionItem.getId())
						&& inputPromotionItem.getUnits() >= promotionItem.getUnits()
						&& tempPromotionalUnits < promotionItem.getUnits()) {
					appliedPromotion = promotionItem;
					tempPromotionalUnits = promotionItem.getUnits();
					promotionId = entry.getKey();
				}
			}
			if (appliedPromotion != null) {
				System.out.println("Applying Individual promotional for following items");
				System.out.println(appliedPromotion.getUnits()+":"+appliedPromotion.getId());;
				
				this.updateRemaingItems(inputPromotionitems, appliedPromotion);
				return promotionId;
			}

		}
		return null;
	}

	private void updateRemaingItems(List<PromotionalItem> inputPromotionitems, PromotionalItem promotionalItem) {
		for (PromotionalItem inputPromotionItem : inputPromotionitems) {
			if (inputPromotionItem.getId().equals(promotionalItem.getId())) {
				inputPromotionItem.setUnits(inputPromotionItem.getUnits() - promotionalItem.getUnits());
			}
		}

	}

	public Double getCost(int promotionId) {
		CostType costType = individualPromotions.get(promotionId).getCostType();
		if (costType instanceof FixedCost) {
			Double cost=individualPromotions.get(promotionId).getCostType().getCost();
			System.out.println("Applying Fixed cost: "+cost);
			return cost;
		}
		if (costType instanceof PercentageCost) {
			Double cost= individualPromotions.get(promotionId).getPromotionalItems().get(0).getUnits()
					* individualPromotions.get(promotionId).getCostType().getCost();
			System.out.println("Applying Percentage cost: "+cost);
			return cost;
		}
		return null;

	}

	public HashMap<Integer, PromotionDetails> getAllPromotions() {
		return individualPromotions;
	}

}
