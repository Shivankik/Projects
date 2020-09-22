package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domains.CostType;
import domains.PromotionDetails;
import domains.PromotionalItem;

public class ComboPromotion implements Promotion {
	HashMap<Integer, PromotionDetails> comboPromotions;
	static int noOfPromotions;

	public ComboPromotion(HashMap<Integer, PromotionDetails> individualPromotions) {
		this.comboPromotions = individualPromotions;
	}

	
	public void addPromotion(List<PromotionalItem> promotionalItems, CostType cost) {
		PromotionDetails details = new PromotionDetails();
		details.setCostType(cost);
		details.setPromotionalItems(promotionalItems);
		noOfPromotions++;
		comboPromotions.put(noOfPromotions, details);
	}

	
	public Integer findPromotionId(List<PromotionalItem> inputPromotionitems) {
		for (Map.Entry<Integer, PromotionDetails> entry : comboPromotions.entrySet()) {
			PromotionDetails details = entry.getValue();
			List<PromotionalItem> foundList = new ArrayList<PromotionalItem>();
			List<PromotionalItem> promotionItems = details.getPromotionalItems();
			for (PromotionalItem inputPromotionItem : inputPromotionitems) {
				for (PromotionalItem promotionItem : promotionItems) {
					if (inputPromotionItem.getId().equals(promotionItem.getId())
							&& inputPromotionItem.getUnits() >= promotionItem.getUnits()) {
						PromotionalItem foundPromotion = promotionItem;
						foundList.add(foundPromotion);
					}
				}
			}
			if (foundList.size() == details.getPromotionalItems().size()) {
				System.out.println("Applying ComboPromotion for following items");
				details.getPromotionalItems().stream().forEach(promotionalItem->System.out.println(promotionalItem.getUnits()+":"+promotionalItem.getId()));;
				this.updateRemaingItems(inputPromotionitems, details.getPromotionalItems());
				return entry.getKey();
			}
		}
		return null;

	}

	private void updateRemaingItems(List<PromotionalItem> inputPromotionitems, List<PromotionalItem> promotionalItems) {
		for (PromotionalItem inputPromotionItem : inputPromotionitems) {
			for (PromotionalItem promotionItem : promotionalItems) {
				if (inputPromotionItem.getId().equals(promotionItem.getId())) {
					inputPromotionItem.setUnits(inputPromotionItem.getUnits() - promotionItem.getUnits());
				}
			}

		}

	}

	
	public Double getCost(int promotionId) {
		Double cost=comboPromotions.get(promotionId).getCostType().getCost();
		System.out.println("Applying cost: "+cost);
		return cost;

	}

	
	public HashMap<Integer, PromotionDetails> getAllPromotions() {
		return comboPromotions;
	}

}
