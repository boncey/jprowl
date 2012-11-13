package org.antbear.jprowl;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DefaultProwlContextTest {

    @Test
    public void urlNotNullTest() {
        DefaultProwlContext context = new DefaultProwlContext();
        assertNotNull(context.getServiceURL());
    }
}
