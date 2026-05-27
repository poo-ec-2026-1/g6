import java.util.List;

// ===== CONCEITO DE POO: INTERFACE (CONTRATO) =====
public interface ServicoTransporte {
    // Nome bem claro e idêntico para todo o sistema
    List<Previsao> consultarPrevisoesDoPonto(String codigoDoPonto);
}