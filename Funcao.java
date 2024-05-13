package taskManager;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import taskManager.AcessoDados.ListagemFinal;

public class Funcao {

	// funcao
	public static ListagemFinal buscarAtividade(List<Atividades> listaAtividades, List<TarefasData> listaDatas,
			String nome) {

		for (Atividades atividade : listaAtividades) {

			if (atividade.getNome().equals(nome)) {
				int idAtividade = atividade.getIdAtividade();
				for (TarefasData data : listaDatas) {

					if (data.getIdData() == idAtividade) {

						ListagemFinal resultado = new ListagemFinal(atividade, data);
						return resultado;
					}
				}

			}
		}
		return null;

	}

	public static List<ListagemFinal> listarPorCategoria(List<Atividades> listaAtividades, List<TarefasData> listaDatas,
			String categoria) {

		List<ListagemFinal> resultado = new ArrayList<>();

		for (Atividades atividade : listaAtividades) {

			if (atividade.getCategoria().equals(categoria)) {
				int idAtividade = atividade.getIdAtividade();
				for (TarefasData data : listaDatas) {

					if (data.getIdData() == idAtividade) {
						ListagemFinal atividadeFinal = new ListagemFinal(atividade, data);
						resultado.add(atividadeFinal);

					}
				}

			}
		}
		return resultado;

	}

	public static void showAllAtividades(List<ListagemFinal> listagemConcatenada) {

		System.out.println();
		System.out.println("========================");
		System.out.println("Listando Atividades Encontradas");

		for (ListagemFinal c1 : listagemConcatenada) {
			System.out.println("Nome da Atividade: " + c1.getAtividade().getNome());
			System.out.println("Categoria: " + c1.getAtividade().getCategoria() + " | Descrição: "
					+ c1.getAtividade().getDescricao());
			System.out.println("Data: " + c1.getData().getDataDia() + "/" + c1.getData().getDataMes() + "/"
					+ c1.getData().getDataAno() + "\n");

			// System.out.println(c1);

		}
		System.out.println("========================");
		System.out.println();
	}

	public static void adicionatarefa(List<Atividades> listaAtividades, Atividades atividade,
			List<TarefasData> listaDatas, TarefasData data) {
		listaAtividades.add(atividade);
		listaDatas.add(data);
		AcessoDados.saveArquivo(listaAtividades, listaDatas, "C:\\\\Users\\\\juanf\\\\Downloads\\\\taskManager.csv");

	}

	public static Atividades getNewAtividadeFromUser() {
		System.out.println("Insira os dados da nova atividade:");
		String nome = getNomeAtividade();
		String categoria = getCategoriaAtividade();
		String descricao = getDescricaoAtividade();
		return Atividades.createNewAtividade(nome, categoria, descricao);
	}

	public static TarefasData getNewDataFromUser() {
		System.out.println("Insira os dados sobre a data da atividade:");
		int dataDia = getDataDiaAtividade();
		int dataMes = getDataMesAtividade();
		int dataAno = getDataAnoAtividade();
		return TarefasData.createNewData(dataDia, dataMes, dataAno, 0);
	}

	public static String getNomeAtividade() {
		System.out.println("Insira  o nome da Atividade:");
		try {
			return getNomeFromUser();
		} catch (NomeVazioException e) {
			System.out.println(e.getMessage());
			System.out.println("Tente novamente!");
			return getNomeAtividade();
		}
	}

	public static String getNomeFromUser() throws NomeVazioException {
		Scanner in = new Scanner(System.in);
		String nome = in.nextLine();
		if (nome.trim().equals("")) {
			throw new NomeVazioException("nome \"" + nome + "\" vazio");
		}
		return nome.trim();
	}

	private static class NomeVazioException extends IOException {
		public NomeVazioException(String message) {
			super(message);
		}
	}

	public static String getCategoriaAtividade() {
		System.out.println("Insira a categoria da Atividade:");
		try {
			return getCategoriaFromUser();
		} catch (CategoriaVaziaException e) {
			System.out.println(e.getMessage());
			System.out.println("Tente novamente!");
			return getCategoriaAtividade();
		}
	}

	public static String getCategoriaFromUser() throws CategoriaVaziaException {
		Scanner in = new Scanner(System.in);
		String categoria = in.nextLine();
		if (categoria.trim().equals("")) {
			throw new CategoriaVaziaException("Categoria \"" + categoria + "\" vazia");
		}
		return categoria.trim();
	}

	private static class CategoriaVaziaException extends IOException {
		public CategoriaVaziaException(String message) {
			super(message);
		}
	}

	public static String getDescricaoAtividade() {
		System.out.println("Insira a descrição da Atividade:");
		try {
			return getDescricaoFromUser();
		} catch (DescricaoVaziaException e) {
			System.out.println(e.getMessage());
			System.out.println("Tente novamente!");
			return getDescricaoAtividade();
		}
	}

	public static String getDescricaoFromUser() throws DescricaoVaziaException {
		Scanner in = new Scanner(System.in);
		String descricao = in.nextLine();
		if (descricao.trim().equals("")) {
			throw new DescricaoVaziaException("Descricao \"" + descricao + "\" vazia");
		}
		return descricao.trim();
	}

	private static class DescricaoVaziaException extends IOException {
		public DescricaoVaziaException(String message) {
			super(message);
		}
	}

	public static int getDataDiaAtividade() {
		System.out.println("Insira o dia:");
		try {
			return getDataDiaFromUser();
		} catch (DataDiaVaziaException e) {
			System.out.println(e.getMessage());
			System.out.println("Tente novamente!");
			return getDataDiaAtividade();
		}
	}

	public static int getDataDiaFromUser() throws DataDiaVaziaException {
		Scanner in = new Scanner(System.in);
		int dataDia = in.nextInt();
		if (dataDia == 0) {
			throw new DataDiaVaziaException("Data Dia \"" + dataDia + "\" vazia");
		}
		return dataDia;
	}

	private static class DataDiaVaziaException extends IOException {
		public DataDiaVaziaException(String message) {
			super(message);
		}
	}

	public static int getDataMesAtividade() {
		System.out.println("Insira o mês:");
		try {
			return getDataMesFromUser();
		} catch (DataMesVaziaException e) {
			System.out.println(e.getMessage());
			System.out.println("Tente novamente!");
			return getDataMesAtividade();
		}
	}

	public static int getDataMesFromUser() throws DataMesVaziaException {
		Scanner in = new Scanner(System.in);
		int dataMes = in.nextInt();
		if (dataMes == 0) {
			throw new DataMesVaziaException("Data Mes \"" + dataMes + "\" vazia");
		}
		return dataMes;
	}

	private static class DataMesVaziaException extends IOException {
		public DataMesVaziaException(String message) {
			super(message);
		}
	}

	public static int getDataAnoAtividade() {
		System.out.println("Insira o ano:");
		try {
			return getDataAnoFromUser();
		} catch (DataAnoVaziaException e) {
			System.out.println(e.getMessage());
			System.out.println("Tente novamente!");
			return getDataAnoAtividade();
		}
	}

	public static int getDataAnoFromUser() throws DataAnoVaziaException {
		Scanner in = new Scanner(System.in);
		int dataAno = in.nextInt();
		if (dataAno == 0) {
			throw new DataAnoVaziaException("Data Ano \"" + dataAno + "\" vazia");
		}
		return dataAno;
	}

	private static class DataAnoVaziaException extends IOException {
		public DataAnoVaziaException(String message) {
			super(message);
		}
	}
}
