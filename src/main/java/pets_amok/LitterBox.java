package pets_amok;

import java.util.HashMap;
import java.util.Map;

public class LitterBox {
    private Map<OrganicCat, Integer> litterBox = new HashMap<>();

    public LitterBox() {
    }

    public void addCat(OrganicCat cat) {
        litterBox.put(cat, cat.getWaste());
    }

    public void getLitterBox() {
        System.out.println("\nLitter Box Waste Levels:");
        System.out.printf("%-10s %-10s %n", "Name", "Waste");
        System.out.println("----------|------");

        for (OrganicCat cat : litterBox.keySet()) {
            System.out.printf("%-10s %-10d %n", cat.getName(), cat.getWaste());
        }
    }

    public void cleanLitterBox() {
        for (OrganicCat cat : litterBox.keySet()) {
            cat.cleanWaste();
        }
    }
}
