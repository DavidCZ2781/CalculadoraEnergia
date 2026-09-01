package Modelo;

public class UsuarioResidencial extends Usuario {
    
    private int numeroHabitantes;
    private boolean tieneSubsidio;
    
    public UsuarioResidencial(String identificacion, String nombre, 
                              double consumoKWh, double valorKWh, 
                              int numeroHabitantes) {
        super(identificacion, nombre, "Residencial", consumoKWh, valorKWh);
        this.numeroHabitantes = numeroHabitantes;
        this.tieneSubsidio = false;
    }
    
    public int getNumeroHabitantes() {
        return numeroHabitantes;
    }
    
    public void setNumeroHabitantes(int numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }
    
    public boolean isTieneSubsidio() {
        return tieneSubsidio;
    }
    
    @Override
    public void calcularValorTotal() {
        super.calcularValorTotal();
        
        // Descuento del 10% si tiene más de 4 habitantes
        if (numeroHabitantes > 4) {
            double descuento = getValorTotal() * 0.10;
            setValorTotal(getValorTotal() - descuento);
            tieneSubsidio = true;
        }
    }
    
    @Override
    public String obtenerInformacionAdicional() {
        return "Número de habitantes: " + numeroHabitantes +
               "\n¿Tiene subsidio?: " + (tieneSubsidio ? "Sí" : "No");
    }
    
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + 
               "\n" + obtenerInformacionAdicional();
    }
}