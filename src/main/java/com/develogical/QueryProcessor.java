package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.contains("programming")) {
            return "Computer programming is the comprehensive process that leads from an original " 
                   + "formulation of a computing problem to executable programs.";
        }
        else if (query.contains("TDD")) {
            return "Test Driven Development is awesome!";
        }
        else if (query.contains("cow")) {
            return "Is a good source of methane among other things";
        }
        else if (query.contains("foo")) {
            return "bar";
        }
        return "";
    }
}
