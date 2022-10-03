import java.io.*;

//This class modifies java files so that tokens
// with more than 3 characters are written in capital letters

public class JavaFileEditor {
    static void javaFileEditor(File filePath) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filePath.getAbsolutePath()));

        String str;
        StringBuilder fl = new StringBuilder();

        while ((str = br.readLine()) != null) fl.append(str).append("\n");

        br.close();

        String[] strarr = (fl.toString().split( "[^a-zA-Z]" ));
        String[] cparr = strarr.clone();

        for (int i = 0; i < strarr.length; i++) if (strarr[i].length()>3) strarr[i] = strarr[i].toUpperCase();

        for (int i = 0; i < strarr.length; i++) fl = new StringBuilder(fl.toString().replace(cparr[i], strarr[i]));

        File myFoo = new File(filePath.getAbsolutePath());
        FileWriter fooWriter = new FileWriter(myFoo, false);
        fooWriter.write(fl.toString());
        fooWriter.close();
    }
}
