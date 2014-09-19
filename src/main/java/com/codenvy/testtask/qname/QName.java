/*
 * Copyright (c)
 *
 */

package com.codenvy.testtask.qname;

/**
 * The class <code>QName</code> represents qualified name.
 * An object of type QName contains three fields whose types are string.
 * <p/>
 * In addition, this class provides several methods for obtaining a prefix name,
 * local name, full name.
 *
 * @author Kiryshkin Petro
 * @since JDK 1.7
 */
public class QName {

    /**
     * The name prefix of this qualified name.
     */
    private String prefixName;

    /**
     * The local name of this qualified name.
     */
    private String localName;

    /**
     * Creates a new fully qualified name using the given parameters.
     * Full name of the qualified name is created by concatenating
     * the name prefix and a local name.
     *
     * @param prefixName The name prefix of the qualified name.
     * @param localName  The local name of the qualified name.
     */
    public QName(String prefixName, String localName) {
        this.prefixName = prefixName;
        this.localName = localName;
    }

    /**
     * Returns the name prefix of the qualified name.
     *
     * @return name prefix - the string value represented by this object.
     */
    public String getPrefix() {
        return prefixName;
    }

    /**
     * Returns the local name of the qualified name.
     *
     * @return local name - the string value represented by this object.
     */
    public String getLocalName() {
        return localName;
    }

    /**
     * Returns the full name of the qualified name.
     *
     * @return full name - the string value represented by this object.
     */
    public String getAsString() {
        StringBuilder fullName = new StringBuilder();

        fullName.append(getPrefix());
        fullName.append(getLocalName());

        return fullName.toString();
    }
}