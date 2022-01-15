package arbolesbinarios;

public class NodoArbol {
    //Atributos
    private int atrDato;
    private String atrNombre; 
    private NodoArbol atrPadre, atrHijoIzquierdo, atrHijoDerecho;

    //Constructor parametrizado
    public NodoArbol(int prmDato, String prmNombre){
        this.atrDato = prmDato;
        this.atrNombre = prmNombre;
        this.atrPadre = null;
        this.atrHijoIzquierdo = null;
        this.atrHijoDerecho = null;
    }
    
    public NodoArbol(int prmDato){
        this.atrDato = prmDato;
        this.atrNombre = "";
        this.atrPadre = null;
        this.atrHijoIzquierdo = null;
        this.atrHijoDerecho = null;
    }

    public int getAtrDato() {
        return atrDato;
    }

    public void setAtrDato(int atrDato) {
        this.atrDato = atrDato;
    }

    public String getAtrNombre() {
        return atrNombre;
    }

    public void setAtrNombre(String atrNombre) {
        this.atrNombre = atrNombre;
    }

    public NodoArbol getAtrPadre() {
        return atrPadre;
    }

    public void setAtrPadre(NodoArbol atrPadre) {
        this.atrPadre = atrPadre;
    }

    public NodoArbol getAtrHijoIzquierdo() {
        return atrHijoIzquierdo;
    }

    public void setAtrHijoIzquierdo(NodoArbol atrHijoIzquierdo) {
        this.atrHijoIzquierdo = atrHijoIzquierdo;
    }

    public NodoArbol getAtrHijoDerecho() {
        return atrHijoDerecho;
    }

    public void setAtrHijoDerecho(NodoArbol atrHijoDerecho) {
        this.atrHijoDerecho = atrHijoDerecho;
    }
    
    //Metodo para retornar el nombre y el dato del nodo
    public String informacionBasica(){
        return "Nombre: " + atrNombre + "\nDato: " + atrDato + "\n";
    }
}
