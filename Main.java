import java.util.List;

public class Main {
    public static void main(String[] args) {
        ServicoTransporte servidor = new SimuladorTransporteService();
        // ====================================================================
        // TESTE O CÓDIGO AQUI: 
        // Troque o número abaixo para simular o que o usuário digitaria:
        // 101 = Bíblia | 102 = Cívica | 103 = Praça A | 104 = DERGO | 105 = Itatiaia/UFG
        // ====================================================================
        String codigoDigitadoPeloUsuario = "103"; 

        System.out.println("=========================================================");
        System.out.println("   PAINEL DE TRANSPORTE COLETIVO RMTC - GOIÂNIA  ");
        System.out.println("=========================================================");
        System.out.println("Consultando o ponto de código: " + codigoDigitadoPeloUsuario + "\n");

        List<Previsao> listaDeOnibus = servidor.consultarPrevisoesDoPonto(codigoDigitadoPeloUsuario);

        for (Previsao onibus : listaDeOnibus) {
            System.out.println("-> Ônibus: " + onibus.getLinha());
            System.out.println("   Destino: " + onibus.getDestino());
            System.out.println("   Aproximação em tempo real: " + onibus.getTempoRestanteMinutos() + " minutos.");
            System.out.println("---------------------------------------------------------");
        }
        
        System.out.println("\n[AVISO] Esta classe 'Main' serve apenas para testes.");
        System.out.println("Classe que sera apagada!");
    }
}