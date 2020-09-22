package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domains.CostType;
import domains.FixedCost;
import domains.IndividualItemCost;
import domains.PromotionalItem;
import factory.PromotionFactory;
import service.Promotion;

public class PromotionBuilder {
	private PromotionFactory factory;
	private List<Promotion> promotionList;
	private Map<String, FixedCost> individualItemCostMap;

	public PromotionBuilder() {
		factory = new PromotionFactory();
		promotionList = new ArrayList<Promotion>();
		this.individualItemCostMap = new HashMap();
	}

	public void addIndividualItemCost(IndividualItemCost individualItemCost) {
		individualItemCostMap.put(individualItemCost.getId(), individualItemCost.getCost());
	}

	public void addPromotions(String promotionType, List<PromotionalItem> promotionalItems, CostType c) {
		Promotion p = factory.getPromotionTye(promotionType);
		if (p != null) {
			p.addPromotion(promotionalItems, c);
		}
		promotionList.add(p);
	}

	public List<Promotion> getPromotionList() {
		return factory.getPromotionList();
	}

	public Map<String, FixedCost> getIndividualItemCost() {
		return individualItemCostMap;
	}
}
