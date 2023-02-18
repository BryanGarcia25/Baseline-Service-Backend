package practicascloud.baselineservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inversiones {
    
    private double inversionInicial;
    private double aportacionAnual;
    private double porcentajeIncremento;
    private int aniosInversion;
    private double rendimientoInversion;

}
