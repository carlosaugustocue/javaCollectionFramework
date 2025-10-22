import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Ejemplo de uso de List: ArrayList y LinkedList
 * 
 * List es una colección ordenada que permite duplicados y acceso por índice.
 */
public class EjemploList {
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO DE ARRAYLIST ===\n");
        ejemploArrayList();
        
        System.out.println("\n=== EJEMPLO DE LINKEDLIST ===\n");
        ejemploLinkedList();
        
        System.out.println("\n=== COMPARACIÓN DE RENDIMIENTO ===\n");
        comparacionRendimiento();
    }
    
    /**
     * Demostración de ArrayList
     * ArrayList es ideal cuando se necesita acceso rápido por índice
     * y se hacen pocas inserciones/eliminaciones
     */
    public static void ejemploArrayList() {
        // Crear un ArrayList de Strings
        ArrayList<String> frutas = new ArrayList<>();
        
        // Agregar elementos (operación eficiente al final: O(1))
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Naranja");
        frutas.add("Manzana"); // Las listas permiten duplicados
        
        System.out.println("ArrayList de frutas: " + frutas);
        
        // Acceso por índice (operación muy rápida: O(1))
        String primeraFruta = frutas.get(0);
        System.out.println("Primera fruta: " + primeraFruta);
        
        // Modificar un elemento por índice
        frutas.set(1, "Pera");
        System.out.println("Después de modificar índice 1: " + frutas);
        
        // Insertar en una posición específica (operación lenta: O(n))
        // Debe mover todos los elementos posteriores
        frutas.add(2, "Uva");
        System.out.println("Después de insertar en índice 2: " + frutas);
        
        // Eliminar por índice (operación lenta: O(n))
        frutas.remove(0);
        System.out.println("Después de eliminar índice 0: " + frutas);
        
        // Eliminar por objeto (busca y elimina la primera ocurrencia)
        frutas.remove("Manzana");
        System.out.println("Después de eliminar 'Manzana': " + frutas);
        
        // Verificar si contiene un elemento
        boolean contieneUva = frutas.contains("Uva");
        System.out.println("¿Contiene 'Uva'? " + contieneUva);
        
        // Obtener tamaño
        System.out.println("Tamaño de la lista: " + frutas.size());
        
        // Iterar sobre la lista
        System.out.println("\nIterando sobre ArrayList:");
        for (String fruta : frutas) {
            System.out.println("  - " + fruta);
        }
        
        // Limpiar la lista
        frutas.clear();
        System.out.println("¿Está vacía después de clear()? " + frutas.isEmpty());
    }
    
    /**
     * Demostración de LinkedList
     * LinkedList es ideal cuando se hacen muchas inserciones/eliminaciones
     * especialmente al inicio o en medio de la lista
     */
    public static void ejemploLinkedList() {
        // Crear un LinkedList de Integers
        LinkedList<Integer> numeros = new LinkedList<>();
        
        // Agregar elementos al final
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        
        System.out.println("LinkedList inicial: " + numeros);
        
        // Agregar al inicio (operación muy eficiente: O(1))
        numeros.addFirst(5);
        System.out.println("Después de addFirst(5): " + numeros);
        
        // Agregar al final (operación muy eficiente: O(1))
        numeros.addLast(40);
        System.out.println("Después de addLast(40): " + numeros);
        
        // Obtener primer y último elemento
        System.out.println("Primer elemento: " + numeros.getFirst());
        System.out.println("Último elemento: " + numeros.getLast());
        
        // Eliminar primer y último elemento (operaciones eficientes: O(1))
        numeros.removeFirst();
        System.out.println("Después de removeFirst(): " + numeros);
        
        numeros.removeLast();
        System.out.println("Después de removeLast(): " + numeros);
        
        // LinkedList puede usarse como pila (Stack)
        System.out.println("\nUsando LinkedList como pila:");
        LinkedList<String> pila = new LinkedList<>();
        
        // Push (agregar al inicio)
        pila.push("Primero");
        pila.push("Segundo");
        pila.push("Tercero");
        System.out.println("Pila: " + pila);
        
        // Pop (eliminar del inicio)
        String tope = pila.pop();
        System.out.println("Elemento sacado: " + tope);
        System.out.println("Pila después de pop: " + pila);
        
        // LinkedList puede usarse como cola (Queue)
        System.out.println("\nUsando LinkedList como cola:");
        LinkedList<String> cola = new LinkedList<>();
        
        // Offer (agregar al final)
        cola.offer("Primero en llegar");
        cola.offer("Segundo en llegar");
        cola.offer("Tercero en llegar");
        System.out.println("Cola: " + cola);
        
        // Poll (eliminar del inicio - FIFO)
        String atendido = cola.poll();
        System.out.println("Atendido: " + atendido);
        System.out.println("Cola después de poll: " + cola);
    }
    
    /**
     * Comparación de rendimiento entre ArrayList y LinkedList
     * Demuestra cuándo usar cada una
     */
    public static void comparacionRendimiento() {
        int n = 50000;
        
        // ArrayList: Acceso por índice
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        
        long inicio = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            // Acceso aleatorio por índice (muy rápido en ArrayList)
            int valor = arrayList.get(i * 10);
        }
        long tiempoArrayList = System.nanoTime() - inicio;
        
        // LinkedList: Acceso por índice
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        
        inicio = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            // Acceso aleatorio por índice (lento en LinkedList)
            int valor = linkedList.get(i * 10);
        }
        long tiempoLinkedList = System.nanoTime() - inicio;
        
        System.out.println("Tiempo de acceso por índice (1000 operaciones):");
        System.out.println("  ArrayList: " + tiempoArrayList / 1000000.0 + " ms");
        System.out.println("  LinkedList: " + tiempoLinkedList / 1000000.0 + " ms");
        System.out.println("  ArrayList es " + (tiempoLinkedList / tiempoArrayList) + "x más rápido");
        
        // Comparar inserciones al inicio
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        inicio = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            // Insertar al inicio (lento en ArrayList)
            arrayList2.add(0, i);
        }
        long tiempoInsertArrayList = System.nanoTime() - inicio;
        
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        inicio = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            // Insertar al inicio (rápido en LinkedList)
            linkedList2.addFirst(i);
        }
        long tiempoInsertLinkedList = System.nanoTime() - inicio;
        
        System.out.println("\nTiempo de inserción al inicio (1000 operaciones):");
        System.out.println("  ArrayList: " + tiempoInsertArrayList / 1000000.0 + " ms");
        System.out.println("  LinkedList: " + tiempoInsertLinkedList / 1000000.0 + " ms");
        System.out.println("  LinkedList es " + (tiempoInsertArrayList / tiempoInsertLinkedList) + "x más rápido");
        
        System.out.println("\n*** CONCLUSIÓN ***");
        System.out.println("- Usa ArrayList para acceso frecuente por índice");
        System.out.println("- Usa LinkedList para inserciones/eliminaciones frecuentes al inicio/medio");
    }
}
