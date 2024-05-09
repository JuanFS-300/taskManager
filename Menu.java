package taskManager;

import java.util.Scanner;
import java.util.List;

public class Menu {
	private static Scanner le;

	public static void menu() {
		System.out.println("--------------APLICATIVO DE GERENCIAMENTO DE TAREFAS---------------\n");
		System.out.println("1. Lista Tarefas do dia a dia");
		System.out.println("2. Buscar tarefa por ID");
		System.out.println("3. Adiciona Tarefas");
		System.out.println("4. Exclui Tarefas");
		System.out.println("5. Sair");
		System.out.println("Digite uma das opções:");
	}

	public static void main(String args[]) {
		int opcao = 0;

		le = new Scanner(System.in);
		menu();

		opcao = le.nextInt();

		switch (opcao) {
		case 1:
			// listadodia();
			break;
		case 2:
			List<Atividades> atividades = AcessoDados.leArquivo("C:\\Users\\juanf\\Downloads\\taskManager.csv");
			System.out.println("Insira o id para buscar atividade:");
			int idAtividade = le.nextInt();
			

			Atividades atividadeEncontrada = Funcao.buscarAtividade(atividades, idAtividade);

			if (atividadeEncontrada != null) {

				System.out.println("Atividade encontrada: " + atividadeEncontrada.toString());
			} else {

				System.out.println("Atividade com o ID " + idAtividade + " não encontrada.");
			}

			break;
		case 3:
			List<Atividades> listaAtividades = AcessoDados.leArquivo("C:\\Users\\juanf\\Downloads\\taskManager.csv");
			
			
			System.out.println("Adicionar Nome:");
			String nome = le.next();
			System.out.println("Adicionar Descricao:");
			String descricao = le.next();
			System.out.println("Adicionar Categoria:");
			String categoria = le.next();
			System.out.println("Adicionar Duração:");
			String duracao = le.next();
			System.out.println("Adicionar Id:");
			int id = le.nextInt();

			
			Funcao.adicionatarefa(listaAtividades, categoria, nome, descricao, duracao, id);
			
			break;
		
		default:
			System.out.println("Opcão invalida, tente novamente!.");

		}
	}

	
}
