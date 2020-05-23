import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

class RSA{
   Random r;
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
     BigInteger resta= new BigInteger("-1");
      while((p.compareTo(q))==0){ // verifico que p no sea igual a q
        q=creadorPrimos();
      }
      BigInteger llave = new BigInteger("0");
      BigInteger producto= p.multiply(q);
      System.out.println("##########################");
      System.out.println("Esta es la llave " + producto );
      p=p.add(resta);
      q=q.add(resta);

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


  public static void main(String[] args) {
    RSA prueba= new RSA();
    BigInteger numeros= prueba.creadorLlave();
    int x= prueba.cooPrimo(numeros);



  }

}
