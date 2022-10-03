import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;

//This Class is for input main Directory of searching Java files
//This one check the entered Directory for existence
// and repeat input until user enters an existing Directory

public class DirScanner {
    static String dirScanner(){
        System.out.print("Input dir for searching Java files: ");
        Scanner dir = new Scanner(System.in);
        String strDir = dir.nextLine();
        if (!Files.exists(Paths.get(strDir))){
            while (!Files.exists(Paths.get(dir.nextLine()))) {
                System.out.print("Wrong dir");
                System.out.print("Input dir for searching java files: ");
                strDir = dir.nextLine();
            }
            dir.close();
        }
        else dir.close();
        System.out.print("Dir for searching java files: " + strDir);
        return strDir;
    }
}
