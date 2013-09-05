package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.StringContains.containsString;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutProgramming() throws Exception {
        assertThat(queryProcessor.process("programming"), containsString("computing"));
    }

    @Test
    public void knowsAboutTDD() throws Exception {
        assertThat(queryProcessor.process("TDD"), containsString("Test Driven Development"));
    }

    @Test
    public void knowsAboutCows() throws Exception {
        assertThat(queryProcessor.process("cow"), containsString("good source of methane"));
    }

    @Test
    public void knowsAboutFoo() throws Exception {
        assertThat(queryProcessor.process("foo"), containsString("bar"));
    }

    @Test
    public void knowsAboutYourName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("TeamAwesome"));
    }

    @Test
    public void knowsAboutAddition() throws Exception {
        assertThat(queryProcessor.process("what is 1 plus 1"), containsString("2"));
    }

    @Test
    public void knowsAboutLargestMultipleNumbers() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 668, 28, 24, 925"),
                containsString("925"));
    }

    @Test
    public void knowsAboutMultiply() throws Exception {
        assertThat(queryProcessor.process("what is 2 multiplied by 12"),
                containsString("24"));
    }

    @Test
    public void knowsAboutDrNo() throws Exception {
        assertThat(queryProcessor.process(" who played James Bond in the film Dr No"),
                containsString("Sean Connery"));
    }

    @Test
    public void knowsAboutPM() throws Exception {
        assertThat(queryProcessor.process("who is the Prime Minister of Great Britain"),
                containsString("David Cameron"));
    }

    @Test
    public void knowsAboutPrimeNumbers() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers are primes: 53, 336"),
                containsString("53"));
    }

    @Test
    public void knowsAboutPrimeNumbersMultiple() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers are primes: 53, 336, 34, 7"),
                containsString("53, 7"));
    }

    @Test
    public void knowsAboutEiffelTower() throws Exception {
        assertThat(queryProcessor.process("which city is the Eiffel tower in"),
                containsString("Paris"));
    }

    @Test
    public void knowsAboutSpain() throws Exception {
        assertThat(queryProcessor.process(" what currency did Spain use before the Euro"),
                containsString("Peseta"));
    }

    @Test
    public void knowsAboutBanana() throws Exception {
        assertThat(queryProcessor.process("what colour is a banana"),
                containsString("yellow"));
    }

    @Test
    public void knowsAboutMinus() throws Exception {
        assertThat(queryProcessor.process("what is 1 minus 1"), containsString("0"));
    }
}
