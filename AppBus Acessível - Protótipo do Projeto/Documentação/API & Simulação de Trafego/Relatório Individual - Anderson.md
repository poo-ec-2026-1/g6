# Relatório Individual de Projeto: Backend da Simulação de Trafego e API

## Atribuição de Cargo e Tarefas

- **Curso:** Engenharia de Computação.
- **Cargo:** Desenvolvedor Backend e Arquiteto de Soluções da Simulação.
- **Responsabilidades Iniciais:** Ficou sob minha responsabilidade projetar e implementar a lógica de negócios central da simulação de transporte urbano (Simulador GP), garantindo que as previsões de chegada fossem calculadas dinamicamente.
- **Atribuições Exercidas na Prática:** Além de criar a infraestrutura das classes de domínio, implementei o algoritmo que consome o relógio do sistema (`LocalTime.now()`) para atualizar as previsões em tempo real e idealizei toda a lógica de tráfego e rotas do ecossistema do projeto.

---

## Contribuição de Acordo com a Atribuição

O backend foi totalmente estruturado aplicando os conceitos centrais de Programação Orientada a Objetos (POO), linguagem previamente escolhida e trabalhada desde o início do semestre letivo.

O cenário foi contextualizado na realidade do transporte público de Goiânia (Eixo Anhanguera e linhas do Campus Samambaia da UFG).

---

## Lista de Commits Relevantes (Evolução do Código)

### commit: `feat(model): Implementação dos Pilares de POO`

**O que foi feito:** Criação da classe abstrata `Veiculo` e suas subclasses concretas `OnibusEixo` e `OnibusConvencional`. Implementação da relação onde uma `Linha` possui um `Veiculo` (Composição), e proteção dos dados através de atributos privados e getters na classe `Ponto` (Encapsulamento).

### commit: `feat(service): Criação da Simulação Baseada no Tempo do Sistema`

**O que foi feito:** Desenvolvimento da classe `SimuladorTransporteService` utilizando a API `java.time` (`LocalTime`, `ChronoUnit`). Foi criada a lógica matemática que simula partidas de ônibus a cada 10 minutos e calcula o tempo de chegada restante cruzando a hora atual do computador com o tempo base da rota.

### commit: `fix(service): Correção de Assinatura e Contrato da Interface ServicoTransporte`

**O que foi feito:** Refatoração e padronização do método de busca com a anotação `@Override` para seguir estritamente o contrato estabelecido pela interface `ServicoTransporte` (`consultarPrevisoesDoPonto`), corrigindo divergências de assinatura e blindando a integração com os demais módulos.

---

## Principais Dificuldades e Tomadas de Decisão (Trade-offs)

### Sincronização Temporal Virtual vs. Real

O desafio de impedir previsões negativas quando o ônibus teórico "já havia passado" da hora atual do sistema.

Resolvido com a validação:

```java
if (passagemNoPonto.isBefore(agora))
```

que projeta o cálculo automaticamente para a viagem dos próximos 10 minutos.

### Abstração Matemática de Rotas (Latitude e Longitude)

O requisito pedia o cálculo de trajetos por coordenadas geográficas.

Diante do tempo hábil restrito do semestre para implementar fórmulas trigonométricas complexas (como a Fórmula de Haversine), tomei a decisão de engenharia de criar um módulo de Grid Mapping.

Substituímos a curvatura global por uma matriz plana de 50 por 50 (onde cada célula equivale a 100 metros, cobrindo uma área simulada de 5 km × 5 km).

A distância é calculada via Distância de Manhattan (deslocamento por quadras lineares), gerando um resultado tratado em metros de forma extremamente performática e elegante.

---

## Contribuição Além do Atribuído

### Código Didático e Cooperação em Acessibilidade

Sendo eu e outro colega de equipe pessoas com deficiência visual, dediquei atenção rigorosa à legibilidade do código, ao conceito de Clean Code e à documentação detalhada e didática de cada método (incluindo guias textuais em Javadoc para os códigos dos pontos de Goiânia).

Essa preocupação garantiu que a leitura por sintetizadores de voz fosse fluida, tornando o projeto um ambiente de desenvolvimento verdadeiramente acessível e colaborativo para nós.

### Justificativa do Design de Classes (Modelo de Domínio)

A criação de múltiplas classes específicas para os veículos (`Veiculo`, `OnibusEixo`, `OnibusConvencional`) foi uma decisão intencional de arquitetura.

O objetivo foi materializar de forma prática os conceitos de Herança e Polimorfismo discutidos em sala de aula.

Longe de ser uma redundância, essa estrutura modela fielmente a realidade física do transporte de Goiânia (onde o Eixo possui canal exclusivo e o ônibus comum divide espaço com o trânsito), permitindo que o sistema decida as regras de atraso em tempo de execução sem a necessidade de condicionais (`if/else`) poluindo o código.

### Apoio à Integração com o Front-End

Criação de métodos com nomenclatura duplicada (`getLine()` e `getLinha()`) na classe de transferência de dados `Previsao`, antecipando e facilitando a comunicação com possíveis restrições de frameworks que a equipe pudesse utilizar na interface visual.

---

## Considerações Gerais e Aprendizado Prático

### Teoria de Sala Aplicada no Projeto

O projeto foi o laboratório perfeito para consolidar a teoria abstrata de POO.

O maior ganho foi ver o Polimorfismo por Sobreposição funcionando na prática: no método de cálculo de tempo, o sistema recebe um `Veiculo` genérico e o Java resolve sozinho se aplica o atraso do ônibus convencional ou a fluidez do Eixo.

Isso provou como a orientação a objetos gera sistemas escaláveis.

### Trabalhos Futuros Pendentes

Como melhoria futura no escopo de Engenharia de Computação, pretendo desacoplar a carga de dados (seed) que hoje está fixa no construtor da classe `SimuladorTransporteService`, permitindo que novas linhas, pontos e o grid da matriz sejam lidos a partir de um arquivo externo JSON ou banco de dados.

### Conclusão

O projeto demonstrou que a engenharia vai muito além de escrever linhas de código: envolve escolhas pragmáticas de arquitetura sob prazos reais, cooperação mútua em acessibilidade e a entrega de uma solução robusta, coesa e de fácil manutenção.
