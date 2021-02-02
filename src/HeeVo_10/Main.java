package HeeVo_10;
import java.util.*;

public class Main {
	
	List<Paciente> Pacientes = new ArrayList<>();
	List<Profissional> Profissionais = new ArrayList<>();
	
	
	public static void main(String[] args) {
		Main a = new Main();
		a.menu(a);
	}
	
	public void menu(Main a) {
		int opcao = 0;
		Scanner Entrada = new Scanner(System.in);
		do
		{
			
			System.out.println("Selecione uma op��o:\n 1.Cadastrar Novo Profissional\n 2.Fazer Login\n 9.Sair");
			opcao = Entrada.nextInt();
			switch (opcao){
				case 1:
					a.novoProfissional();
					break;
				case 2:
					a.Login(a);
					break;
		
			}
		}	while(opcao != 9);
		Entrada.close();
	}
	
	public void Login(Main a) {
		Scanner Entradas = new Scanner(System.in);
		System.out.println("Digite o CPF:");
		String CPF = Entradas.nextLine();
		int index = -1;
		int opcao = 0;
		for (int i=0; i<Profissionais.size(); i = i+1) {
			if (CPF.equals(Profissionais.get(i).CPF))
				index = i;
		}
		if (index == -1) {
			System.out.println("Profissional N�o encontrado");
		}
		else {
			do {
				Profissionais.get(index).display();
				System.out.println("Selecione uma op��o:\n 1.Cadastrar Novo Paciente\n 2.Acessar Paciente\n 9.Sair");
				opcao = Entradas.nextInt();
				switch(opcao){
					case 1:
						Paciente p = novoPaciente();
						Profissionais.get(index).Pacientes.add(p);
						Prontuario Pron = Profissionais.get(index).novoProntuario(p.CPF);
						p.prontuarios.add(Pron);
						break;
					case 2:
						a.acessarPaciente(index);
						break;
				}
			} while(opcao!=9);
		}
	}
	
	public void novoProfissional() {
		Scanner Entradas = new Scanner(System.in);
		System.out.println("Digite o CPF:");
		String CPF = Entradas.nextLine();
		System.out.println("Digite o nome:");
		String nome = Entradas.nextLine();
		System.out.println("Digite o email:");
		String email = Entradas.nextLine();
		Profissional medico = new Profissional();
		medico.name = nome;
		medico.CPF = CPF;
		medico.email = email;
		medico.display();
		Profissionais.add(medico);
		//Entradas.close();
	}
	
	public Paciente novoPaciente() {
		Scanner Entradas = new Scanner(System.in);
		System.out.println("Digite o CPF:");
		String CPF = Entradas.nextLine();
		System.out.println("Digite o nome:");
		String nome = Entradas.nextLine();
		System.out.println("Digite o email:");
		String email = Entradas.nextLine();
		Paciente pessoa = new Paciente();
		pessoa.name = nome;
		pessoa.CPF = CPF;
		pessoa.email = email;
		pessoa.display();
		Pacientes.add(pessoa);
		return pessoa;
		//Entradas.close();		
	}
	public void acessarPaciente(int indexPro) { //Como o paciente precisa ter um m�dico, procuramos
		Scanner Entradas = new Scanner(System.in); //somente entre os pacientes do m�dico
		System.out.println("Digite o nome:");
		String nome = Entradas.nextLine();
		int index = -1;
		for (int i=0; i<Profissionais.get(indexPro).Pacientes.size(); i = i+1) {
			if (nome.equals(Profissionais.get(indexPro).Pacientes.get(i).name))
				index = i;
		}
		if (index == -1) {
			System.out.println("Paciente N�o encontrado");
		}
		else {
			Pacientes.get(index).display();
			Profissionais.get(indexPro).Prontuarios.get(index).display();
			System.out.println("1. Nova Entrada \n2. Voltar");
			int opcao = Entradas.nextInt();
			Entradas.nextLine();// o next int pega apenas o n�mero. Assim precisamos disso para "limpar"
			switch (opcao) {	// a linha e pegar a pr�xima quando o profissional digitar a entrada
			case 1:
				System.out.println("Digite Entrada");
				String Entrada = Entradas.nextLine();
				Profissionais.get(indexPro).Prontuarios.get(index).novaEntrada(Entrada);
				//O �ndice do prontu�rio tem que ser o mesmo do paciente, porque toda vez que
				//um paciente � criado, tamb�m � criado seu prontu�rio
				Profissionais.get(indexPro).Prontuarios.get(index).display();
				break;
			case 2:
				break;
			}
		}
		
	}
}
