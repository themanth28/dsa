import java.io.*;

public class Sample {


    public static void main(String args[]) {
//
//        try {
//            byte bWrite [] = {65, 66, 67, 68, 69};
//            OutputStream os = new FileOutputStream("test.txt");
//            for(int x = 0; x < bWrite.length ; x++) {
//                os.write( bWrite[x] );   // writes the bytes
//            }
//            os.write(12);
//            os.close();
//
//            InputStream is = new FileInputStream("test.txt");
//            int size = is.available();
//
//            for(int i = 0; i < size; i++) {
//                System.out.print((char)is.read() + "  ");
//            }
//            is.close();
//        } catch (IOException e) {
//            System.out.print("Exception");
//        }
        try {
            File file = new File("D:\\INTELLIJ PROJECTS\\dsa\\src\\testFile1.txt");

            //Create the file
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

            // Write Content
            FileWriter writer = new FileWriter(file);
            writer.write("Test data");
            writer.close();


            // read content
            FileReader reader = new FileReader(file);

            int c;
            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                System.out.print(ch);
            }
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }
}
