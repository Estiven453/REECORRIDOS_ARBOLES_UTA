/*
 * RECORRIDOS DE ARBOLES BINARIOS - UTA
 * Carrera: Ingenieria de Software
 * Asignatura: Estructura de Datos
 * Tema: Implementacion de recorridos DFS (Preorden, Inorden, Postorden) y BFS
 * Lenguaje: Java
 * 
 * DESCRIPCION: Programa interactivo para explorar los 5 ejercicios propuestos
 * sobre recorridos de arboles binarios con menu de seleccion.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ============================================================================
// CLASE NODO - ESTRUCTURA DEL ARBOL BINARIO
// ============================================================================

/**
 * Clase Nodo: Representa cada nodo del arbol binario
 * Atributos: dato (valor entero), izquierda y derecha (referencias a nodos)
 */
class Nodo {
    int dato;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}

// ============================================================================
// CLASE PRINCIPAL - CONTIENE TODOS LOS METODOS
// ============================================================================

public class Main {

    // ========================================================================
    // FUNCIONES DE RECORRIDO (DFS - Depth-First Search)
    // ========================================================================

    /**
     * RECORRIDO PREORDEN: Raiz -> Izquierda -> Derecha
     * Uso: Mostrar la estructura jerarquica desde la raiz
     */
    public static void preorden(Nodo raiz) {
        if (raiz == null) return;
        System.out.print(raiz.dato + " ");
        preorden(raiz.izquierda);
        preorden(raiz.derecha);
    }

    /**
     * RECORRIDO INORDEN: Izquierda -> Raiz -> Derecha
     * Uso: Obtener valores ordenados en un arbol binario de busqueda
     */
    public static void inorden(Nodo raiz) {
        if (raiz == null) return;
        inorden(raiz.izquierda);
        System.out.print(raiz.dato + " ");
        inorden(raiz.derecha);
    }

    /**
     * RECORRIDO POSTORDEN: Izquierda -> Derecha -> Raiz
     * Uso: Procesar primero los nodos internos (ejemplo: liberar memoria)
     */
    public static void postorden(Nodo raiz) {
        if (raiz == null) return;
        postorden(raiz.izquierda);
        postorden(raiz.derecha);
        System.out.print(raiz.dato + " ");
    }

    // ========================================================================
    // FUNCIONES DE RECORRIDO (BFS - Breadth-First Search)
    // ========================================================================

    /**
     * RECORRIDO BFS: Nivel por nivel usando una cola (FIFO)
     * Uso: Procesar el arbol por niveles
     */
    public static void bfs(Nodo raiz) {
        if (raiz == null) return;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.dato + " ");

