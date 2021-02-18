package life.heevo.prototipo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import life.heevo.prototipo.DAO.EntradaDAO;


/**
 * Representa um prontu�rio
 * 
 * @author hl
 * @author rk
 *
 */
public class Prontuario {
	private Long uniqueID; //Identificador do Prontu�rio
	private String dataCriado; // Data de cria��o do prontu�rio (n�o da entrada)
	private Long cpf; // CPF do paciente
	private Long cpfPro; // CPF do profissional
	private String nome; //nome do paciente
	
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	public Prontuario (String nome, Long cpf, Long cpfPro) {
		this.cpf = cpf;
		this.cpfPro = cpfPro;
		this.nome = nome;
		this.dataCriado = formatter.format(date);		
		long bigCpf = (int) Math.floor(cpf/100); //Descartando os dois �ltimos digitos
		long bigCpfPro = (int) Math.floor(cpfPro/100);
		long uni = ((bigCpf+bigCpfPro+1)*(bigCpf+bigCpfPro)/2)+bigCpfPro;
		this.uniqueID = uni; //Esse � um indicador �nico do Prontu�rio
	}
	

	public Long getUniqueID() {
		return uniqueID;
	}

	public Long getCpf() {
		return cpf;
	}
	
	public Long getCpfPro() {
		return cpfPro;
	}
	
	public String getDataCriado() {
		return dataCriado;
	}
	
	public String getNome() {
		return nome;
	}
	
}
