# Projeto-POO: AppBus Acessível

## Equipe do projeto:
● Anderson Valério dos Santos  
● Daniel Alberto de Alencar Souza  
● Ítalo Reis Medina  
● Juan Victor Bastos Oliveira  
● Miguel Camargo de Andrade - Líder da equipe  

### Este documento se refere às ideias e perspectivas iniciais de desenvolvimento do projeto

## Tema e Escopo do projeto:

**Tema:** Desenvolver um programa que simule um aplicativo utilizável em plataformas móveis para a navegação através do transporte público que possua recursos de acessibilidade mais táteis ao usuário (Semelhante ao aplicativo SIMRmtc).

**Escopo:** Dar suporte a usuários de transporte público com ou sem alguma deficiência visual, não abrangendo apenas aspectos que facilitariam o uso da ferramenta para esses grupos de usuários mas também facilitando o uso do aplicativo para os demais indivíduos que tem como o transporte público seu principal meio de transporte.

## Funcionalidades principais:

● Monitoramento em tempo real dos ônibus  

● Salvamento de pontos de referência (paradas favoritas)  

● Exibição de rotas disponíveis  

● Criação de usuário (sistema de login opcional) para o salvamento e compartilhamento de preferências facilitado.  

## Tipo de interface:

● Aplicativo para dispositivos móveis (celular)

---

# Trabalhos Semelhantes e Referências:

## Produto Semelhantes:

● SIMRmtc  

● Siu MObile BH  

● Google Maps (visualização voltada a linhas e rotas de ônibus)  

## Referências Técnicas:

● SIMRmtc  

● Google Maps (visualização voltada a linhas e rotas de ônibus)  

---

# Estrutura Inicial de Classes (POO)

**Lógica base da estrutura:** O programa pede ao usuário o setor em que ele se localiza e imprime na tela as respectivas paradas de ônibus naquele setor. O usuário seleciona uma parada em específico e o programa imprime na tela as linhas de ônibus que passam por aquela parada. O usuário seleciona uma linha de ônibus de sua preferência e o programa imprime na tela a rota que o respectivo ônibus selecionado percorre. O programa pergunta ao usuário se ele deseja visualizar outro caminho no mesmo setor, ou em um setor diferente ou se deseja finalizar a visualização de linhas e rotas.

## Classe “Parada”

Possui os métodos de impressão/leitura das strings relacionadas aos parâmetros da classe, além disso a classe possui métodos de listagem e adição das determinadas linhas relacionadas aos setores definidos como localização dessas paradas.

### Métodos da classe:

● `public void adicionarLinha(String linha)` - Adicionar linhas que passam ativamente por uma parada de ônibus.

● `public Parada(String nome, String setor)` - Cria um determinado objeto na memória definindo seu lugar e nome além de criar uma lista de linhas sem dados para a adição posterior.

● `public String getNome()` - Métodos que possibilitam a classe “Programa” acessar o nome da parada selecionada e do setor correspondente.

● `public List<String> getLinhas()` - Imprime a lista de linhas que abrangem uma determinada parada.

---

## Classe “Rota”

Possui métodos que contém os percursos traçados por cada linha e o nome das respectivas linhas que traçam tais percursos.

### Métodos da classe:

● `public Rota(String nomeLinha, String percurso)` - Define a qual linha de ônibus o trajeto pertence e descreve o caminho de forma simplificada (A - B - C).

● `public String getNomeLinha()` - Permite a comparação do número de uma linha definida digitado pelo usuário para imprimir a rota de forma correta.

● `public String getPercurso()` - Imprime o trajeto na tela feito pela linha de ônibus selecionada.

---

## Classe “Onibus”

Carrega métodos simples que contém as rotas que cada linha de ônibus irá traçar e a quantidade de passageiros que entrou no ônibus da linha selecionada.

### Métodos da classe:

● `public Onibus(String idLinha, int passageiros)` - Define qual linha de ônibus está ou não em operação além da quantidade de pessoas que entraram no ônibus desde o início da simulação.

---

## Classe “Programa”

A classe que contém os principais métodos de inicialização e execução do programa além de carregar os dados correlacionados das demais classes como as rotas, setores e linhas que compõem o sistema.

### Métodos da classe:

● `inicializarDados()` - É o método de configuração que cria todos os objetos (Parada, Rota) e os coloca dentro das listas (ArrayList). Sem ele, o programa estaria "vazio" sem dados a serem usados/carregados.

● `listarTodosOsSetores()` - Percorre todas as paradas cadastradas e imprime os nomes dos setores únicos com paradas e linhas já definidas, para que o usuário saiba o que pode digitar e escolher dado a sua preferência.

● `buscarParadasPorSetor(String setor)` - Filtra o banco de dados. Se o usuário digitar "Norte", o método vai vasculhar a lista de dados e devolver apenas as paradas que estão no Norte, tal como as suas respectivas linhas.

● `exibirFluxoSelecao(ArrayList<Parada> paradas)` - Gerencia a interface de usuário básica. Ele mostra as opções numéricas ([0], [1], [2]...) e lê o que o usuário escolheu pela digitação através do teclado.

● `mostrarRotaDaLinha(String numLinha)` - Faz a busca final olhando diretamente para a escolha do usuário e procura na lista de rotas qual objeto tem o percurso correspondente.

● `executar()` - É o loop principal, ele garante que o programa continue rodando e só feche quando o usuário escolher a opção "0" que determina o fechamento do programa.

● `main(String[] args)` - O ponto de entrada que o Java (e o BlueJ) usa para iniciar a execução.
