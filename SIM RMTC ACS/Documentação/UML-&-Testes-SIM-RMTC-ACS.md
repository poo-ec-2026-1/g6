# Complemento UML e Evidências/Testes de Execução - SIM RMTC Acessível

## Diagrama de Classes (PlantUML)

```plantuml
@startuml

interface TrafegoTransporte

class APIVirtual
class ControleTela
class TelaPrograma
class ExecutarPrograma
class ExecutarTerminal

abstract class OnibusModelo
class OnibusComum
class OnibusEixo

class LinhaOnibus
class PontoOnibus
class PrevisaoOnibus
class TamanhoRota

APIVirtual ..|> TrafegoTransporte

ControleTela --> TrafegoTransporte
ControleTela --> PontoOnibus

APIVirtual --> LinhaOnibus
APIVirtual --> PontoOnibus
APIVirtual --> PrevisaoOnibus
APIVirtual --> TamanhoRota

LinhaOnibus --> PontoOnibus
LinhaOnibus --> OnibusModelo

OnibusComum --|> OnibusModelo
OnibusEixo --|> OnibusModelo

ExecutarPrograma --> TelaPrograma
ExecutarTerminal --> APIVirtual
TelaPrograma --> ControleTela

@enduml
```

---

## Diagrama de Sequência - Consulta de Rota

```plantuml
@startuml

actor Usuario

Usuario -> ControleTela : Informa origem e destino
ControleTela -> APIVirtual : calcularRota(origem,destino)
APIVirtual -> APIVirtual : Processa matriz de setores
APIVirtual --> ControleTela : TamanhoRota
ControleTela --> Usuario : Exibe distância e tempo

@enduml
```

---

## Diagrama de Casos de Uso

```plantuml
@startuml

left to right direction

actor Usuario

rectangle "SIM RMTC Acessível" {
    usecase "Pesquisar Ponto" as UC1
    usecase "Visualizar Linhas" as UC2
    usecase "Consultar Previsão" as UC3
    usecase "Calcular Rota" as UC4
    usecase "Listar Setores" as UC5
}

Usuario --> UC1
Usuario --> UC2
Usuario --> UC3
Usuario --> UC4
Usuario --> UC5

@enduml
```

---

# Evidências de Execução e Testes

## Capturas de Tela

### Figura 1

![Captura de tela 2026-06-10 183257.png](Imagens/Captura de tela 2026-06-10 183257.png)

### Figura 2

![Captura de tela 2026-06-10 184228.png](Imagens/Captura de tela 2026-06-10 184228.png)

### Figura 3

![Captura de tela 2026-06-10 184242.png](Imagens/Captura de tela 2026-06-10 184242.png)

### Figura 4

![Captura de tela 2026-06-10 184302.png](Imagens/Captura de tela 2026-06-10 184302.png)

### Figura 5

![Captura de tela 2026-06-10 184452.png](Imagens/Captura de tela 2026-06-10 184452.png)

### Figura 6

![Captura de tela 2026-06-10 184456.png](Imagens/Captura de tela 2026-06-10 184456.png)

### Figura 7

![Captura de tela 2026-06-10 184459.png](Imagens/Captura de tela 2026-06-10 184459.png)

### Figura 8

![Captura de tela 2026-06-10 184503.png](Imagens/Captura de tela 2026-06-10 184503.png)

### Figura 9

![Captura de tela 2026-06-10 184506.png](Imagens/Captura de tela 2026-06-10 184506.png)

### Figura 10

![Captura de tela 2026-06-10 184510.png](Imagens/Captura de tela 2026-06-10 184510.png)

### Figura 11

![Captura de tela 2026-06-10 184513.png](Imagens/Captura de tela 2026-06-10 184513.png)

### Figura 12

![Captura de tela 2026-06-10 184516.png](Imagens/Captura de tela 2026-06-10 184516.png)

### Figura 13

![Captura de tela 2026-06-10 184519.png](Imagens/Captura de tela 2026-06-10 184519.png)

### Figura 14

![Captura de tela 2026-06-10 184522.png](Imagens/Captura de tela 2026-06-10 184522.png)

### Figura 15

![Captura de tela 2026-06-10 184525.png](Imagens/Captura de tela 2026-06-10 184525.png)

### Figura 16

![Captura de tela 2026-06-10 184529.png](Imagens/Captura de tela 2026-06-10 184529.png)

### Figura 17

![Captura de tela 2026-06-10 184531.png](Imagens/Captura de tela 2026-06-10 184531.png)

### Figura 18

![Captura de tela 2026-06-10 184614.png](Imagens/Captura de tela 2026-06-10 184614.png)

### Figura 19

![Captura de tela 2026-06-10 184625.png](Imagens/Captura de tela 2026-06-10 184625.png)

### Figura 20

![Captura de tela 2026-06-10 184648.png](Imagens/Captura de tela 2026-06-10 184648.png)

### Figura 21

![Captura de tela 2026-06-10 184729.png](Imagens/Captura de tela 2026-06-10 184729.png)

### Figura 22

![Captura de tela 2026-06-10 184741.png](Imagens/Captura de tela 2026-06-10 184741.png)

### Figura 23

![Captura de tela 2026-06-10 184755.png](Imagens/Captura de tela 2026-06-10 184755.png)

### Figura 24

![Captura de tela 2026-06-10 184815.png](Imagens/Captura de tela 2026-06-10 184815.png)

### Figura 25

![Captura de tela 2026-06-10 184836.png](Imagens/Captura de tela 2026-06-10 184836.png)

### Figura 26

![Captura de tela 2026-06-10 190214.png](Imagens/Captura de tela 2026-06-10 190214.png)


## Observações dos Testes

As Imagens apresentadas demonstram:

- Execução da interface gráfica JavaFX;
- Consulta de pontos de ônibus;
- Exibição de linhas associadas aos pontos;
- Cálculo de rotas entre setores;
- Simulação de previsão de chegada;
- Validação das funcionalidades principais do sistema.
