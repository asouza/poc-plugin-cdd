package br.com.stackedu.cdd.icp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.stackedu.cdd.Resources;
import br.com.stackedu.cdd.StoreMetrics;
import spoon.Launcher;

public class CatchProcessorTest {
  @Test
  public void testName() throws Exception {
    Launcher l = new Launcher();
    l.getEnvironment().setNoClasspath(true);

    l.addInputResource(new Resources().findFile("ServicoNotas.java"));

    StoreMetrics context = new StoreMetrics();
    CatchProcessor processor = new CatchProcessor(context);

    l.addProcessor(processor);
    l.run();

    assertEquals(1, processor.total());
  }

  @Test
  public void testName2() throws Exception {
    Launcher l = new Launcher();
    l.getEnvironment().setNoClasspath(true);

    l.addInputResource(new Resources().findFile("TryComFinally.java"));

    StoreMetrics context = new StoreMetrics();
    CatchProcessor processor = new CatchProcessor(context);

    l.addProcessor(processor);
    l.run();

    assertEquals(1, processor.total());
  }
}