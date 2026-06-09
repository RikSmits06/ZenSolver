package org.exceptions;

public class UnknownVariableException extends Exception {
    public UnknownVariableException(String variableName) {
        super("Variable " + variableName + " is not defined.");
    }
}
