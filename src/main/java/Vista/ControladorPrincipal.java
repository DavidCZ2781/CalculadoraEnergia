package Controlador;

import Modelo.*;
import Vista.VentanaPrincipal;

public class ControladorPrincipal {
    private GestorUsuarios gestor;
    private VentanaPrincipal vista;
    
    public ControladorPrincipal(GestorUsuarios gestor, VentanaPrincipal vista) {
        this.gestor = gestor;
        this.vista = vista;
    }
    
    public void registrarUsuario() {
        try {
            // 1. Obtener datos de la vista
            String identificacion = vista.getTxtIdentificacion().getText();
            String nombre = vista.getTxtNombre().getText();
            String tipo = vista.getCboTipoUsuario().getSelectedItem().toString();
            double consumo = Double.parseDouble(vista.getTxtConsumo().getText());
            double valorKWh = Double.parseDouble(vista.getTxtValorKWh().getText());
            
            // 2. Validar datos
            if (identificacion.isEmpty() || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(vista, 
                    "Identificación y nombre son obligatorios", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // 3. Crear el usuario según el tipo
            Usuario nuevoUsuario;
            if (tipo.equals("Residencial")) {
                int habitantes = Integer.parseInt(vista.getTxtHabitantes().getText());
                nuevoUsuario = new UsuarioResidencial(
                    identificacion, nombre, consumo, valorKWh, habitantes
                );
            } else {
                String rubro = vista.getTxtRubro().getText();
                String nit = vista.getTxtNit().getText();
                nuevoUsuario = new UsuarioComercial(
                    identificacion, nombre, consumo, valorKWh, rubro, nit
                );
            }
            
            // 4. Calcular todo
            nuevoUsuario.calcularValorTotal();
            nuevoUsuario.calcularClasificacion();
            
            // 5. GUARDAR EN EL GESTOR - ATRIBUTO 1 EN ACCIÓN
            gestor.agregarUsuario(nuevoUsuario);
            
            // 6. GUARDAR COMO USUARIO ACTUAL - ATRIBUTO 2 EN ACCIÓN
            vista.setUsuarioActual(nuevoUsuario);
            
            // 7. Mostrar resultado
            mostrarResultado(nuevoUsuario);
            
            // 8. Limpiar campos
            vista.limpiarCampos();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista,
                "Error: Ingrese valores numéricos válidos",
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista,
                "Error: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrarResultado(Usuario usuario) {
        // Mostrar en la interfaz los detalles del usuario
        String mensaje = "=== REGISTRO EXITOSO ===\n\n";
        mensaje += usuario.obtenerDetalles();
        
        // Mostrar en el área de texto de la ventana
        vista.getTxtResultado().setText(mensaje);
        
        // También mostrar en un diálogo
        JOptionPane.showMessageDialog(vista, mensaje, 
            "Resultado del Registro", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void generarReporte() {
        // ATRIBUTO 1 en acción - generar reporte con todos los usuarios
        String reporte = gestor.generarReporte();
        vista.getTxtResultado().setText(reporte);
    }
    
    public void buscarUsuario(String identificacion) {
        // ATRIBUTO 1 y 2 en acción
        Usuario encontrado = gestor.buscarPorIdentificacion(identificacion);
        if (encontrado != null) {
            vista.setUsuarioActual(encontrado);
            vista.mostrarUsuarioEncontrado(encontrado);
        } else {
            JOptionPane.showMessageDialog(vista,
                "Usuario no encontrado",
                "Búsqueda", JOptionPane.WARNING_MESSAGE);
        }
    }
}