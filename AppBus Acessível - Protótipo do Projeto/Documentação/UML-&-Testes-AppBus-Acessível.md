# UML e Evidências/Testes de Execução do Protótipo - AppBus Acessível

## Diagrama de Classes

```plantuml
@startuml

skinparam classAttributeIconSize 0

interface TrafegoTransporte {
    +buscarPontos(String)
    +buscarLinhas(PontoOnibus)
    +calcularRota(String,String)
    +calcularPrevisao(LinhaOnibus,PontoOnibus)
}

class ExecutarPrograma {
    +main(String[])
    +start(Stage)
}

class TelaPrograma {
    +abrirTela()
}

class ControleTela {
    -api : APIVirtual
    -pontoSelecionado : PontoOnibus

    +initialize()
    +pesquisarPonto()
    +pesquisarSetor()
    +selecionarPonto()
    +selecionarLinha()
    +calcularRota()
}

class APIVirtual {
    -pontos : List<PontoOnibus>
    -linhas : List<LinhaOnibus>

    +buscarPontos(String)
    +buscarLinhas(PontoOnibus)
    +calcularRota(String,String)
    +calcularPrevisao(LinhaOnibus,PontoOnibus)
}

class PontoOnibus {
    -codigo : String
    -nome : String
    -setor : String
    -sigla : String
}

class LinhaOnibus {
    -numero : String
    -nome : String
    -rota : String
}

class PrevisaoOnibus {
    -tempoMinutos : int
    -distanciaMetros : double
}

class TamanhoRota {
    -distanciaKm : double
    -tempoMinutos : int
    -descricao : String
}

class OnibusModelo {
    -numero : String
    -velocidade : double
}

class OnibusComum

class OnibusEixo

ExecutarPrograma --> TelaPrograma
TelaPrograma --> ControleTela

ControleTela --> TrafegoTransporte
APIVirtual ..|> TrafegoTransporte

ControleTela --> APIVirtual

APIVirtual "1" *-- "*" PontoOnibus
APIVirtual "1" *-- "*" LinhaOnibus

APIVirtual --> PrevisaoOnibus
APIVirtual --> TamanhoRota

OnibusModelo <|-- OnibusComum
OnibusModelo <|-- OnibusEixo

LinhaOnibus "*" -- "*" PontoOnibus

@enduml
```

---

## Diagrama de Sequência - Calculo de Rota

```plantuml
@startuml

actor Usuario

participant TelaPrograma
participant ControleTela
participant APIVirtual
participant TamanhoRota

Usuario -> TelaPrograma : Informa origem e destino

TelaPrograma -> ControleTela : calcularRota()

ControleTela -> APIVirtual : calcularRota(origem,destino)

APIVirtual -> APIVirtual : normalizar setores

APIVirtual -> APIVirtual : localizar rota

APIVirtual -> APIVirtual : calcular distância

APIVirtual -> APIVirtual : calcular tempo

APIVirtual -> TamanhoRota : criar resultado

TamanhoRota --> APIVirtual : resultado

APIVirtual --> ControleTela : rota calculada

ControleTela --> TelaPrograma : atualizar resultado

@enduml
```

---

## Diagrama de Casos de Uso

```plantuml
@startuml

left to right direction

actor Usuario

rectangle "AppBus Acessível" {

    usecase "Pesquisar Ponto" as UC1
    usecase "Pesquisar Setor" as UC2
    usecase "Listar Pontos" as UC3
    usecase "Listar Linhas" as UC4
    usecase "Selecionar Linha" as UC5
    usecase "Consultar Previsão" as UC6
    usecase "Calcular Rota" as UC7
    usecase "Visualizar Distância" as UC8
    usecase "Visualizar Tempo Estimado" as UC9

}

Usuario --> UC1
Usuario --> UC2
Usuario --> UC7

UC1 --> UC4 : <<include>>
UC2 --> UC3 : <<include>>

UC3 --> UC4 : <<extend>>

UC4 --> UC5 : <<include>>

UC5 --> UC6 : <<include>>

UC7 --> UC8 : <<include>>
UC7 --> UC9 : <<include>>

@enduml
```

---

## Diagrama de Sequência - Previsão de Chegada

```plantuml
@startuml

actor Usuario

participant TelaPrograma
participant ControleTela
participant APIVirtual
participant LinhaOnibus
participant PrevisaoOnibus

Usuario -> TelaPrograma : Seleciona linha

TelaPrograma -> ControleTela : selecionarLinha()

ControleTela -> APIVirtual : calcularPrevisao()

APIVirtual -> LinhaOnibus : obter posição

LinhaOnibus --> APIVirtual : posição atual

APIVirtual -> APIVirtual : calcular distância

APIVirtual -> APIVirtual : calcular tempo

APIVirtual -> PrevisaoOnibus : criar previsão

PrevisaoOnibus --> APIVirtual

APIVirtual --> ControleTela

ControleTela --> TelaPrograma : atualizar informações

@enduml
```

