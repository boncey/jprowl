package org.antbear.prowl;

import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotNull;

public class SpringProwlContext extends AbstractProwlContext {

    private String serviceURL;

    @Required
    public void setServiceURL(@NotNull final String serviceURL) {
        this.serviceURL = serviceURL;
    }

    @Override
    public String getServiceURL() {
        return this.serviceURL;
    }
}
