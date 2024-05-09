package taskManager;

//import java.util.ArrayList;
import java.util.List;

public class Funcao {

	// funcao
	public static Atividades buscarAtividade(List<Atividades> listaAtividades, int idAtividade) {
		
		for (Atividades atividade : listaAtividades) {
	
			if (atividade.getIdAtividade() == idAtividade) {
				return atividade;
			}
		}
		return null;

	}

	public static void adicionatarefa(List<Atividades> listaAtividades, String categoria, String nome, String descricao,
			String duracao, int id) {
		listaAtividades.add(new Atividades(categoria, nome, descricao, duracao, id));
		 AcessoDados.saveArquivo(listaAtividades, "C:\\\\Users\\\\juanf\\\\Downloads\\\\taskManager.csv");

	}

}
