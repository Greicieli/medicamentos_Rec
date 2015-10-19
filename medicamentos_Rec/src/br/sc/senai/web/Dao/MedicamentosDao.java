package br.sc.senai.web.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sc.senai.web.dominio.Medicamento;

public class MedicamentosDao extends Dao {
	private final String INSERT = "INSERT INTO medicamento(nome, dosagem, intervalo, duracao) values (?, ?, ?, ?)";
	private final String UPDATE = "UPDATE medicamento SET nome = ?, dosagem = ?, intervalo = ?, duracao = ? WHERE idMedicamento = ?";
	private final String DELETE = "DELETE FROM medicamento WHERE idMedicamento = ?";
	private final String SELECT = "SELECT * FROM medicamento";
	private final String SELECT_ID = "SELECT * FROM medicamento WHERE idMedicamento = ?";
	
	
	public void salvar(Medicamento medicamento) throws Exception{
		if(medicamento.getIdMedicamento() == 0){
			inserir(medicamento);
		}else{
			alterar(medicamento);
		
		}
	}

	
	public void inserir(Medicamento medicamento) throws Exception{
		try{
			PreparedStatement ps = getConnection().prepareStatement(INSERT);
			ps.setString(1, medicamento.getNome());
			ps.setDouble(2, medicamento.getDosagem());
			ps.setDouble(3, medicamento.getIntervalo());
			ps.setDouble(4, medicamento.getDuracao());
			
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Erro ao tentar salvar o registro do Medicamento");
		}
	}
	public void alterar(Medicamento medicamento) throws Exception{
		try{
			PreparedStatement ps =getConnection().prepareStatement(UPDATE);
			ps.setString(1, medicamento.getNome());
			ps.setDouble(2, medicamento.getDosagem());
			ps.setDouble(3, medicamento.getIntervalo());
			ps.setDouble(4, medicamento.getDuracao());
			ps.setLong(5, medicamento.getIdMedicamento());

			
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Erro ao executar o update"+ e);
		}
		
	}
	
	
	public void excluir(Long idMedicamento) throws Exception{
		try{
			PreparedStatement ps = getConnection().prepareStatement(DELETE);
			ps.setLong(1, idMedicamento);
			ps.executeUpdate();
		} catch (SQLException e ){
			e.printStackTrace();
			System.out.println("Erro ao executar o delete: " + e);
			throw new Exception("Erro ao tentar excluir");
		}
	}
	

	
	public List <Medicamento> listarTodos(){
		List<Medicamento> medicamentos = new ArrayList<Medicamento>();
		try{
			PreparedStatement ps =getConnection().prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Medicamento medicamento = new Medicamento();
				medicamento.setNome(rs.getString("nome"));
				medicamento.setDosagem(rs.getDouble("dosagem"));
				medicamento.setIntervalo(rs.getDouble("intervalo"));
				medicamento.setDuracao(rs.getDouble("duracao"));
				medicamento.setIdMedicamento(rs.getLong("idMedicamento"));
				medicamentos.add(medicamento);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Erro ao mostrar o Medicamento: " + e);
				
			}
			return medicamentos;
		
		}
	public Medicamento buscarPorId(Long idMedicamento) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT_ID);
			ps.setLong(1, idMedicamento);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Medicamento medicamento = new Medicamento();
				medicamento.setNome(rs.getString("nome"));
				medicamento.setDosagem(rs.getDouble("dosagem"));
				medicamento.setIntervalo(rs.getDouble("intervalo"));
				medicamento.setDuracao(rs.getDouble("duracao"));
				medicamento.setIdMedicamento(rs.getLong("idMedicamento"));
				return medicamento;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o select do Medicamento: " + e);
		}
		return null;
	}

}


