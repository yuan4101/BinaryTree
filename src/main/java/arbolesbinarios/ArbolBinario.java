package arbolesbinarios;

public class ArbolBinario {

    //Atributos
    NodoArbol atrRaiz;
    String atrPreorden = "";
    String atrInorden = "";
    String atrPosorden = "";
    String atrImprimir = "";
    NodoArbol varTemp = null;

    //Constructor no parametrizado
    public ArbolBinario() {
        atrRaiz = null;
    }

    //Metodo para limpiar los strings
    public void cleanStrings() {
        atrPreorden = "";
        atrInorden = "";
        atrPosorden = "";
        atrImprimir = "";
    }

    //Metodo para agregar un nodo
    public void agregarNodo(int prmDato){
        agregarNodo(prmDato, "");
    }
    public void agregarNodo(int prmDato, String prmNombre) {
        NodoArbol varNuevoNodo = new NodoArbol(prmDato, prmNombre);
        if (atrRaiz == null) {
            atrRaiz = varNuevoNodo;
        }
        else {
            NodoArbol varNodoAuxiliar = atrRaiz;
            NodoArbol varNodoPadre;
            while (true) {
                varNodoPadre = varNodoAuxiliar;
                if (prmDato < varNodoAuxiliar.getAtrDato()) {
                    varNodoAuxiliar = varNodoAuxiliar.getAtrHijoIzquierdo();
                    if (varNodoAuxiliar == null) {
                        varNuevoNodo.setAtrPadre(varNodoPadre);
                        varNodoPadre.setAtrHijoIzquierdo(varNuevoNodo);
                        return;
                    }
                }
                else {
                    varNodoAuxiliar = varNodoAuxiliar.getAtrHijoDerecho();
                    if (varNodoAuxiliar == null) {
                        varNuevoNodo.setAtrPadre(varNodoPadre);
                        varNodoPadre.setAtrHijoDerecho(varNuevoNodo);
                        return;
                    }
                }
            }
        }
    }

    //Metodo para saber si un arbol esta vacio
    public boolean estaVacio() {
        return atrRaiz == null;
    }

    //Metodo para recorrer el arbol PREORDEN (R - I - D)
    public void preOrden(NodoArbol prmNodoArbol) {
        if (prmNodoArbol != null) {
            atrPreorden += prmNodoArbol.getAtrDato() + " ";
            System.out.print(" " + prmNodoArbol.getAtrDato());
            preOrden(prmNodoArbol.getAtrHijoIzquierdo());
            preOrden(prmNodoArbol.getAtrHijoDerecho());
        }
    }

    //Metodo para recorrer el arbol INORDEN (I - R - D)
    public void inOrden(NodoArbol prmNodoArbol) {
        if (prmNodoArbol != null) {
            inOrden(prmNodoArbol.getAtrHijoIzquierdo());
            atrInorden += prmNodoArbol.getAtrDato() + " ";
            System.out.print(" " + prmNodoArbol.getAtrDato());
            inOrden(prmNodoArbol.getAtrHijoDerecho());
        }
    }

    //Metodo para recorrer el arbol POSORDEN (I - D - R)
    public void posOrden(NodoArbol prmNodoArbol) {
        if (prmNodoArbol != null) {
            posOrden(prmNodoArbol.getAtrHijoIzquierdo());
            posOrden(prmNodoArbol.getAtrHijoDerecho());
            atrPosorden += prmNodoArbol.getAtrDato() + " ";
            System.out.print(" " + prmNodoArbol.getAtrDato());
        }
    }

    //Metodo para buscar un nodo
    public NodoArbol buscarNodo(int prmDato) {
        NodoArbol varNodo = atrRaiz;
        if (estaVacio()) {
            return null;
        }
        do {
            if (prmDato < varNodo.getAtrDato()) {
                varNodo = varNodo.getAtrHijoIzquierdo();
            }
            else if (prmDato > varNodo.getAtrDato()) {
                varNodo = varNodo.getAtrHijoDerecho();
            }
            if (varNodo == null) {
                return null;
            }
        } while (varNodo.getAtrDato() != prmDato);
        return varNodo;
    }
    
    //Metodo para imprimir un arbol
    public void imprimirArbol() {
        atrImprimir = "Nivel | Dato\n";
        imprimirArbol(atrRaiz, 0);
    }
    private void imprimirArbol(NodoArbol prmNodoArbol, int prmNivel) {
        if (prmNodoArbol != null) {
            imprimirArbol(prmNodoArbol.getAtrHijoIzquierdo(), prmNivel + 1);
            atrImprimir += "\t    " + prmNivel + "    \t|\t    "
                    + prmNodoArbol.getAtrDato() + "    \t" + "\n";
            imprimirArbol(prmNodoArbol.getAtrHijoDerecho(), prmNivel + 1);
        }
    }
   
