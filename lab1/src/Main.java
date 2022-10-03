import java.io.IOException;
//The main class of program
public class Main {

    public static void main(String[] args) throws IOException {
        String ext = ".java";

//        Its Directory for testing our program
//        String dir = "C:\\Users\\zxerf\\Downloads\\Telegram Desktop";

        String dirPath = DirScanner.dirScanner();
        FileJavaFilter.fileJavaFilter(dirPath, ext);
    }
}