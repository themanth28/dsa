import java.io.*;
import java.util.*;

public class Sample {


    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

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
//        try {
//            File file = new File("D:\\INTELLIJ PROJECTS\\dsa\\src\\testFile1.txt");
//
//            //Create the file
//            if (file.createNewFile()) {
//                System.out.println("File is created!");
//            } else {
//                System.out.println("File already exists.");
//            }
//
//            // Write Content
//            FileWriter writer = new FileWriter(file);
//            writer.write("Test data");
//            writer.close();
//
//
//            // read content
//            FileReader reader = new FileReader(file);
//
//            int c;
//            while ((c = reader.read()) != -1) {
//                char ch = (char) c;
//                System.out.print(ch);
//            }
//        } catch (IOException e) {
//            System.out.print("Exception");
//        }
//        Set<Integer> set = new LinkedHashSet<>();
//        set.add(10);
//        set.add(30);
//        set.add(50);
//        Random random = new Random();
//
////        System.out.println(set.remove(2));
//        for (int i:set){
//            System.out.print(i+" ");
//        }
//        set.remove(10);
//        System.out.println();
//        for (int i:set){
//            System.out.print(i+" ");
//        }
//        set.add(10);
//        System.out.println();
//        for (int i:set){
////            System.out.print(i+" ");
//            System.out.println(random.nextInt(i));
//        }
//        System.out.println(random.nextInt());
//        Integer
//        String[] bank = {"011001","000000","010100","001000"};
//        System.out.println(bank[0].charAt(1));
//        System.out.println(bank[0].length());
//        int ans = 0;
//        int ones = 0;
//        for (int i = 0; i < bank[0].length(); i++) {
//            if (bank[0].charAt(i) == '1') {
//                ones++;
//            }
//        }
//        System.out.println(ones);
//        int twos = 0;
//
//        for (int i = 1; i < bank.length; i++) {
//            for (int j = 0; j < bank[i].length(); j++) {
//                if (bank[i].charAt(j) == '1') {
//                    twos++;
//                }
//            }
//            System.out.println(twos);
//            if(twos>0){
//                ans += (ones*twos);
//                ones = twos;
//                twos=0;
//            }
//        }
//        System.out.println(ans);

//        System.out.println("Hello World");
        String t = "gcj";
//        int a = t.charAt(0) - 'a';
//        System.out.println(a);
        String a = "gcj";
        System.out.println(t.hashCode());
        System.out.println(a.hashCode());
        System.out.println(a.equals(t));





    }
}
