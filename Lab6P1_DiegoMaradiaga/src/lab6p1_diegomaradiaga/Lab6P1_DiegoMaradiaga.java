package lab6p1_diegomaradiaga;

import java.util.Scanner;
import java.util.Random;

public class Lab6P1_DiegoMaradiaga {

    static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();
    
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("");
            System.out.println("-----------------------------------------");
            System.out.println("              >>>> MENU <<<<             ");
            System.out.println(" ");
            System.out.println("1) Turing                  ");
            System.out.println("2) Kaprekar                ");
            System.out.println("3) Salir                   ");
            System.out.print("Ingrese su opcion: ");
            opcion = leer.nextInt();
            System.out.println("");

            switch (opcion) {
                case 1: { 
                    System.out.println("Turing");
                    System.out.print("Ingrese el tamano del arreglo: ");
                    int tamano = leer.nextInt();
                    
                    int [] arregloG = new int [tamano];
                    arregloG = lectura (tamano);
                    
                    System.out.print("Arreglo generado: ");
                    imprimir(arregloG);
                    System.out.println("");
                    
                    System.out.print("Ingrese la cadena de instrucciones \n(caracteres entre R,L,X): ");
                    String cadena = leer.next().toUpperCase();
                    int cont = 0;
                    
                    for (int i = 0; i < cadena.length(); i++) {
                        char c = cadena.charAt(i);
                        int n = (int) c;
                        if (n!=76 && n!=82 && n!=88){
                            cont= cont + 1;
                        }    
                    }//Fin for
                    
                    while (cont > 0){
                        System.out.println("Error: Ingrese caracteres (R, L o X)");
                        System.out.print("Ingrese la cadena de instrucciones: ");
                        cadena = leer.next().toUpperCase();
                        cont = 0;
                        
                        for (int i = 0; i < cadena.length(); i++) {
                        char c = cadena.charAt(i);
                        int n = (int) c;
                        if (n!=76 && n!=82 && n!=88){
                            cont= cont + 1;
                        }    
                    }//Fin for
                        
                    }//Fin while de validacion
                    System.out.println("Cadena generada: "+puntero(cadena,arregloG));
                }//Fin case 1
                break;
                
                case 2: {
                    System.out.println("Kaprekar");
                    System.out.print("Ingrese un numero de 4 cifras: ");
                    int cifra = leer.nextInt();
                    int cont = 0;
                    int conterror = 0;
                    
                    String cifraS = String.valueOf(cifra);

                    for (int i = 0; i < cifraS.length(); i++) {
                        char c = cifraS.charAt(i);
                        cont = cont + 1;
                    }

                    while (cont != 4) {
                        System.out.print("Ingrese un numero DE 4 CIFRAS: ");
                        cifra = leer.nextInt();
                        cont = 0;

                        cifraS = String.valueOf(cifra);

                        for (int i = 0; i < cifraS.length(); i++) {
                            char c = cifraS.charAt(i);
                            cont = cont + 1;
                        }
                    }//Fin while validacion de 4 digitos
                    
                    
                    /*int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0, cont5 = 0; 
                    int cont6 = 0, cont7 = 0, cont8 = 0, cont9 = 0;
                    
                    for (int i = 0; i < cifraS.length(); i++) {
                        char c = cifraS.charAt(i);
                        
                        switch (c){
                            case '1':
                            cont1++;
                            case '2':
                            cont2++;
                            case '3':
                            cont3++;
                            case '4':
                            cont4++;
                            case '5':
                            cont5++;
                            case '6':
                            cont6++;
                            case '7':
                            cont7++;
                            case '8':
                            cont8++;
                            case '9':
                            cont9++;                               
                        }
                        if (cont1>3||cont2>3||cont3>3||cont4>3||cont5>3||cont6>3||cont7>3||cont8>3||cont9>3){
                            System.out.println("El número ingresado no es válido.");
                            conterror = conterror + 1;
                        }//Fin if
                    }//Fin for*/
                    
                    imprimir(conversionArray(cifra));
                    
                }
                break;
                
                case 3: {
                    System.out.println("Saliendo...");
                }
                break;
            }
        } while (opcion != 3);
    }//Fin metodo main
    
    public static int [] lectura(int tamano){
        int [] temporal = new int [tamano];
        for (int i = 0; i < temporal.length; i++) {
            temporal [i] = 1 + aleatorio.nextInt(10);
        }
        return temporal;
    }//Fin metodo lectura
    
    public static void imprimir (int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print("["+array[i]+ "]");   
        }
    }//Fin metodo imprimir
    
    public static String puntero (String cadena,int[] arreglo){
        String acum = "";
        int apuntador = 0;
        
        for (int i = 0; i < cadena.length(); i++) {
            char pos = cadena.charAt(i);
            if (pos == 'R'){
                apuntador += 1;
            }else if (pos == 'L'){
                apuntador -= 1;
            }else if (pos == 'X'){
                acum += arreglo[apuntador];
            }
        }//Fin for  
        
        return acum;
    }
   
    public static int [] conversionArray(int cifra){
        int [] temporal = new int [4];
        String cifraF = String.valueOf(cifra);
        
        for (int i = 0; i < cifraF.length(); i++) {
            char c = cifraF.charAt(i);
            int N = ((int) c)-48;
            temporal [i] = N;
        }
        return temporal;
    }
    
    public static String conversionaNum (int [] arreglo){
        String acum = "";
        for (int i = 0; i < arreglo.length; i++) {
            acum += arreglo[i];
        }
        
    return acum;      
    }
    
    public static int [] ascendente (int [] arreglo, int cifra){
        int [] temporalA = new int [arreglo.length];
        String cifraF = String.valueOf(cifra);
        int acumnum = 0;
        
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < cifraF.length(); j++) {
                char caracter = cifraF.charAt(i);
                int num = (int) caracter;
                int num2 = acumnum;
                if (num > num2) {
                temporalA [i] += cifraF.charAt(i);                
                }  
            }
            
        }//Fin for 
        
        return temporalA;
    }
    
    public static int [] descendente (int [] arreglo, int cifra){
        int [] temporalD = new int [arreglo.length];
        String cifraF = String.valueOf(cifra);
        int acumnum = 0;
        
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < cifraF.length(); j++) {
              char caracter = cifraF.charAt(i);
            int num = (int) caracter;
            int num2 = acumnum;
            if (num > num2) {
                temporalD [i] += cifraF.charAt(i);                
            }  
            }
            
        }//Fin for 
        
        return temporalD;
    }
    
    
    
}//Fin clase
