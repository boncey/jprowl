package org.antbear.prowl;

import org.antbear.prowl.DefaultProwlContext;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DefaultProwlContextTest {

    @Test
    public void urlNotNullTest() {
        DefaultProwlContext context = new DefaultProwlContext();
        assertNotNull(context.getServiceURL());
    }
}
