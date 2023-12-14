/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author fernando El 23
 */
public class Nodo {
    int dato;
    Nodo Enlace;
    //constructor sin parametros
    public Nodo(){
        //dato=0;
        Enlace=null;
    }
    //constructor con parametros
    public Nodo(int dato, Nodo p) {
        this.dato = dato;
        this.Enlace = p;
    }

    public Nodo(int dato) {
        this.dato = dato;
        this.Enlace = null;
    }
    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setEnlace(Nodo p) {
        this.Enlace = p;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getEnlace() {
        return Enlace;
    }

    @Override
    public String toString() {
        String s="[dato=";
        s=s+getDato();
        return s+" | ]";
    }
    public static void main(String[] args) {
        Nodo p=new Nodo();
        p.setDato(2);
        System.out.println(p.toString());
         System.out.println(p.toString()+"->"+p.getEnlace());
         Nodo q=new Nodo();
        q.setDato(1);
        System.out.println(q.toString());
         Nodo r=new Nodo();
        r.setDato(3);
        System.out.println(r.toString());
        //-------------------------------------------------
        //Enlazando nodos setEnlace
        q.setEnlace(p);// aqui enlazamos dos nodos q apunta a p
        System.out.println(q.toString()+"->"+q.getEnlace());
        p.setEnlace(r);// aqui enlazamos dos nodos p apunta a r
        System.out.println(q.toString()+"->"+q.getEnlace()+"->"+q.getEnlace().getEnlace());
        
                
    }
}
