package life.heevo.prototipo.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Entrada {
	
	private int IDProntuario; // ID do Prontuario
	private String dataCriado; // Data de cria��o da entrada
	private String descricao; // texto da entrada
	
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	/*
	 * public Entrada(String texto, Long idPront) { this.IDProntuario = idPront;
	 * this.descricao = texto; this.dataCriado = formatter.format(date); }
	 */

	public String getDataCriado() {
		return dataCriado;
	}

	public void setDataCriado(String dataCriado) {
		this.dataCriado = dataCriado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String entrada) {
		this.descricao = entrada;
	}

	
	
	public int getIDProntuario() {
		return IDProntuario;
	}

	public void setIDProntuario(int iDProntuario) {
		IDProntuario = iDProntuario;
	}

	@Override
	public String toString() {
		return "Entrada: \"" + dataCriado + "\", " + "\n" + descricao;
	}
	
	
	
}
