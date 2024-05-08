package taskManager;
//import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Atividades> funcoes = AcessoDados.leArquivo("C:\\Users\\juanf\\Downloads\\taskManager.csv");
        int idAtividade = 1;
     
            System.out.println(funcoes);
        

        // Buscando a atividade na lista
        Atividades atividadeEncontrada = Funcao.buscarAtividade(funcoes, idAtividade);

        if (atividadeEncontrada != null) {
            System.out.println("Atividade encontrada: " + atividadeEncontrada.getDescricao());
        } else {
            System.out.println("Atividade com o ID " + idAtividade + " não encontrada.");
        }
   		 
	     
    //   AcessoDados.saveArquivo(funcoes, "C:\\\\Users\\\\juanf\\\\Downloads\\\\taskManager.csv");



    }

}
