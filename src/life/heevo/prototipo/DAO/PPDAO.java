package life.heevo.prototipo.DAO;

import java.util.ArrayList;
import java.util.Scanner;

import life.heevo.prototipo.models.PP;

public class PPDAO {


	private static Scanner scanner = new Scanner(System.in);
	
	public static ArrayList<PP> listaPP = new ArrayList<PP>();
	
	public static void consultarPP() throws Exception {
		if(listaPP.isEmpty())throw new Exception("[*] N�o h� PP's cadastrados.\n");
		System.out.println("\n[*]------------------------------------------------------[*]");
		for(PP i:listaPP)
			System.out.println(i);
		System.out.println("\n[*]------------------------------------------------------[*]\n");
		
	}

	public static void cadastrarPP() throws Exception {
		System.out.println("[*] Cadastro de Profissionais Prescritores.");
		System.out.println("\n Nome: ");
		String nome = scanner.next();
		System.out.println("\n CPF: ");
		Long CPF = scanner.nextLong();
		System.out.println("\n CodReg: ");
		int CodReg = scanner.nextInt();
		PP existente = consultarPPporCPF(CPF);
		if(existente==null) {
			PP novoPP = new PP(nome, CPF, CodReg);
			listaPP.add(novoPP);
			System.out.println("\n[*] Profissional cadastrado!\n");
		}else throw new Exception("\n[*] J� existe um profissional com este CPF.\n");
		
	}
	
	public static PP consultarPPporCPF(Long CPF) {
		for(PP i:listaPP) {
			if(i.getCpf()==CPF)
				return i;
		}
		return null;
	}

}
