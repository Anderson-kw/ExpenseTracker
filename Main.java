package com.expensetracker;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Month;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean executando = true;
		int opcao = 0;
		String desc;
		double qtd = 0;
		
		ArrayList<Expense> expenses = new ArrayList<>();

		
		while (executando) {
			System.out.println("\tEscolha a função que deseja realizar:"
					+ "\n\n 1 - Adicionar despesa"
					+ "\n 2 - Editar despesa"
					+ "\n 3 - Deletar despesa"
					+ "\n 4 - Visualizar todas despesas"
					+ "\n 5 - Resumo das despesas"
					+ "\n 6 - Resumo das despesas de um mês específico"
					+ "\n 7 - Sair.\n");
			
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("\tAdicionar despesa"
						+ "\n\n Digite a descrição da despesa"
						+ "\n\n 0 para sair ou cancelar\n");
				scanner.nextLine();
				desc = scanner.nextLine();
				if (desc.equals("0"))
					break;
				
				System.out.println("\tAdicionar despesa"
						+ "\n\n Digite a quantidade da despesa"
						+ "\n 0 para sair ou cancelar\n");
				qtd = scanner.nextDouble();
				System.out.println("Adicionado!\n");
				if (qtd == 0)
					break;
				Expense expense = new Expense(qtd, desc, LocalDate.now());
				expenses.add(expense);
				
				break;
			case 2:
				System.out.println("\tEditar despesa"
						+ "\n\nSelecione qual despesa quer editar\n");
				int num = scanner.nextInt();
				num = num - 1;
				if (expenses.size() > num && num >= 0) {
					System.out.println("\tEditar despesa\n\n" +
							(num+1) + " - " + expenses.get(num).getDescription() + " - " 
							+ expenses.get(num).getAmount()+ " R$"
							+ "\n\nSelecione qual deseja editar"
							+ "\n1 - Descrição"
							+ "\n2 - Despesa\n" );		
					int sel = scanner.nextInt();
					
					switch (sel) {
					case 1 :
						System.out.println("\tEditar despesa"
								+ "\n\nDigite a nova descrição:\n");
						scanner.nextLine();
						expenses.get(num).setDescription(scanner.nextLine());
						System.out.println("\nDescrição editada\n");
						break;
						
					case 2:
						System.out.println("\tEditar despesa"
								+ "\n\nDigite a nova despesa:\n");
						expenses.get(num).setAmount(scanner.nextDouble());
						System.out.println("\nDespesa editada\n");
						break;
					default: 
						System.out.println("\tValor inválido\n");
						break;
					}
				} else {
					System.out.println("\tValor inválido\n");
					break;
				}
				
				break;
			case 3:
				System.out.println("\tDeletar despesa"
						+ "\n\nSelecione qual despesa quer deletar\n");
				int num3 = scanner.nextInt();
				num3 = num3 - 1;
				
				if (expenses.size() > num3 && num3 >= 0) {
					System.out.println("\tDeletar despesa"
							+ "\n\nDeseja realmente deletar a despesa " + (num3+1) + "?(Sim ou Não)\n");
					System.out.println((num3+1) + " - " + expenses.get(num3).getDescription() + " - " 
					+ expenses.get(num3).getAmount()+ " R$");
					
					String resp = scanner.next();
					if (resp.equalsIgnoreCase("Sim") || resp.equalsIgnoreCase("s")) {
						expenses.remove(num3);
						System.out.println("Despesa deletada com sucesso\n");
					} else {
						System.out.println("Cancelado\n");
						break;
					}
					
				}	else {
					System.out.println("\tValor inválido\n");
					break;
					}
				break;
				
			case 4:
				System.out.println("\tLista de despesas:\n");
				for (Expense ex : expenses) {
					System.out.println( (expenses.indexOf(ex)+1) + " - "
					+ ex.getDescription() + " - " + ex.getAmount()
					+ " R$");
					System.out.println("----------");
				}		
				break;				
			case 5:
				System.out.println("\tResumo das despesas");
				double total = 0;
				for (Expense ex : expenses) {
					total += ex.getAmount();
				}	
				System.out.println("\nTotal = " + total + " R$\n");
				
				break;
			case 6:
				System.out.println("\tResumo das despesas de um mês específico"
						+ "\n\nEscolha o mês que deseja ver as despesas"
						+ "\n 1 - Janeiro"
						+ "\n 2 - Fevereiro"
						+ "\n 3 - Março"
						+ "\n...\n");
				
				int mes = scanner.nextInt();
				
				if (mes <= 12 && mes > 0) {
					Month meuMes = Month.of(mes);
					
					System.out.println("\tResumo das despesas de " + meuMes);
					double total1 = 0;
					for (Expense ex : expenses) {
						if (ex.getDate().getMonthValue() == mes) {
							total1 += ex.getAmount();
						}
					}	
					System.out.println("\nTotal = " + total1 + " R$");
				} else {
					System.out.println("Valor inválido");
					break;
				}
				break;		
			case 7:
				System.out.println("Finalizado");
				executando = false;
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
		scanner.close();
		
	}

}
