# Documentação do Projeto - SIM RMTC Acessível

## 1. Introdução

### 1.1 Contextualização

O transporte público é um dos principais meios de deslocamento da população urbana. Entretanto, muitos usuários enfrentam dificuldades para localizar pontos de ônibus, identificar linhas disponíveis e estimar o tempo necessário para realizar um trajeto.

Pensando nesse cenário, foi desenvolvido o **SIM RMTC Acessível**, um sistema de simulação de transporte coletivo construído em Java com interface JavaFX. O projeto busca representar, de forma simplificada, o funcionamento de uma rede de transporte urbano, permitindo consultas de pontos, linhas e rotas entre setores da cidade com uma interface simplificada para facilitação de implementação de acessibilidade geral.

### 1.2 Problema

Usuários podem encontrar dificuldades para:

- Encontrar pontos de ônibus próximos ou pertencentes a um setor específico;
- Identificar quais linhas atendem determinado ponto;
- Estimar tempo e distância de deslocamento;
- Obter informações de forma acessível e organizada.

### 1.3 Justificativa

O desenvolvimento do sistema permite aplicar conceitos de Programação Orientada a Objetos, interfaces gráficas, modelagem de dados e acessibilidade digital em um contexto próximo da realidade.

Além disso, o projeto serve como uma ferramenta de aprendizado para simulação de sistemas de transporte ou semelhantes, organização de dados e desenvolvimento colaborativo.

### 1.4 Motivação

A motivação principal consiste em unir:

- Simulação de transporte urbano;
- Acessibilidade na apresentação das informações;
- Desenvolvimento colaborativo em equipe;
- Aplicação prática dos conteúdos estudados em sala de aula.

---

## 2. Plano do Projeto

### 2.1 Objetivo Geral

Desenvolver um sistema acessível de simulação da rede de transporte coletivo capaz de fornecer informações sobre pontos de ônibus, linhas disponíveis, previsão de chegada e cálculo de rotas entre setores da cidade.

### 2.2 Objetivos Específicos

- Implementar uma base de dados simulada para pontos e linhas de ônibus;
- Permitir consultas por código, setor ou texto livre;
- Exibir linhas associadas a cada ponto;
- Calcular rotas entre setores da cidade;
- Simular previsão de chegada dos ônibus;
- Desenvolver uma interface gráfica intuitiva e acessível;
- Implementar mecanismos de persistência local para preferências do usuário;
- Produzir documentação técnica e relatórios do projeto;
- Realizar testes de funcionamento e validação das funcionalidades.

---

## 3. Estrutura Atual do Sistema

### Camada de Simulação e Dados

| Classe | Responsabilidade |
|----------|----------|
| APIVirtual | Base de dados simulada contendo setores, pontos, linhas e rotas |
| TrafegoTransporte | Interface dos serviços de transporte |
| LinhaOnibus | Modela uma linha de ônibus |
| PontoOnibus | Modela um ponto de ônibus |
| PrevisaoOnibus | Representa uma previsão de chegada |
| TamanhoRota | Representa o resultado do cálculo de rota |
| OnibusModelo | Classe abstrata para modelos de ônibus |
| OnibusComum | Simulação de ônibus convencional |
| OnibusEixo | Simulação de ônibus rápido/eixo |

### Camada de Interface

| Classe | Responsabilidade |
|----------|----------|
| TelaPrograma | Carregamento da interface JavaFX |
| ControleTela | Controle das interações do usuário |
| TelaPrograma.fxml | Estrutura visual da aplicação |

### Camada de Execução

| Classe | Responsabilidade |
|----------|----------|
| ExecutarPrograma | Inicialização da aplicação JavaFX |
| ExecutarTerminal | Execução e testes via terminal |

---

## 4. Divisão de Tarefas

### Cronograma Geral

**Data de início:** 05/06/2026

**Prazo final do projeto:** 26/06/2026

---

### Ítalo Reis

#### Responsabilidades

