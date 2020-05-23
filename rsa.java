import java.math.BigInteger;
public class rsa{

	public BigInteger generaLlaves(){

		return null;

	}
	
	public static byte[] cifrar(BigInteger n, BigInteger e, byte[] mensaje){
	
	return (new BigInteger(mensaje).modPow(e,n)).toByteArray();

	}

	public static String imprimeBytes(byte[] mensaje, String cad){
		int c = 0;
		for (byte b : mensaje ) {
			c++;
			cad+=Byte.toString(b) + "\t";
		}
		return cad+"\t c: "+c;
	}

	public static byte[]  descrifrar(BigInteger n, BigInteger d, byte [] mensaje){

		return (new BigInteger(mensaje)).modPow(d, n).toByteArray();
		
	}

	public static void main(String[] args) {
	
		String mensaje="mensaje,";
		BigInteger n = new BigInteger("2257");
		BigInteger e = new BigInteger("7");
		BigInteger d = new BigInteger("1543");


		System.out.println("Mensaje en Bytes: "+ imprimeBytes(mensaje.getBytes() , ""));
		System.out.println("cifrado:");
		System.out.println();
		byte [] encripyt = cifrar(n,e,mensaje.getBytes());
		System.out.println(imprimeBytes(encripyt,""));
		System.out.println("\n\nDescifrado:\n");
		System.out.println(imprimeBytes());

		
	}

}