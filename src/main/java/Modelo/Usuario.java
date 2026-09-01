package Modelo;

/** @author David Camargo */
public abstract class Usuario {  
    
    // Atributos Privados (Encapsulamiento)
    private String identificacion;
    private String nombre;
    private String tipoUsuario;
    private double consumoKWh;
    private double valorKWh;
    private double valorTotal;
    private String clasificacion;
    
    // CONSTRUCTOR 
    public Usuario(String identificacion, String nombre, String tipoUsuario, 
                   double consumoKWh, double valorKWh) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        this.consumoKWh = consumoKWh;
        this.valorKWh = valorKWh;
        this.valorTotal = 0.0;
        this.clasificacion = "Sin clasificar";
    }
    
    // GETTERS Y SETTERS 
    public String getIdentificacion() {
        return identificacion;
    }
    
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public double getConsumoKWh() {
        return consumoKWh;
    }
    
    public void setConsumoKWh(double consumoKWh) {
        this.consumoKWh = consumoKWh;
    }
    
    public double getValorKWh() {  // 
        return valorKWh;
    }
    
    public void setValorKWh(double valorKWh) {  
        this.valorKWh = valorKWh;
    }
    
    public double getValorTotal() {  // <
        return valorTotal;
    }
    
    public void setValorTotal(double valorTotal) {  
        this.valorTotal = valorTotal;
    }
    
    public String getClasificacion() {
        return clasificacion;
    }
    
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    
    // MÉTODO PARA CALCULAR VALOR TOTAL
    public void calcularValorTotal() {  
        this.valorTotal = this.consumoKWh * this.valorKWh;
    }
    
    // MÉTODO PARA CALCULAR CLASIFICACIÓN
    public void calcularClasificacion() {
        if (consumoKWh < 100) {
            clasificacion = "Consumo bajo";
        } else if (consumoKWh >= 100 && consumoKWh < 200) { 
            clasificacion = "Consumo moderado";
        } else if (consumoKWh >= 200 && consumoKWh < 300) {  
            clasificacion = "Consumo alto";
        } else {
            clasificacion = "Consumo muy alto";
        }
    }
    
    // MÉTODO ABSTRACT PARA POLIMORFISMO
    public abstract String obtenerInformacionAdicional();
    
    // MÉTODO PARA OBTENER DETALLES 
    public String obtenerDetalles() {
        return "Identificación: " + identificacion + 
               "\nNombre: " + nombre +
               "\nTipo de usuario: " + tipoUsuario +
               "\nConsumo mensual: " + consumoKWh + " kWh" +
               "\nValor del kWh: $" + valorKWh +
               "\nValor del consumo: $" + valorTotal +
               "\nClasificación: " + clasificacion;
    }
    
    @Override
    public String toString() {
        return identificacion + " | " + nombre + " | " + tipoUsuario + 
               " | " + consumoKWh + " | $" + valorKWh + " | $" + 
               valorTotal + " | " + clasificacion;
    }
}