package com.ph3.tmp;

import java.util.*;  

public class Test04 {  
   public static void main(String[] args) {  
        
    ArrayList<String> listaColores = new ArrayList<String>();  
  
    listaColores.add("Blanco");  
    listaColores.add("Negro");  
    listaColores.add("Rojo");  
     
    ArrayList<String> lista2 = new ArrayList<String>();  
      
    lista2.add("Verde");   
    lista2.add("Rojo");   
    lista2.add("Blanco");  
      
    System.out.println("Primera lista : "+ listaColores);  
    System.out.println("Segunda lista : "+ lista2); 
    
    lista2.removeAll(listaColores);  
      
    System.out.println("Primera lista (después): "+ listaColores);  
    System.out.println("Segunda lista (después): "+ lista2);  
  
  }  
} 