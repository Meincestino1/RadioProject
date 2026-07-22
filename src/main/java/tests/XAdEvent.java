package tests;

import java.util.EventObject;
import java.util.logging.Logger;

public class XAdEvent extends EventObject {

    private final String slogan;

    public XAdEvent(Object source, String slogan) {
        super(source);
        this.slogan = slogan;
    }

    public String getSlogan() {
        return slogan;
    }



}
