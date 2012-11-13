package org.antbear.jprowl;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;

public class ProwlResponseHandler implements ResponseHandler<ProwlResponse> {

    /**
     * @see <a href="http://hc.apache.org/httpcomponents-client-ga/httpclient/clover/org/apache/http/impl/client/BasicResponseHandler.html">BasicResponseHandler</a>
     */
    @Override
    public ProwlResponse handleResponse(HttpResponse response) throws ClientProtocolException, IOException {

        final StatusLine statusLine = response.getStatusLine();
        final HttpEntity entity = response.getEntity();
        if (statusLine.getStatusCode() >= 300) {
            EntityUtils.consume(entity);
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }
        if (entity == null) {
            return null;
        }

        final String entityString = EntityUtils.toString(entity);
        StringReader reader = new StringReader(entityString);

        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(ProwlResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            ProwlResponse prowlResponse = (ProwlResponse) unmarshaller.unmarshal(reader);
            return prowlResponse;

        } catch (JAXBException e) {
            throw new RuntimeException("Failed to parse XML response", e);
        }
    }
}
