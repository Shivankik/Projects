package factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domains.PromotionDetails;
import service.ComboPromotion;
import service.IndividualPromotion;
import service.Promotion;

public class PromotionFactory {
	Promotion comboPromotion;
	Promotion individualPromotion;
	List<Promotion> promotionList;

	public PromotionFactory() {
		promotionList= new ArrayList<Promotion>();
		comboPromotion = new ComboPromotion(new HashMap<Integer, PromotionDetails>());
		individualPromotion = new IndividualPromotion(new HashMap<Integer, PromotionDetails>());
		promotionList.add(comboPromotion);
		promotionList.add(individualPromotion);
	}

	public Promotion getPromotionTye(String promotiontype) {
		if (promotiontype.equalsIgnoreCase("Combo")) {
			return comboPromotion;
		}
		if (promotiontype.equalsIgnoreCase("Individual")) {
			return individualPromotion;
		}
		return null;
	}
	
	public List<Promotion> getPromotionList() {
		return promotionList;
	}

}
