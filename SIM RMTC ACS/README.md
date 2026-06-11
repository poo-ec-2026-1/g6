# SIM RMTC - ACESSIVEL

## Perspectiva

Protótipo funcional de um projeto JavaFX construído para uma simulação de aplicativo móvel de transporte público com aspectos acessiveis por simplicidade.

A interface é montada por FXML e o fluxo de interação fica separado na classe de controle e na classe de visão.

## Arquivo visual do programa

`TelaPrograma.fxml`

## Classes principais do programa

### ExecutarPrograma.java

Classe principal do JavaFX. Contém o método start, o método executarPrograma e o main.

### TelaPrograma.java

Classe de visão. Carrega o arquivo TelaPrograma.fxml, cria a Scene em formato mobile e mostra a janela.

### TelaPrograma.fxml

Arquivo visual do programa. Pode ser aberto no SceneBuilder para alterar campos, listas, botões e layout.

### ControleTela.java

Classe de controle. Lida com cliques, pesquisas, seleção de pontos, seleção de linhas e cálculo de rotas.

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

## Fluxo de uso/interação da tela pelo usuário

1. O usuário inicia na pesquisa de ponto e linha.
2. Pode digitar um código de ponto, como `SS01`, ou o final do código, como `01`.
3. Também pode digitar setor em vários formatos, como `Setor Sul`, `setor sul`, `setorsul` ou `SS`.
4. Se a busca encontrar um ponto direto, as linhas daquele ponto aparecem.
5. Se a busca encontrar um setor, os pontos daquele setor aparecem.
6. Ao selecionar um ponto, aparecem as linhas que passam por ele.
7. Ao selecionar uma linha, aparecem tempo de chegada, distância do ônibus e rota simplificada.
8. Na pesquisa de rota, o usuário informa origem e destino para receber tempo aproximado, distância e linhas sugeridas.
