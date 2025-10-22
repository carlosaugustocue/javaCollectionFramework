import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Comparator;

/**
 * Ejemplo de uso de Queue/Deque: LinkedList, ArrayDeque y PriorityQueue
 * 
 * Queue (Cola) es una colección diseñada para mantener elementos
 * antes de procesarlos. Típicamente sigue el orden FIFO (First-In-First-Out).
 * 
 * Deque (Double-Ended Queue) permite inserción y eliminación en ambos extremos.
 */
public class EjemploQueue {
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO DE QUEUE (LINKEDLIST) ===\n");
        ejemploQueueBasico();
        
        System.out.println("\n=== EJEMPLO DE DEQUE (ARRAYDEQUE) ===\n");
        ejemploDeque();
        
        System.out.println("\n=== EJEMPLO DE PRIORITYQUEUE ===\n");
        ejemploPriorityQueue();
        
        System.out.println("\n=== APLICACIONES PRÁCTICAS ===\n");
        aplicacionesPracticas();
    }
    
    /**
     * Demostración de Queue usando LinkedList
     * Queue es ideal para implementar sistemas FIFO (First-In-First-Out)
     * como colas de atención, procesamiento de tareas, etc.
     */
    public static void ejemploQueueBasico() {
        // LinkedList implementa la interfaz Queue
        Queue<String> cola = new LinkedList<>();
        
        // Agregar elementos al final de la cola con offer()
        // offer() es preferible a add() porque retorna false si falla
        // en lugar de lanzar excepción
        cola.offer("Cliente 1");
        cola.offer("Cliente 2");
        cola.offer("Cliente 3");
        cola.offer("Cliente 4");
        
        System.out.println("Cola inicial: " + cola);
        System.out.println("Tamaño de la cola: " + cola.size());
        
        // Ver el primer elemento sin eliminarlo con peek()
        // peek() retorna null si la cola está vacía (no lanza excepción)
        String primero = cola.peek();
        System.out.println("Primer elemento (peek): " + primero);
        System.out.println("Cola después de peek: " + cola);
        
        // Eliminar y obtener el primer elemento con poll()
        // poll() retorna null si la cola está vacía (no lanza excepción)
        String atendido = cola.poll();
        System.out.println("\nAtendiendo: " + atendido);
        System.out.println("Cola después de poll: " + cola);
        
        // Procesar todos los elementos de la cola
        System.out.println("\nAtendiendo a todos los clientes:");
        while (!cola.isEmpty()) {
            String cliente = cola.poll();
            System.out.println("  Atendiendo: " + cliente);
        }
        
        System.out.println("¿Cola vacía? " + cola.isEmpty());
        
        // Intentar poll() en cola vacía (retorna null, no lanza excepción)
        String vacio = cola.poll();
        System.out.println("Poll en cola vacía: " + vacio);
        
        // Comparación de métodos de Queue:
        // add() vs offer(): add() lanza excepción, offer() retorna false
        // remove() vs poll(): remove() lanza excepción, poll() retorna null
        // element() vs peek(): element() lanza excepción, peek() retorna null
    }
    
    /**
     * Demostración de Deque (Double-Ended Queue)
     * Deque permite operaciones en ambos extremos
     * Puede usarse como pila (LIFO) o cola (FIFO)
     */
    public static void ejemploDeque() {
        // ArrayDeque es más eficiente que LinkedList para operaciones de Deque
        Deque<Integer> deque = new ArrayDeque<>();
        
        // Agregar elementos
        deque.addFirst(10);  // Agregar al inicio
        deque.addLast(20);   // Agregar al final
        deque.addFirst(5);   // Agregar al inicio
        deque.addLast(30);   // Agregar al final
        
        System.out.println("Deque: " + deque);
        // Orden: [5, 10, 20, 30]
        
        // Ver elementos en los extremos
        System.out.println("Primer elemento: " + deque.peekFirst());
        System.out.println("Último elemento: " + deque.peekLast());
        
        // Eliminar elementos de los extremos
        System.out.println("\nEliminando del inicio: " + deque.pollFirst());
        System.out.println("Deque: " + deque);
        
        System.out.println("Eliminando del final: " + deque.pollLast());
        System.out.println("Deque: " + deque);
        
        // Usar Deque como pila (LIFO - Last-In-First-Out)
        System.out.println("\n--- Usando Deque como PILA ---");
        Deque<String> pila = new ArrayDeque<>();
        
        // Push: agregar al tope de la pila
        pila.push("Plato 1");
        pila.push("Plato 2");
        pila.push("Plato 3");
        System.out.println("Pila: " + pila);
        
        // Pop: sacar del tope de la pila
        System.out.println("Sacando: " + pila.pop()); // Plato 3 (último en entrar)
        System.out.println("Sacando: " + pila.pop()); // Plato 2
        System.out.println("Pila restante: " + pila);
        
        // Usar Deque como cola (FIFO)
        System.out.println("\n--- Usando Deque como COLA ---");
        Deque<String> cola = new ArrayDeque<>();
        
        // Agregar al final (como queue normal)
        cola.offerLast("Tarea 1");
        cola.offerLast("Tarea 2");
        cola.offerLast("Tarea 3");
        System.out.println("Cola: " + cola);
        
        // Sacar del inicio (FIFO)
        System.out.println("Procesando: " + cola.pollFirst()); // Tarea 1 (primera en entrar)
        System.out.println("Cola restante: " + cola);
    }
    
    /**
     * Demostración de PriorityQueue
     * PriorityQueue es una cola donde los elementos se ordenan por prioridad
     * Los elementos con mayor prioridad se procesan primero
     * Por defecto usa orden natural (números menores tienen mayor prioridad)
     */
    public static void ejemploPriorityQueue() {
        // PriorityQueue con orden natural (números menores primero)
        PriorityQueue<Integer> colaNumeros = new PriorityQueue<>();
        
        // Agregar elementos en orden aleatorio
        colaNumeros.offer(50);
        colaNumeros.offer(10);
        colaNumeros.offer(30);
        colaNumeros.offer(20);
        colaNumeros.offer(40);
        
        System.out.println("PriorityQueue (orden natural):");
        // peek() siempre retorna el elemento de mayor prioridad (menor número)
        System.out.println("Elemento con mayor prioridad: " + colaNumeros.peek());
        
        // Procesar elementos por prioridad
        System.out.println("Procesando por prioridad:");
        while (!colaNumeros.isEmpty()) {
            System.out.println("  Procesando: " + colaNumeros.poll());
        }
        
        // PriorityQueue con Comparator personalizado (orden inverso)
        System.out.println("\nPriorityQueue con orden inverso (mayor primero):");
        PriorityQueue<Integer> colaInversa = new PriorityQueue<>(Comparator.reverseOrder());
        
        colaInversa.offer(50);
        colaInversa.offer(10);
        colaInversa.offer(30);
        colaInversa.offer(20);
        
        System.out.println("Procesando (mayor primero):");
        while (!colaInversa.isEmpty()) {
            System.out.println("  Procesando: " + colaInversa.poll());
        }
        
        // PriorityQueue con objetos personalizados
        System.out.println("\nPriorityQueue con objetos personalizados:");
        PriorityQueue<Tarea> colaTareas = new PriorityQueue<>();
        
        colaTareas.offer(new Tarea("Estudiar para examen", 5));
        colaTareas.offer(new Tarea("Hacer compras", 2));
        colaTareas.offer(new Tarea("Pagar facturas", 4));
        colaTareas.offer(new Tarea("Llamar al doctor", 3));
        
        System.out.println("Procesando tareas por prioridad:");
        while (!colaTareas.isEmpty()) {
            Tarea tarea = colaTareas.poll();
            System.out.println("  " + tarea);
        }
    }
    
    /**
     * Aplicaciones prácticas de Queue/Deque
     */
    public static void aplicacionesPracticas() {
        // 1. Sistema de atención al cliente (FIFO)
        System.out.println("1. Sistema de atención al cliente:");
        Queue<Cliente> atencion = new LinkedList<>();
        
        atencion.offer(new Cliente("Juan", "Consulta"));
        atencion.offer(new Cliente("María", "Reclamo"));
        atencion.offer(new Cliente("Pedro", "Información"));
        
        System.out.println("Clientes en espera: " + atencion.size());
        System.out.println("Atendiendo clientes:");
        while (!atencion.isEmpty()) {
            Cliente cliente = atencion.poll();
            System.out.println("  Atendiendo: " + cliente);
        }
        
        // 2. Sistema de impresión (cola de trabajos)
        System.out.println("\n2. Cola de impresión:");
        Queue<String> colaImpresion = new LinkedList<>();
        
        colaImpresion.offer("Documento1.pdf (5 páginas)");
        colaImpresion.offer("Reporte.docx (10 páginas)");
        colaImpresion.offer("Imagen.jpg (1 página)");
        
        System.out.println("Trabajos en cola: " + colaImpresion.size());
        System.out.println("Imprimiendo:");
        while (!colaImpresion.isEmpty()) {
            System.out.println("  Imprimiendo: " + colaImpresion.poll());
        }
        
        // 3. Navegación de historial (Deque como pila)
        System.out.println("\n3. Historial de navegación web:");
        Deque<String> historial = new ArrayDeque<>();
        
        // Visitar páginas (push a la pila)
        historial.push("google.com");
        historial.push("github.com");
        historial.push("stackoverflow.com");
        historial.push("youtube.com");
        
        System.out.println("Página actual: " + historial.peek());
        System.out.println("\nRetrocediendo (botón atrás):");
        historial.pop(); // youtube.com
        System.out.println("  Página actual: " + historial.peek());
        historial.pop(); // stackoverflow.com
        System.out.println("  Página actual: " + historial.peek());
        
        // 4. Sistema de prioridades de tareas
        System.out.println("\n4. Gestión de tareas con prioridad:");
        PriorityQueue<Tarea> sistemaTareas = new PriorityQueue<>();
        
        sistemaTareas.offer(new Tarea("Revisar emails", 2));
        sistemaTareas.offer(new Tarea("Bug crítico en producción", 5));
        sistemaTareas.offer(new Tarea("Reunión de equipo", 3));
        sistemaTareas.offer(new Tarea("Actualizar documentación", 1));
        sistemaTareas.offer(new Tarea("Code review urgente", 4));
        
        System.out.println("Tareas ordenadas por prioridad:");
        while (!sistemaTareas.isEmpty()) {
            System.out.println("  " + sistemaTareas.poll());
        }
        
        // 5. Sistema de emergencias médicas
        System.out.println("\n5. Sala de emergencias (triaje):");
        PriorityQueue<Paciente> emergencias = new PriorityQueue<>();
        
        emergencias.offer(new Paciente("Ana", "Gripe", 2));
        emergencias.offer(new Paciente("Carlos", "Fractura", 3));
        emergencias.offer(new Paciente("Luis", "Infarto", 5)); // Más urgente
        emergencias.offer(new Paciente("María", "Dolor leve", 1));
        emergencias.offer(new Paciente("Pedro", "Accidente grave", 5));
        
        System.out.println("Atendiendo por urgencia:");
        while (!emergencias.isEmpty()) {
            Paciente paciente = emergencias.poll();
            System.out.println("  " + paciente);
        }
        
        // 6. Buffer de procesamiento (producer-consumer)
        System.out.println("\n6. Buffer de procesamiento de datos:");
        Queue<String> buffer = new LinkedList<>();
        int capacidadMaxima = 3;
        
        // Simulación de producer
        String[] datosEntrantes = {"Dato1", "Dato2", "Dato3", "Dato4", "Dato5"};
        for (String dato : datosEntrantes) {
            if (buffer.size() < capacidadMaxima) {
                buffer.offer(dato);
                System.out.println("  Producido: " + dato + " | Buffer: " + buffer);
            } else {
                System.out.println("  Buffer lleno, procesando...");
                // Procesar (consumir) un elemento
                String procesado = buffer.poll();
                System.out.println("  Consumido: " + procesado);
                // Ahora hay espacio
                buffer.offer(dato);
                System.out.println("  Producido: " + dato + " | Buffer: " + buffer);
            }
        }
    }
}

