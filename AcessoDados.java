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
	public static List<Atividades> leArquivo(String filePath) {

		List<Atividades> atividades = new ArrayList<>();
		
		try (InputStream is = new FileInputStream(filePath);
				InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);) {
			String linha;
			while ((linha = br.readLine()) != null) {

				String[] parts = linha.split(",");
				int id = Integer.parseInt(parts[0]);
				String nome = parts[1];
				String categoria = parts[2];
				String descricao = parts[3];

				Atividades atividade = new Atividades(id, nome, categoria, descricao);
				atividades.add(atividade);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return atividades;
	}

	public static List<TarefasData> leArquivoData(String filePath) {

		List<TarefasData> datas = new ArrayList<>();

		try (InputStream is = new FileInputStream(filePath);
				InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);) {
			String linha;
			while ((linha = br.readLine()) != null) {

				String[] parts = linha.split(",");
				int id = Integer.parseInt(parts[0]);
				int dataDia = Integer.parseInt(parts[4]);
				int dataMes = Integer.parseInt(parts[5]);
				int dataAno = Integer.parseInt(parts[6]);

				TarefasData data = new TarefasData(dataDia, dataMes, dataAno, id);
				datas.add(data);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return datas;
	}

	public static void saveArquivo(List<Atividades> atividades, List<TarefasData> datas, String filePath) {
		List<ListagemFinal> resultado = new ArrayList<>();
		   int tamanhoMinimo = Math.min(atividades.size(), datas.size());

        // Concatenar as linhas
        for (int i = 0; i < tamanhoMinimo; i++) {
            resultado.add(new ListagemFinal(atividades.get(i),datas.get(i)));
        }

		try (OutputStream os = new FileOutputStream(filePath);
				OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
				PrintWriter pw = new PrintWriter(osw, true);) {
			for (ListagemFinal linha : resultado) {
				pw.println(linha);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<ListagemFinal>  concatenarLista(List<Atividades> atividades, List<TarefasData> datas) {
		List<ListagemFinal> resultado = new ArrayList<>();
		   int tamanhoMinimo = Math.min(atividades.size(), datas.size());

        // Concatenar as linhas
        for (int i = 0; i < tamanhoMinimo; i++) {
            resultado.add(new ListagemFinal(atividades.get(i),datas.get(i)));
        }
		return resultado;
	}

	public static class ListagemFinal {
		private String categoria;
		private String nome;
		private String descricao;
		private int idAtividade;
		private int dataDia;
		private int dataMes;
		private int dataAno;

		public ListagemFinal(Atividades  atividade, TarefasData data) {
			super();
			this.categoria = atividade.getCategoria();
			this.nome = atividade.getNome();
			this.descricao = atividade.getDescricao();
			this.idAtividade = atividade.getIdAtividade();
			this.dataDia = data.getDataDia();
			this.dataMes = data.getDataMes();
			this.dataAno = data.getDataAno();

		}
	
       public Atividades getAtividade() {
    	   Atividades a = new Atividades(idAtividade, nome, categoria, descricao);
		return a;
    	   
       }
       public TarefasData getData() {
    	   TarefasData d = new TarefasData(dataDia, dataMes, dataAno, idAtividade);
		return d;
    	   
       }
		@Override
		public String toString() {
			return idAtividade + "," + nome + "," + categoria + "," + descricao + "," + dataDia + "," + dataMes + ","
					+ dataAno;
		}

		
		public String getNome() {
			// TODO Auto-generated method stub
			return nome;
		}

		public int getIdAtividade() {
			// TODO Auto-generated method stub
			return idAtividade;
		}

	}
}
