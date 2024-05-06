package taskManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class AcessoDados {
    public static List<Funcao> leArquivo(String filePath){

        try ( InputStream is = new FileInputStream(filePath);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            int i=0;
            while((linha = br.readLine()) != null){

                System.out.println("linha " + i++);

                String[] palavras = linha.split(",");

                for(String p: palavras){
                    System.out.println("palavra: " + p);
                }

            }

        }catch(IOException e){
            e.printStackTrace();
        }
		return null;
    }
    
    public static void saveArquivo(List<Funcao> funcoes, String filePath){

        try( OutputStream os = new FileOutputStream(filePath);
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw, true);
                ){
            for(Funcao linha: funcoes){
                pw.println(linha);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
