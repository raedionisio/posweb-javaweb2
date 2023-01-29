package dev.fujioka.java.avancado.web.curso;

import dev.fujioka.java.avancado.web.model.Curso;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AreaCursoConsumer {

    @JmsListener(destination = "curso_queue")
    public void receiveMessage(Curso curso) {

        System.out.println("Mensagem da fila:" + curso.getAreaCurso());
    }
}