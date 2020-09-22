package service;

import java.util.HashMap;
import java.util.List;

import domains.CostType;
import domains.PromotionDetails;
import domains.PromotionalItem;



public interface Promotion {
	
	public void addPromotion(List<PromotionalItem> promotionalItems, CostType cost);
	public Integer findPromotionId(List<PromotionalItem> promotionitems);
	public Double getCost(int promotionId);
	public HashMap<Integer, PromotionDetails> getAllPromotions();

	

}
