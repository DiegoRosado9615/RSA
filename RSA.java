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
   *Metodo que permite la creación de la llave privada para el metodo RSa
   */

   public BigInteger creadorLlave(){
     BigInteger p = creadorPrimos();
     BigInteger q = creadorPrimos();
     BigInteger resta= new BigInteger("-1");
      while(p==q){ // verifico que p no sea igual a q
        q=creadorPrimos();
      }
      BigInteger llave = new BigInteger("0");
      p=p.add(resta);
      q=q.add(resta);
      llave=llave.add(p);
      llave=llave.add(q);
     return llave;
   }



  public static void main(String[] args) {
    RSA prueba= new RSA();
    System.out.println(prueba.creadorLlave());
    //prueba.creadorLlave();
  }

}
