/* **************************************************************************
 * UNIVERSIDAD TECNICA DE AMBATO
 * Facultad de Ingenieria en Sistemas, Electronica e Industrial
 * Carrera: Ingenieria de Software
 * * ASIGNATURA: Estructura de Datos
 * TEMA:       Practica de Arboles Binarios (Ejercicios 1-5)
 * ESTUDIANTE: Estiven Chiluisa
 * NIVEL:      Tercero B
 * ************************************************************************** */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

public class Main {

    // --- METODOS RECURSIVOS PRIVADOS ---

    public static Nodo insertar(Nodo raiz, int valor) {
        if (raiz == null) return new Nodo(valor);
        if (valor < raiz.dato) raiz.izquierda = insertar(raiz.izquierda, valor);
        else if (valor > raiz.dato) raiz.derecha = insertar(raiz.derecha, valor);
        return raiz;
    }
    /**
     * Se usa en EJERCICIOS 1 y 2.
     * Orden: Raiz -> Izquierda -> Derecha.
     * Uso: Mostrar la estructura jerarquica desde la parte superior.
     */

    public static void preorden(Nodo raiz) {
        if (raiz == null) return;
        System.out.print(raiz.dato + " ");
        preorden(raiz.izquierda);
        preorden(raiz.derecha);
    }
    /**
     * Se usa en EJERCICIOS 1 y 2.
     * Orden: Izquierda -> Raiz -> Derecha.
     * Uso: Obtener valores en orden ascendente (si es un arbol de busqueda).
     */

    public static void inorden(Nodo raiz) {
        if (raiz == null) return;
        inorden(raiz.izquierda);
        System.out.print(raiz.dato + " ");
        inorden(raiz.derecha);
    }

    /**
     * Se usa en EJERCICIOS 1 y 2.
     * Orden: Izquierda -> Derecha -> Raiz.
     * Uso: Procesar hojas antes que padres (ej. calculos de dependencias).
     */
    public static void postorden(Nodo raiz) {
        if (raiz == null) return;
        postorden(raiz.izquierda);
        postorden(raiz.derecha);
        System.out.print(raiz.dato + " ");
    }
    /**
     * Recorrido BFS: Nivel por nivel.
     * Se usa en EJERCICIOS 1 y 2 (Requerimiento README: Uso de Cola).
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
    /**
     * Se usa en EJERCICIO 3.
     * Logica: 1 (actual) + suma de nodos de subarboles.
     */
    public static int contarNodos(Nodo raiz) {
        if (raiz == null) return 0;
        return 1 + contarNodos(raiz.izquierda) + contarNodos(raiz.derecha);
    }
    /**
     * Se usa en EJERCICIO 4.
     * Logica: Suma 1 solo si el nodo no tiene ningun hijo (hoja).
     */

    public static int contarHojas(Nodo raiz) {
        if (raiz == null) return 0;
        if (raiz.izquierda == null && raiz.derecha == null) return 1;
        return contarHojas(raiz.izquierda) + contarHojas(raiz.derecha);
    }

    public static void mostrarEjercicio5() {
        System.out.println("\n********************************************************");
        System.out.println("EJERCICIO 5 - SISTEMA WEB (MODULOS)");
        System.out.println("********************************************************");
        System.out.println("Estructura jerarquica de modulos:\n");
        System.out.println("            Sistema Web");
        System.out.println("            /         \\");
        System.out.println("      Usuarios       Inventario");
        System.out.println("       /     \\        /      \\");
        System.out.println("Registrar  Buscar  Productos  Reportes\n");
        
        System.out.println("RESPUESTAS A LAS PREGUNTAS DE LA GUIA:");
        System.out.println("--------------------------------------------------------");
        System.out.println("1. Mostrar el menu principal:");
        System.out.println("   -> RECORRIDO PREORDEN (Raiz, Izq, Der).");
        System.out.println("2. Procesar primero los modulos internos (hojas):");
        System.out.println("   -> RECORRIDO POSTORDEN (Izq, Der, Raiz).");
        System.out.println("3. Mostrar modulos nivel por nivel:");
        System.out.println("   -> RECORRIDO BFS (Nivel por nivel usando cola).");
        System.out.println("--------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Nodo arbolActual = null;
        int opcion;

        do {
            System.out.println("\nMENU PRINCIPAL (JAVA):");
            System.out.println("1. Ejercicio 1 - Arbol base");
            System.out.println("2. Ejercicio 2 - Arbol ampliado");
            System.out.println("3. Ejercicio 3 - Contar nodos totales");
            System.out.println("4. Ejercicio 4 - Contar hojas");
            System.out.println("5. Ejercicio 5 - Sistema Web (Modulos)");
            System.out.println("6. Arbol personalizado (insercion manual)");
            System.out.println("0. Salir");
            System.out.print("\nSeleccione opcion: ");
            
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                case 2:
                    arbolActual = null;
                    arbolActual = insertar(arbolActual, 10);
                    arbolActual = insertar(arbolActual, 5);
                    arbolActual = insertar(arbolActual, 15);
                    arbolActual = insertar(arbolActual, 2);
                    arbolActual = insertar(arbolActual, 7);
                    arbolActual = insertar(arbolActual, 12);
                    arbolActual = insertar(arbolActual, 20);

                    if (opcion == 2) {
                        arbolActual = insertar(arbolActual, 1);
                        arbolActual = insertar(arbolActual, 3);
                        arbolActual = insertar(arbolActual, 18);
                        arbolActual = insertar(arbolActual, 25);
                    }

                    System.out.println("\n------------------------------------------------------------");
                    System.out.println("ESTRUCTURA DEL ARBOL:");
                    if (opcion == 1) System.out.println("    10\n   /  \\\n  5    15\n / \\  / \\\n2   7 12 20");
                    else System.out.println("      10\n    /    \\\n   5      15\n  / \\    /  \\\n 2   7  12   20\n/ \\         /  \\\n1   3       18   25");
                    
                    System.out.println("\nRECORRIDOS:");
                    System.out.print("Preorden:  "); preorden(arbolActual); System.out.println();
                    System.out.print("Inorden:   "); inorden(arbolActual); System.out.println();
                    System.out.print("Postorden: "); postorden(arbolActual); System.out.println();
                    System.out.print("BFS:       "); bfs(arbolActual); System.out.println();
                    break;

                case 3:
                    if (arbolActual == null) System.out.println("\n[AVISO] Carga primero el arbol 1 o 2.");
                    else System.out.println("\nTotal de nodos: " + contarNodos(arbolActual));
                    break;

                case 4:
                    if (arbolActual == null) System.out.println("\n[AVISO] Carga primero el arbol 1 o 2.");
                    else System.out.println("\nTotal de hojas: " + contarHojas(arbolActual));
                    break;

                case 5:
                    mostrarEjercicio5();
                    break;

                case 6:
                    System.out.print("Ingrese valor: ");
                    int v = sc.nextInt();
                    arbolActual = insertar(arbolActual, v);
                    System.out.println("Nodo insertado.");
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}