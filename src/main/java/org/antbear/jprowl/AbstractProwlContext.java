package org.antbear.jprowl;

import com.google.common.collect.Lists;
import org.apache.http.client.utils.URIBuilder;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public abstract class AbstractProwlContext implements ProwlContext {

    private static String terminateStringBy(@NotNull final String t, @NotNull final String input) {
        return input.endsWith(t) ? input : input + t;
    }

    @NotNull
    @Override
    public URI buildRequestURI(@NotNull final String apiMethod, @NotNull ProwlRequestParameter... parameters) {
        List<ProwlRequestParameter> result = Lists.newArrayList();
        for (ProwlRequestParameter param : parameters) {
            result.add(param);
        }
        return buildRequestURI(apiMethod, result);
    }

    @NotNull
    @Override
    public URI buildRequestURI(@NotNull final String apiMethod, @NotNull List<ProwlRequestParameter> parameters) {
        try {
            final String baseURLString = terminateStringBy("/", getServiceURL());
            final String method = terminateStringBy("/", apiMethod);

            URIBuilder builder = new URIBuilder(baseURLString + method);
            for (ProwlRequestParameter parameter : parameters) {
                builder.addParameter(parameter.getKey(), parameter.getValue());
            }
            return builder.build();
        } catch (URISyntaxException e) {
            throw new RuntimeException("Failed building URL", e);
        }
    }
}
