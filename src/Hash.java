import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public static String getDigest(String password){
        byte[] passwordBytes;
        byte[] resumen;
        String resumenHexadecimal = "";
        try {
            // Convierto la contraseña introducida por el usuario en un array de bytes
            passwordBytes = password.getBytes("UTF-8");

            // Creo una instancia de MessageDigest con el algoritmo SHA-512
            MessageDigest algoritmo = MessageDigest.getInstance("SHA-512");

            // Reiniciamos el objeto por si contiene datos
            algoritmo.reset();

            // Añadimos la contraseña de la cual quiero calcular su hash
            algoritmo.update(passwordBytes);

            // Generamos el resumen
            resumen = algoritmo.digest();

            //Lo pasamos a formato haxadecimal
            resumenHexadecimal = String.format("%064x", new BigInteger(1, resumen));

        } catch (NoSuchAlgorithmException e) {
            System.err.println("El algoritmo seleccionado no existe");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.err.println("No se conoce la codificación especificada");
            e.printStackTrace();
        }
        return resumenHexadecimal;
    }
}
