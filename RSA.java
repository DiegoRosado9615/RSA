import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

class RSA{
   Random r;
   public static final BigInteger UNO = new BigInteger("1");
   public static final BigInteger CERO = new BigInteger("0");
   public static final BigInteger MENOSUNO = new BigInteger("-1");

   /**
   Metodo que crea son los primos de al menos tamaño 50
   @param
   @return BigInteger
   */
   public BigInteger creadorPrimos(){
     int bitlength = 1024;
     Random r2= new Random();
     BigInteger p=BigInteger.probablePrime(bitlength,r2);
     return p;
   }

   /**
   *Metodo que permite la creación de el modulo donde va a vivir nuestro RSA
   *@param
   *@return BigInteger
   */

   public BigInteger creadorLlave(){
     BigInteger p = creadorPrimos();
     BigInteger q = creadorPrimos();
      while((p.compareTo(q))==0){ // verifico que p no sea igual a q
        q=creadorPrimos();
      }
      BigInteger llave = new BigInteger("0");
      BigInteger producto= p.multiply(q);
      System.out.println("##########################");
      System.out.println("Esta es la llave " + producto );
      p=p.add(MENOSUNO);
      q=q.add(MENOSUNO);
      llave=llave.add(p);
      llave=llave.multiply(q);
     return llave;
   }
   /**
   *Metodo que nos permitira saber si un número es primo o no
   *@param int x
   *@return
   */

   public boolean esPrimo(int x){
    int contador=2;
    boolean primo =true;
    while ((contador!=x)){
      if (x % contador == 0){
          primo = false;
          return primo;
      }
      contador++;
    }
    return  primo;
   }

   /**
   *Metodo que nos genera un número que sea coprimo de nuesta llave
   *@param BigInteger x
   *@return int x
   */
   public int cooPrimo(BigInteger x){
     BigInteger proCop= new BigInteger("0");
     String cast ="";
     String sobrante;
     int esperanza=0;
     BigInteger modulo;
     for (int i=0;i<10000 ;i++ ) {
        if (esPrimo(i)) {
          cast=i+"";
          proCop= new BigInteger(cast);
          modulo=x.mod(proCop);
          sobrante=modulo.toString();
          if ("0"!=sobrante) {
            System.out.println("Este es k " + i );
            return i;
          }
        }
     }
     System.out.println("Por favor intente de nuevo :C ");
     return -1;
   }

   /**
   *Metodo que permite hacer MCD, recibe un entero y un big integer  ,
   *@param int x
   *@param BigInteger y
   *@param BigInteger z
   */
   public BigInteger mcd(BigInteger x, BigInteger y){
     BigInteger cero= new BigInteger("0");
     if ((x.compareTo(cero)) == 0) return y;
     if ((y.compareTo(cero)) == 0) return x;
     else{
       BigInteger z=  x.mod(y);
       return mcd(y,z);
     }
   }//mcd

   public BigInteger inversoMultiplicativo(BigInteger a, BigInteger m){
     BigInteger c1 = UNO;
     BigInteger c2 = MENOSUNO.multiply(m.divide(a));
     BigInteger t1 = CERO;
     BigInteger t2 = UNO;
     BigInteger r = m.mod(a);
     BigInteger x = a;
     BigInteger y = r;
     BigInteger c ;
     BigInteger t1p;
     BigInteger t2p;
     while ((r.compareTo(CERO)) !=0 ) {
       c  = x.divide(y);
       r  = x.mod(y);
       c1 = (MENOSUNO.multiply(c)).multiply(c1);
       c2 = (MENOSUNO.multiply(c)).multiply(c2);
       c1 = c1.add(t1);
       c2 = c2.add(t2);
       t1p = (c1.add(MENOSUNO.multiply(t1)));
       t2p = (c2.add(MENOSUNO.multiply(t2)));
       t1 = (MENOSUNO.multiply(t1p)).divide(c);
       t2 = (MENOSUNO.multiply(t2p)).divide(c);
       x=y;
       y=r;
     }
     if(x.compareTo(UNO) ==  0) return t2.mod(m);
     else{
       System.out.println("No tuvo inverso lo siento F");
       return MENOSUNO;
     }
   }//inversoMultiplicativo

   /**
   Metodo auxiliarque recibe un char y lo transforma en número
   *@param char x
   *@return String y
   */
   public String letraNum(char x){
     switch(x){
       case 'a':
       return "0";

       case 'b' :
       return "1";

       case 'c':
       return "2";

       case 'd' :
       return "3";

       case 'e':
       return "4";

       case 'f' :
       return "5";

       case 'g':
       return "6";

       case 'h' :
       return "7";

       case 'i':
       return "8";

       case 'j' :
       return "9";

       case 'k':
       return "10";

       case 'l' :
       return "11";

       case 'm':
       return "12";

       case 'n' :
       return "13";

       case 'ñ':
       return "14";

       case 'o' :
       return "15";

       case 'p':
       return "16";

       case 'q' :
       return "17";

       case 'r':
       return "18";
       case 's' :

       return "19";

       case 't':
       return "20";

       case 'u' :
       return "21";

       case 'v':
       return "22";

       case 'w' :
       return "23";

       case 'x':
       return "24";

       case 'y' :
       return "25";

       case 'z':
       return "26";

       case ' ' :
       return "27";

       case ',' :
       return "28";

     }
     return "0";
   }//letraNum

   /**
   *Metodo que me permite transformar un string a una lista de String pero en su forma
   *numerica para poder despues transformarlos en bigInteger en la codificacion
   *@param String x
   *@return List <String> y
   */

   public ArrayList <String> combertidor(String x){
     String numero="";
     return null;
   }



  public static void main(String[] args) {
    RSA prueba= new RSA();

    //BigInteger numeros= prueba.creadorLlave();
    //int x= prueba.cooPrimo(numeros);
    //BigInteger numero1= new BigInteger("11");
    //BigInteger numero2= new BigInteger("224");
    //BigInteger numero3= numero1.divide(numero2);
    //System.out.println(prueba.inversoMultiplicativo(numero1,numero2));
    //System.out.println(prueba.mcd(numero1,numero2));

  }

}
