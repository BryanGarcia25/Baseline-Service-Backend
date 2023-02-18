package practicascloud.baselineservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InversionCalculada {
    
    private int anio;
    private double saldoInicial;
    private double aportacion;
    private double rendimiento;
    private double saldoFinal;

}
