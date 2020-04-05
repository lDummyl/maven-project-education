package simpleTasks.Cosmetics;

import java.util.HashSet;
import java.util.Set;

public class GlamorousPerson extends Person {

    public GlamorousPerson(String name) {
        super(name);
    }

    public <T extends Cosmetics> void apply(Class<T> tClass, Object object) throws Exception {
        if (tClass == Parfum.class) {
           if( object.equals("Flowers"))
           {  System.out.println("Flowers aroma is a good choice");}
           else{
               System.out.println("I recommend you to change your mind and choose a flowers' aroma");
           }
        }

        if(tClass == Lipstick.class){
            if(object.equals("Peach")){
                System.out.println("Peach color looks perfect");
            }
            else{
                System.out.println("I recommend you to choose peach color");
            }
        }
    }
}

    //  Set<Cosmetics> allCosmetics = new HashSet<>();
  //  public void applyCosmetics(Cosmetics cosmetics){
  //      allCosmetics.add(cosmetics);
  //  }
//
  //  @Override
  //  public String toString() {
  //      return "GlamorousPerson{" +
  //              "allCosmetics=" + allCosmetics +
  //              '}';
  //  }

