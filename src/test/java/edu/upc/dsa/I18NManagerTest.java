package edu.upc.dsa;

import edu.upc.dsa.models.I18NManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.MissingResourceException;

public class I18NManagerTest {
    I18NManager i18n;

    @Before
    public void setUp() throws Exception{
        this.i18n = I18NManager.getInstance();
    }

    @After
    public void tearDown() {
        this.i18n.getInstance().clear();
    }

    @Test
    public void testGetText() throws Exception {
        String msg1 = I18NManager.getInstance().getText("ca","l1");
        Assert.assertEquals("hola", msg1);

        String msg2 = I18NManager.getInstance().getText("ca","l2");
        Assert.assertEquals("adéu", msg2);

        String msg3 = I18NManager.getInstance().getText("es","l2");
        Assert.assertEquals("adiós", msg3);

        String msg4 = I18NManager.getInstance().getText("pt","l2");
        Assert.assertEquals("adeus", msg4);
    }

    @Test(expected = MissingResourceException.class)
    public void testGetTextBundleNotFound() throws Exception {
        String msg1 = I18NManager.getInstance().getText("ca","l1");
        Assert.assertEquals("hola", msg1);

        String msg2 = I18NManager.getInstance().getText("ca","l2");
        Assert.assertEquals("adéu", msg2);

        String msg3 = I18NManager.getInstance().getText("XXXX","l2");
    }
}