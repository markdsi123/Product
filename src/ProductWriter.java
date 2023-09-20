import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args) throws IOException {
        boolean done = false;
        Scanner in = new Scanner(System.in);
        ArrayList<Product> folks = new ArrayList<>();

        String ID, ProductName, Description;
        int Price;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Please enter your ID [6 digits]");
            ProductName = SafeInput.getNonZeroLenString(in, "Please enter your product name");
            Description = SafeInput.getNonZeroLenString(in, "Please enter your description");
            Price = SafeInput.getRangedInt(in, "Please enter your price ", 100, 3100);

            folks.add(new Product(ID, ProductName, Description, Price));

            done = SafeInput.getYNConfirm(in, "Are you done?");
        }while(!done);

        //Output what user has entered
        for (Product personRec : folks)
        {
            System.out.println(personRec.toCSVDataRecord());
        }

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory + "\\src\\ProductDataText.txt");

        try{
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            //Create a file from an array list
            for( Product p : folks)
            {
                writer.write(p.toCSVDataRecord());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data is written!");
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}