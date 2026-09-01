package Modelo;

public class Main {
    public static void main(String[] args) {
        // 1. Crear gestor
        GestorUsuarios gestor = new GestorUsuarios();
        
        // 2. Crear usuarios
        UsuarioResidencial u1 = new UsuarioResidencial("1054789652", "Laura Martínez", 215, 850, 5);
        UsuarioComercial u2 = new UsuarioComercial("8901234567", "Tienda XYZ", 350, 850, "Comercio", "NIT-123");
        
        // 3. Calcular datos
        u1.calcularValorTotal();
        u1.calcularClasificacion();
        
        u2.calcularValorTotal();
        u2.calcularClasificacion();
        
        // 4. Guardar en gestor
        gestor.agregarUsuario(u1);
        gestor.agregarUsuario(u2);
        
        // 5. Mostrar detalles
        System.out.println("=== USUARIO 1 ===");
        System.out.println(u1.obtenerDetalles());
        System.out.println("\n=== USUARIO 2 ===");
        System.out.println(u2.obtenerDetalles());
        
        // 6. Generar reporte
        System.out.println("\n" + gestor.generarReporte());
        
        // 7. Buscar usuario
        Usuario encontrado = gestor.buscarPorIdentificacion("1054789652");
        if (encontrado != null) {
            System.out.println("\nUsuario encontrado: " + encontrado.getNombre());
        }
    }
}