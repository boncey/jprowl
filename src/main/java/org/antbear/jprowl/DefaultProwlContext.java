package org.antbear.jprowl;

import javax.validation.constraints.NotNull;

public final class DefaultProwlContext extends AbstractProwlContext {

    private String serviceURL;

    public DefaultProwlContext() {
        this("https://api.prowlapp.com/publicapi/");
    }

    public DefaultProwlContext(@NotNull final String serviceURL) {
        this.serviceURL = serviceURL;
    }

    public void setServiceURL(@NotNull final String serviceURL) {
        this.serviceURL = serviceURL;
    }

    @Override
    public String getServiceURL() {
        return this.serviceURL;
    }
}
