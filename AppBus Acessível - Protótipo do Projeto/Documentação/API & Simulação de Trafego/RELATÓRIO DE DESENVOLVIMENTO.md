# RELATÓRIO DE DESENVOLVIMENTO: SIMULADOR DE API EM TEMPO REAL

## 1. ESCOPO DO SUBSISTEMA DE SIMULAÇÃO 

Para resolver o desafio de mostrar os horários dos ônibus em tempo real sem ter acesso a um GPS real, foi desenvolvido um motor de simulação inteligente dentro da classe `APIVirtual`.

Esse serviço funciona como uma base de dados direto na memória do programa, o que deixa o aplicativo extremamente rápido. Ele simula toda a estrutura de transporte da cidade, dividindo o mapa em regiões, cadastrando os pontos de parada e gerenciando as linhas de ônibus.

Em vez de usar horários fixos e engessados, o sistema calcula tudo dinamicamente usando a hora atual do computador e o comportamento esperado de cada linha, criando uma experiência muito próxima de um aplicativo de transporte real.

---

## 2. ABORDAGEM TÉCNICA EM PROGRAMAÇÃO ORIENTADA A OBJETOS (POO)

O ecossistema do sistema utiliza os pilares fundamentais da POO para garantir que o projeto ficasse organizado, limpo e fácil de mexer no futuro:

### Abstração

Transformamos entidades do mundo real (como linhas, ônibus e pontos) em objetos organizados no código, focando apenas nos atributos necessários para o sistema (como códigos, rotas e tempos).

### Encapsulamento

As informações sensíveis dos modelos foram protegidas usando o modificador `private` e coleções imutáveis.

O acesso é feito apenas por métodos `getters`, o que impede que uma parte do sistema altere os dados de outra por engano.

### Herança e Polimorfismo

Aplicados através da classe abstrata `OnibusModelo`.

O sistema trata ônibus do tipo `Comum` e `Eixo` de forma genérica, mas cada subclasse calcula seu próprio impacto no trânsito e sua velocidade média de um jeito único através do método `aplicarTransito`.

### Interfaces

A classe `APIVirtual` se integra à interface `TrafegoTransporte`.

Isso desacopla as regras de operações da tela, permitindo que esse simulador seja substituído por uma API web real no futuro sem quebrar o programa por um todo.

---

## 3. ALGORITMOS E REGRAS DE NEGÓCIO IMPLEMENTADAS

A inteligência por trás das buscas e rotas conta com três mecanismos principais:

### A. Tratamento Léxico e Normalização

O sistema possui um algoritmo baseado na classe `java.text.Normalizer` que remove acentos, espaços e letras maiúsculas de tudo o que é digitado.

Isso evita erros de busca se o usuário digitar o nome de um setor ou ponto de forma variada.

### B. Motor de Previsão de Chegada

Para estimar em quantos minutos o ônibus vai chegar, o algoritmo faz um cálculo matemático cruzando o tempo base da rota com o minuto atual do relógio do sistema operacional e o intervalo de partida da linha (8 ou 12 minutos), inferindo a posição teórica do veículo na malha.

### C. Inteligência de Roteamento Intersetorial

A função de traçar rotas faz uma varredura completa em dois níveis.

Primeiro, tenta achar uma linha direta que atenda a origem e o destino.

Caso não encontre, ela cruza os dados das rotas usando conjuntos (`LinkedHashSet`) e sugere uma rota com conexão (transbordo), indicando exatamente em qual setor o usuário deve trocar de ônibus.
