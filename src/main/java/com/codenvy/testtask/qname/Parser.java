/*
 * Copyright (c)
 *
 */

package com.codenvy.testtask.qname;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class <code>Parser</code>.
 * The class contains a method, for construction
 * of the qualified name.
 *
 * @author Kiryshkin Petro
 * @since JDK 1.7
 */
public class Parser {

    /**
     * Analyzes the string and look for pattern matching.
     */
    private Matcher matcher;

    /**
     * A regular expressions that matches name prefix of the qualified name.
     */
    private static final String PREFIX_NAME_PATTERN = "(\\w+)";

    /**
     * A regular expressions that matches local name of the qualified name.
     */
    private static final String LOCAL_NAME_PATTERN = "(:\\w+(\\s\\w+)*)";

    /**
     * A regular expressions that matches the qualified name.
     */
    private static final String NAME_PATTERN = "\\w+(:\\w+(\\s\\w+)*)?";

    /**
     * The compiled representation of the regular expressions.
     */
    private Pattern patternForPrefixName = Pattern.compile(PREFIX_NAME_PATTERN);
    private Pattern patternForLocalName = Pattern.compile(LOCAL_NAME_PATTERN);
    private Pattern patternForAsString= Pattern.compile(NAME_PATTERN);

    /**
     * Default Constructor.
     */
    public Parser() {
    }

    /**
     * Returns object of the qualified name if the string
     * matches the regular expression.
     *
     * @param name String which will be checked on compliance to the regular expression.
     * @return Returns object of the qualified name.
     * @throws IllegalNameException if the string
     *                              does not match the regular expression.
     */
    public QName parse(String name) throws IllegalNameException {
        String prefix = "";
        String localName = "";

        if (validate(name)) {
            prefix = getPrefix(name);
            localName = getName(name);
        } else {
            throw new IllegalNameException();
        }

        return new QName(prefix, localName);
    }

    /**
     * Return name prefix for the qualified name if the string
     * matches the regular expression.
     *
     * @param name String which will be checked on compliance to the regular expression.
     * @return name prefix for the qualified name.
     */
    public String getPrefix(String name) {
        matcher = patternForPrefixName.matcher(name);

        String prefix = "";

        if (matcher.find()) {
            prefix = matcher.group(1);
        }

        return prefix;
    }

    /**
     * Return local name for the qualified name if the string
     * matches the regular expression.
     *
     * @param name
     * @return local name for the qualified name.
     */
    public String getName(String name) {
        matcher = patternForLocalName.matcher(name);

        String localname = "";

        if (matcher.find()) {
            localname = matcher.group(1);
        }

        return localname;
    }

    /**
     * Determines whether the regular expression string.
     */
    public boolean validate(final String name) {
        matcher = patternForAsString.matcher(name);
        return matcher.matches();
    }
}
