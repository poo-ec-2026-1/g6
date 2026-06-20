# Código fonte do programa AppBus Acessível

## Classes e arquivos principais do programa

---
### Aspecto Visual do Programa (Lógica & Implementação) - Miguel Camargo e Daniel Alberto
---
### ExecutarPrograma.java

Classe principal do JavaFX. Contém o método start, o método executarPrograma e o main.

### TelaPrograma.java

Classe de visão. Carrega o arquivo TelaPrograma.fxml, cria a Scene em formato mobile e mostra a janela.

### TelaPrograma.fxml

Arquivo visual do programa. Pode ser aberto no SceneBuilder para alterar campos, listas, botões e layout.

### ControleTela.java

Classe de controle. Lida com cliques, pesquisas, seleção de pontos, seleção de linhas e cálculo de rotas.

---
### Aspecto de Simulação do Programa (Lógica & Implementação) - Anderson Valerio
---
### TrafegoTransporte.java

Interface que define o contrato da API de transporte: buscar pontos, linhas, rotas e previsões.

### APIVirtual.java

Base de dados simulada. Contém setores, aliases de busca, pontos, linhas, rotas e cálculo de previsões.

### PontoOnibus.java

Modelo de ponto de ônibus. Guarda código, nome, setor e sigla do setor.

### LinhaOnibus.java

Modelo de linha de ônibus. Guarda número, nome, rota simplificada, rota completa, destino, pontos e ônibus.

### PrevisaoOnibus.java

Modelo do resultado de previsão de chegada de uma linha em um ponto.

### TamanhoRota.java

Modelo do resultado de uma rota entre setores, contendo tempo, distância e linhas sugeridas.

### OnibusModelo.java

Classe abstrata base para os ônibus. Define identificador, tipo, cálculo de trânsito e velocidade média.

### OnibusComum.java

Ônibus convencional. Simula maior tempo de chegada e menor velocidade média.

### OnibusEixo.java

Ônibus rápido/eixo. Simula menor tempo de chegada e maior velocidade média.

### ExecutarTerminal.java

Classe de teste sem JavaFX. Serve para validar a APIVirtual diretamente pelo terminal.

---
### Aspecto de Perseverança de Dados (Lógica) - Juan Victor
---
### AppAcessivel

Classe de interface do sistema usando JavaFX com um sistema de listagem simplorio através do uso das demais classes.

### AppCRUD

Classe de interface do sistema usando JavaFX que simula o ciclo de controle completo dos dados (Criar, Ler, Atualizar e Deletar - CRUD).

### Launcher

Classe de inicialização das interfaces de modo alternado
