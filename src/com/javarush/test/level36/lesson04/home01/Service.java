package com.javarush.test.level36.lesson04.home01;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private List<String> data = new ArrayList<String>() {{
        add("First string");
        add("Second string");
        add("Third string");
    }};

    public List<String> getData() {
        return data;
    }
}
