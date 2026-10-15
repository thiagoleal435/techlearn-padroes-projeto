package techlearn;

import techlearn.composite.Aula;
import techlearn.composite.ComponenteCatalogo;
import techlearn.composite.Modulo;
import techlearn.iterator.ComposicaoIterator;
import techlearn.iterator.FiltroIterator;
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

        Modulo submodulo = new Modulo("Submódulo 2.4: Extras");
        submodulo.adicionar(new Aula("Aula 2.4.1: Revisão Rápida", 20));
        submodulo.adicionar(new Aula("Aula 2.4.2: Estudo Aprofundado", 55));
        modulo2.adicionar(submodulo);

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

        System.out.println("\nAulas curtas (<= 45 min):");
        Iterator<ComponenteCatalogo> aulasCurtas = new FiltroIterator(
                new ComposicaoIterator(curso),
                componente -> componente instanceof Aula
                        && componente.getDuracaoMinutos() <= 45);
        while (aulasCurtas.hasNext()) {
            ComponenteCatalogo aula = aulasCurtas.next();
            logger.log("Aula curta encontrada: " + aula.getNome()
                    + " | Duração: " + aula.getDuracaoMinutos() + " min");
        }

        logger.log("Execução da atividade finalizada.");
    }
}
