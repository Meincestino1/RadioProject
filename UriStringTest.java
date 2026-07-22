public class UriStringTest {


    @FunctionalInterface
    interface CheckedFunction<T, R> {
        R apply(T t) throws Exception;
    }


    public static void main(String[] args) {
        CheckedFunction<String, URI> safeUriFactory = URI::new;
        safeUriFactory.apply("www.boh.xn");
    }

}
