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
import java.util.ArrayList;
import java.util.List;

public class AcessoDados {
    public static List<Atividades> leArquivo(String filePath){

    	List<Atividades> atividades = new ArrayList<>();

        try ( InputStream is = new FileInputStream(filePath);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            while((linha = br.readLine()) != null){

               

                String[] palavras = linha.split(",");

                for(String p: palavras){
                    System.out.println("palavra: " + p);
                }
                String nome = palavras[1];
                
                 String categoria = palavras[4];
                
                 String descricao = palavras[2];;
                 //int duracao =Integer.parseInt(palavras[3]);;
                 String prioridade = palavras[5];;
                 
                 int idAtividade = 1;

                Atividades atividade = new Atividades(nome,descricao,prioridade,idAtividade, "",categoria, idAtividade);
                atividades.add(atividade);
                

            }

        }catch(IOException e){
            e.printStackTrace();
        }
		return atividades;
    }
    
    public static void saveArquivo(List<Atividades> funcoes, String filePath){

        try( OutputStream os = new FileOutputStream(filePath);
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw, true);
                ){
            for(Atividades linha: funcoes){
                pw.println(linha);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
