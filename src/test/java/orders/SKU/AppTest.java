package orders.SKU;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domains.FixedCost;
import domains.IndividualItemCost;
import domains.PercentageCost;
import domains.PromotionalItem;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import service.Promotion;
import utils.CostCalculator;
import utils.PromotionBuilder;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	public void testApp_percentageCost() {
		PromotionBuilder builder = new PromotionBuilder();
		IndividualItemCost c1 = new IndividualItemCost("A", new FixedCost(2.0));
		IndividualItemCost c2 = new IndividualItemCost("B", new FixedCost(3.0));
		IndividualItemCost c3 = new IndividualItemCost("C", new FixedCost(5.0));
		builder.addIndividualItemCost(c1);
		builder.addIndividualItemCost(c2);
		builder.addIndividualItemCost(c3);

		List<PromotionalItem> individualpromotionalItemsA = new ArrayList<PromotionalItem>();
		PromotionalItem item = new PromotionalItem("A", 3);
		individualpromotionalItemsA.add(item);
		builder.addPromotions("Individual", individualpromotionalItemsA, new FixedCost(5));

		List<PromotionalItem> individualpromotionalItemsA2 = new ArrayList<PromotionalItem>();
		PromotionalItem itemA2 = new PromotionalItem("A", 4);
		individualpromotionalItemsA2.add(itemA2);
		builder.addPromotions("Individual", individualpromotionalItemsA2, new PercentageCost(new FixedCost(2.0), 50));

		List<PromotionalItem> individualpromotionalItemsB = new ArrayList<PromotionalItem>();
		PromotionalItem itemB = new PromotionalItem("B", 2);
		individualpromotionalItemsB.add(itemB);
		builder.addPromotions("Individual", individualpromotionalItemsB, new FixedCost(5));

		List<PromotionalItem> individualpromotionalItemsC = new ArrayList<PromotionalItem>();
		PromotionalItem itemC = new PromotionalItem("C", 2);
		individualpromotionalItemsC.add(itemC);
		builder.addPromotions("Individual", individualpromotionalItemsC, new FixedCost(7));

		List<PromotionalItem> combopromotionalItemsBC = new ArrayList<PromotionalItem>();
		PromotionalItem comboItemB = new PromotionalItem("B", 1);
		combopromotionalItemsBC.add(comboItemB);
		PromotionalItem comboItemc = new PromotionalItem("C", 2);
		combopromotionalItemsBC.add(comboItemc);
		builder.addPromotions("Combo", combopromotionalItemsBC, new FixedCost(10));

		List<Promotion> list = builder.getPromotionList();
		Map<String, FixedCost> map = builder.getIndividualItemCost();

		List<PromotionalItem> inputPromotionitems = new ArrayList<PromotionalItem>();
		PromotionalItem a1 = new PromotionalItem("A", 7);
		PromotionalItem a2 = new PromotionalItem("B", 3);
		PromotionalItem a3 = new PromotionalItem("C", 4);
		inputPromotionitems.add(a1);
		inputPromotionitems.add(a2);
		inputPromotionitems.add(a3);
		CostCalculator calculator = new CostCalculator();
		assertEquals(32.0, calculator.findTotalCost(map, inputPromotionitems, list));
	}

	public void testApp_fixedCost() {
		PromotionBuilder builder = new PromotionBuilder();
		IndividualItemCost c1 = new IndividualItemCost("A", new FixedCost(2.0));
		IndividualItemCost c2 = new IndividualItemCost("B", new FixedCost(3.0));
		IndividualItemCost c3 = new IndividualItemCost("C", new FixedCost(5.0));
		builder.addIndividualItemCost(c1);
		builder.addIndividualItemCost(c2);
		builder.addIndividualItemCost(c3);

		List<PromotionalItem> individualpromotionalItemsA = new ArrayList<PromotionalItem>();
		PromotionalItem item = new PromotionalItem("A", 3);
		individualpromotionalItemsA.add(item);
		builder.addPromotions("Individual", individualpromotionalItemsA, new FixedCost(5));

		List<PromotionalItem> individualpromotionalItemsB = new ArrayList<PromotionalItem>();
		PromotionalItem itemB = new PromotionalItem("B", 2);
		individualpromotionalItemsB.add(itemB);
		builder.addPromotions("Individual", individualpromotionalItemsB, new FixedCost(5));

		List<PromotionalItem> individualpromotionalItemsC = new ArrayList<PromotionalItem>();
		PromotionalItem itemC = new PromotionalItem("C", 2);
		individualpromotionalItemsC.add(itemC);
		builder.addPromotions("Individual", individualpromotionalItemsC, new FixedCost(7));

		List<PromotionalItem> combopromotionalItemsBC = new ArrayList<PromotionalItem>();
		PromotionalItem comboItemB = new PromotionalItem("B", 1);
		combopromotionalItemsBC.add(comboItemB);
		PromotionalItem comboItemc = new PromotionalItem("C", 2);
		combopromotionalItemsBC.add(comboItemc);
		builder.addPromotions("Combo", combopromotionalItemsBC, new FixedCost(10));

		List<Promotion> list = builder.getPromotionList();
		Map<String, FixedCost> map = builder.getIndividualItemCost();

		List<PromotionalItem> inputPromotionitems = new ArrayList<PromotionalItem>();
		PromotionalItem a1 = new PromotionalItem("A", 6);
		PromotionalItem a2 = new PromotionalItem("B", 3);
		PromotionalItem a3 = new PromotionalItem("C", 4);
		inputPromotionitems.add(a1);
		inputPromotionitems.add(a2);
		inputPromotionitems.add(a3);
		CostCalculator calculator = new CostCalculator();
		assertEquals(33.0, calculator.findTotalCost(map, inputPromotionitems, list));
	}
	
	public void testApp_noPromotionApplied() {
		PromotionBuilder builder = new PromotionBuilder();
		IndividualItemCost c1 = new IndividualItemCost("A", new FixedCost(2.0));
		IndividualItemCost c2 = new IndividualItemCost("B", new FixedCost(3.0));
		IndividualItemCost c3 = new IndividualItemCost("C", new FixedCost(5.0));
		builder.addIndividualItemCost(c1);
		builder.addIndividualItemCost(c2);
		builder.addIndividualItemCost(c3);

		List<PromotionalItem> individualpromotionalItemsA = new ArrayList<PromotionalItem>();
		PromotionalItem item = new PromotionalItem("A", 3);
		individualpromotionalItemsA.add(item);
		builder.addPromotions("Individual", individualpromotionalItemsA, new FixedCost(5));

		List<PromotionalItem> individualpromotionalItemsB = new ArrayList<PromotionalItem>();
		PromotionalItem itemB = new PromotionalItem("B", 2);
		individualpromotionalItemsB.add(itemB);
		builder.addPromotions("Individual", individualpromotionalItemsB, new FixedCost(5));

		List<PromotionalItem> individualpromotionalItemsC = new ArrayList<PromotionalItem>();
		PromotionalItem itemC = new PromotionalItem("C", 2);
		individualpromotionalItemsC.add(itemC);
		builder.addPromotions("Individual", individualpromotionalItemsC, new FixedCost(7));

		List<PromotionalItem> combopromotionalItemsBC = new ArrayList<PromotionalItem>();
		PromotionalItem comboItemB = new PromotionalItem("B", 1);
		combopromotionalItemsBC.add(comboItemB);
		PromotionalItem comboItemc = new PromotionalItem("C", 2);
		combopromotionalItemsBC.add(comboItemc);
		builder.addPromotions("Combo", combopromotionalItemsBC, new FixedCost(10));

		List<Promotion> list = builder.getPromotionList();
		Map<String, FixedCost> map = builder.getIndividualItemCost();

		List<PromotionalItem> inputPromotionitems = new ArrayList<PromotionalItem>();
		PromotionalItem a1 = new PromotionalItem("A", 1);
		PromotionalItem a2 = new PromotionalItem("B", 1);
		PromotionalItem a3 = new PromotionalItem("C", 1);
		inputPromotionitems.add(a1);
		inputPromotionitems.add(a2);
		inputPromotionitems.add(a3);
		CostCalculator calculator = new CostCalculator();
		assertEquals(10.0, calculator.findTotalCost(map, inputPromotionitems, list));
	}
	
	public void testApp_onlyIndividualPromoApplied() {
		PromotionBuilder builder = new PromotionBuilder();
		IndividualItemCost c1 = new IndividualItemCost("A", new FixedCost(2.0));
		IndividualItemCost c2 = new IndividualItemCost("B", new FixedCost(3.0));
		IndividualItemCost c3 = new IndividualItemCost("C", new FixedCost(5.0));
		builder.addIndividualItemCost(c1);
		builder.addIndividualItemCost(c2);
		builder.addIndividualItemCost(c3);

		List<PromotionalItem> individualpromotionalItemsA = new ArrayList<PromotionalItem>();
		PromotionalItem item = new PromotionalItem("A", 4);
		individualpromotionalItemsA.add(item);
		builder.addPromotions("Individual", individualpromotionalItemsA, new FixedCost(5));

		List<PromotionalItem> individualpromotionalItemsB = new ArrayList<PromotionalItem>();
		PromotionalItem itemB = new PromotionalItem("B", 2);
		individualpromotionalItemsB.add(itemB);
		builder.addPromotions("Individual", individualpromotionalItemsB, new FixedCost(5));

		List<PromotionalItem> individualpromotionalItemsC = new ArrayList<PromotionalItem>();
		PromotionalItem itemC = new PromotionalItem("C", 2);
		individualpromotionalItemsC.add(itemC);
		builder.addPromotions("Individual", individualpromotionalItemsC, new FixedCost(7));

		List<PromotionalItem> combopromotionalItemsBC = new ArrayList<PromotionalItem>();
		PromotionalItem comboItemB = new PromotionalItem("B", 6);
		combopromotionalItemsBC.add(comboItemB);
		PromotionalItem comboItemc = new PromotionalItem("C", 2);
		combopromotionalItemsBC.add(comboItemc);
		builder.addPromotions("Combo", combopromotionalItemsBC, new FixedCost(10));

		List<Promotion> list = builder.getPromotionList();
		Map<String, FixedCost> map = builder.getIndividualItemCost();

		List<PromotionalItem> inputPromotionitems = new ArrayList<PromotionalItem>();
		PromotionalItem a1 = new PromotionalItem("A", 4);
		PromotionalItem a2 = new PromotionalItem("B", 2);
		PromotionalItem a3 = new PromotionalItem("C", 2);
		inputPromotionitems.add(a1);
		inputPromotionitems.add(a2);
		inputPromotionitems.add(a3);
		CostCalculator calculator = new CostCalculator();
		assertEquals(17.0, calculator.findTotalCost(map, inputPromotionitems, list));
	}
	
	public void testApp_onlyComboPromoApplied() {
		PromotionBuilder builder = new PromotionBuilder();
		IndividualItemCost c1 = new IndividualItemCost("A", new FixedCost(2.0));
		IndividualItemCost c2 = new IndividualItemCost("B", new FixedCost(3.0));
		IndividualItemCost c3 = new IndividualItemCost("C", new FixedCost(5.0));
		builder.addIndividualItemCost(c1);
		builder.addIndividualItemCost(c2);
		builder.addIndividualItemCost(c3);

		List<PromotionalItem> individualpromotionalItemsA = new ArrayList<PromotionalItem>();
		PromotionalItem item = new PromotionalItem("A", 4);
		individualpromotionalItemsA.add(item);
		builder.addPromotions("Individual", individualpromotionalItemsA, new FixedCost(5));

		List<PromotionalItem> individualpromotionalItemsB = new ArrayList<PromotionalItem>();
		PromotionalItem itemB = new PromotionalItem("B", 2);
		individualpromotionalItemsB.add(itemB);
		builder.addPromotions("Individual", individualpromotionalItemsB, new FixedCost(5));

		List<PromotionalItem> individualpromotionalItemsC = new ArrayList<PromotionalItem>();
		PromotionalItem itemC = new PromotionalItem("C", 2);
		individualpromotionalItemsC.add(itemC);
		builder.addPromotions("Individual", individualpromotionalItemsC, new FixedCost(7));

		List<PromotionalItem> combopromotionalItemsBC = new ArrayList<PromotionalItem>();
		PromotionalItem comboItemB = new PromotionalItem("B", 3);
		combopromotionalItemsBC.add(comboItemB);
		PromotionalItem comboItemc = new PromotionalItem("C", 1);
		combopromotionalItemsBC.add(comboItemc);
		builder.addPromotions("Combo", combopromotionalItemsBC, new FixedCost(10));

		List<Promotion> list = builder.getPromotionList();
		Map<String, FixedCost> map = builder.getIndividualItemCost();

		List<PromotionalItem> inputPromotionitems = new ArrayList<PromotionalItem>();
		PromotionalItem a1 = new PromotionalItem("A", 0);
		PromotionalItem a2 = new PromotionalItem("B", 3);
		PromotionalItem a3 = new PromotionalItem("C", 1);
		inputPromotionitems.add(a1);
		inputPromotionitems.add(a2);
		inputPromotionitems.add(a3);
		CostCalculator calculator = new CostCalculator();
		assertEquals(10.0, calculator.findTotalCost(map, inputPromotionitems, list));
	}
	
	public void testApp_ScenarioA() {
		PromotionBuilder builder = new PromotionBuilder();
		IndividualItemCost c1 = new IndividualItemCost("A", new FixedCost(50.0));
		IndividualItemCost c2 = new IndividualItemCost("B", new FixedCost(30.0));
		IndividualItemCost c3 = new IndividualItemCost("C", new FixedCost(20.0));
		IndividualItemCost c4 = new IndividualItemCost("D", new FixedCost(15.0));
		builder.addIndividualItemCost(c1);
		builder.addIndividualItemCost(c2);
		builder.addIndividualItemCost(c3);
		builder.addIndividualItemCost(c4);
		List<PromotionalItem> individualpromotionalItemsA = new ArrayList<PromotionalItem>();
		PromotionalItem item = new PromotionalItem("A", 3);
		individualpromotionalItemsA.add(item);
		builder.addPromotions("Individual", individualpromotionalItemsA, new FixedCost(130));

		List<PromotionalItem> individualpromotionalItemsB = new ArrayList<PromotionalItem>();
		PromotionalItem itemB = new PromotionalItem("B", 2);
		individualpromotionalItemsB.add(itemB);
		builder.addPromotions("Individual", individualpromotionalItemsB, new FixedCost(45));


		List<PromotionalItem> combopromotionalItemsBC = new ArrayList<PromotionalItem>();
		PromotionalItem comboItemB = new PromotionalItem("C", 1);
		combopromotionalItemsBC.add(comboItemB);
		PromotionalItem comboItemc = new PromotionalItem("D", 1);
		combopromotionalItemsBC.add(comboItemc);
		builder.addPromotions("Combo", combopromotionalItemsBC, new FixedCost(30));

		List<Promotion> list = builder.getPromotionList();
		Map<String, FixedCost> map = builder.getIndividualItemCost();

		List<PromotionalItem> inputPromotionitems = new ArrayList<PromotionalItem>();
		PromotionalItem a1 = new PromotionalItem("A", 1);
		PromotionalItem a2 = new PromotionalItem("B", 1);
		PromotionalItem a3 = new PromotionalItem("C", 1);
		inputPromotionitems.add(a1);
		inputPromotionitems.add(a2);
		inputPromotionitems.add(a3);
		CostCalculator calculator = new CostCalculator();
		assertEquals(100.0, calculator.findTotalCost(map, inputPromotionitems, list));
	}
	
	public void testApp_ScenarioB() {
		PromotionBuilder builder = new PromotionBuilder();
		IndividualItemCost c1 = new IndividualItemCost("A", new FixedCost(50.0));
		IndividualItemCost c2 = new IndividualItemCost("B", new FixedCost(30.0));
		IndividualItemCost c3 = new IndividualItemCost("C", new FixedCost(20.0));
		IndividualItemCost c4 = new IndividualItemCost("D", new FixedCost(15.0));
		builder.addIndividualItemCost(c1);
		builder.addIndividualItemCost(c2);
		builder.addIndividualItemCost(c3);
		builder.addIndividualItemCost(c4);
		List<PromotionalItem> individualpromotionalItemsA = new ArrayList<PromotionalItem>();
		PromotionalItem item = new PromotionalItem("A", 3);
		individualpromotionalItemsA.add(item);
		builder.addPromotions("Individual", individualpromotionalItemsA, new FixedCost(130));

		List<PromotionalItem> individualpromotionalItemsB = new ArrayList<PromotionalItem>();
		PromotionalItem itemB = new PromotionalItem("B", 2);
		individualpromotionalItemsB.add(itemB);
		builder.addPromotions("Individual", individualpromotionalItemsB, new FixedCost(45));


		List<PromotionalItem> combopromotionalItemsBC = new ArrayList<PromotionalItem>();
		PromotionalItem comboItemB = new PromotionalItem("C", 1);
		combopromotionalItemsBC.add(comboItemB);
		PromotionalItem comboItemc = new PromotionalItem("D", 1);
		combopromotionalItemsBC.add(comboItemc);
		builder.addPromotions("Combo", combopromotionalItemsBC, new FixedCost(30));

		List<Promotion> list = builder.getPromotionList();
		Map<String, FixedCost> map = builder.getIndividualItemCost();

		List<PromotionalItem> inputPromotionitems = new ArrayList<PromotionalItem>();
		PromotionalItem a1 = new PromotionalItem("A", 5);
		PromotionalItem a2 = new PromotionalItem("B", 5);
		PromotionalItem a3 = new PromotionalItem("C", 1);
		inputPromotionitems.add(a1);
		inputPromotionitems.add(a2);
		inputPromotionitems.add(a3);
		CostCalculator calculator = new CostCalculator();
		assertEquals(370.0, calculator.findTotalCost(map, inputPromotionitems, list));
	}
	
	public void testApp_ScenarioC() {
		PromotionBuilder builder = new PromotionBuilder();
		IndividualItemCost c1 = new IndividualItemCost("A", new FixedCost(50.0));
		IndividualItemCost c2 = new IndividualItemCost("B", new FixedCost(30.0));
		IndividualItemCost c3 = new IndividualItemCost("C", new FixedCost(20.0));
		IndividualItemCost c4 = new IndividualItemCost("D", new FixedCost(15.0));
		builder.addIndividualItemCost(c1);
		builder.addIndividualItemCost(c2);
		builder.addIndividualItemCost(c3);
		builder.addIndividualItemCost(c4);
		List<PromotionalItem> individualpromotionalItemsA = new ArrayList<PromotionalItem>();
		PromotionalItem item = new PromotionalItem("A", 3);
		individualpromotionalItemsA.add(item);
		builder.addPromotions("Individual", individualpromotionalItemsA, new FixedCost(130));

		List<PromotionalItem> individualpromotionalItemsB = new ArrayList<PromotionalItem>();
		PromotionalItem itemB = new PromotionalItem("B", 2);
		individualpromotionalItemsB.add(itemB);
		builder.addPromotions("Individual", individualpromotionalItemsB, new FixedCost(45));


		List<PromotionalItem> combopromotionalItemsBC = new ArrayList<PromotionalItem>();
		PromotionalItem comboItemB = new PromotionalItem("C", 1);
		combopromotionalItemsBC.add(comboItemB);
		PromotionalItem comboItemc = new PromotionalItem("D", 1);
		combopromotionalItemsBC.add(comboItemc);
		builder.addPromotions("Combo", combopromotionalItemsBC, new FixedCost(30));

		List<Promotion> list = builder.getPromotionList();
		Map<String, FixedCost> map = builder.getIndividualItemCost();

		List<PromotionalItem> inputPromotionitems = new ArrayList<PromotionalItem>();
		PromotionalItem a1 = new PromotionalItem("A", 3);
		PromotionalItem a2 = new PromotionalItem("B", 5);
		PromotionalItem a3 = new PromotionalItem("C", 1);
		PromotionalItem a4 = new PromotionalItem("D", 1);
		inputPromotionitems.add(a1);
		inputPromotionitems.add(a2);
		inputPromotionitems.add(a3);
		inputPromotionitems.add(a4);
		CostCalculator calculator = new CostCalculator();
		assertEquals(280.0, calculator.findTotalCost(map, inputPromotionitems, list));
	}
}
