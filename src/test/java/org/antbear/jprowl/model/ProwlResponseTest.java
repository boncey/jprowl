package org.antbear.jprowl.model;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static java.lang.System.out;
import static org.junit.Assert.*;

public class ProwlResponseTest {

    private JAXBContext context;

    @Before
    public void setUp() throws JAXBException {
        this.context = JAXBContext.newInstance(ProwlResponse.class);
    }

    @After
    public void tearDown() {
        this.context = null;
    }

    @Test
    public void prowlRetrieveTest() throws JAXBException, IOException {
        final String filename = "retrieveToken.xml";
        final String xml = getTestResourceAsString(filename);

        assertNotNull(xml);
        out.println(xml);

        Unmarshaller unmarshaller = this.context.createUnmarshaller();

        ProwlResponse response = (ProwlResponse) unmarshaller.unmarshal(getTestResourceAsStream(filename));
        assertNotNull(response);
        assertNull(response.getError());

        ProwlSuccess success = response.getSuccess();
        assertNotNull(success);
        assertEquals(200, success.getStatusCode());
        assertEquals(5, success.getRemainingApiCalls());
        assertNotNull(success.getResetDate());

        ProwlRetrieve retrieve = response.getRetrieve();
        assertNotNull(retrieve);
        assertEquals("abc", retrieve.getToken());
        assertEquals(new URL("http://www.github.com/"), retrieve.getUrl());
    }

    private String getTestResourceAsString(final String name) throws IOException {
        return IOUtils.toString(getTestResourceAsStream(name));
    }

    private InputStream getTestResourceAsStream(final String name) {
        return this.getClass().getResourceAsStream(name);
    }
}
