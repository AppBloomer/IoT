package com.example.walinnsinnovation.iot.Singleton;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;

/**
 * Created by walinnsinnovation on 13/07/17.
 */

public class XHeader implements Header {
    private String name;
    private String value;

    public XHeader(String name, String value, HeaderElement[] element) {
        this.value = value;
        this.name = name;
    }

    public XHeader(String name, String value) {
        this.value = value;
        this.name = name;
    }

    public HeaderElement[] getElements() throws ParseException {
        return null;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }
}
