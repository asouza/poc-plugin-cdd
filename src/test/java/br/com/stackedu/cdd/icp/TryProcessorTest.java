package br.com.stackedu.cdd.icp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.stackedu.cdd.Resources;
import br.com.stackedu.cdd.StoreMetrics;
import spoon.Launcher;

public class TryProcessorTest {
    @Test
    public void testName() throws Exception {
        Launcher l = new Launcher();
        l.getEnvironment().setNoClasspath(true);
        l.addInputResource(
            new Resources().findFile("ServicoNotas.java"));

        StoreMetrics context = new StoreMetrics();
        TryProcessor processor = new TryProcessor(context);

        l.addProcessor(processor);
        l.run();

        assertEquals(1, processor.total());
    }

    @Test
    @DisplayName("Try with finally")
    public void testName2() throws Exception {
        Launcher l = new Launcher();
        l.getEnvironment().setNoClasspath(true);
        l.addInputResource(
            new Resources().findFile("TryComFinally.java"));

        StoreMetrics context = new StoreMetrics();
        TryProcessor processor = new TryProcessor(context);

        l.addProcessor(processor);
        l.run();

        assertEquals(2, processor.total());
    }
}