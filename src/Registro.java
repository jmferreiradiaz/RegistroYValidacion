import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Registro {
    private static Hash hash = new Hash();
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String passwordCodificada;

        System.out.println("Inserte el usuario");
        String usuario = sc.nextLine();
        System.out.println("Inserte la contraseña");
        String password = sc.nextLine();

        passwordCodificada = hash.getDigest(password);

        if (passwordCodificada.equals("")){
            System.out.println("La codificación se ha hecho de forma incorrecta, escriba una contraseña diferente");
        } else {
            escribirFichero(usuario, passwordCodificada);
        }
    }

    private static void escribirFichero(String usuario, String password) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\credenciales.cre",true));
        bw.write(usuario + " " + password);
        bw.newLine();
        bw.close();
    }
}