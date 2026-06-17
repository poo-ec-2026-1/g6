# Relatório de desenvolvimento da interface visual
## 1. Escopo da interface
O objetivo das duas classes relacionadas à interface visual é relacionar as demais classes do programa com a interface criada pelo arquivo fxml, além de criar e configurar a interface interativa do programa.
## 2. Contextualização - IDEs e Programas Auixiliares
Para a programaçao convencional foram utilizados IDEs como BlueJ e VSCode.

Para a construção da interface visual (sem interação com o código direto) foi utilizado o programa SceneBuilder, através da criação de um arquivo fxml.
## 3. Abordagem de programação
Para uma construção sistêmica e organizada do sistema foi usada uma arquitetura que separa a visão da tela do controle da tela e do arquivo responsável pela construção dos aparatos visuais.

A classe ControleTela.java é responsável pelo controle das interações entre o usuário e o programa, construindo uma ponte entre os aspectos visuais e os métodos internos do programa.

A classe TelaPrograma.java carrega o arquivo fxml e monta a janela do programa.

O arquivo fxml descreve como é o layout do programa.
## 4. Interações internas do programa
