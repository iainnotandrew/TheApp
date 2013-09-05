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

            String[] parts = query.split("primes: ");

            StringTokenizer st = new StringTokenizer(parts[1], ", ");

            String output = "";

            while(st.hasMoreTokens())
            {
                String currentString = st.nextToken();
                BigInteger current = new BigInteger(currentString);
                if (current.isProbablePrime(1))
                {
                    if (output.length() > 0)
                    {
                        output = output + ", ";
                    }
                    output = output + currentString;
                }
            }

            return output;
        }
        else if (query.contains("Eiffel")) {

            return "Paris";
        }
        else if (query.contains("Spain")) {
            return "Peseta";
        }
        else if (query.contains("banana")) {
            return "yellow";
        }
        else if (query.contains("minus")) {
            Pattern p = Pattern.compile("what is ([0-9]+) minus ([0-9]+).*");
            Matcher m = p.matcher(query);
            if (m.find()) {
                return "" + (intFromString(m.group(1)) - intFromString(m.group(2)));
            }
        }
        else if (query.contains("Fibonacci")) {
            Pattern p = Pattern.compile("what is the ([0-9]+).*");
            Matcher m = p.matcher(query);

            int prev1=0, prev2=1;
            if(m.find()) {
                int n = intFromString(m.group(1));
                for(int i=0; i<n; i++) {
                    int savePrev1 = prev1;
                    prev1 = prev2;
                    prev2 = savePrev1 + prev2;
                }
                return "" + prev1;
            }
            return "dunno";
        }
        else if (query.contains("square and a cube:")) {

            String[] parts = query.split("square and a cube: ");

            StringTokenizer st = new StringTokenizer(parts[1], ", ");

            String output = "";

            while(st.hasMoreTokens())
            {
                String currentString = st.nextToken();
                int current = intFromString(currentString);
                if (isSquare(current))
                {
                    if(isCube(current)) {
                        if (output.length() > 0)
                        {
                            output = output + ", ";
                        }

                        output = output + currentString;
                    }
                }
            }

            return output;
        }
        else if (query.contains("power of")) {

            Pattern p = Pattern.compile("what is ([0-9]+) to the power of ([0-9]+).*");
            Matcher m = p.matcher(query);
            if (m.find()) {
                return "" + (Math.pow(intFromString(m.group(1)),intFromString(m.group(2))));
            }

            return "";
        }

        return "";
    }


    private boolean isCube(int number) {
        double answer = Math.cbrt(number);
        return (answer - Math.round(answer) < 0.01);
    }

    private boolean isSquare(int number) {
        double answer = Math.sqrt(number);
        return (answer - Math.round(answer) < 0.01);
    }

    private int intFromString(String string) {
        return Integer.parseInt(string);
    }
}