            if (actual.izquierda != null) cola.add(actual.izquierda);
            if (actual.derecha != null) cola.add(actual.derecha);
        }
    }

    // ========================================================================
    // FUNCIONES AUXILIARES (Ejercicios 3 y 4)
    // ========================================================================

    /**
     * Funcion para contar el total de nodos del arbol
     * Utiliza recursividad: cuenta 1 (nodo actual) + nodos izquierda + nodos derecha
     */
    public static int contarNodos(Nodo raiz) {
        if (raiz == null) return 0;
        return 1 + contarNodos(raiz.izquierda) + contarNodos(raiz.derecha);
    }

    /**
     * Funcion para contar hojas del arbol
     * Una hoja es un nodo sin hijos (izquierda y derecha = null)
     */
    public static int contarHojas(Nodo raiz) {
        if (raiz == null) return 0;
        if (raiz.izquierda == null && raiz.derecha == null) return 1;
        return contarHojas(raiz.izquierda) + contarHojas(raiz.derecha);
    }

    // ========================================================================
    // FUNCIONES DE EJERCICIOS
    // ========================================================================

    /**
     * EJERCICIO 1: Recorridos basicos del arbol sin nodos adicionales
     * Se muestra la estructura basica y los 4 recorridos fundamentales
     */
    public static void ejercicio1() {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                 EJERCICIO 1: RECORRIDOS BASICOS                ║");
        System.out.println("║  (Arbol base sin nodos adicionales - valores: 10,5,15,2,7,12,20) ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

        // Construir el arbol base del Ejercicio 1
        Nodo raiz = new Nodo(10);
        raiz.izquierda = new Nodo(5);
        raiz.derecha = new Nodo(15);
        raiz.izquierda.izquierda = new Nodo(2);
        raiz.izquierda.derecha = new Nodo(7);
        raiz.derecha.izquierda = new Nodo(12);
        raiz.derecha.derecha = new Nodo(20);

        System.out.println("\nEstructura del arbol:");
        System.out.println("        10");
        System.out.println("       /  \\");
        System.out.println("      5    15");
        System.out.println("     / \\   / \\");
        System.out.println("    2   7 12  20\n");

        System.out.println("Resultados de recorridos:");
        System.out.print("├─ Preorden (Raiz -> Izq -> Der):  ");
        preorden(raiz);
        System.out.println();

        System.out.print("├─ Inorden (Izq -> Raiz -> Der):   ");
        inorden(raiz);
        System.out.println();

        System.out.print("├─ Postorden (Izq -> Der -> Raiz): ");
        postorden(raiz);
        System.out.println();

        System.out.print("└─ BFS (Nivel por nivel):          ");
        bfs(raiz);
        System.out.println();
    }

    /**
     * EJERCICIO 2: Arbol ampliado con nodos adicionales
     * Se agrega: 1, 3, 18, 25 al arbol del Ejercicio 1
     */
    public static void ejercicio2() {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║              EJERCICIO 2: ARBOL AMPLIADO CON NODOS NUEVOS      ║");
        System.out.println("║                 Nodos agregados: 1, 3, 18, 25                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

        // Construir arbol base y agregar nodos
        Nodo raiz = new Nodo(10);
        raiz.izquierda = new Nodo(5);
        raiz.derecha = new Nodo(15);
        raiz.izquierda.izquierda = new Nodo(2);
        raiz.izquierda.derecha = new Nodo(7);
        raiz.derecha.izquierda = new Nodo(12);
        raiz.derecha.derecha = new Nodo(20);

        // Agregar nodos del Ejercicio 2
        raiz.izquierda.izquierda.izquierda = new Nodo(1);   // Hijo izq de 2
        raiz.izquierda.izquierda.derecha = new Nodo(3);     // Hijo der de 2
        raiz.derecha.derecha.izquierda = new Nodo(18);      // Hijo izq de 20
        raiz.derecha.derecha.derecha = new Nodo(25);        // Hijo der de 20

        System.out.println("\nEstructura del arbol ampliado:");
        System.out.println("            10");
        System.out.println("           /  \\");
        System.out.println("          5    15");
        System.out.println("         / \\   / \\");
        System.out.println("        2   7 12 20");
        System.out.println("       / \\       / \\");
        System.out.println("      1   3     18 25\n");

        System.out.println("Resultados de recorridos:");
        System.out.print("├─ Preorden (Raiz -> Izq -> Der):  ");
        preorden(raiz);
        System.out.println();

        System.out.print("├─ Inorden (Izq -> Raiz -> Der):   ");
        inorden(raiz);
        System.out.println();

        System.out.print("├─ Postorden (Izq -> Der -> Raiz): ");
        postorden(raiz);
        System.out.println();

        System.out.print("└─ BFS (Nivel por nivel):          ");
        bfs(raiz);
        System.out.println();
    }

    /**
     * EJERCICIO 3: Contar el total de nodos del arbol
     * Se utiliza recursividad para contar todos los nodos
     */
    public static void ejercicio3() {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║         EJERCICIO 3: CONTAR TOTAL DE NODOS DEL ARBOL           ║");
        System.out.println("║         Implementa una funcion que cuente todos los nodos      ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

        // Construir el arbol con todos los nodos
        Nodo raiz = new Nodo(10);
        raiz.izquierda = new Nodo(5);
        raiz.derecha = new Nodo(15);
        raiz.izquierda.izquierda = new Nodo(2);
        raiz.izquierda.derecha = new Nodo(7);
        raiz.derecha.izquierda = new Nodo(12);
        raiz.derecha.derecha = new Nodo(20);
        raiz.izquierda.izquierda.izquierda = new Nodo(1);
        raiz.izquierda.izquierda.derecha = new Nodo(3);
        raiz.derecha.derecha.izquierda = new Nodo(18);
        raiz.derecha.derecha.derecha = new Nodo(25);

        System.out.println("\n[RECORRIDO PREORDEN] Listado de todos los nodos:");
        preorden(raiz);
        System.out.println("\n");

        int totalNodos = contarNodos(raiz);
        System.out.println("╭─ RESULTADO ─────────────────────────────────────────────────");
        System.out.println("│  Total de nodos en el arbol: " + totalNodos);
        System.out.println("╰──────────────────────────────────────────────────────────────");

        System.out.println("\nExplicacion de la funcion:");
        System.out.println("  - contarNodos(raiz) cuenta de forma recursiva:");
        System.out.println("    * 1 (por el nodo actual)");
        System.out.println("    * + nodos en subArbol izquierdo");
        System.out.println("    * + nodos en subArbol derecho");
    }

    /**
     * EJERCICIO 4: Contar las hojas del arbol
     * Una hoja es un nodo sin hijos izquierdo ni derecho
     */
    public static void ejercicio4() {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║           EJERCICIO 4: CONTAR HOJAS DEL ARBOL                  ║");
        System.out.println("║  Una hoja es un nodo sin hijos (izquierda=null, derecha=null)  ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

        // Construir el arbol con todos los nodos
        Nodo raiz = new Nodo(10);
        raiz.izquierda = new Nodo(5);
        raiz.derecha = new Nodo(15);
        raiz.izquierda.izquierda = new Nodo(2);
        raiz.izquierda.derecha = new Nodo(7);
        raiz.derecha.izquierda = new Nodo(12);
        raiz.derecha.derecha = new Nodo(20);
        raiz.izquierda.izquierda.izquierda = new Nodo(1);
        raiz.izquierda.izquierda.derecha = new Nodo(3);
        raiz.derecha.derecha.izquierda = new Nodo(18);
        raiz.derecha.derecha.derecha = new Nodo(25);

        System.out.println("\n[POSTORDEN] Recorrido que procesa hojas primero:");
        postorden(raiz);
        System.out.println("\n");

        int totalHojas = contarHojas(raiz);
        System.out.println("╭─ RESULTADO ─────────────────────────────────────────────────");
        System.out.println("│  Total de hojas en el arbol: " + totalHojas);
        System.out.println("├─ Nodos hoja identificados:");
        System.out.println("│  1, 3, 7, 12, 18, 25");
        System.out.println("╰──────────────────────────────────────────────────────────────");

        System.out.println("\nExplicacion de la funcion:");
        System.out.println("  - contarHojas(raiz) cuenta recursivamente los nodos hoja:");
        System.out.println("    * Si izquierda == null AND derecha == null -> es una hoja");
        System.out.println("    * Si no es hoja -> suma hojas del subArbol izq + subArbol der");
    }

    /**
     * EJERCICIO 5: Aplicacion al proyecto final
     * Representa un sistema web como arbol binario y explica los recorridos utiles
     */
    public static void ejercicio5() {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║           EJERCICIO 5: APLICACION AL PROYECTO FINAL            ║");
        System.out.println("║         Sistema Web de Gestion Empresarial como arbol          ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

        Nodo sistemWeb = new Nodo(0); // Raiz virtual
        sistemWeb.izquierda = new Nodo(1);    // Usuarios
        sistemWeb.derecha = new Nodo(2);      // Inventario
        sistemWeb.izquierda.izquierda = new Nodo(11);   // Registrar
        sistemWeb.izquierda.derecha = new Nodo(12);     // Buscar
        sistemWeb.derecha.izquierda = new Nodo(21);     // Productos
        sistemWeb.derecha.derecha = new Nodo(22);       // Reportes

        System.out.println("\nEstructura del Sistema Web como arbol binario:\n");
        System.out.println("                    [SistemaWeb]");
        System.out.println("                   /             \\");
        System.out.println("            [Usuarios]      [Inventario]");
        System.out.println("            /        \\      /            \\");
        System.out.println("    [Registrar] [Buscar] [Productos] [Reportes]\n");

        System.out.println("Analisis de recorridos para el proyecto final:\n");

        System.out.println("┌─ 1. MOSTRAR MENU PRINCIPAL (jerarquia top-down)");
        System.out.println("│   Recorrido recomendado: PREORDEN (Raiz -> Izq -> Der)");
        System.out.println("│   Razon: Presenta primero el modulo principal,");
        System.out.println("│           luego sus submodulos de forma natural.");
        System.out.println("│   Aplicacion: Generador dinamico de menu principal");
        System.out.println("│   Secuencia: Muestra primero Sistema, luego Usuarios...");
        System.out.println("│   Ventaja: Orden intuitivo para el usuario");
        System.out.println("└─ Resultado esperado: 0 1 11 12 2 21 22\n");

        System.out.println("┌─ 2. PROCESAR MODULOS INTERNOS PRIMERO (bottom-up)");
        System.out.println("│   Recorrido recomendado: POSTORDEN (Izq -> Der -> Raiz)");
        System.out.println("│   Razon: Procesa primero las hojas (modulos internos),");
        System.out.println("│           despues los padres (modulos contenedores).");
        System.out.println("│   Aplicacion: Validacion de dependencias antes del despliegue");
        System.out.println("│   Caso de uso: Verificar que todos los modulos esten listos");
        System.out.println("│   Ventaja: Resuelve dependencias correctamente");
        System.out.println("└─ Resultado esperado: 11 12 1 21 22 2 0\n");

        System.out.println("┌─ 3. MOSTRAR MODULOS NIVEL POR NIVEL (dashboard)");
        System.out.println("│   Recorrido recomendado: BFS (Nivel por nivel con cola)");
        System.out.println("│   Razon: Muestra la jerarquia claramente, nivel por nivel,");
        System.out.println("│           ideal para interfaces graficas en capas.");
        System.out.println("│   Aplicacion: Dashboard que muestra capas funcionales");
        System.out.println("│   Caso de uso: Visualizacion en tablas o graficos de capas");
        System.out.println("│   Ventaja: Facilita la comprension de profundidad");
        System.out.println("│   Niveles:  [Sistema] -> [Usuarios, Inventario] ->");
        System.out.println("│             [Registrar, Buscar, Productos, Reportes]");
        System.out.println("└─ Resultado esperado: 0 1 2 11 12 21 22");
    }

    // ========================================================================
    // MENU INTERACTIVO
    // ========================================================================

    public static void mostrarMenu() {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║         RECORRIDOS DE ARBOLES BINARIOS - MENU PRINCIPAL        ║");
        System.out.println("║            Universidad Tecnica de Ambato (UTA)                 ║");
        System.out.println("║                   Estructura de Datos                          ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        System.out.println("\nSelecciona un ejercicio para ejecutar:\n");
        System.out.println("  [1] Ejercicio 1 - Recorridos basicos del arbol");
        System.out.println("  [2] Ejercicio 2 - Arbol ampliado con nodos adicionales");
        System.out.println("  [3] Ejercicio 3 - Contar total de nodos del arbol");
        System.out.println("  [4] Ejercicio 4 - Contar hojas del arbol");
        System.out.println("  [5] Ejercicio 5 - Aplicacion al proyecto final (Sistema Web)");
        System.out.println("  [0] Salir del programa");
        System.out.println("\n════════════════════════════════════════════════════════════════");
        System.out.print("Ingresa tu opcion (0-5): ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        ejercicio1();
                        break;
                    case 2:
                        ejercicio2();
                        break;
                    case 3:
                        ejercicio3();
                        break;
                    case 4:
                        ejercicio4();
                        break;
                    case 5:
                        ejercicio5();
                        break;
                    case 0:
                        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
                        System.out.println("║  Gracias por usar el programa. Adios!");
                        System.out.println("║  Codigo desarrollado para la asignatura de Estructura de Datos");
                        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");
                        salir = true;
                        break;
                    default:
                        System.out.println("\n[ERROR] Opcion no valida. Por favor ingresa un numero entre 0 y 5.");
                        System.out.println("Presiona Enter para continuar...");
                        scanner.nextLine();
                }

                if (!salir) {
                    System.out.println("\nPresiona Enter para volver al menu...");
                    scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("\n[ERROR] Entrada invalida. Por favor ingresa un numero.");
                scanner.nextLine(); // Limpiar buffer
            }
        }

        scanner.close();
    }
}