---

## Diagrama de Sequência - Pesquisa de Ponto

```plantuml
@startuml

actor Usuario

participant TelaPrograma
participant ControleTela
participant APIVirtual
participant PontoOnibus
participant LinhaOnibus

Usuario -> TelaPrograma : Digita código do ponto

TelaPrograma -> ControleTela : pesquisarPonto()

ControleTela -> APIVirtual : buscarPontos(codigo)

APIVirtual -> PontoOnibus : localizar ponto

PontoOnibus --> APIVirtual : ponto encontrado

APIVirtual -> LinhaOnibus : buscar linhas do ponto

LinhaOnibus --> APIVirtual : lista de linhas

APIVirtual --> ControleTela : linhas encontradas

ControleTela --> TelaPrograma : atualizar lista

@enduml
```

---

## Diagrama dos Componentes do Programa

```plantuml
@startuml

package "Interface" {

    [TelaPrograma.fxml]
    [ControleTela]
}

package "Execução" {

    [ExecutarPrograma]
}

package "Serviços" {

    [TrafegoTransporte]
    [APIVirtual]
}

package "Domínio" {

    [PontoOnibus]
    [LinhaOnibus]
    [PrevisaoOnibus]
    [TamanhoRota]
}

package "Frota" {

    [OnibusModelo]
    [OnibusComum]
    [OnibusEixo]
}

ExecutarPrograma --> [TelaPrograma.fxml]

[TelaPrograma.fxml] --> [ControleTela]

[ControleTela] --> [TrafegoTransporte]

[TrafegoTransporte] --> [APIVirtual]

[APIVirtual] --> [PontoOnibus]
[APIVirtual] --> [LinhaOnibus]
[APIVirtual] --> [PrevisaoOnibus]
[APIVirtual] --> [TamanhoRota]

[OnibusComum] -up-|> [OnibusModelo]
[OnibusEixo] -up-|> [OnibusModelo]

@enduml
```

---

# Diagramas e Evidências de Execução/Testes

## Capturas de Tela - Testes

### Classes do Programa Vizualidadas Via BlueJ

![image1.png](Imagens/image1.png)

### Tela Inicial - Pesquisa de Ponto e Linha

![image2.png](Imagens/image2.png)

### Teste - Entrada/Saída (Nome Padrão do Setor/Ponto)

![image3.png](Imagens/image3.png)

### Teste - Entrada/Saída (Sigla do Setor/Ponto)

![image4.png](Imagens/image4.png)

### Teste - Entrada/Saída (Nome Minúsculo e Junto do Setor/Ponto)

![image5.png](Imagens/image5.png)

### Teste - Entrada/Saída (Erro: Sertor/Ponto Inválido)

![image6.png](Imagens/image6.png)

### Teste - Entrada/Saída (Simplicação do Setor/Ponto) 

![image7.png](Imagens/image7.png)

### Tela Inicial - Pesquisa de Rota

![image8.png](Imagens/image8.png)

### Teste - Entrada/Saída (Nome Padrão dos Setores/Pontos)

![image9.png](Imagens/image9.png)

### Teste - Entrada/Saída (Sigla dos Setores/Pontos)

![image10.png](Imagens/image10.png)

### Teste - Entrada/Saída (Erro: Origem Inválida)

![image11.png](Imagens/image11.png)

### Teste - Entrada/Saída (Erro: Destino Inválido)

![image12.png](Imagens/image12.png)

### Tela Inicial Ampliada - Pesquisa de Ponto e Linha

![image13.png](Imagens/image13.png)

### Tela Inicial Ampliada - Pesquisa de Rota

![image14.png](Imagens/image14.png)

## Captura de Tela - Diagramas

### Diagrama - Classes do Programa

![classes.png](Imagens/classes.png)

### Diagrama - Pesquisa de Rota

![rota.png](Imagens/rota.png)

### Diagrama - Pesquisa de Ponto

![ponto.png](Imagens/ponto.png)

### Diagrama - Casos de Uso

![uso.png](Imagens/uso.png)

### Diagrama - Previsão de Chegada

![previsão.png](Imagens/previsão.png)

### Diagrama - Componentes do Programa

![componentes.png](Imagens/componentes.png)

## Observações dos Testes

As imagens apresentadas demonstram:

- Execução da interface gráfica JavaFX;
- Consulta de pontos de ônibus;
- Exibição de linhas associadas aos pontos;
- Cálculo de rotas entre setores;
- Simulação de previsão de chegada;
- Simulação de erros possivéis do usuário;
- Validação das funcionalidades principais do sistema.
