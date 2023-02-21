import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Validacion {
    private static Hash hash = new Hash();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserte el usuario");
        String usuario = sc.nextLine();
        System.out.println("Inserte la contraseña");
        String password = sc.nextLine();

        leerFichero(usuario, password);
    }

    public static void leerFichero(String usuario, String password){
        try {

            BufferedReader br = new BufferedReader(new FileReader("src\\credenciales.cre"));

            String cadena;
            boolean permiso = false;

            //Codificamos la contraseña para compararla
            String passwordCodificada = hash.getDigest(password);

            //Comprobamos si el usuario y la contraseña escritos por consola son iguales a los escritos en el fichero
            while ((cadena = br.readLine())!=null){
                if (cadena.equals(usuario+" "+passwordCodificada)){
                    permiso = true;
                }
            }
            //Comprobamos si tiene el permiso
            if (permiso){
                System.out.println("Acceso permitido");
            } else {
                System.out.println("Acceso denegado");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
