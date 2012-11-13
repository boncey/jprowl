package org.antbear.jprowl;

import javax.validation.constraints.NotNull;

public interface ProwlClient {

    @NotNull
    ProwlResponse verifyApiKey(String apiKey);

    @NotNull
    ProwlResponse postNotification(@NotNull ProwlNotification notification);
}