    //Metodo para Eliminar un nodo
    public boolean eliminarNodo(NodoArbol prmNodo) {
        boolean varTieneNodoDerecha = prmNodo.getAtrHijoDerecho() != null;
        boolean varTieneNodoIzquierda = prmNodo.getAtrHijoIzquierdo() != null;
        if (varTemp == null) {
            varTemp = prmNodo;
        }
        //Caso 1: Es un nodo hoja
        if (!varTieneNodoIzquierda && !varTieneNodoDerecha) {
            return eliminarCaso1(prmNodo);
        }
        //Caso 2 (Izquierda): Un hijo izquierdo
        if (varTieneNodoIzquierda && !varTieneNodoDerecha) {
            //Si ese hijo es subraiz
            if (prmNodo.getAtrHijoIzquierdo().getAtrHijoIzquierdo() != null || prmNodo.getAtrHijoIzquierdo().getAtrHijoDerecho() != null) {
                if (prmNodo.getAtrPadre() == varTemp) {
                    varTemp = null;
                    return eliminarCaso2(prmNodo);
                }
                return eliminarCaso3RD(prmNodo);
            }
            return eliminarCaso2(prmNodo);
        }
        //Caso 2 (Derecha): Un hijo derecho
        if (!varTieneNodoIzquierda && varTieneNodoDerecha) {
            //Si ese hijo es subraiz
            if (prmNodo.getAtrHijoDerecho().getAtrHijoIzquierdo() != null || prmNodo.getAtrHijoDerecho().getAtrHijoDerecho() != null) {
                if (prmNodo.getAtrPadre() == varTemp) {
                    varTemp = null;
                    return eliminarCaso2(prmNodo);
                }
                return eliminarCaso3RI(prmNodo);
            }
            return eliminarCaso2(prmNodo);
        }
        //Caso 3: Tiene ambos hijos
        if (varTieneNodoDerecha && varTieneNodoIzquierda) {
            if (prmNodo.getAtrPadre() == varTemp) {
                    varTemp = null;
                    return eliminarCaso2(prmNodo);
                }
            return eliminarCaso3RI(prmNodo);
        }
        return false;
    }
    //Metodo para la eliminacion caso 1
    private boolean eliminarCaso1(NodoArbol prmNodo) {
        if (prmNodo.getAtrPadre() == null) {
            atrRaiz = null;
        }
        NodoArbol varHijoIzquierdo = prmNodo.getAtrPadre().getAtrHijoIzquierdo();
        NodoArbol varHijoDerecho = prmNodo.getAtrPadre().getAtrHijoDerecho();

        if ( varHijoIzquierdo == prmNodo ) {
            prmNodo.getAtrPadre().setAtrHijoIzquierdo(null);
            return true;
        }

        if ( varHijoDerecho == prmNodo) {
            prmNodo.getAtrPadre().setAtrHijoDerecho(null);
            return true;
        }
        return false;
    }
    //Metodo para la eliminacion caso 2
    private boolean eliminarCaso2(NodoArbol prmNodo) {
        if (prmNodo.getAtrPadre() == null) {
            boolean varEstaIzquierda = prmNodo.getAtrHijoIzquierdo() != null;
            NodoArbol varHijoActual = varEstaIzquierda ? 
                prmNodo.getAtrHijoIzquierdo() : prmNodo.getAtrHijoDerecho();
            if (varEstaIzquierda) {
                atrRaiz = varHijoActual;
            }
            else
            {
                atrRaiz = varHijoActual;
            }
        }
        NodoArbol varHijoIzquierdo = prmNodo.getAtrPadre().getAtrHijoIzquierdo();
        NodoArbol varHijoDerecho = prmNodo.getAtrPadre().getAtrHijoDerecho();

        NodoArbol varHijoActual = prmNodo.getAtrHijoIzquierdo() != null ? 
                prmNodo.getAtrHijoIzquierdo() : prmNodo.getAtrHijoDerecho();

        if (varHijoIzquierdo == prmNodo) {
            prmNodo.getAtrPadre().setAtrHijoIzquierdo(varHijoActual);
            varHijoActual.setAtrPadre(prmNodo.getAtrPadre());
            return true;
        }
        
        if (varHijoDerecho == prmNodo) {
            varHijoActual.setAtrPadre(prmNodo.getAtrPadre());
            prmNodo.getAtrPadre().setAtrHijoDerecho(varHijoActual);
            return true;
        }
        return false;
    }
    //Metodo para la eliminacion caso 3 rama derecha
    private boolean eliminarCaso3RI(NodoArbol prmNodo) {
        NodoArbol varNodoMasALaIzquierda = recorrerIzquierda(prmNodo.getAtrHijoDerecho());
        if (varNodoMasALaIzquierda != null) {
            prmNodo.setAtrDato(varNodoMasALaIzquierda.getAtrDato());
            eliminarNodo(varNodoMasALaIzquierda);
            return true;
        }
        return false;
    }
    //Metodo para la eliminacion caso 3 rama izquierda
    private boolean eliminarCaso3RD(NodoArbol prmNodo) {
        NodoArbol varNodoMasALaDerecha = recorrerDerecha(prmNodo.getAtrHijoIzquierdo());
        if (varNodoMasALaDerecha != null) {
            prmNodo.setAtrDato(varNodoMasALaDerecha.getAtrDato());
            eliminarNodo(varNodoMasALaDerecha);
            return true;
        }
        return false;
    }
    
    //Metodo para recorrer de forma recursiva hasta encontrar el nodo más a la izquierda
    private NodoArbol recorrerIzquierda(NodoArbol prmNodo) {
        if (prmNodo.getAtrHijoIzquierdo() != null) {
            return recorrerIzquierda( prmNodo.getAtrHijoIzquierdo() );
        }
        return prmNodo;
    }
    //Metodo para recorrer de forma recursiva hasta encontrar el nodo más a la derecha
    private NodoArbol recorrerDerecha(NodoArbol prmNodo) {
        if (prmNodo.getAtrHijoDerecho() != null) {
            return recorrerDerecha( prmNodo.getAtrHijoDerecho() );
        }
        return prmNodo;
    }
}