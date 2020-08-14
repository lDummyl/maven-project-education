package customPackage.animals;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CowReflection {

    public static void main(String[] ar) throws IllegalAccessException, IllegalArgumentException {
        Method[] mthd = Cow.class.getMethods(); // for axis the methods

        Field[] fld = Cow.class.getDeclaredFields();  // for axis the fields

        // Loop for get all the methods in class
        for (Method mthd1 : mthd) {

            System.out.println("method :" + mthd1.getName());
            System.out.println("parameters :" + mthd1.getReturnType());
        }

        // Loop for get all the Field in class
        for (Field fld1 : fld) {
            fld1.setAccessible(true);
            System.out.println("field :" + fld1.getName());
            System.out.println("type :" + fld1.getType());
            // System.out.println("value :" + fld1.getInt(new Cow()));
        }
    }

}
