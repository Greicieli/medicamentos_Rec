package br.sc.senai.web.Rn;

import java.util.List;

import br.sc.senai.web.Dao.MedicamentosDao;
import br.sc.senai.web.dominio.Medicamento;

public class MedicamentosRn {
private MedicamentosDao dao;
	
	public MedicamentosRn(){
		dao = new MedicamentosDao();
	}
	public void salvar(Medicamento medicamento)throws Exception{
		if(medicamento.getNome().trim().isEmpty()){
			throw new Exception("O nome é Obrigatório");
		}
		if(medicamento.getDosagem()<=0){
			throw new Exception("A Dosagem é Obrigatória");
		}
		if(medicamento.getIntervalo()<=0){
			throw new Exception("O intervalo é Obrigatório");
		}
		if(medicamento.getDuracao()<=0){
			throw new Exception("A Duração é Obrigatória");
		}
		
		dao.salvar(medicamento);
		
	}
	public List<Medicamento> listar() {
		return dao.listarTodos();
	}

	public Medicamento buscarPorId(Long idMedicamento) {
		return dao.buscarPorId(idMedicamento);
	}

	public void excluir(Long idMedicamento) throws Exception {
		dao.excluir(idMedicamento);
	}


}
