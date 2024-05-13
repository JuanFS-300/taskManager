package taskManager;

import java.util.Scanner;

import taskManager.AcessoDados.ListagemFinal;

import java.util.List;

public class Menu {
	private static Scanner le;

	public static void menu() {
		System.out.println("\n\n--------------APLICATIVO DE GERENCIAMENTO DE TAREFAS---------------\n");
		System.out.println("1. Listar tarefas por dia");
		System.out.println("2. Buscar tarefa por nome");
		System.out.println("3. Adiciona Tarefas");
		System.out.println("4. Listar todas as tarefas");
		System.out.println("5. Sair");

		System.out.println("Digite uma das opções:");
	
		int opcao = 0;

		le = new Scanner(System.in);
		//menu();

		opcao = le.nextInt();

		switch (opcao) {
		case 1:
			List<Atividades> listagemAtividade = AcessoDados.leArquivo("C:\\Users\\juanf\\Downloads\\taskManager.csv");
			List<TarefasData> listagemData = AcessoDados.leArquivoData("C:\\Users\\juanf\\Downloads\\taskManager.csv");
			
			System.out.println("Insira o categoria para buscar atividade:");
			String categoria = le.next();
			

			List<ListagemFinal> listaPorCategoria = Funcao.listarPorCategoria(listagemAtividade,listagemData, categoria);
			
			if(listaPorCategoria.isEmpty() == true) {
				System.out.println("Não foram encontradas atividades para essa categoria!");
			}else {
				 Funcao.showAllAtividades(listaPorCategoria);
			}
			
			confirmacaoSaida();
			break;
		case 2:
			List<Atividades> atividades = AcessoDados.leArquivo("C:\\Users\\juanf\\Downloads\\taskManager.csv");
			List<TarefasData> listaData = AcessoDados.leArquivoData("C:\\Users\\juanf\\Downloads\\taskManager.csv");
			
			System.out.println("Insira o nome para buscar atividade:");
			String nome = le.next();
			

			ListagemFinal atividadeEncontrada = Funcao.buscarAtividade(atividades,listaData, nome);

			if (atividadeEncontrada != null) {

				System.out.println("Atividade encontrada: ");
				System.out.println("Nome da Atividade: " + atividadeEncontrada.getAtividade().getNome());
				System.out.println("Categoria: " + atividadeEncontrada.getAtividade().getCategoria() + " | Descrição: " + atividadeEncontrada.getAtividade().getDescricao());
				System.out.println("Data: " + atividadeEncontrada.getData().getDataDia() + "/" + atividadeEncontrada.getData().getDataMes() + "/" +atividadeEncontrada.getData().getDataAno() + "\n");
				
				
			} else {

				System.out.println("Atividade com o nome'" + nome + "' não encontrada.");
			}
			confirmacaoSaida();
			break;
		case 3:
			List<Atividades> listaAtividades = AcessoDados.leArquivo("C:\\Users\\juanf\\Downloads\\taskManager.csv");
			List<TarefasData> listaDatas = AcessoDados.leArquivoData("C:\\Users\\juanf\\Downloads\\taskManager.csv");
			
			
		 Atividades atividade = Funcao.getNewAtividadeFromUser();
		 TarefasData data = Funcao.getNewDataFromUser();

			
			Funcao.adicionatarefa(listaAtividades, atividade, listaDatas, data);
			confirmacaoSaida();
			break;
		case 4:
			List<Atividades> listaAtividadesCompleta = AcessoDados.leArquivo("C:\\Users\\juanf\\Downloads\\taskManager.csv");
			List<TarefasData> datas = AcessoDados.leArquivoData("C:\\Users\\juanf\\Downloads\\taskManager.csv");
			List<ListagemFinal> listagemConcatenada = AcessoDados.concatenarLista(listaAtividadesCompleta,datas);
		    Funcao.showAllAtividades(listagemConcatenada);
		    confirmacaoSaida();
		    
			break;
		case 5:
			System.out.println("\n\n--------------APLICATIVO ENCERRADO---------------\n");
			break;
		
		default:
			System.out.println("Opcão invalida, tente novamente!.");

		}
	}
	
public static void confirmacaoSaida() {
	System.out.println("Deseja encerrar o aplicativo?");
	System.out.println("1 - Para retornar ao menu");
	System.out.println("2 - Para Encerrar aplicativo");
	int prosseguir = le.nextInt();
	if(prosseguir == 1) {
		 menu();
	} else if(prosseguir == 2) {
		System.out.println("\n\n--------------APLICATIVO ENCERRADO---------------\n");
		
	} else {
		System.out.println("Opcão invalida, tente novamente!.");
		confirmacaoSaida();
	}
}

	public static void main(String args[]) {
		

	}
}
