package simpleTasks.Furniture;

import org.w3c.dom.ls.LSOutput;

public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void clean(Furniture furniture) throws Exception {
        //протрем пыль:
        boolean isDustOnTableOrBookshelfOrChairOrWardrobe = (furniture.getClass() == Table.class) || (furniture.getClass() == Bookshelf.class) || (furniture.getClass() == Chair.class) || (furniture.getClass() == Wardrobe.class);
        //пропылесосим:
        boolean isDustOnCarpetOrSofa = (furniture.getClass() == Carpet.class) || (furniture.getClass() == Sofa.class);
        //поменяем простынь:
        boolean isDustOnBed = (furniture.getClass() == Bed.class);

        if (isDustOnTableOrBookshelfOrChairOrWardrobe){
            System.out.println("Just a little dusting around");
        }
        else if (isDustOnCarpetOrSofa){
            System.out.println("to vacuum");
        }
        else if(isDustOnBed){
            System.out.println("change bedsheets");
        }
        else{
            System.out.println("Exception");
        }
    }

    public void goToSleep(SleepingPlace sleepingPlace) throws Exception {
        if ((sleepingPlace.getClass() == Bed.class) || (sleepingPlace.getClass() == Sofa.class)){
            System.out.println("It's a good sleeping place");
        }
        else{
            System.out.println("It's not a good sleeping place");
        }
    }
}
