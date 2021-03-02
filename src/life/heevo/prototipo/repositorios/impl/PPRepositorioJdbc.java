package life.heevo.prototipo.repositorios.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import life.heevo.prototipo.models.PP;
import life.heevo.prototipo.repositorios.interfaces.HeevoRepositorio;
import life.heevo.prototipo.fabricas.FabricaConexaoJdbc;

public class PPRepositorioJdbc implements HeevoRepositorio<PP> {

	public Object selecionar(long ID) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PP> listar() throws SQLException, IOException {
		ArrayList<PP> pps = new ArrayList<PP>();
		try (Connection conexao = FabricaConexaoJdbc.criarConexao()) {
			Statement comando = conexao.createStatement();
			ResultSet rs = comando.executeQuery("SELECT * FROM pps");
			while (rs.next()) {
				PP prof = new PP();
				prof.setCpf(rs.getString("CPFpp"));
				prof.setNome(rs.getString("NOMpp"));
				prof.setCodRegPro(rs.getString("codregpro"));
				pps.add(prof);
			}
		}
		return pps;
	}
	
	@Override
	public void inserir(PP entidade) throws SQLException, IOException {
		try(Connection conexao =FabricaConexaoJdbc.criarConexao())  {
			PreparedStatement comando = conexao.prepareStatement("INSERT INTO pps (NOMpp, CPFpp, codregpro) " + "VALUES (?, ?, ?)");
			comando.setString(2, entidade.getCpf());// indice jdbc come�a em 1, mySQL come�a em 0
			comando.setString(1, entidade.getNome());
			comando.setString(3,  entidade.getCodRegPro());
			comando.execute();
		} 
	}
	
	@Override
	public void atualizar(PP entidade) {
		return;
		
	}
	
	@Override
	public void excluir(PP entidade) {
		return;
		
	}

}
