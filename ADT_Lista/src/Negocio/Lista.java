/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author fernando Angulo
 */
public class Lista {

    //Atributos
    Nodo L;
    int cantidad;

    public Lista() {
        L = null;
        cantidad = 0;
    }

    public boolean Vacia() {
        return L == null;
    }

    public int cantidad() {
        return cantidad;
    }

    public void insertar(int elemento) {
        if (Vacia()) {
            Nodo p = new Nodo(elemento);
            L = p;
            cantidad++;
        } else {
            //aqui nos ubicamos en donde insertar el elemento
            Nodo aux = L;
            Nodo ant = null;
            while (aux != null && aux.getDato() <= elemento) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (ant == null) {//aqui entras si quieres insertar en la cabeza o primer nodo
                Nodo p = new Nodo(elemento);//creamos el nodo
                p.setEnlace(L);
                L = p;
                cantidad++;
            } else {
                if (ant.getDato() != elemento) {// esta condicion permite tener valores unicos en la lista
                    Nodo p = new Nodo(elemento);
                    ant.setEnlace(p);
                    p.setEnlace(aux);
                    cantidad++;
                }

            }

        }

    }

    //--Eliminar
    public void Eliminar(int elemento) {
        if (!Vacia()) {
            //aqui nos ubicamos en donde eliminaremos
            Nodo aux = L;
            Nodo ant = null;
            while (aux != null && aux.getDato() != elemento) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (ant == null) {//aqui entras si quieres eliminar en la cabeza o primer nodo
                L = aux.getEnlace();
                cantidad--;
            } else {
                if (aux != null) {// esta condicion permite tener valores unicos en la lista
                    Nodo p = aux.getEnlace();
                    ant.setEnlace(p);
                    cantidad--;
                }

            }

        }
    }

    public int sacar(int posi) {
        Nodo aux = L;
        int i = 1;
        while (i < posi) {

            aux = aux.getEnlace();
            i++;
        }
        return aux.getDato();
    }

    public boolean existe(int elemento) {
        Nodo aux = L;

        while (aux != null && aux.getDato() != elemento) {

            aux = aux.getEnlace();
        }
        return aux != null;
    }
    public String toString() {
        String S = "L -> ";
        Nodo aux = L;
        while (aux != null) {
            S = S + "[" + aux.getDato() + " | ]->";
            aux = aux.getEnlace();
        }
        return S + "null";
    }
     
    public int sumaI(){
        int suma=0;
        if (!Vacia()) {
            Nodo act= L;
            while (act != null) {
                suma = suma + act.getDato() ;
                act = act.getEnlace();
            } 
        }
        return suma;
    }
            
            
    //Recursivoo
    public int suma(){
        return SumaR(L);
    }
    
    private int SumaR(Nodo p){
        if(p==null){   //Caso base 
           return 0;
        }else{//caso general
            int s=SumaR(p.getEnlace());
            
            s=s+p.getDato();
            return s;
        }
    }
    
    
    public int promedio(){
        return promedioR(L)/cantidad;
                 //      16/4=4
    }
    
    private int promedioR(Nodo p){
        if(p==null){   //Caso base 
           return 0;
        }else{//caso general
            int s=promedioR(p.getEnlace());
            
            s=s+p.getDato();
            return s;
        }
    }
    
    public void invertirRecursivo(){
       invertirR(L); 
    }
    private void invertirR(Nodo p){
        if(p==null ){
            //nada
        }else{
            if (p.getEnlace()==null) {
                L=p;
            }else{ //caso general
              //  System.out.println(p.toString());
                invertirR(p.getEnlace());
                //Uniendo
                p.getEnlace().setEnlace(p);
                p.setEnlace(null);
            }
        }
    }
            
     
     public void invertira2() {
        Nodo aux = L; //[dato=1  | ]//[dato=2  | ]
        Nodo pos = L.getEnlace();//[dato=2  | ]
        Nodo ant = null;
        while (pos != null) { // L -> [1 | ]->[2 | ]->[3 | ]
            aux.setEnlace(pos.getEnlace());//el enlace de auxiliar 
            pos.setEnlace(aux);//el enlace de pos  apunta aux
            if (aux == L) {//si L
                L = pos;
            } else {
                ant.setEnlace(pos);
            }
            ant = aux;//
            aux = aux.getEnlace();
            if (aux == null) {
                pos = aux;
            } else {
                pos = aux.getEnlace();
            }
        }
    }
  /*  
    public void intercalar22(){
        //if (cantidad>1) {
            Nodo aux = L,ant = null;
              
            while (aux !=null) {                
                Nodo sig=aux.getEnlace();
                aux.setEnlace(sig.getEnlace());
                sig.setEnlace(aux);
                if (L==aux) {
                    L=sig;
                }else{
                    ant.setEnlace(sig);
                }
                ant=aux;
                aux=aux.getEnlace();
            }
        //}
    }*/
    
    public void intercalar(){
        if (cantidad>1) {
            Nodo aux,ant;
            if (cantidad%2==0) {
                aux=L;
                ant=null;
            }else{
                ant=L;
                aux=ant.getEnlace();
            }
            while (aux !=null) {                
                Nodo sig=aux.getEnlace();
                aux.setEnlace(sig.getEnlace());
                sig.setEnlace(aux);
                if (L==aux) {
                    L=sig;
                }else{
                    ant.setEnlace(sig);
                }
                ant=aux;
                aux=aux.getEnlace();
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        Lista L = new Lista();
        /*L.insertar(2);
        L.insertar(5);
        L.insertar(7);
        L.insertar(12);
        System.out.println(L.toString());
        //---------------------------
        L.insertar(6);
        System.out.println(L.toString());
        L.in(5);
        System.out.println(L.toString());*/
        for (int i = 1; i < 6; i++) {
            L.insertar(i);
        }
        System.out.println(L.toString());
        //L. invertira2();
      //  L.intercalar22();
        System.out.println(L.toString());
    }
}
