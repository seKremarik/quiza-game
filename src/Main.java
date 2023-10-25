import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src\\data\\problems.csv";
        ArrayList<String> lines;

        lines = getLinesFromFile(path);
        System.out.println(lines);
        gameLogic(lines);
    }

    /**
    * Lee todas las líneas de un archivo y las devuelve en un ArrayList de cadenas de texto.
    * @param path La ruta del archivo a leer.
    * @return Un ArrayList de cadenas de texto que contiene todas las líneas del archivo.
    * @throws IOException Si ocurre un error al leer el archivo.
    */
    private static ArrayList<String> getLinesFromFile(String path) throws IOException {
        return new ArrayList<>(Files.readAllLines(Paths.get(path)));
    }

    /**
    * Procesa cada pregunta del juego utilizando un bucle for y el método splitString().
    * @param lines Un ArrayList de cadenas de texto que contiene todas las preguntas del juego.
    */
    private static void gameLogic(ArrayList<String> lines) {
        Scanner scan = new Scanner(System.in);

        for (String line : lines) {
            String[] partsOfString = splitString(line);
            String question = partsOfString[0];
            String answer = partsOfString[1];

            System.out.println("Resuelva el siguiente ejercicio: " + question);
            String userAnswer = scan.nextLine();

            checkAnswer(userAnswer, answer);
        }
    }

    /**
    * Divide una cadena de texto en varias subcadenas utilizando como separador la coma (',').
    * @param line La cadena de texto a dividir.
    * @return Un arreglo de cadenas de texto que contiene las subcadenas resultantes.
    */
    private static String[] splitString(String line) {
        return line.split(",");
    }

    /**
    * Compara la respuesta del usuario con la respuesta correcta y muestra un mensaje en la consola.
    * @param userAnswer La respuesta del usuario.
    * @param answer La respuesta correcta.
    */
    private static void checkAnswer(String userAnswer, String answer) {
        if (Objects.equals(userAnswer, answer)) {
            System.out.println("Correcto ✅");
        } else {
            System.out.println("Incorrecto ❌, suerte la próxima.");
        }
    }
}