/**
 * Clase auxiliar para representar una tarea con prioridad
 * Implementa Comparable para que PriorityQueue pueda ordenar
 */
class Tarea implements Comparable<Tarea> {
    String descripcion;
    int prioridad; // Número mayor = mayor prioridad
    
    public Tarea(String descripcion, int prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }
    
    @Override
    public int compareTo(Tarea otra) {
        // Orden descendente: mayor prioridad primero
        return Integer.compare(otra.prioridad, this.prioridad);
    }
    
    @Override
    public String toString() {
        return "[Prioridad " + prioridad + "] " + descripcion;
    }
}

/**
 * Clase auxiliar para representar un cliente
 */
class Cliente {
    String nombre;
    String motivo;
    
    public Cliente(String nombre, String motivo) {
        this.nombre = nombre;
        this.motivo = motivo;
    }
    
    @Override
    public String toString() {
        return nombre + " (" + motivo + ")";
    }
}

/**
 * Clase auxiliar para representar un paciente
 * Implementa Comparable para ordenar por urgencia
 */
class Paciente implements Comparable<Paciente> {
    String nombre;
    String condicion;
    int urgencia; // 1-5, donde 5 es más urgente
    
    public Paciente(String nombre, String condicion, int urgencia) {
        this.nombre = nombre;
        this.condicion = condicion;
        this.urgencia = urgencia;
    }
    
    @Override
    public int compareTo(Paciente otro) {
        // Orden descendente: mayor urgencia primero
        return Integer.compare(otro.urgencia, this.urgencia);
    }
    
    @Override
    public String toString() {
        return "[Urgencia " + urgencia + "] " + nombre + " - " + condicion;
    }
}
