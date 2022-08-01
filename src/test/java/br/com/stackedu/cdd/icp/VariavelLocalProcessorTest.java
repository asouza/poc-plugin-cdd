package br.com.stackedu.cdd.icp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.stackedu.cdd.ArmazenarMetricas;
import br.com.stackedu.cdd.Resources;
import spoon.Launcher;

public class VariavelLocalProcessorTest {
    @Test
    public void testName() throws Exception {
        Launcher l = new Launcher();
        l.getEnvironment().setNoClasspath(true);
        l.addInputResource(
            new Resources().buscaArquivo("Aluno.java"));

        ArmazenarMetricas context = new ArmazenarMetricas();
        VariavelLocalProcessor processor = new VariavelLocalProcessor(context);

        l.addProcessor(processor);
        l.run();

        assertEquals(6, processor.total());
    }
}