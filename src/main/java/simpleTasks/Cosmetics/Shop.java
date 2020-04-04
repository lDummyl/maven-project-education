package simpleTasks.Cosmetics;

import org.w3c.dom.ls.LSOutput;

public class Shop {
    public static void main(String[] args) {
        Parfum parfum = new Parfum("Armani", "Flowers");
        CosmeticsApplying choice = parfum.apply();
        System.out.println(choice);
    }

}
