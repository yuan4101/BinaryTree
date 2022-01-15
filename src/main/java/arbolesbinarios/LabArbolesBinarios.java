package arbolesbinarios;

import javax.swing.JOptionPane;

public class LabArbolesBinarios {
    
    public static void main(String[] args) {
        int varOpcion = 0, varElemento, varNumero;
        NodoArbol varNodo, varNodoTemp;
        String varNombre;
        ArbolBinario miArbol = new ArbolBinario();
        do {
            try{
                varOpcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        1. Agregar un Nodo
                        2. Imprimir Arbol
                        3. Recorre arbol PREORDEN
                        4. Recorre arbol INORDEN
                        5. Recorre arbol POSORDEN
                        6. Buscar Nodo
                        7. Eliminar Nodo
                        8. Salir
                        Elige una opcion...
                        """, "Arboles Binarios", JOptionPane.QUESTION_MESSAGE));
                switch(varOpcion){
                    case 1 -> {
                        varElemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el numero del nodo: ",
                                "Agregando Nodo", JOptionPane.QUESTION_MESSAGE));
                        varNombre = JOptionPane.showInputDialog(null,
                                "Ingresa el nombre del nodo: ",
                                "Agregando Nodo", JOptionPane.QUESTION_MESSAGE);
                        miArbol.agregarNodo(varElemento, varNombre);
                    }
                    
                    case 2 -> {
                        if (miArbol.estaVacio()) {
                            JOptionPane.showMessageDialog(null,
                                    "EL ARBOL ESTA VACIO",
                                    "!!CUIDADO!!2", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        miArbol.imprimirArbol();
                        JOptionPane.showMessageDialog(null,
                                    miArbol.atrImprimir,
                                    "!!CUIDADO!!2", JOptionPane.INFORMATION_MESSAGE);
                        miArbol.cleanStrings();
                    }
                        
                    case 3 -> {
                        if (!miArbol.estaVacio()) {
                            System.out.println();
                            miArbol.preOrden(miArbol.atrRaiz);
                            JOptionPane.showMessageDialog(null,
                                    "Preorden: " + miArbol.atrPreorden,
                                    "!!CUIDADO!!3", JOptionPane.INFORMATION_MESSAGE);
                            miArbol.cleanStrings();
                        }else{
                            JOptionPane.showMessageDialog(null,
                                    "EL ARBOL ESTA VACIO",
                                    "!!CUIDADO!!3", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    
                    case 4 -> {
                        if (!miArbol.estaVacio()) {
                            System.out.println();
                            miArbol.inOrden(miArbol.atrRaiz);
                            JOptionPane.showMessageDialog(null,
                                    "Inorden: " + miArbol.atrInorden,
                                    "!!CUIDADO!!4", JOptionPane.INFORMATION_MESSAGE);
                            miArbol.cleanStrings();
                        }else{
                            JOptionPane.showMessageDialog(null,
                                    "EL ARBOL ESTA VACIO",
                                    "!!CUIDADO!!4", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    
                    case 5 -> {
                        if (!miArbol.estaVacio()) {
                            System.out.println();
                            miArbol.posOrden(miArbol.atrRaiz);
                            JOptionPane.showMessageDialog(null,
                                    "Posorden: " + miArbol.atrPosorden,
                                    "!!CUIDADO!!5", JOptionPane.INFORMATION_MESSAGE);
                            miArbol.cleanStrings();
                        }else{
                            JOptionPane.showMessageDialog(null,
                                    "EL ARBOL ESTA VACIO",
                                    "!!CUIDADO!!5", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    
                    case 6 -> {
                        if (miArbol.estaVacio()) {
                            JOptionPane.showMessageDialog(null,
                                    "EL ARBOL ESTA VACIO",
                                    "!!CUIDADO!!6", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        varNumero = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el numero del nodo a buscar: ",
                                "Buscar Nodo", JOptionPane.QUESTION_MESSAGE));
                        varNodo = miArbol.buscarNodo(varNumero);
                        if (varNodo == null) {
                            JOptionPane.showMessageDialog(null,
                                    "El nodo no se encuentra en el arbol",
                                    "!!CUIDADO!!6", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,
                                    "Informacion del nodo\n" +
                                    varNodo.informacionBasica(),
                                    "Nodo",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    
                    case 7 -> {
                        if (miArbol.estaVacio()) {
                            JOptionPane.showMessageDialog(null,
                                    "EL ARBOL ESTA VACIO",
                                    "!!CUIDADO!!7", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        varNumero = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el nodo a eliminar: ",
                                "Eliminar Nodo", JOptionPane.QUESTION_MESSAGE));
                        varNodoTemp = miArbol.buscarNodo(varNumero);
                        if (varNodoTemp == null) {
                            JOptionPane.showMessageDialog(null,
                                    "EL NODO NO EXISTE",
                                    "!!CUIDADO!!7", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        JOptionPane.showMessageDialog(null,
                                    "El nodo\n" + varNodoTemp.informacionBasica() +
                                    "se esta eliminando", "!!CUIDADO!!6",
                                    JOptionPane.INFORMATION_MESSAGE);
                        if (!miArbol.eliminarNodo(varNodoTemp))
                        {
                            JOptionPane.showMessageDialog(null,
                                    "El nodo no se encuentra en el arbol",
                                    "!!CUIDADO!!7", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,
                                    "El nodo\n" +
                                    "se ha eliminado", "!!CUIDADO!!6",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                        
                    case 8 -> JOptionPane.showMessageDialog(null,
                                "APLICACION FINALIZADA",
                                "FIN", JOptionPane.INFORMATION_MESSAGE);
                        
                    default -> JOptionPane.showMessageDialog(null,
                                "OPCION INCORRECTA",
                                "!!CUIDADO!!", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(NumberFormatException n){
                JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
            }
        } while (varOpcion != 8);
        
    }
}
