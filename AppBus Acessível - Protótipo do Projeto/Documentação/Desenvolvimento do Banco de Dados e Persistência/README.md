# Relatório de Desenvolvimento do Banco de Dados e Persistência

Parte do projeto direcionada à interface e operações CRUD do projeto, esta parte é designada ao membro Juan Victor Bastos Oliveira (202604054).

---

## 1. Atribuição de cargo e tarefas

Durante o desenvolvimento do sistema **AppBus Acessível**, fui responsável pela implementação das interfaces gráficas voltadas ao gerenciamento de informações do sistema, utilizando **JavaFX**.

Minhas responsabilidades incluíam:
* Desenvolvimento das telas administrativas;
* Implementação de operações de cadastro, visualização, atualização e remoção de dados (CRUD);
* Manipulação de dados através de `TableView` e `ObservableList`;
* Integração das interfaces com as entidades do sistema;
* Organização da exibição das informações relacionadas a pontos e linhas de ônibus.

Na prática, desenvolvi telas que permitem ao administrador visualizar e manipular registros de forma intuitiva, simulando o comportamento esperado do sistema antes da integração definitiva com a camada de persistência.

---

## 2. Contribuição de acordo com a atribuição

Minha principal contribuição foi a implementação das interfaces responsáveis pelo gerenciamento dos dados de transporte.

### 2.1 AppAcessivel
A classe `AppAcessivel` foi desenvolvida para realizar a listagem e o cadastro de pontos de ônibus. Sua lógica funciona da seguinte forma:
* Os dados são carregados inicialmente pela classe `APIVirtual`;
* Os registros são armazenados em uma `ObservableList`;
* A `TableView` exibe automaticamente os elementos presentes nessa lista;
* O formulário permite a criação de novos objetos da classe `PontoOnibus`;
* Ao inserir um novo registro, a tabela é atualizada dinamicamente sem necessidade de reiniciar a aplicação.

Essa implementação demonstra a integração entre a interface gráfica e as estruturas de dados utilizadas pelo sistema.

### 2.2 AppCRUD
A classe `AppCRUD` foi desenvolvida para fornecer um painel administrativo mais completo. O sistema utiliza abas separadas para gerenciar:
* Pontos de ônibus;
* Linhas de ônibus.

Para ambas as entidades foram implementadas as operações CRUD:
* **Create (Inserir):** Permite adicionar novos registros através dos formulários disponíveis na interface.
* **Read (Consultar):** Exibe todos os registros cadastrados utilizando `TableView`.
* **Update (Atualizar):** Permite alterar informações de um registro previamente selecionado.
* **Delete (Excluir):** Remove registros da lista exibida na aplicação.

Além disso, foi implementado o preenchimento automático dos campos do formulário ao selecionar um item da tabela, facilitando a edição dos dados.

### Estrutura e interação das classes
O funcionamento geral ocorre da seguinte forma:
1. A `APIVirtual` fornece os dados iniciais;
2. Os dados são armazenados em `ObservableList`;
3. As entidades `PontoOnibus` e `LinhaOnibus` representam os objetos manipulados;
4. As `TableViews` exibem essas informações ao usuário;
5. Os formulários criam ou modificam objetos;
6. As listas observáveis atualizam automaticamente a interface.

Essa arquitetura facilita a futura integração com banco de dados e outras funcionalidades do sistema.

### Principais dificuldades
As principais dificuldades encontradas foram:
* Aprender a utilizar os componentes do JavaFX;
* Configurar corretamente as `TableViews`;
* Integrar os formulários com as estruturas de dados;
* Garantir a atualização dinâmica da interface;
* Organizar o código para suportar futuras expansões do sistema.

---

## 3. Contribuição além do atribuído

Além do desenvolvimento das interfaces e operações CRUD, participei da integração entre diferentes componentes do projeto.

Também contribuí para a definição da estrutura das entidades utilizadas pela aplicação, auxiliando na organização dos dados e na preparação da arquitetura para futuras funcionalidades.

As interfaces desenvolvidas serviram como base para testes e validação das entidades do sistema, permitindo que outros módulos pudessem ser integrados posteriormente.

---

## 4. Considerações gerais

O desenvolvimento deste módulo permitiu aprofundar conhecimentos em:
* Programação orientada a objetos;
* Desenvolvimento de interfaces gráficas com JavaFX;
* Manipulação de coleções observáveis;
* Estruturação de sistemas utilizando entidades e componentes reutilizáveis;
* Implementação de operações CRUD.

Durante o projeto também foi possível compreender melhor a importância da separação entre interface, regras de negócio e armazenamento de dados.

### Funcionalidades futuras pendentes
As seguintes funcionalidades ainda não foram implementadas e constituem trabalhos futuros do projeto:
* Persistência permanente de dados;
* Sistema de usuários;
* Gerenciamento de favoritos;
* Histórico de rotas consultadas;
* Preferências personalizadas do usuário;
* Sistema de login e autenticação;
* Integração com banco de dados;
* Sincronização de informações entre sessões.

---

## Conclusão

As funcionalidades desenvolvidas estabeleceram a base da camada de interação do sistema, permitindo o gerenciamento visual dos dados de transporte e preparando a aplicação para futuras integrações com mecanismos de persistência duráveis.