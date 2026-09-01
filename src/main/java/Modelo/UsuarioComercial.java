package Modelo;

public class UsuarioComercial extends Usuario {
    
    private String rubroNegocio;
    private String nit;
    private boolean tieneDescuento;
    
    public UsuarioComercial(String identificacion, String nombre, 
                            double consumoKWh, double valorKWh, 
                            String rubroNegocio, String nit) {
        super(identificacion, nombre, "Comercial", consumoKWh, valorKWh);
        this.rubroNegocio = rubroNegocio;
        this.nit = nit;
        this.tieneDescuento = false;
    }
    
    public String getRubroNegocio() {
        return rubroNegocio;
    }
    
    public void setRubroNegocio(String rubroNegocio) {
        this.rubroNegocio = rubroNegocio;
    }
    
    public String getNit() {
        return nit;
    }
    
    public void setNit(String nit) {
        this.nit = nit;
    }
    
    public boolean isTieneDescuento() {
        return tieneDescuento;
    }
    
    @Override
    public void calcularValorTotal() {
        super.calcularValorTotal();
        
        // Descuento del 5% si consume más de 300 kWh
        if (getConsumoKWh() > 300) {
            double descuento = getValorTotal() * 0.05;
            setValorTotal(getValorTotal() - descuento);
            tieneDescuento = true;
        }
    }
    
    @Override
    public String obtenerInformacionAdicional() {
        return "Rubro de negocio: " + rubroNegocio +
               "\nNIT: " + nit +
               "\n¿Tiene descuento?: " + (tieneDescuento ? "Sí" : "No");
    }
    
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + 
               "\n" + obtenerInformacionAdicional();
    }
}