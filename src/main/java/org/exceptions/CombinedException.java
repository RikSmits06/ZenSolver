package org.exceptions;

import java.util.List;

public class CombinedException extends Exception {
    public CombinedException(List<String> errors) {
        StringBuilder builder = new StringBuilder("Encountered the following error(s):\n");
        for (String error : errors) {
            builder.append(error).append("\n");
        }
        super(builder.toString());
    }
}
