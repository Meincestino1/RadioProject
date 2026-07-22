package tests;

public class LagerUtils {

    public static <T> Lager<T> kopiereLager(Lager<T> original) {
        Lager<T> kopie = new Lager<>();
        for (T element : original.getAlle()) {
            kopie.einlagern(element);
        }
        return kopie;
    }
}
