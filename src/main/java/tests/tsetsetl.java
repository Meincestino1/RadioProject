package tests;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.function.Function;
import java.util.function.Supplier;

public class tsetsetl {



    public static void main(String[] args) {

        Supplier<Date> factory = Date::new;
        System.out.println(factory.get());

        Function<String, URI> uriFactory = str ->

        {
            try {
                return new URI(str);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        };
        URI uri = uriFactory.apply("https://example.com");
        System.out.println(uri);



    }

}
