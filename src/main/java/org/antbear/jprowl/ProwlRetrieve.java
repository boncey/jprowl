package org.antbear.jprowl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.net.URL;

@XmlAccessorType(XmlAccessType.FIELD)
public final class ProwlRetrieve {

    @XmlAttribute
    private String token;

    @XmlAttribute
    private URL url;

    @XmlAttribute(name="apikey")
    private String apiKey;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
