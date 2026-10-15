package techlearn;

import techlearn.composite.Aula;
import techlearn.composite.ComponenteCatalogo;
import techlearn.composite.Modulo;
import techlearn.iterator.Iterator;
import techlearn.logging.LoggerService;

public class Main {
    public static void main(String[] args) {
        LoggerService logger = LoggerService.getInstance();
        logger.log("Iniciando montagem da estrutura de cursos...");

        Modulo curso = new Modulo("Engenharia de Software Moderna");

        Modulo modulo1 = new Modulo("Módulo 1: Orientação a Objetos Avançada");
        modulo1.adicionar(new Aula("Aula 1.1: Coesão e Acoplamento", 45));
        modulo1.adicionar(new Aula("Aula 1.2: Interfaces e Polimorfismo", 60));

        Modulo modulo2 = new Modulo("Módulo 2: Padrões de Projeto (GoF)");
        modulo2.adicionar(new Aula("Aula 2.1: Singleton na Prática", 30));
        modulo2.adicionar(new Aula("Aula 2.2: Composite Hierárquico", 50));
        modulo2.adicionar(new Aula("Aula 2.3: Iterator para Coleções", 40));

        curso.adicionar(modulo1);
        curso.adicionar(modulo2);

        logger.log("Estrutura montada com sucesso. Exibindo detalhes da ementa:");
        curso.exibirDetalhes();

        System.out.println("\nVarredura do Curso Principal via Iterator:");
        Iterator<ComponenteCatalogo> iterator = curso.criarIterator();
        while (iterator.hasNext()) {
            ComponenteCatalogo item = iterator.next();
            logger.log("Navegando no Item Raiz: " + item.getNome()
                    + " | Duração acumulada: " + item.getDuracaoMinutos() + " min");
        }

        logger.log("Execução da atividade finalizada.");
    }
}
