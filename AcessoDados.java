package taskManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
                      
	                	 String[] parts = linha.split(",");
	             
	                	   String categoria = parts[0];
	                       String nome = parts[1];
	                       String descricao = parts[2];
	                       String duracao = parts[3];
	                       int id = Integer.parseInt(parts[4]);
	                   
	                    
						Atividades atividade = new Atividades(categoria, nome,descricao, duracao, id);
	 	                atividades.add(atividade);
	            }

	        }catch(IOException e){
	            e.printStackTrace();
	        }
			return atividades;
	    }
	    
	    public static void saveArquivo(List<Atividades> atividades, String filePath){

	        try( OutputStream os = new FileOutputStream(filePath);
	                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
	                PrintWriter pw = new PrintWriter(osw, true);
	                ){
	            for(Atividades linha: atividades){
	                pw.println(linha);
	            }

	        }catch(IOException e){
	            e.printStackTrace();
	        }
	    }
	}
	
