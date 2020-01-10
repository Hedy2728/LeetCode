package hm_test.java_test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import hm_test.java_test.SysConstant;

public class Test {
    public static void main(String[] args) {
        try {
            System.out.println(SysConstant.INT_VALUE);
            Field field = SysConstant.class.getDeclaredField("INT_VALUE");
            field.setAccessible(true);
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(null, 200);
            System.out.println(SysConstant.INT_VALUE);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
