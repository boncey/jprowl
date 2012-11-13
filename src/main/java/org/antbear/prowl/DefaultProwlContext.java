package org.antbear.prowl;

import java.io.IOException;
import java.util.Properties;

public final class DefaultProwlContext extends AbstractProwlContext {

    @Override
    public String getServiceURL() {
        final Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream(getClass().getSimpleName() + ".properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed loading class resource", e);
        }
        final String url = properties.getProperty("prowl.url");
        if (null == url) {
            throw new RuntimeException("Failed loading properties or misconfigured properties file");
        }
        return url;
    }
}
