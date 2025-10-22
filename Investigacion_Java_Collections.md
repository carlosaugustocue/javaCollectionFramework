# Investigación: Java Collection Framework

## 1. ¿Qué es el Java Collection Framework y para qué se utiliza?

El **Java Collection Framework** es un conjunto unificado de interfaces, implementaciones y algoritmos que proporciona Java para almacenar y manipular grupos de objetos de manera eficiente. Fue introducido en Java 2 (JDK 1.2) y se encuentra en el paquete `java.util`.

### Propósitos principales:

- **Reducir el esfuerzo de programación**: Proporciona estructuras de datos y algoritmos de alto rendimiento ya implementados
- **Aumentar la velocidad y calidad**: Las implementaciones están optimizadas y ampliamente probadas
- **Permitir la interoperabilidad**: Todas las colecciones siguen interfaces comunes, facilitando el intercambio de datos
- **Facilitar el aprendizaje y uso**: API consistente y bien documentada
- **Promover la reutilización de software**: Interfaces estándar que pueden ser implementadas por desarrolladores

### Jerarquía principal:

```
Collection (Interface)
├── List (Interface) - Colecciones ordenadas que permiten duplicados
├── Set (Interface) - Colecciones sin duplicados
├── Queue (Interface) - Colecciones para procesamiento FIFO
└── Deque (Interface) - Colas de doble extremo

Map (Interface) - Colecciones de pares clave-valor (no extiende Collection)
```

---

## 2. Descripción de los tipos de colecciones

### 2.1. List (Lista)

**Características:**
- Colección ordenada (secuencial)
- Permite elementos duplicados
- Los elementos pueden ser accedidos por su índice
- Mantiene el orden de inserción

**Implementaciones principales:**

- **ArrayList**: 
  - Basada en un array dinámico
  - Acceso rápido por índice O(1)
  - Inserción/eliminación lenta en medio O(n)
  - Mejor para: acceso frecuente por índice, pocas inserciones/eliminaciones

- **LinkedList**:
  - Basada en lista doblemente enlazada
  - Acceso por índice lento O(n)
  - Inserción/eliminación rápida en extremos O(1)
  - Mejor para: muchas inserciones/eliminaciones, implementar colas/pilas

### 2.2. Set (Conjunto)

**Características:**
- No permite elementos duplicados
- Sin orden garantizado (excepto en algunas implementaciones)
- Útil para búsquedas de existencia

**Implementaciones principales:**

- **HashSet**:
  - Basada en tabla hash (HashMap internamente)
  - No garantiza orden
  - Operaciones muy rápidas O(1) en promedio
  - Mejor para: búsquedas rápidas, sin necesidad de orden

- **TreeSet**:
  - Basada en árbol rojo-negro (TreeMap internamente)
  - Elementos ordenados naturalmente o por Comparator
  - Operaciones O(log n)
  - Mejor para: cuando se necesita orden o navegación por rango

### 2.3. Map (Mapa)

**Características:**
- Almacena pares clave-valor
- No permite claves duplicadas (pero sí valores duplicados)
- No es parte de la interfaz Collection
- Permite búsqueda rápida por clave

**Implementaciones principales:**

- **HashMap**:
  - Basada en tabla hash
  - No garantiza orden
  - Operaciones muy rápidas O(1) en promedio
  - Mejor para: búsquedas rápidas por clave, sin necesidad de orden

- **TreeMap**:
  - Basada en árbol rojo-negro
  - Claves ordenadas
  - Operaciones O(log n)
  - Mejor para: cuando se necesita orden de claves o navegación por rango

### 2.4. Queue / Deque (Cola)

**Características:**
- Diseñada para procesamiento de elementos antes de procesarlos
- Típicamente orden FIFO (First-In-First-Out)
- Puede tener diferentes prioridades

**Implementaciones principales:**

- **LinkedList** (como Queue):
  - Implementa tanto List como Deque
  - FIFO simple
  - Operaciones O(1) en extremos

