package dev.fujioka.java.avancado.web.professor;

import dev.fujioka.java.avancado.web.model.Professor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class DisciplinaProfessorConsumer {

    @JmsListener(destination = "professor_queue")
    public void receiveMessage(Professor professor) {

        System.out.println("Mensagem da fila:" + professor.getDisciplina());
    }
}