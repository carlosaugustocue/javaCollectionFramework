import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

/**
 * Ejemplo de uso de Map: HashMap y TreeMap
 * 
 * Map almacena pares clave-valor.
 * No permite claves duplicadas, pero sí valores duplicados.
 * No es parte de la interfaz Collection, sino una interfaz separada.
 */
public class EjemploMap {
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO DE HASHMAP ===\n");
        ejemploHashMap();
        
        System.out.println("\n=== EJEMPLO DE TREEMAP ===\n");
        ejemploTreeMap();
        
        System.out.println("\n=== APLICACIONES PRÁCTICAS ===\n");
        aplicacionesPracticas();
    }
    
    /**
     * Demostración de HashMap
     * HashMap es ideal cuando se necesita acceso rápido por clave
     * Operaciones: put, get, remove son O(1) en promedio
     * No garantiza ningún orden
     */
    public static void ejemploHashMap() {
        // Crear un HashMap con String como clave e Integer como valor
        HashMap<String, Integer> edades = new HashMap<>();
        
        // Agregar pares clave-valor con put()
        edades.put("Juan", 25);
        edades.put("María", 30);
        edades.put("Carlos", 28);
        edades.put("Ana", 22);
        
        System.out.println("HashMap de edades: " + edades);
        
        // Acceder a un valor por su clave (operación muy rápida: O(1))
        int edadJuan = edades.get("Juan");
        System.out.println("Edad de Juan: " + edadJuan);
        
        // Si la clave no existe, get() retorna null
        Integer edadPedro = edades.get("Pedro");
        System.out.println("Edad de Pedro: " + edadPedro); // null
        
        // Usar getOrDefault para evitar null
        int edadDefault = edades.getOrDefault("Pedro", 0);
        System.out.println("Edad de Pedro (con default): " + edadDefault);
        
        // Actualizar un valor (sobrescribe si la clave existe)
        edades.put("Juan", 26); // Juan cumplió años
        System.out.println("Edad actualizada de Juan: " + edades.get("Juan"));
        
        // Verificar si existe una clave
        boolean existeCarlos = edades.containsKey("Carlos");
        System.out.println("¿Existe Carlos? " + existeCarlos);
        
        // Verificar si existe un valor
        boolean hayAlguienCon30 = edades.containsValue(30);
        System.out.println("¿Hay alguien con 30 años? " + hayAlguienCon30);
        
        // Eliminar un par clave-valor
        Integer edadEliminada = edades.remove("Carlos");
        System.out.println("Edad eliminada de Carlos: " + edadEliminada);
        System.out.println("HashMap después de eliminar: " + edades);
        
        // Tamaño del mapa
        System.out.println("Cantidad de personas: " + edades.size());
        
        // Iterar sobre el HashMap
        System.out.println("\nIterando sobre HashMap:");
        
        // Forma 1: Iterar sobre las claves
        System.out.println("  Iterando por claves:");
        for (String nombre : edades.keySet()) {
            System.out.println("    " + nombre + " tiene " + edades.get(nombre) + " años");
        }
        
        // Forma 2: Iterar sobre los valores
        System.out.println("  Todas las edades:");
        for (Integer edad : edades.values()) {
            System.out.println("    " + edad);
        }
        
        // Forma 3: Iterar sobre las entradas (pares clave-valor) - MÁS EFICIENTE
        System.out.println("  Iterando por entradas:");
        for (Map.Entry<String, Integer> entrada : edades.entrySet()) {
            System.out.println("    " + entrada.getKey() + " -> " + entrada.getValue());
        }
        
        // putIfAbsent: solo agrega si la clave no existe
        edades.putIfAbsent("Juan", 40); // No se agrega (Juan ya existe)
        edades.putIfAbsent("Pedro", 35); // Sí se agrega (Pedro no existe)
        System.out.println("\nDespués de putIfAbsent: " + edades);
        
        // Limpiar el mapa
        edades.clear();
        System.out.println("¿Está vacío? " + edades.isEmpty());
    }
    
    /**
     * Demostración de TreeMap
     * TreeMap mantiene las claves ordenadas
     * Operaciones: put, get, remove son O(log n)
     * Útil cuando se necesita orden de claves o navegación por rangos
     */
    public static void ejemploTreeMap() {
        // Crear un TreeMap con String como clave y Double como valor
        TreeMap<String, Double> calificaciones = new TreeMap<>();
        
        // Agregar elementos en orden aleatorio
        calificaciones.put("Matemáticas", 4.5);
        calificaciones.put("Física", 3.8);
        calificaciones.put("Química", 4.2);
        calificaciones.put("Biología", 4.0);
        calificaciones.put("Historia", 4.7);
        
        // TreeMap mantiene las claves ordenadas alfabéticamente
        System.out.println("TreeMap ordenado por materia:");
        for (Map.Entry<String, Double> entrada : calificaciones.entrySet()) {
            System.out.println("  " + entrada.getKey() + ": " + entrada.getValue());
        }
        
        // Obtener primera y última clave
        System.out.println("\nPrimera materia (alfabéticamente): " + calificaciones.firstKey());
        System.out.println("Última materia (alfabéticamente): " + calificaciones.lastKey());
        
        // Obtener primera y última entrada completa
        System.out.println("Primera entrada: " + calificaciones.firstEntry());
        System.out.println("Última entrada: " + calificaciones.lastEntry());
        
        // Navegación por rangos de claves
        System.out.println("\nNavegación por rangos:");
        
        // Materias desde el inicio hasta "Historia" (excluida)
        System.out.println("Antes de 'Historia': " + calificaciones.headMap("Historia"));
        
        // Materias desde "Física" hasta el final
        System.out.println("Desde 'Física': " + calificaciones.tailMap("Física"));
        
        // Materias entre "Biología" y "Matemáticas"
        System.out.println("Entre 'Biología' y 'Matemáticas': " 
            + calificaciones.subMap("Biología", "Matemáticas"));
        
        // Métodos de navegación
        System.out.println("\nMétodos de navegación:");
        System.out.println("Clave menor o igual a 'Inglés': " 
            + calificaciones.floorKey("Inglés")); // Historia
        System.out.println("Clave mayor o igual a 'Inglés': " 
            + calificaciones.ceilingKey("Inglés")); // Matemáticas
        
        // TreeMap con Integer como clave (orden numérico)
        System.out.println("\nTreeMap con claves numéricas:");
        TreeMap<Integer, String> meses = new TreeMap<>();
        meses.put(3, "Marzo");
        meses.put(1, "Enero");
        meses.put(12, "Diciembre");
        meses.put(7, "Julio");
        
        System.out.println("Meses ordenados: " + meses);
        
        // Orden descendente
        System.out.println("Orden descendente: " + calificaciones.descendingMap());
    }
    
    /**
     * Aplicaciones prácticas de Map
     */
    public static void aplicacionesPracticas() {
        // 1. Contador de frecuencias (contar ocurrencias de palabras)
        System.out.println("1. Contador de frecuencias:");
        String texto = "java es genial java es poderoso java es versátil";
        HashMap<String, Integer> frecuencias = new HashMap<>();
        
        String[] palabras = texto.split(" ");
        for (String palabra : palabras) {
            // Incrementar contador o inicializar en 1
            frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
        }
        
        System.out.println("Texto: " + texto);
        System.out.println("Frecuencias:");
        for (Map.Entry<String, Integer> entrada : frecuencias.entrySet()) {
            System.out.println("  '" + entrada.getKey() + "': " + entrada.getValue() + " veces");
        }
        
        // 2. Diccionario de traducción
        System.out.println("\n2. Diccionario Español-Inglés:");
        HashMap<String, String> diccionario = new HashMap<>();
        diccionario.put("perro", "dog");
        diccionario.put("gato", "cat");
        diccionario.put("casa", "house");
        diccionario.put("carro", "car");
        
        String[] palabrasTraducir = {"perro", "casa", "avión", "gato"};
        for (String palabra : palabrasTraducir) {
            String traduccion = diccionario.getOrDefault(palabra, "traducción no disponible");
            System.out.println("  " + palabra + " -> " + traduccion);
        }
        
        // 3. Directorio telefónico
        System.out.println("\n3. Directorio telefónico:");
        HashMap<String, String> directorio = new HashMap<>();
        directorio.put("Juan Pérez", "555-1234");
        directorio.put("María García", "555-5678");
        directorio.put("Carlos López", "555-9012");
        
        String buscar = "María García";
        if (directorio.containsKey(buscar)) {
            System.out.println("Teléfono de " + buscar + ": " + directorio.get(buscar));
        }
        
        // 4. Caché de resultados (evitar cálculos repetidos)
        System.out.println("\n4. Caché de factorial:");
        HashMap<Integer, Long> cacheFactorial = new HashMap<>();
        
        int[] numerosCalcular = {5, 3, 7, 5, 3}; // Hay repetidos
        for (int n : numerosCalcular) {
            if (cacheFactorial.containsKey(n)) {
                System.out.println("Factorial de " + n + " (desde caché): " 
                    + cacheFactorial.get(n));
            } else {
                long factorial = calcularFactorial(n);
                cacheFactorial.put(n, factorial);
                System.out.println("Factorial de " + n + " (calculado): " + factorial);
            }
        }
        
        // 5. Agenda de eventos ordenada por fecha
        System.out.println("\n5. Agenda de eventos (TreeMap con orden por fecha):");
        TreeMap<String, String> agenda = new TreeMap<>();
        
        // Formato: AAAA-MM-DD para que se ordene cronológicamente
        agenda.put("2025-10-25", "Examen de Programación");
        agenda.put("2025-10-22", "Entrega de proyecto");
        agenda.put("2025-11-01", "Inicio de vacaciones");
        agenda.put("2025-10-28", "Presentación del trabajo");
        
        System.out.println("Eventos ordenados cronológicamente:");
        for (Map.Entry<String, String> evento : agenda.entrySet()) {
            System.out.println("  " + evento.getKey() + ": " + evento.getValue());
        }
        
        // 6. Inventario de productos
        System.out.println("\n6. Sistema de inventario:");
        HashMap<String, Producto> inventario = new HashMap<>();
        
        inventario.put("LAP001", new Producto("Laptop Dell", 1200.0, 15));
        inventario.put("MOU002", new Producto("Mouse Logitech", 25.0, 50));
        inventario.put("TEC003", new Producto("Teclado Mecánico", 80.0, 30));
        
        String codigoBuscar = "LAP001";
        if (inventario.containsKey(codigoBuscar)) {
            Producto p = inventario.get(codigoBuscar);
            System.out.println("Producto encontrado: " + p);
            
            // Actualizar cantidad
            p.cantidad -= 1;
            System.out.println("Después de vender 1 unidad: " + p);
        }
    }
    
    /**
     * Método auxiliar para calcular factorial
     */
    private static long calcularFactorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}

/**
 * Clase auxiliar para representar un producto
 */
class Producto {
    String nombre;
    double precio;
    int cantidad;
    
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString() {
        return nombre + " - $" + precio + " (Stock: " + cantidad + ")";
    }
}
