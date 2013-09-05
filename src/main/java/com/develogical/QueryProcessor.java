package com.develogical;

import java.util.StringTokenizer;

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
        else if (query.contains("what is your name")) {
            return "TeamAwesome";
        }
        else if (query.contains("plus")) {
            StringTokenizer st = new StringTokenizer(query);
            String previous = "";
            while(st.hasMoreTokens()) {
                String current = st.nextToken();
                if (current.equals("plus")) {
                    return "" + (Integer.parseInt(previous) + Integer.parseInt(st.nextToken()));
                }
                previous = current;
            }


            return "";
        }
        return "";
    }
}
