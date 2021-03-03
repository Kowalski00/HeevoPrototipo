package life.heevo.prototipo.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import life.heevo.prototipo.models.PP;
import life.heevo.prototipo.repositorios.impl.PPRepositorioJdbc;
import life.heevo.prototipo.repositorios.interfaces.HeevoRepositorio;

public class PPDAO {


	private static Scanner scanner = new Scanner(System.in);
	
	public static List<PP> listaPP = new ArrayList<PP>();
	
	public static List<PP> listaPP() throws Exception {
		HeevoRepositorio<PP> PPRepo = new PPRepositorioJdbc();
		listaPP = PPRepo.listar();
		if(listaPP.isEmpty())throw new Exception("[*] N�o h� PP's cadastrados.\n");
		return listaPP;
	}
	
	
	public static void consultarPP() throws Exception {
		HeevoRepositorio<PP> PPRepo = new PPRepositorioJdbc();
		listaPP = PPRepo.listar();
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
		String CPF = scanner.next();
		System.out.println("\n CodReg: ");
		String CodReg = scanner.next();
		PP existente = consultarPPporCPF(CPF);
		if (existente == null) {
			try {
				PP novoPP = new PP();
				novoPP.setCpf(CPF);
				novoPP.setNome(nome);
				novoPP.setCodRegPro(CodReg);
				HeevoRepositorio<PP> PPRepo = new PPRepositorioJdbc();
				PPRepo.inserir(novoPP);
				System.out.println("\n[*] Profissional cadastrado!\n");
			} catch (Exception e) {
				System.out.println("Erro:" + e.getMessage());
			}
		} else
			throw new Exception("\n[*] J� existe um profissional com este CPF.\n");
		
	}
	
	public static PP consultarPPporCPF(String CPF) {
		try {
			HeevoRepositorio<PP> PPRepo = new PPRepositorioJdbc();
			PP prof = PPRepo.selecionar(CPF);
			return prof;
		} catch(Exception e) {
			System.out.println("Erro:" + e.getMessage());
			return null;
		}
	}

}
