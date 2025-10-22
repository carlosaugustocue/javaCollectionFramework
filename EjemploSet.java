import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Arrays;

/**
 * Ejemplo de uso de Set: HashSet y TreeSet
 * 
 * Set es una colección que NO permite elementos duplicados.
 * Es ideal para verificar existencia de elementos y eliminar duplicados.
 */
public class EjemploSet {
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO DE HASHSET ===\n");
        ejemploHashSet();
        
        System.out.println("\n=== EJEMPLO DE TREESET ===\n");
        ejemploTreeSet();
        
        System.out.println("\n=== APLICACIONES PRÁCTICAS ===\n");
        aplicacionesPracticas();
    }
    
    /**
     * Demostración de HashSet
     * HashSet es ideal cuando se necesita velocidad y no importa el orden
     * Operaciones: add, remove, contains son O(1) en promedio
     */
    public static void ejemploHashSet() {
        // Crear un HashSet de Strings
        HashSet<String> paises = new HashSet<>();
        
        // Agregar elementos (orden no garantizado)
        paises.add("Colombia");
        paises.add("México");
        paises.add("Argentina");
        paises.add("Colombia"); // Intento de duplicado - será ignorado
        paises.add("Brasil");
        
        System.out.println("HashSet de países: " + paises);
        System.out.println("Tamaño: " + paises.size()); // 4, no 5 (duplicado ignorado)
        
        // Verificar existencia (operación muy rápida: O(1))
        boolean tieneColombia = paises.contains("Colombia");
        System.out.println("¿Contiene 'Colombia'? " + tieneColombia);
        
        boolean tieneChile = paises.contains("Chile");
        System.out.println("¿Contiene 'Chile'? " + tieneChile);
        
        // Eliminar elemento
        boolean eliminado = paises.remove("México");
        System.out.println("¿Se eliminó 'México'? " + eliminado);
        System.out.println("HashSet después de eliminar: " + paises);
        
        // Iterar sobre el HashSet (orden no garantizado)
        System.out.println("\nIterando sobre HashSet:");
        for (String pais : paises) {
            System.out.println("  - " + pais);
        }
        
        // Operaciones de conjuntos
        HashSet<String> otrosPaises = new HashSet<>();
        otrosPaises.add("Colombia");
        otrosPaises.add("Chile");
        otrosPaises.add("Perú");
        
        // Unión (addAll)
        HashSet<String> union = new HashSet<>(paises);
        union.addAll(otrosPaises);
        System.out.println("\nUnión de conjuntos: " + union);
        
        // Intersección (retainAll)
        HashSet<String> interseccion = new HashSet<>(paises);
        interseccion.retainAll(otrosPaises);
        System.out.println("Intersección: " + interseccion);
        
        // Diferencia (removeAll)
        HashSet<String> diferencia = new HashSet<>(paises);
        diferencia.removeAll(otrosPaises);
        System.out.println("Diferencia (paises - otrosPaises): " + diferencia);
    }
    
    /**
     * Demostración de TreeSet
     * TreeSet mantiene los elementos ordenados automáticamente
     * Operaciones: add, remove, contains son O(log n)
     * Útil cuando se necesita orden natural o navegación por rangos
     */
    public static void ejemploTreeSet() {
        // Crear un TreeSet de Integers
        TreeSet<Integer> numeros = new TreeSet<>();
        
        // Agregar elementos en orden aleatorio
        numeros.add(50);
        numeros.add(20);
        numeros.add(80);
        numeros.add(10);
        numeros.add(30);
        numeros.add(20); // Duplicado - será ignorado
        
        // TreeSet mantiene orden natural (ascendente)
        System.out.println("TreeSet ordenado: " + numeros);
        
        // Obtener primer y último elemento
        System.out.println("Primer elemento (mínimo): " + numeros.first());
        System.out.println("Último elemento (máximo): " + numeros.last());
        
        // Navegación por rangos
        System.out.println("\nNavegación por rangos:");
        
        // Elementos menores que 50
        System.out.println("Menores que 50: " + numeros.headSet(50));
        
        // Elementos mayores o iguales a 30
        System.out.println("Mayores o iguales a 30: " + numeros.tailSet(30));
        
        // Elementos entre 20 y 60 (20 incluido, 60 excluido)
        System.out.println("Entre 20 y 60: " + numeros.subSet(20, 60));
        
        // Métodos de navegación
        System.out.println("\nMétodos de navegación:");
        System.out.println("Menor o igual a 25: " + numeros.floor(25)); // 20
        System.out.println("Mayor o igual a 25: " + numeros.ceiling(25)); // 30
        System.out.println("Menor estricto que 30: " + numeros.lower(30)); // 20
        System.out.println("Mayor estricto que 30: " + numeros.higher(30)); // 50
        
        // TreeSet con Strings (orden alfabético)
        System.out.println("\nTreeSet con orden alfabético:");
        TreeSet<String> nombres = new TreeSet<>();
        nombres.add("Carlos");
        nombres.add("Ana");
        nombres.add("Beatriz");
        nombres.add("Daniel");
        
        System.out.println("Nombres ordenados: " + nombres);
        
        // Orden descendente
        System.out.println("Orden descendente: " + numeros.descendingSet());
    }
    
    /**
     * Aplicaciones prácticas de Set
     */
    public static void aplicacionesPracticas() {
        // 1. Eliminar duplicados de una lista
        System.out.println("1. Eliminar duplicados:");
        Integer[] numerosConDuplicados = {1, 2, 3, 2, 4, 1, 5, 3, 6, 4};
        HashSet<Integer> sinDuplicados = new HashSet<>(Arrays.asList(numerosConDuplicados));
        System.out.println("Array original: " + Arrays.toString(numerosConDuplicados));
        System.out.println("Sin duplicados: " + sinDuplicados);
        
        // 2. Verificar si hay palabras repetidas en un texto
        System.out.println("\n2. Verificar palabras únicas:");
        String texto = "el gato y el perro juegan el gato corre";
        String[] palabras = texto.split(" ");
        HashSet<String> palabrasUnicas = new HashSet<>(Arrays.asList(palabras));
        
        System.out.println("Texto: " + texto);
        System.out.println("Total de palabras: " + palabras.length);
        System.out.println("Palabras únicas: " + palabrasUnicas.size());
        System.out.println("¿Hay repetidas? " + (palabras.length != palabrasUnicas.size()));
        
        // 3. Encontrar elementos comunes entre dos listas (intersección)
        System.out.println("\n3. Elementos comunes (intersección):");
        HashSet<String> listaA = new HashSet<>(Arrays.asList("Java", "Python", "C++", "JavaScript"));
        HashSet<String> listaB = new HashSet<>(Arrays.asList("Python", "Ruby", "JavaScript", "Go"));
        
        HashSet<String> comunes = new HashSet<>(listaA);
        comunes.retainAll(listaB);
        
        System.out.println("Lista A: " + listaA);
        System.out.println("Lista B: " + listaB);
        System.out.println("Lenguajes comunes: " + comunes);
        
        // 4. Sistema de control de emails únicos
        System.out.println("\n4. Sistema de registro de emails:");
        HashSet<String> emailsRegistrados = new HashSet<>();
        
        String[] intentosRegistro = {
            "juan@email.com",
            "maria@email.com",
            "juan@email.com", // Duplicado
            "pedro@email.com",
            "maria@email.com"  // Duplicado
        };
        
        for (String email : intentosRegistro) {
            boolean agregado = emailsRegistrados.add(email);
            if (agregado) {
                System.out.println("✓ Email registrado: " + email);
            } else {
                System.out.println("✗ Email ya existe: " + email);
            }
        }
        System.out.println("Total de emails únicos: " + emailsRegistrados.size());
        
        // 5. Ranking ordenado con TreeSet
        System.out.println("\n5. Sistema de ranking ordenado:");
        TreeSet<Estudiante> ranking = new TreeSet<>();
        
        ranking.add(new Estudiante("Ana", 95));
        ranking.add(new Estudiante("Carlos", 88));
        ranking.add(new Estudiante("Beatriz", 92));
        ranking.add(new Estudiante("Daniel", 85));
        
        System.out.println("Ranking de estudiantes (ordenado por calificación):");
        int posicion = 1;
        // TreeSet itera en orden (descendente por calificación)
        for (Estudiante est : ranking.descendingSet()) {
            System.out.println(posicion + ". " + est);
            posicion++;
        }
    }
}

/**
 * Clase auxiliar para el ejemplo de ranking
 * Implementa Comparable para que TreeSet pueda ordenar
 */
class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private int calificacion;
    
    public Estudiante(String nombre, int calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }
    
    @Override
    public int compareTo(Estudiante otro) {
        // Ordenar por calificación (menor a mayor)
        return Integer.compare(this.calificacion, otro.calificacion);
    }
    
    @Override
    public String toString() {
        return nombre + " - " + calificacion + " puntos";
    }
}
