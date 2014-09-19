/*
 * Copyright (c)
 *
 */

package com.codenvy.testtask.qname;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// Test class, for testing of correct operation of the class Parser
public class ParserTest {
    private Parser parser;
    private QName name;

    //Class Parser initialization
    @BeforeClass
    public void initData() throws IllegalNameException {
        parser = new Parser();
        name = parser.parse("prename:local");
    }

    //Valid names
    @DataProvider
    public Object[][] validNameProvider() {
        return new Object[][]{
                {
                        new String[]{
                                "name",
                                "prefix:name",
                                "prefix:name name"
                        }
                }
        };
    }

    //Ivalid names
    @DataProvider
    public Object[][] inValidNameProvider() {
        return new Object[][]{
                {
                        new String[]{
                                "",
                                ":name",
                                ".",
                                "..",
                                "prefix:",
                                " name",
                                " prefix:name",
                                "prefix: name",
                                "prefix:name ",
                                "pre fix:name",
                                "name/name",
                                "name[name",
                                "prefix:name:name"
                        }
                }
        };
    }

    //Testing get the correct prefix name
    @Test
    public void testGetPrefixQName() {
        Assert.assertEquals(name.getPrefix(), "prename");
    }

    //Testing get the correct local name
    @Test
    public void testGetLocalNameQName() throws IllegalNameException {
        Assert.assertEquals(name.getLocalName(), ":local");
    }

    //Testing get the correct full name
    @Test
    public void testGetAsString() {
        Assert.assertEquals(name.getAsString(), "prename:local");
    }

    //Testing get the correct prefix name
    @Test
    public void testIncorrectName() throws IllegalNameException {
        boolean valid = parser.validate("name ");
        Assert.assertEquals(valid, false);
    }

    //Testing the transfer of incorrect name and catching an exception
    @Test
    public void testIncorrectPrefixedName() {
        boolean valid = parser.validate(":name prefix");
        Assert.assertEquals(valid, false);
    }

    //Testing the transfer of incorrect name and catching an exception
    @Test
    public void testAsString() {
        boolean valid = parser.validate(":name prefix");
        Assert.assertEquals(valid, false);
    }

    //Testing the transfer of incorrect name and catching an exception
    @Test(expectedExceptions = IllegalNameException.class)
    public void testException() throws IllegalNameException {
        QName valid = parser.parse("prefix:name ");
        Assert.assertEquals(valid.getPrefix(), "prefix");
    }

    //Testing valid names
    @Test(dataProvider = "validNameProvider")
    public void validNameTest(String[] names) {

        for (String temp : names) {
            boolean valid = parser.validate(temp);
            Assert.assertEquals(valid, true);
        }
    }

    //Testing invalid names
    @Test(dataProvider = "inValidNameProvider", dependsOnMethods = "validNameTest")
    public void InValidNameTest(String[] names) {

        for (String temp : names) {
            boolean valid = parser.validate(temp);
            Assert.assertEquals(valid, false);
        }
    }
}