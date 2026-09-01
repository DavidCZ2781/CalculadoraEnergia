
package Utilidades;

public class ValidadorEntradas {
    
    //Comprobar que el campo no esta Vacio
    public static boolean esTextoValido(String texto){
        return texto != null && !texto.trim().isEmpty();
    }
    //Validar que el consumo sea mayor a 0
    public static boolean esConsumoValido(double consumo) {
        return consumo > 0;
    }
    //Validar si el valor del KWh es mayor a 0
    public static boolean esValorKwhValido(double valorKwh) {
        return valorKwh > 0;
    }
    
}
