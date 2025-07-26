# 🚀 Sistema de Bootcamp - Demonstração de POO em Java

## 📋 Sobre o Projeto

O sistema simula um **Bootcamp de Tecnologia** onde desenvolvedores se inscrevem em cursos e mentorias, progridem através dos conteúdos e acumulam XP (Experience Points).

### 🎯 Objetivo

Demonstrar na prática os **4 pilares fundamentais da POO**:

- ✅ **Abstração**
- ✅ **Encapsulamento**
- ✅ **Herança**
- ✅ **Polimorfismo**

## 🏗️ Arquitetura do Sistema

### 📁 Estrutura do Projeto

```
src/
├── Main.java                          # Classe principal com demonstrações
└── br/com/dio/desafio/dominio/
    ├── Conteudo.java                   # Classe abstrata base
    ├── Curso.java                      # Herda de Conteudo
    ├── Mentoria.java                   # Herda de Conteudo
    ├── Dev.java                        # Representa desenvolvedores
    └── Bootcamp.java                   # Gerencia o bootcamp
```

### 🔗 Diagrama de Classes

```
Conteudo (Abstract)
├── titulo: String
├── descricao: String
├── XP_PADRAO: double
└── calcularXp(): double (abstract)
    │
    ├── Curso
    │   ├── cargaHoraria: int
    │   └── calcularXp(): XP_PADRAO * cargaHoraria
    │
    └── Mentoria
        ├── data: LocalDate
        └── calcularXp(): XP_PADRAO + 20
```

## 🎮 Funcionalidades Implementadas

### 🎓 Sistema de Bootcamp

- ✅ **Criação de bootcamps** com nome, descrição e período
- ✅ **Gestão de conteúdos** (cursos e mentorias)
- ✅ **Controle de inscrições** de desenvolvedores

### 📚 Gestão de Conteúdos

- ✅ **Cursos** com carga horária e cálculo de XP proporcional
- ✅ **Mentorias** com data específica e XP fixo adicional
- ✅ **Sistema polimórfico** de cálculo de experiência

### 👨‍💻 Sistema de Desenvolvedores

- ✅ **Inscrição automática** em todos os conteúdos do bootcamp
- ✅ **Progressão sequencial** através dos conteúdos
- ✅ **Acúmulo de XP** baseado nos conteúdos concluídos
- ✅ **Relatórios individuais** de progresso

### 📊 Sistema de Relatórios

- ✅ **Ranking por XP** dos participantes
- ✅ **Estatísticas do bootcamp** (inscritos, conclusões)
- ✅ **Acompanhamento de progresso** individual

## 🔧 Como Executar

### Pré-requisitos

- Java JDK 11 ou superior
- Terminal/CMD

### Executando o projeto

1. **Clone o repositório**

```bash
git clone https://github.com/Rychardsson/abstracao-java.git
cd abstracao-java
```

2. **Compile o projeto**

```bash
javac -d . src/Main.java src/br/com/dio/desafio/dominio/*.java
```

3. **Execute a aplicação**

```bash
java Main
```

## 🎯 Demonstração dos Pilares da POO

### 🔺 **ABSTRAÇÃO**

```java
// Classe abstrata que define o contrato comum
public abstract class Conteudo {
    protected static final double XP_PADRAO = 10d;
    private String titulo;
    private String descricao;

    public abstract double calcularXp(); // Método abstrato
}
```

### 🔺 **ENCAPSULAMENTO**

```java
// Atributos privados com acesso controlado
private String nome;
private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();

// Métodos públicos para acesso controlado
public String getNome() { return nome; }
public void setNome(String nome) { this.nome = nome; }
```

### 🔺 **HERANÇA**

```java
// Curso herda características e comportamentos de Conteudo
public class Curso extends Conteudo {
    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }
}
```

### 🔺 **POLIMORFISMO**

```java
// Diferentes implementações do mesmo método
// Curso: XP baseado na carga horária
public double calcularXp() { return XP_PADRAO * cargaHoraria; }

// Mentoria: XP fixo adicional
public double calcularXp() { return XP_PADRAO + 20d; }
```

## 📈 Exemplo de Saída

