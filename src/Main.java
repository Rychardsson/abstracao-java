import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

/**
 * Classe principal que demonstra o uso dos conceitos de POO:
 * Abstração, Encapsulamento, Herança e Polimorfismo
 * 
 * @author Bootcamp Java Developer
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE BOOTCAMP - DEMONSTRACAO POO ===\n");
        
        // Criando os conteúdos do bootcamp
        Curso cursoJava = criarCurso("Curso Java Avancado", 
                                   "Aprenda Java do basico ao avancado com projetos praticos", 
                                   8);
        
        Curso cursoJavaScript = criarCurso("Curso JavaScript Moderno", 
                                         "Domine JavaScript ES6+ e desenvolvimento web", 
                                         6);
        
        Curso cursoSpring = criarCurso("Spring Boot Essentials", 
                                     "Construa APIs REST robustas com Spring Boot", 
                                     12);
        
        Mentoria mentoriaCarreira = criarMentoria("Mentoria: Carreira em Tecnologia", 
                                                "Dicas essenciais para acelerar sua carreira na area tech", 
                                                LocalDate.now().plusDays(7));

        // Criando e configurando o bootcamp
        Bootcamp bootcamp = criarBootcamp("Bootcamp Java Full Stack Developer 2025", 
                                         "Bootcamp completo para formacao de desenvolvedores Java Full Stack");
        
        // Adicionando conteúdos ao bootcamp
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(cursoJavaScript);
        bootcamp.getConteudos().add(cursoSpring);
        bootcamp.getConteudos().add(mentoriaCarreira);
        
        System.out.println("BOOTCAMP CRIADO: " + bootcamp.getNome());
        System.out.println("Descricao: " + bootcamp.getDescricao());
        System.out.println("Periodo: " + bootcamp.getDataInicial() + " ate " + bootcamp.getDataFinal());
        System.out.println("Total de conteudos: " + bootcamp.getConteudos().size());
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Simulando desenvolvedores se inscrevendo no bootcamp
        Dev devCamila = criarDev("Camila Silva");
        Dev devJoao = criarDev("Joao Santos");
        Dev devAna = criarDev("Ana Costa");
        
        // Inscrevendo os devs no bootcamp
        inscreverDevNoBootcamp(devCamila, bootcamp);
        inscreverDevNoBootcamp(devJoao, bootcamp);
        inscreverDevNoBootcamp(devAna, bootcamp);
        
        // Simulando progresso dos desenvolvedores
        simularProgressoDev(devCamila, 2);  // Camila conclui 2 conteúdos
        simularProgressoDev(devJoao, 4);    // João conclui todos os conteúdos
        simularProgressoDev(devAna, 1);     // Ana conclui apenas 1 conteúdo
        
        // Relatório final
        gerarRelatorioFinal(bootcamp);
    }
    
    /**
     * Método utilitário para criar um curso
     */
    private static Curso criarCurso(String titulo, String descricao, int cargaHoraria) {
        Curso curso = new Curso();
        curso.setTitulo(titulo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }
    
    /**
     * Método utilitário para criar uma mentoria
     */
    private static Mentoria criarMentoria(String titulo, String descricao, LocalDate data) {
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo(titulo);
        mentoria.setDescricao(descricao);
        mentoria.setData(data);
        return mentoria;
    }
    
    /**
     * Método utilitário para criar um bootcamp
     */
    private static Bootcamp criarBootcamp(String nome, String descricao) {
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome(nome);
        bootcamp.setDescricao(descricao);
        return bootcamp;
    }
    
    /**
     * Método utilitário para criar um desenvolvedor
     */
    private static Dev criarDev(String nome) {
        Dev dev = new Dev();
        dev.setNome(nome);
        return dev;
    }
    
    /**
     * Método para inscrever um dev no bootcamp
     */
    private static void inscreverDevNoBootcamp(Dev dev, Bootcamp bootcamp) {
        dev.inscreverBootcamp(bootcamp);
        System.out.println(">>> " + dev.getNome() + " se inscreveu no bootcamp!");
    }
    
    /**
     * Simula o progresso de um desenvolvedor
     */
    private static void simularProgressoDev(Dev dev, int numeroProgressoes) {
        System.out.println("\n=== PROGRESSO DE " + dev.getNome().toUpperCase() + " ===");
        System.out.println("Conteudos inscritos: " + dev.getConteudosInscritos().size());
        
        for (int i = 0; i < numeroProgressoes; i++) {
            if (!dev.getConteudosInscritos().isEmpty()) {
                dev.progredir();
                System.out.println("   [OK] Conteudo " + (i + 1) + " concluido!");
            }
        }
        
        System.out.println("RELATORIO DE " + dev.getNome() + ":");
        System.out.println("   Conteudos restantes: " + dev.getConteudosInscritos().size());
        System.out.println("   Conteudos concluidos: " + dev.getConteudosConcluidos().size());
        System.out.println("   XP total: " + String.format("%.1f", dev.calcularTotalXp()));
    }
    
    /**
     * Gera um relatório final do bootcamp
     */
    private static void gerarRelatorioFinal(Bootcamp bootcamp) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("RELATORIO FINAL DO BOOTCAMP");
        System.out.println("=".repeat(70));
        
        System.out.println("Bootcamp: " + bootcamp.getNome());
        System.out.println("Total de devs inscritos: " + bootcamp.getDevsInscritos().size());
        
        // Ranking por XP
        System.out.println("\n>>> RANKING POR XP:");
        bootcamp.getDevsInscritos().stream()
                .sorted((dev1, dev2) -> Double.compare(dev2.calcularTotalXp(), dev1.calcularTotalXp()))
                .forEach(dev -> {
                    String posicao = dev.calcularTotalXp() >= 150 ? "[1o]" : 
                                    dev.calcularTotalXp() >= 100 ? "[2o]" : "[3o]";
                    System.out.println(String.format("   %s %s - %.1f XP (%d conteudos concluidos)", 
                                                    posicao, 
                                                    dev.getNome(), 
                                                    dev.calcularTotalXp(),
                                                    dev.getConteudosConcluidos().size()));
                });
        
        System.out.println("\n>>> Bootcamp finalizado com sucesso!");
        System.out.println("=".repeat(70));
    }
}
