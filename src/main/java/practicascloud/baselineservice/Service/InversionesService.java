package practicascloud.baselineservice.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import practicascloud.baselineservice.Model.InversionCalculada;
import practicascloud.baselineservice.Model.Inversiones;

@Service
public class InversionesService {
    
    //Nuestro método nos permitirá calcular la inversion por cada año que hemos indicado
    public List<InversionCalculada> calculandoInversion(Inversiones inversiones) {
        //Llamamos a la clase InversionCalculada que nos permitirá almacenar los resultados finales de la inversión por año
        InversionCalculada ResultadoInversion;
        //Creamos una lista que nos permitirá almacenar y retornar en el frontend todos los resultados de la inversión con el paso de los años
        List<InversionCalculada> ListaInversiones = new ArrayList<InversionCalculada>();

        //Declaramos las siguientes variables que tendran los valores iniciales de la inversión
        int Anios = inversiones.getAniosInversion(); //Años que durará la inversión
        double SaldoInicial = inversiones.getInversionInicial(); //Cantidad que empieza la inversión
        double Aportacion = inversiones.getAportacionAnual(); //Aportación destinada a la inversión
        double SaldoFinal = 0.0; //Variable que permitirá guardar la inversión final al final del año

        //Ejecuta las operaciones para calcular la inversión determinadas por los años asignados
        for (int i = 0; i < Anios; i++) {
            double Rendimiento = inversiones.getRendimientoInversion(); //Almacena de manera estática el porcentaje de rendimiento de inversión
            double PorcentajeIncremento = inversiones.getPorcentajeIncremento(); //Almacena el porcentaje de incremento de la inversión

            //Calcula el rendimiento total del año con la sumatoria de la inversion inicial, la aportación inicial destinada a la inversión 
            //y el porcentaje de rendimiento todo dividio entre 100
            Rendimiento = ((SaldoInicial + Aportacion) * Rendimiento) / 100;
            //Calcula la inversión final al momento de finalizar el año con la sumatoria de la inversión, la aportación inicial destinada a la inversión
            //y el porcentaje de rendimiento de inversión
            SaldoFinal = SaldoInicial + Aportacion + Rendimiento;
            
            //Almacenamos todos los resultados finales de la inversion dentro de nuestra clase InversionCalculada
            ResultadoInversion = new InversionCalculada((i+1), Math.ceil(SaldoInicial), Math.ceil(Aportacion), Math.ceil(Rendimiento), Math.ceil(SaldoFinal));

            //Cambiamos nuestro monto inicial de la inversión por el resultado de la inversión del final del año
            SaldoInicial = SaldoFinal;
            //Cambiamos la aportación inicial por una nueva aportación calculada de la aportación inicial multiplicado por el porcentaje de incremento dividido entre 100
            Aportacion = Aportacion * (1 + (PorcentajeIncremento / 100));

            //Guardamos todos los resultados finales obtenidos de nuestros cálculos en la lista que hemos creado al inicio del método 
            ListaInversiones.add(ResultadoInversion);
        }

        //Retornamos nuestra lista de inversiones
        return ListaInversiones;
    }

}
