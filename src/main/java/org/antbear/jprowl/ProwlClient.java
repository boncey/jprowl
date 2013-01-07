package org.antbear.jprowl;

import org.antbear.jprowl.model.ProwlResponse;

import javax.validation.constraints.NotNull;

public interface ProwlClient {

    @NotNull
    ProwlResponse verifyApiKey(String apiKey);

    @NotNull
    ProwlResponse postNotification(@NotNull ProwlNotification notification);
}
