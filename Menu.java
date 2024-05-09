package taskManager;

import java.util.Scanner;
import java.util.List;


public class Menu {
	public static void menu() {
		System.out.println("--------------APLICATIVO DE GERENCIAMENTO DE TAREFAS---------------\n");
		System.out.println("1. Lista Tarefas do dia a dia");
		System.out.println("2. Lista Tarefas por categoria");
		System.out.println("3. Adiciona Tarefas");
		System.out.println("4. Exclui Tarefas");
		System.out.println("5. Sair");
		System.out.println("Digite uma das opções:");	
	}
	
	public static void main (String args[]) {
		int opcao = 0;
		
		Scanner le = new Scanner(System.in);
		menu();
		
		opcao= le.nextInt();
		
		switch (opcao) {
		case 1:
			listadodia();
			break;
		case 2:
			listatarefa();
			break;
		case 3:
		
			System.out.println("Adicionar Categoria:");
			String categoria = le.nextLine();
			
			System.out.println("Adicionar Nome:");
			String nome = le.nextLine();
			
			System.out.println("Adicionar Descriçao da Tarefa:");
			String descricao = le.nextLine();
			
			System.out.println("Adicionar Duração:");
			Integer duracao = le.nextInt();
			
			System.out.println("Adicionar Id:");
			Integer id = le.nextInt();
			
			List<Atividades> listaAtividades = AcessoDados.leArquivo("C:\\Users\\juanf\\Downloads\\taskManager.csv");;
			Funcao.adicionatarefa(listaAtividades,categoria, nome, descricao, duracao, id);
			break;
		case 4:
			excluitarefa();
			break;
		case 5:
			sair();
			break;
		default:
			System.out.println("Opcão invalida, tente novamente!.");
		
		}
	}

	private static void sair() {
		
	}

	private static void excluitarefa() {
		
	}