- Produção dos relatórios e documentação do projeto;
- Organização dos documentos no repositório;
- Planejamento da documentação técnica;
- Execução dos testes funcionais;
- Registro de erros encontrados;
- Proposição de melhorias e correções.

#### Classes Relacionadas

- ExecutarTerminal
- APIVirtual
- ControleTela
- Todas as classes durante a etapa de testes

#### Prazo

- 05/06 a 17/06: Estruturação da documentação;
- 18/06 a 24/06: Testes e validações;
- 25/06 a 26/06: Consolidação do relatório final.

---

### Miguel Camargo

#### Responsabilidades

- Desenvolvimento da interface visual;
- Organização da experiência do usuário;
- Definição dos elementos gráficos;
- Estruturação da navegação da aplicação;
- Ajustes de usabilidade.

#### Classes Relacionadas

- TelaPrograma.fxml
- TelaPrograma
- ControleTela

#### Prazo

- 05/06 a 18/06: Desenvolvimento visual;
- 19/06 a 23/06: Ajustes de usabilidade;
- 24/06 a 26/06: Refinamentos finais.

---

### Daniel Alberto

#### Responsabilidades

- Implementação dos recursos de acessibilidade;
- Revisão das mensagens exibidas ao usuário;
- Garantia de clareza nas informações;
- Melhoria da interação entre usuário e sistema;
- Padronização das saídas do programa.

#### Classes Relacionadas

- ControleTela
- TelaPrograma.fxml
- TelaPrograma
- ExecutarTerminal

#### Prazo

- 05/06 a 19/06: Implementação inicial;
- 20/06 a 24/06: Validação de acessibilidade;
- 25/06 a 26/06: Ajustes finais.

---

### Anderson Valerio

#### Responsabilidades

- Desenvolvimento da APIVirtual;
- Implementação da lógica de simulação;
- Cálculo de distância e tempo das rotas;
- Organização dos setores da cidade;
- Simulação de tráfego e deslocamento.

#### Classes Relacionadas

- APIVirtual
- TrafegoTransporte
- LinhaOnibus
- PontoOnibus
- PrevisaoOnibus
- TamanhoRota
- OnibusModelo
- OnibusComum
- OnibusEixo

#### Prazo

- 05/06 a 20/06: Implementação da lógica;
- 21/06 a 24/06: Testes de integração;
- 25/06 a 26/06: Correções.

---

### Juan Victor

#### Responsabilidades

- Implementação do sistema de login;
- Cadastro de usuário e senha;
- Persistência local dos dados;
- Armazenamento de preferências do usuário;
- Salvamento de rotas favoritas;
- Salvamento de linhas favoritas;
- Salvamento de pontos favoritos.

#### Classes Previstas

- Usuario
- SistemaLogin
- BancoLocal
- PreferenciasUsuario
- ArquivoDados

#### Integração com

- ControleTela
- APIVirtual

#### Prazo

- 05/06 a 18/06: Estrutura da persistência;
- 19/06 a 23/06: Implementação do login;
- 24/06 a 26/06: Integração e testes.

---

## 5. Entregáveis

### Até 17/06

- Estrutura documental inicial;
- Interface visual preliminar;
- Estrutura inicial da persistência local.

### Até 20/06

- Simulação das rotas concluída;
- Recursos de acessibilidade implementados;
- Sistema de login em desenvolvimento.

### Até 24/06

- Integração completa dos módulos;
- Testes funcionais realizados.

### Até 26/06

- Sistema finalizado;
- Relatório final concluído;
- Repositório atualizado;
- Correções finais aplicadas.

---

## 6. Considerações Finais

O SIM RMTC Acessível busca fornecer uma simulação simplificada de um sistema de transporte coletivo, combinando conceitos de orientação a objetos, acessibilidade, interface gráfica e trabalho colaborativo.

A divisão de tarefas foi organizada para distribuir as responsabilidades de maneira equilibrada entre os integrantes da equipe, permitindo que cada membro atue em uma área específica do projeto enquanto contribui para a construção de um sistema integrado e funcional.
