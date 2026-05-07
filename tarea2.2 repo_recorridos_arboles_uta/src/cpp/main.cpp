/* **************************************************************************
 * UNIVERSIDAD TECNICA DE AMBATO
 * Facultad de Ingenieria en Sistemas, Electronica e Industrial
 * Carrera: Ingenieria de Software
 * * ASIGNATURA: Estructura de Datos
 * TEMA:       Practica de Arboles Binarios (Ejercicios 1-5)
 * ESTUDIANTE: Estiven Chiluisa
 * NIVEL:      Tercero B
 * ************************************************************************** */

#include <iostream>
#include <queue>   
#include <string>

using namespace std;

// Estructura base para los nodos del arbol
struct Nodo {
    int dato;
    Nodo *izquierda, *derecha;
    Nodo(int v) : dato(v), izquierda(nullptr), derecha(nullptr) {}
};

class ArbolBST {
private:
    Nodo* raiz;

    // --- METODOS RECURSIVOS PRIVADOS ---
    /**
     * Se usa en EJERCICIOS 1, 2 y 6.
     * Logica: Compara el valor para decidir si insertarlo a la izquierda (menor)
     * o a la derecha (mayor), manteniendo la estructura de un arbol de busqueda.
     */
    Nodo* insertarRec(Nodo* n, int v) {
        if (!n) return new Nodo(v);
        if (v < n->dato) n->izquierda = insertarRec(n->izquierda, v);
        else if (v > n->dato) n->derecha = insertarRec(n->derecha, v);
        return n;
    }
    /**
     * Se usa en EJERCICIOS 1 y 2.
     * Orden: Raiz -> Izquierda -> Derecha.
     * Utilidad: Copiar la estructura exacta del arbol o jerarquias de menu.
     */

    void preorden(Nodo* n) {
        if (!n) return;
        cout << n->dato << " ";
        preorden(n->izquierda);
        preorden(n->derecha);
    }
    /**
     * Se usa en EJERCICIOS 1 y 2.
     * Orden: Izquierda -> Raiz -> Derecha.
     * Utilidad: En un BST, este recorrido devuelve los elementos ordenados de menor a mayor.
     */
    void inorden(Nodo* n) {
        if (!n) return;
        inorden(n->izquierda);
        cout << n->dato << " ";
        inorden(n->derecha);
    }
    /**
     * Se usa en EJERCICIOS 1 y 2.
     * Orden: Izquierda -> Derecha -> Raiz.
     * Utilidad: Ideal para liberar memoria (borrar nodos) o procesar dependencias internas.
     */

    void postorden(Nodo* n) {
        if (!n) return;
        postorden(n->izquierda);
        postorden(n->derecha);
        cout << n->dato << " ";
    }
    /**
     * Se usa en EJERCICIO 3.
     * Logica: Suma 1 por el nodo actual mas la suma de los nodos en ambos subarboles.
     */

    int contarNodos(Nodo* n) {
        if (!n) return 0;
        return 1 + contarNodos(n->izquierda) + contarNodos(n->derecha);
    }
    /**
     * Se usa en EJERCICIO 4.
     * Logica: Solo suma 1 si el nodo no tiene ningun hijo (es una hoja).
     */

    int contarHojas(Nodo* n) {
        if (!n) return 0;
        if (!n->izquierda && !n->derecha) return 1;
        return contarHojas(n->izquierda) + contarHojas(n->derecha);
    }
    /**
     * Metodo de gestion de memoria.
     * Logica: Usa un recorrido Postorden para borrar los hijos antes de borrar al padre.
     */

    void borrarArbol(Nodo* n) {
        if (!n) return;
        borrarArbol(n->izquierda);
        borrarArbol(n->derecha);
        delete n;
    }

public:
    ArbolBST() : raiz(nullptr) {}
    ~ArbolBST() { borrarArbol(raiz); }
    
    void insertar(int v) { raiz = insertarRec(raiz, v); }
    void limpiar() { borrarArbol(raiz); raiz = nullptr; }
    
    // Metodos publicos de visualizacion
    void mostrarPre() { preorden(raiz); cout << endl; }
    void mostrarIn() { inorden(raiz); cout << endl; }
    void mostrarPost() { postorden(raiz); cout << endl; }
    
    void mostrarBFS() {
        if (!raiz) return;
        queue<Nodo*> q;
        q.push(raiz);
        while (!q.empty()) {
            Nodo* actual = q.front(); q.pop();
            cout << actual->dato << " ";
            if (actual->izquierda) q.push(actual->izquierda);
            if (actual->derecha) q.push(actual->derecha);
        }
        cout << endl;
    }

    int getNodosTotal() { return contarNodos(raiz); }
    int getHojasTotal() { return contarHojas(raiz); }
};