```
=== SISTEMA DE BOOTCAMP - DEMONSTRACAO POO ===

BOOTCAMP CRIADO: Bootcamp Java Full Stack Developer 2025
Descricao: Bootcamp completo para formacao de desenvolvedores Java Full Stack
Periodo: 2025-07-26 ate 2025-09-09
Total de conteudos: 4

>>> Camila Silva se inscreveu no bootcamp!
>>> Joao Santos se inscreveu no bootcamp!
>>> Ana Costa se inscreveu no bootcamp!

=== PROGRESSO DE JOAO SANTOS ===
   [OK] Conteudo 1 concluido!
   [OK] Conteudo 2 concluido!
   [OK] Conteudo 3 concluido!
   [OK] Conteudo 4 concluido!

======================================================================
RELATORIO FINAL DO BOOTCAMP
======================================================================
>>> RANKING POR XP:
   [1o] Joao Santos - 290,0 XP (4 conteudos concluidos)
   [2o] Camila Silva - 140,0 XP (2 conteudos concluidos)
   [3o] Ana Costa - 80,0 XP (1 conteudos concluidos)
======================================================================
```

## 🛠️ Tecnologias Utilizadas

- ☕ **Java 11+**
- 🏗️ **Programação Orientada a Objetos**
- 📦 **Collections Framework**
- 🕒 **Java Time API**
- 🔄 **Streams API**

## 📚 Conceitos Aplicados

### Design Patterns

- ✅ **Template Method** (classe abstrata Conteudo)
- ✅ **Factory Method** (métodos de criação na Main)

### Boas Práticas

- ✅ **Código limpo** e bem documentado
- ✅ **Separação de responsabilidades**
- ✅ **Métodos com uma única responsabilidade**
- ✅ **Nomenclatura clara e descritiva**

### Java Features

- ✅ **Generics** com Collections
- ✅ **Optional** para tratamento de valores
- ✅ **Lambda expressions** e Stream API
- ✅ **JavaDoc** para documentação

## 📖 Conceitos de POO Explicados

### 🔻 **DOMÍNIO**

Camada de negócio onde estão localizadas as classes que fazem parte do domínio do problema. No nosso caso, o domínio é um **sistema de bootcamp** com cursos, mentorias e desenvolvedores.

### 🔻 **CLASSE**

Elemento do código que representa objetos do mundo real. Nossas classes principais:

- `Bootcamp` - Representa um bootcamp de tecnologia
- `Conteudo` - Classe abstrata para conteúdos educacionais
- `Curso` - Representa um curso com carga horária
- `Mentoria` - Representa uma sessão de mentoria
- `Dev` - Representa um desenvolvedor participante

### 🔻 **ABSTRAÇÃO**

Capacidade de concentrar-se nos aspectos essenciais, ignorando detalhes menos importantes. A classe `Conteudo` abstrai as características comuns entre cursos e mentorias.

### 🔻 **ENCAPSULAMENTO**

Esconder a implementação dos objetos, favorecendo manutenção e evolução. Todos os atributos são privados com acesso controlado via getters/setters.

### 🔻 **HERANÇA**

Permite que classes filhas reutilizem código de classes pai. `Curso` e `Mentoria` herdam de `Conteudo`, aproveitando título, descrição e XP padrão.

### 🔻 **POLIMORFISMO**

Capacidade de um objeto ser referenciado de várias formas. O método `calcularXp()` é implementado diferentemente em cada classe filha, mas pode ser chamado de forma uniforme.

## 🎓 Resultados de Aprendizado

Ao final deste projeto, você terá:

✅ **Compreendido** os 4 pilares da POO na prática  
✅ **Implementado** um sistema completo usando conceitos avançados  
✅ **Aplicado** boas práticas de programação Java  
✅ **Criado** um projeto portfolio demonstrando conhecimento em POO

## 🤝 Contribuindo

Este projeto foi criado para fins educacionais. Contribuições são bem-vindas!

### Como contribuir:

1. Faça um Fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

### Ideias de melhorias:

- 🔄 Sistema de avaliações para cursos
- 📅 Calendário de eventos do bootcamp
- 🏆 Sistema de badges e conquistas
- 📊 Dashboard com métricas avançadas
- 💾 Persistência de dados em arquivo/banco

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Autor

**Rychardsson Souza**

- GitHub: [@Rychardsson](https://github.com/Rychardsson)
- LinkedIn: [Rychardsson Souza](https://www.linkedin.com/in/rychardssonsouza/)

## 🙏 Agradecimentos

- **Digital Innovation One (DIO)** pelo desafio e conteúdo educacional
- **Camila Cavalcante** pela criação original do projeto
- Comunidade Java por todo o conhecimento compartilhado

---
