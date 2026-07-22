package tests;

public class Ancelotti {

    public static <T> T newInstance(Class<T> type) {
        try {
            return type.getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }
}
