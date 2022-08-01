package br.com.stackedu.cdd.icp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.stackedu.cdd.ArmazenarMetricas;
import br.com.stackedu.cdd.Resources;
import br.com.stackedu.cdd.shared.UserDefinitionForTesting;
import spoon.Launcher;

public class MetodoProcessorTest {
    @Test
    @DisplayName("Testando classe usando equals e hashcode, sem usar essa configuração no cdd.json")
    public void testName() throws Exception {
        Launcher l = new Launcher();
        l.getEnvironment().setNoClasspath(true);
        l.addInputResource(
            new Resources().buscaArquivo("Aluno.java"));

        ArmazenarMetricas context = new ArmazenarMetricas();
        MetodoProcessor processor = new MetodoProcessor(UserDefinitionForTesting.load(), context);

        l.addProcessor(processor);
        l.run();

        assertEquals(11, processor.total());
    }

    @Test
    //TODO: como faço pra criar um teste quando o "methodsAutoGenerated" for true?
    public void testName2() throws Exception {
        Launcher l = new Launcher();
        l.getEnvironment().setNoClasspath(true);
        l.addInputResource(
            new Resources().buscaArquivo("AlunoSimples.java"));

        ArmazenarMetricas context = new ArmazenarMetricas();
        MetodoProcessor processor = new MetodoProcessor(UserDefinitionForTesting.load(), context);

        l.addProcessor(processor);
        l.run();

        assertEquals(5, processor.total());
    }
}