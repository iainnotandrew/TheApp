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
        assertThat(queryProcessor.process("which of the following numbers is the largest: 2, 12, 300, 1"),
                containsString("300"));
    }
}
