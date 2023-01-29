package dev.fujioka.java.avancado.web.aluno;

import dev.fujioka.java.avancado.web.model.Aluno;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MatriculaAlunoConsumer {

    @JmsListener(destination = "aluno_queue")
    public void receiveMessage(Aluno aluno) {

        System.out.println("Mensagem da fila:" + aluno.getMatricula());
    }
}
