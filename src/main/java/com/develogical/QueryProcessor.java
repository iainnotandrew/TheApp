package com.develogical;

import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

            Pattern p = Pattern.compile("what is ([0-9]+) plus ([0-9]+).*");
            Matcher m = p.matcher(query);
            if (m.find()) {
                return "" + (intFromString(m.group(1)) + intFromString(m.group(2)));
            }

            return "";
        }

        else if (query.contains("largest")) {

            Pattern p = Pattern.compile("which of the following numbers is the largest: ([0-9]+), ([0-9]+), ([0-9]+), ([0-9]+).*");
            Matcher m = p.matcher(query);
            int highest = 0;

            if (m.find()) {
                for (int i = 1; i <= m.groupCount(); i ++) {
                    int current = intFromString(m.group(i));
                    if(current > highest) {
                        highest = intFromString(m.group(i));
                    }
                }
            }
            return "" + highest;
        }
        else if (query.contains("multiplied")) {

            Pattern p = Pattern.compile("what is ([0-9]+) multiplied by ([0-9]+).*");
            Matcher m = p.matcher(query);
            if (m.find()) {
                return "" + (intFromString(m.group(1)) * intFromString(m.group(2)));
            }

            return "";
        }
        else if (query.contains("Bond")) {


            return "Sean Connery";
        }

        else if (query.contains("Prime Minister")) {


            return "David Cameron";
        }

        else if (query.contains("primes:")) {

            Pattern p = Pattern.compile(".*primes: ([0-9]+), ([0-9]+).*");
            Matcher m = p.matcher(query);

            if (m.find()) {
                BigInteger bigInt = new BigInteger(m.group(1));
                if(bigInt.isProbablePrime(1)) {
                    return "" + m.group(1);
                } else {
                    return "" + m.group(2);
                }
            }
        }

        return "";
    }

    private int intFromString(String string) {
        return Integer.parseInt(string);
    }
}