// --- FUNCION PARA EL EJERCICIO 5  ---
void mostrarEjercicio5() {
    cout << "\n========================================================" << endl;
    cout << "EJERCICIO 5 - SISTEMA WEB (MODULOS)" << endl;
    cout << "========================================================" << endl;
    cout << "Estructura del Sistema:\n" << endl;
    cout << "            Sistema Web" << endl;
    cout << "            /         \\" << endl;
    cout << "      Usuarios       Inventario" << endl;
    cout << "       /     \\        /      \\" << endl;
    cout << "Registrar  Buscar  Productos  Reportes\n" << endl;
    
    cout << "RESPUESTAS A LAS PREGUNTAS DE LA GUIA:" << endl;
    cout << "--------------------------------------------------------" << endl;
    cout << "1. Mostrar el menu principal:" << endl;
    cout << "   -> RECORRIDO PREORDEN (Raiz, Izq, Der)." << endl;
    cout << "   Justificacion: Muestra primero el titulo del modulo y luego" << endl;
    cout << "   desglosa sus opciones, ideal para menus jerarquicos." << endl;
    
    cout << "\n2. Procesar primero los modulos internos (hojas):" << endl;
    cout << "   -> RECORRIDO POSTORDEN (Izq, Der, Raiz)." << endl;
    cout << "   Justificacion: Permite verificar o cargar todas las funciones" << endl;
    cout << "   finales (hojas) antes de habilitar el modulo padre." << endl;
    
    cout << "\n3. Mostrar modulos nivel por nivel:" << endl;
    cout << "   -> RECORRIDO BFS (Nivel por nivel usando cola)." << endl;
    cout << "   Justificacion: Utile para dashboards que muestran primero" << endl;
    cout << "   las categorias generales y luego el detalle tecnico." << endl;
    cout << "--------------------------------------------------------" << endl;
}

int main() {
    ArbolBST arbol;
    int opcion;

    do {
        cout << "\n------------------------------------------------------------" << endl;
        cout << "MENU PRINCIPAL:" << endl;
        cout << "------------------------------------------------------------" << endl;
        cout << "1. Ejercicio 1 - Arbol base (10, 5, 15, 2, 7, 12, 20)" << endl;
        cout << "2. Ejercicio 2 - Arbol con nodos adicionales (1, 3, 18, 25)" << endl;
        cout << "3. Ejercicio 3 - Contar nodos totales" << endl;
        cout << "4. Ejercicio 4 - Contar hojas" << endl;
        cout << "5. Ejercicio 5 - Sistema Web (Modulos)" << endl;
        cout << "6. Arbol con insercion manual" << endl;
        cout << "0. Salir" << endl;
        cout << "\nSeleccione opcion: ";
        cin >> opcion;
        cout << "------------------------------------------------------------" << endl;

        switch (opcion) {
            case 1:
            case 2:
                arbol.limpiar();
                arbol.insertar(10); arbol.insertar(5); arbol.insertar(15);
                arbol.insertar(2); arbol.insertar(7); arbol.insertar(12); arbol.insertar(20);
                
                if (opcion == 2) {
                    arbol.insertar(1); arbol.insertar(3); 
                    arbol.insertar(18); arbol.insertar(25);
                }

                cout << "\n------------------------------------------------------------" << endl;
                cout << "EJERCICIO " << opcion << ": ESTRUCTURA DEL ARBOL" << endl;
                cout << "------------------------------------------------------------" << endl;
                
                if (opcion == 1) {
                    cout << "        10" << endl;
                    cout << "       /  \\" << endl;
                    cout << "      5    15" << endl;
                    cout << "     / \\  / \\" << endl;
                    cout << "    2   7 12 20" << endl;
                } else {
                    cout << "          10" << endl;
                    cout << "        /    \\" << endl;
                    cout << "       5      15" << endl;
                    cout << "      / \\    /  \\" << endl;
                    cout << "     2   7  12   20" << endl;
                    cout << "    / \\         /  \\" << endl;
                    cout << "   1   3       18   25" << endl;
                }

                cout << "\nRECORRIDOS DETALLADOS:" << endl;
                cout << "Preorden:  "; arbol.mostrarPre();
                cout << "Inorden:   "; arbol.mostrarIn();
                cout << "Postorden: "; arbol.mostrarPost();
                cout << "BFS:       "; arbol.mostrarBFS();
                cout << "------------------------------------------------------------" << endl;
                cout << "Total nodos: " << arbol.getNodosTotal() << " | Hojas: " << arbol.getHojasTotal() << endl;
                break;

            case 3:
                cout << "\n[Ejercicio 3] Total de nodos en el arbol: " << arbol.getNodosTotal() << endl;
                break;

            case 4:
                cout << "\n[Ejercicio 4] Total de hojas en el arbol: " << arbol.getHojasTotal() << endl;
                break;

            case 5:
                mostrarEjercicio5();
                break;

            case 6:
                int valor;
                cout << "Ingrese valor para el nodo: ";
                cin >> valor;
                arbol.insertar(valor);
                cout << "Nodo insertado correctamente." << endl;
                break;

            case 0:
                cout << "Saliendo del programa..." << endl;
                break;

            default:
                cout << "Opcion invalida, intente de nuevo." << endl;
        }
    } while (opcion != 0);

    return 0;
}