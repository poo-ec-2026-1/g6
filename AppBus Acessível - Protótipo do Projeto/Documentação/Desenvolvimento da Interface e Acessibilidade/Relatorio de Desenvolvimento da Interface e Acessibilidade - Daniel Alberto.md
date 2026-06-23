**RELATÓRIO DA PARTE DESENVOLVIDA – INTERFACE E ACESSIBILIDADE**

**1\. Introdução**

Na minha parte do projeto, o foco ficou na interface principal do AppBus Acessível, principalmente na organização da tela e em melhorias voltadas à acessibilidade. A ideia não foi só montar uma tela que funcionasse visualmente, mas pensar em como o usuário iria interagir com ela de forma mais clara, principalmente em um sistema que lida com bastante informação ao mesmo tempo, como pontos, linhas, campos de busca e resultado de rota. Como eu também tenho deficiência visual, procurei pensar essa parte não só pelo lado técnico, mas também pelo lado de uso real, ou seja, em como a navegação poderia ficar menos confusa, mais previsível e mais confortável para quem depende de uma interface bem organizada para conseguir usar o sistema de forma autônoma.

**2\. Objetivo da parte desenvolvida**

O objetivo da minha parte foi estruturar a interface de forma que as funcionalidades principais do sistema ficassem mais fáceis de entender e de usar. Em vez de deixar tudo misturado na mesma área, eu pensei na tela separando dois fluxos principais: a parte de consulta de ponto e linha, e a parte de consulta de rota. Essa divisão ajuda porque o usuário não precisa lidar com todos os elementos ao mesmo tempo, e cada área da tela passa a ter uma função mais clara. Além disso, tentei pensar essa organização com foco em acessibilidade, reduzindo excesso de informação visual, melhorando a leitura da tela e deixando o fluxo de uso menos dependente de tentativa e erro.

**3\. Arquivos envolvidos na minha parte**

A parte que eu desenvolvi se relaciona principalmente com os arquivos da interface em FXML, com a classe responsável por abrir a tela e com o controlador associado a essa interface. O FXML define a estrutura visual da aplicação; a classe principal faz a inicialização da tela; e o controlador faz a ligação entre o que aparece na interface e as ações executadas pelo sistema. Mesmo quando a lógica mais pesada fica em serviços separados, essa camada continua sendo essencial, porque é nela que o usuário realmente enxerga e utiliza o projeto. Em outras palavras, se essa parte estiver mal organizada, o restante pode até funcionar internamente, mas o uso já começa comprometido antes mesmo da lógica entrar em cena.

**4\. Como eu pensei a estrutura da interface**

Na organização da tela, eu procurei separar visualmente o sistema em duas áreas principais. A primeira é voltada à consulta de ponto e linha, com campo de pesquisa, botão de busca, lista de pontos encontrados, lista de linhas e área de resultado. A segunda é voltada à consulta de rota, com campos de origem e destino, botão para calcular a rota, área de exibição do trajeto e lista de linhas sugeridas. Essa separação não foi feita só por estética. A intenção foi tornar o uso mais lógico e evitar que a tela virasse um bloco único de informação em que o usuário precisasse adivinhar o que cada parte faz. Para quem enxerga bem, isso já é ruim; para quem depende de uma organização mais clara para conseguir se localizar, vira um problema ainda maior.

**5\. Acessibilidade e decisões de interface**

A parte de acessibilidade foi pensada principalmente na organização do fluxo de uso e na forma como os elementos aparecem para o usuário. Em um sistema como esse, não adianta apenas colocar campos e botões na tela se a navegação entre eles fica confusa ou se as funções não estão bem separadas. Por isso, procurei estruturar a interface de forma mais limpa, com agrupamento de elementos por função, distinção entre as áreas de ponto/linha e rota e uma apresentação mais previsível das informações. Pensando como usuário com deficiência visual, isso faz diferença porque reduz o esforço para localizar campos, entender o que cada botão faz e acompanhar os resultados retornados pelo sistema. A preocupação aqui não foi “enfeitar” a interface, mas fazer com que ela exigisse menos desgaste de quem precisa usá-la de verdade.

**6\. Relação da minha parte com o restante do projeto**

A minha parte não funciona isoladamente do restante do sistema. A interface depende do controlador para receber as ações do usuário e dos serviços para retornar os dados de busca, linha e rota. Então, o papel dessa camada é servir como ponte entre o usuário e a lógica do programa. Em outras palavras, ela organiza a entrada de dados, aciona as funções corretas e apresenta os resultados de forma compreensível. Por isso, mesmo não concentrando toda a lógica do projeto, essa parte é importante para o funcionamento geral, porque é nela que as outras camadas realmente chegam ao usuário. Se essa ponte falha, não adianta muito o restante estar bem resolvido nos bastidores.

**7\. Contribuição da minha parte para o projeto**

Eu considero que a principal contribuição da minha parte foi trazer uma preocupação maior com a usabilidade da interface e com a acessibilidade dentro do sistema. Em vez de pensar a tela só como um lugar para “colocar as funções”, eu procurei organizar a experiência de uso de um jeito mais coerente com a proposta do aplicativo. Isso inclui a separação dos fluxos de navegação, a distribuição dos elementos na tela e a tentativa de tornar o uso mais claro para quem vai consultar ponto, linha ou rota. Dentro do contexto do projeto, essa parte ajuda a transformar a lógica do sistema em uma aplicação mais utilizável de fato, e não só em algo que funciona tecnicamente. No fim, a diferença entre uma tela apenas montada e uma interface realmente pensada para o usuário costuma aparecer justamente nesses detalhes.

.

**8\. Considerações finais**

Em resumo, a parte que eu desenvolvi no AppBus Acessível ficou centrada na organização da interface principal e na preocupação com acessibilidade dentro do sistema. O objetivo foi estruturar uma tela que não fosse apenas funcional, mas também mais clara, previsível e confortável de usar, especialmente para quem pode ter mais dificuldade na navegação visual. Como eu também vivencio essa questão na prática, tentei trazer para o projeto uma visão menos genérica e mais próxima da experiência real de uso. No fim, minha intenção foi justamente essa: contribuir para que o sistema não fosse só tecnicamente correto, mas também mais humano na forma como apresenta suas funções.