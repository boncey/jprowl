package org.antbear.prowl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class SimpleProwlClient implements ProwlClient {

    private RawProwlClient client;

    @Autowired
    public void setClient(@NotNull final RawProwlClient client) {
        this.client = client;
    }

    @Override
    public ProwlResponse verifyApiKey(final String apiKey) {
        final ProwlResponse response = client.verifyApiKey(apiKey);
        final ProwlSuccess success = response.getSuccess();
        if (null == success || 200 != success.getStatusCode()) {
            throw new ProwlException("API Key could not be verified", response);
        }
        return response;
    }

    @Override
    public ProwlResponse postNotification(@NotNull final ProwlNotification notification) {
        final ProwlResponse response = client.postNotification(notification);
        final ProwlSuccess success = response.getSuccess();
        if (null == success || 200 != success.getStatusCode()) {
            throw new ProwlException("Notification could not be posted", response);
        }
        return response;
    }
}
