package org.antbear.prowl;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

public interface ProwlContext {

    @NotNull
    String getServiceURL();

    @NotNull
    URI buildRequestURI(@NotNull final String apiMethod, @NotNull ProwlRequestParameter... parameters);

    @NotNull
    URI buildRequestURI(@NotNull final String apiMethod, @NotNull List<ProwlRequestParameter> parameters);
}
