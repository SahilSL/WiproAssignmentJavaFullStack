package house;

public class Kitchen {
    public void showAppliances() {
        String[] appliances = {"Fridge", "Microwave", "Oven", "Mixer"};
        
        System.out.println("Appliances in kitchen:");
        for (String item : appliances) {
            System.out.println(item);
        }

        String[] copiedAppliances = new String[appliances.length];
        for (int i = 0; i < appliances.length; i++) {
            copiedAppliances[i] = appliances[i];
        }

        System.out.println("\nCopied Appliances:");
        for (String item : copiedAppliances) {
            System.out.println(item);
        }
    }
}