- **PriorityQueue**:
  - Cola con prioridad basada en heap
  - Elementos ordenados por prioridad
  - Operaciones O(log n)
  - Mejor para: cuando los elementos deben procesarse por prioridad

---

## 3. Ejemplos funcionales en código Java

Los ejemplos de código están en los archivos adjuntos:
- `EjemploList.java` - Demostración de ArrayList y LinkedList
- `EjemploSet.java` - Demostración de HashSet y TreeSet
- `EjemploMap.java` - Demostración de HashMap y TreeMap
- `EjemploQueue.java` - Demostración de LinkedList como Queue y PriorityQueue

Cada archivo contiene ejemplos prácticos con código completamente comentado.

---

## 4. Conclusiones: ¿Cuándo conviene usar cada colección?

### Usa **ArrayList** cuando:
- Necesites acceso rápido por índice
- Hagas pocas inserciones/eliminaciones
- El tamaño de la colección sea relativamente estable
- **Ejemplo**: Lista de productos en un catálogo que se consulta frecuentemente

### Usa **LinkedList** cuando:
- Hagas muchas inserciones/eliminaciones, especialmente al inicio o en medio
- Implementes estructuras como colas o pilas
- No necesites acceso frecuente por índice
- **Ejemplo**: Lista de tareas pendientes donde constantemente se agregan y eliminan elementos

### Usa **HashSet** cuando:
- Necesites eliminar duplicados
- No te importe el orden
- Requieras búsquedas muy rápidas
- **Ejemplo**: Lista de emails únicos de usuarios registrados

### Usa **TreeSet** cuando:
- Necesites elementos únicos Y ordenados
- Requieras operaciones de rango (subSet, headSet, tailSet)
- **Ejemplo**: Sistema de clasificación de estudiantes por calificación

### Usa **HashMap** cuando:
- Necesites asociar claves con valores
- Requieras búsquedas muy rápidas por clave
- No te importe el orden
- **Ejemplo**: Diccionario de traducción palabra-significado

### Usa **TreeMap** cuando:
- Necesites un mapa ordenado por claves
- Requieras navegación por rangos de claves
- **Ejemplo**: Registro de eventos ordenados por fecha

### Usa **PriorityQueue** cuando:
- Necesites procesar elementos por orden de prioridad
- Los elementos con mayor prioridad deban procesarse primero
- **Ejemplo**: Sistema de atención de emergencias médicas

### Resumen de complejidad temporal:

| Operación | ArrayList | LinkedList | HashSet | TreeSet | HashMap | TreeMap | PriorityQueue |
|-----------|-----------|------------|---------|---------|---------|---------|---------------|
| Agregar | O(1)* | O(1) | O(1) | O(log n) | O(1) | O(log n) | O(log n) |
| Eliminar | O(n) | O(1)** | O(1) | O(log n) | O(1) | O(log n) | O(log n) |
| Buscar | O(n) | O(n) | O(1) | O(log n) | O(1) | O(log n) | O(n) |
| Acceso por índice | O(1) | O(n) | N/A | N/A | N/A | N/A | N/A |

\* Amortizado (puede ser O(n) cuando se redimensiona el array)
\*\* Solo en los extremos

### Consideraciones finales:

1. **Thread-Safety**: Ninguna de estas implementaciones es thread-safe por defecto. Para uso concurrente, considera usar las versiones sincronizadas o las del paquete `java.util.concurrent`

2. **Capacidad inicial**: Para HashMap, HashSet y ArrayList, si conoces el tamaño aproximado, especifica la capacidad inicial para evitar redimensionamientos

3. **Null**: HashMap y HashSet permiten elementos null, pero TreeMap y TreeSet no (lanzarán NullPointerException)

4. **Iteración**: Si necesitas iterar frecuentemente, LinkedList puede ser más lenta que ArrayList para colecciones grandes

5. **Memoria**: LinkedList consume más memoria que ArrayList debido a los nodos con referencias adicionales

---

## Referencias

- Oracle Java Documentation: [Collections Framework Overview](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
- Java API Documentation: [java.util package](https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html)
