# Investigación sobre Java Collection Framework

## 📁 Archivos incluidos

Este paquete contiene una investigación completa sobre el Java Collection Framework con ejemplos prácticos:

### 1. **Investigacion_Java_Collections.md**
   - Documento principal con toda la investigación teórica
   - Explicación completa del Java Collection Framework
   - Descripción detallada de cada tipo de colección
   - Tabla comparativa de complejidad temporal
   - Conclusiones y recomendaciones de uso

### 2. **EjemploList.java**
   - Demostración completa de ArrayList y LinkedList
   - Ejemplos de operaciones básicas
   - Comparación de rendimiento
   - Casos de uso prácticos
   - Código completamente comentado

### 3. **EjemploSet.java**
   - Demostración completa de HashSet y TreeSet
   - Operaciones de conjuntos (unión, intersección, diferencia)
   - Navegación por rangos con TreeSet
   - Aplicaciones prácticas (eliminar duplicados, ranking, etc.)
   - Código completamente comentado

### 4. **EjemploMap.java**
   - Demostración completa de HashMap y TreeMap
   - Ejemplos de pares clave-valor
   - Diferentes formas de iterar
   - Aplicaciones prácticas (contador, diccionario, caché, etc.)
   - Código completamente comentado

### 5. **EjemploQueue.java**
   - Demostración de Queue, Deque y PriorityQueue
   - Uso de LinkedList como Queue
   - ArrayDeque como pila y cola
   - Cola de prioridades con objetos personalizados
   - Aplicaciones prácticas (atención al cliente, emergencias, etc.)
   - Código completamente comentado

---

## 🚀 Cómo usar estos archivos

### Para leer la investigación:
1. Abre el archivo `Investigacion_Java_Collections.md` en cualquier visor de Markdown o editor de texto
2. Encontrarás toda la información teórica organizada en secciones

### Para ejecutar los ejemplos:

#### Opción 1: Desde línea de comandos
```bash
# Compilar un archivo
javac EjemploList.java

# Ejecutar
java EjemploList
```

#### Opción 2: Desde un IDE (Eclipse, IntelliJ, NetBeans, VS Code)
1. Crea un nuevo proyecto Java
2. Copia los archivos .java al proyecto
3. Ejecuta cada archivo (tienen su propio método main)

#### Opción 3: Ejecutar todos los ejemplos
```bash
# Compilar todos los archivos
javac *.java

# Ejecutar cada ejemplo
java EjemploList
java EjemploSet
java EjemploMap
java EjemploQueue
```

---

## 📝 Estructura del código

Cada archivo de ejemplo sigue esta estructura:

1. **Explicación inicial**: Comentarios que describen qué es la colección
2. **Método main**: Llama a todos los ejemplos del archivo
3. **Ejemplos básicos**: Demostración de operaciones fundamentales
4. **Aplicaciones prácticas**: Casos de uso del mundo real
5. **Código comentado**: Cada línea importante está explicada

---

## 🎯 Recomendaciones para la presentación

### Para el miércoles 22 de octubre:

1. **Lee primero** el documento `Investigacion_Java_Collections.md` para entender la teoría

2. **Ejecuta los ejemplos** uno por uno para ver cómo funcionan en la práctica

3. **Estructura de presentación sugerida**:
   - Introducción: ¿Qué es el Java Collection Framework? (5 min)
   - List: Demostrar ArrayList vs LinkedList (5 min)
   - Set: Demostrar HashSet vs TreeSet (5 min)
   - Map: Demostrar HashMap vs TreeMap (5 min)
   - Queue: Demostrar PriorityQueue (5 min)
   - Conclusiones: ¿Cuándo usar cada colección? (5 min)

4. **Tips para la presentación**:
   - Ejecuta el código en vivo para mostrar los resultados
   - Explica las diferencias de rendimiento con los ejemplos
   - Menciona casos de uso del mundo real
   - Prepara respuestas para preguntas comunes

---

## 📊 Resumen rápido

| Colección | Orden | Duplicados | Velocidad | Cuándo usarla |
|-----------|-------|------------|-----------|---------------|
| **ArrayList** | Sí | Sí | Acceso: O(1) | Acceso frecuente por índice |
| **LinkedList** | Sí | Sí | Insert/Delete: O(1) | Muchas inserciones/eliminaciones |
| **HashSet** | No | No | O(1) | Búsquedas rápidas, sin orden |
| **TreeSet** | Sí | No | O(log n) | Elementos únicos ordenados |
| **HashMap** | No | Claves: No<br>Valores: Sí | O(1) | Búsqueda rápida por clave |
| **TreeMap** | Sí | Claves: No<br>Valores: Sí | O(log n) | Mapa ordenado por claves |
| **PriorityQueue** | Por prioridad | Sí | O(log n) | Procesamiento por prioridad |

---

## 💡 Conceptos clave a mencionar

1. **Java Collection Framework** es una arquitectura unificada para manipular colecciones
2. **Complejidad temporal**: Importante para elegir la estructura correcta
3. **Trade-offs**: Velocidad vs orden vs características especiales
4. **Thread-safety**: Ninguna es thread-safe por defecto
5. **Null values**: HashMap/HashSet permiten null, TreeMap/TreeSet no

---

## ✅ Checklist para el grupo

- [ ] Cada integrante lee el documento completo
- [ ] Todos ejecutan los ejemplos al menos una vez
- [ ] Dividen la presentación entre los 3 integrantes
- [ ] Preparan slides o presentación (opcional pero recomendado)
- [ ] Practican la explicación del código
- [ ] Preparan respuestas para posibles preguntas

---

## 🔗 Referencias adicionales

- [Oracle Java Documentation - Collections](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
- [Java API - java.util package](https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html)

---

**¡Buena suerte con la presentación! 🚀**

---

## 📞 Notas

- Todos los ejemplos están probados y funcionan correctamente
- El código está diseñado para ser educativo y fácil de entender
- Puedes modificar los ejemplos para adaptarlos a tu presentación
- Si encuentras algún error o tienes dudas, revisa los comentarios en el código
