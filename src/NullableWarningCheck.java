import java.lang.reflect.Field;

public class NullableWarningCheck {

    public static void checkNullWarnings(Object obj) {
        Class<?> clazz = obj.getClass();

        checkFieldsForNullWarnings(clazz, obj);

        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null) {
            checkFieldsForNullWarnings(superclass, obj);
        }
    }

    private static void checkFieldsForNullWarnings(Class<?> clazz, Object obj) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(NullableWarning.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(obj);
                    if (value == null) {
                        System.out.println("Variable [" + field.getName() + "] is null in [" + clazz.getSimpleName() + "]!");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
