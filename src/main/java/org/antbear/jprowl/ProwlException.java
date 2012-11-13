package org.antbear.jprowl;

import javax.validation.constraints.Null;

public class ProwlException extends RuntimeException {

    @Null
    private final ProwlResponse response;

    public ProwlException(final String message, final Throwable cause) {
        super(message, cause);
        this.response = null;
    }

    public ProwlException(final String message, final ProwlResponse response) {
        super(message);
        this.response = response;
    }
}
