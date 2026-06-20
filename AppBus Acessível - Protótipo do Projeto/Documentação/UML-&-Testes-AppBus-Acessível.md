# UML e Evidências/Testes de Execução - AppBus Acessível

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

# Evidências de Execução e Testes

## Capturas de Tela

### Figura 1

![image1.png](Imagens/image1.png)

### Figura 2

![image2.png](Imagens/image2.png)

### Figura 3

![image3.png](Imagens/image3.png)

### Figura 4

![image4.png](Imagens/image4.png)

### Figura 5

![image5.png](Imagens/image5.png)

### Figura 6

![image6.png](Imagens/image6.png)

### Figura 7

![image7.png](Imagens/image7.png)

### Figura 8

![image8.png](Imagens/image8.png)

### Figura 9

![image9.png](Imagens/image9.png)

### Figura 10

![image10.png](Imagens/image10.png)

### Figura 11

![image11.png](Imagens/image11.png)

### Figura 12

![image12.png](Imagens/image12.png)

### Figura 13

![image13.png](Imagens/image13.png)

### Figura 14

![image14.png](Imagens/image14.png)

### Figura 15

![Captura de tela 2026-06-10 184525.png](Imagens/Captura%20de%20tela%202026-06-10%20184525.png)

### Figura 16

![Captura de tela 2026-06-10 184529.png](Imagens/Captura%20de%20tela%202026-06-10%20184529.png)

### Figura 17

![Captura de tela 2026-06-10 184531.png](Imagens/Captura%20de%20tela%202026-06-10%20184531.png)

### Figura 18

![Captura de tela 2026-06-10 184614.png](Imagens/Captura%20de%20tela%202026-06-10%20184614.png)

### Figura 19

![Captura de tela 2026-06-10 184625.png](Imagens/Captura%20de%20tela%202026-06-10%20184625.png)

### Figura 20

![Captura de tela 2026-06-10 184648.png](Imagens/Captura%20de%20tela%202026-06-10%20184648.png)

### Figura 21

![Captura de tela 2026-06-10 184729.png](Imagens/Captura%20de%20tela%202026-06-10%20184729.png)

### Figura 22

![Captura de tela 2026-06-10 184741.png](Imagens/Captura%20de%20tela%202026-06-10%20184741.png)

### Figura 23

![Captura de tela 2026-06-10 184755.png](Imagens/Captura%20de%20tela%202026-06-10%20184755.png)

### Figura 24

![Captura de tela 2026-06-10 184815.png](Imagens/Captura%20de%20tela%202026-06-10%20184815.png)

### Figura 25

![Captura de tela 2026-06-10 184836.png](Imagens/Captura%20de%20tela%202026-06-10%20184836.png)

### Figura 26

![Captura de tela 2026-06-10 190214.png](Imagens/Captura%20de%20tela%202026-06-10%20190214.png)


## Observações dos Testes

As imagens apresentadas demonstram:

- Execução da interface gráfica JavaFX;
- Consulta de pontos de ônibus;
- Exibição de linhas associadas aos pontos;
- Cálculo de rotas entre setores;
- Simulação de previsão de chegada;
- Validação das funcionalidades principais do sistema.
