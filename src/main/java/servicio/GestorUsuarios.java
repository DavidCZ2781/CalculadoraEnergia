package Modelo;

import java.util.ArrayList;

public class GestorUsuarios {
    private ArrayList<Usuario> listaUsuarios;
    
    public GestorUsuarios() {
        listaUsuarios = new ArrayList<>();
    }
    
    public void agregarUsuario(Usuario usuario) {
        if (usuario != null) {
            listaUsuarios.add(usuario);
        }
    }
    
    public ArrayList<Usuario> obtenerTodosUsuarios() {
        return listaUsuarios;
    }
    
    public int contarUsuarios() {
        return listaUsuarios.size();
    }
    
    public Usuario buscarPorIdentificacion(String id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdentificacion().equals(id)) {
                return usuario;
            }
        }
        return null;
    }
    
    public String generarReporte() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("╔═══════════════════════════════════════════════════════════════════════════╗\n");
        reporte.append("║                        REPORTE DE CONSUMO ELÉCTRICO                      ║\n");
        reporte.append("╚═══════════════════════════════════════════════════════════════════════════╝\n\n");
        
        if (listaUsuarios.isEmpty()) {
            reporte.append("⚠ No hay usuarios registrados.\n");
            return reporte.toString();
        }
        
        reporte.append(String.format("%-15s | %-20s | %-12s | %-10s | %-12s | %-15s | %-20s\n",
            "Identificación", "Nombre", "Tipo", "Consumo", "Valor kWh", "Valor Total", "Clasificación"));
        reporte.append("─".repeat(120)).append("\n");
        
        for (Usuario usuario : listaUsuarios) {
            reporte.append(String.format("%-15s | %-20s | %-12s | %-10.1f | $%-11.0f | $%-14.0f | %-20s\n",
                usuario.getIdentificacion(),
                usuario.getNombre(),
                usuario.getTipoUsuario(),
                usuario.getConsumoKWh(),
                usuario.getValorKWh(),
                usuario.getValorTotal(),
                usuario.getClasificacion()
            ));
        }
        
        reporte.append("─".repeat(120)).append("\n");
        reporte.append("Total de usuarios: ").append(listaUsuarios.size()).append("\n");
        
        return reporte.toString();
    }
}