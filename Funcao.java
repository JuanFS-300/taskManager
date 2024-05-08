package taskManager;
//import java.util.ArrayList;
import java.util.List;

public class Funcao {
	 
	            //funcao
			    public static Atividades buscarAtividade(List<Atividades> listaAtividades, int idAtividade) {
			        for (Atividades atividade : listaAtividades) {
			            if (atividade.getIdAtividade() == idAtividade ) {
			                return atividade;
			            }
			        }
			        return null; // Retornar null se a atividade não for encontrada
			    }
			
	 }

