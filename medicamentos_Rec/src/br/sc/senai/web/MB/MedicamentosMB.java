package br.sc.senai.web.MB;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.sc.senai.web.Rn.MedicamentosRn;
import br.sc.senai.web.dominio.Medicamento;

@ManagedBean
public class MedicamentosMB {

	private List<Medicamento> medicamentos;
	private Medicamento medicamento;
	private MedicamentosRn rn;

	
	@PostConstruct
	
	
	public void init(){
		 rn = new MedicamentosRn();
			medicamento = new Medicamento();
		}
	
	public List<Medicamento> getMedicamentos() {
		if( medicamentos == null){
			medicamentos = rn.listar();
		}
		return medicamentos;
	}
	
	public void setMedicamento(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}


	
	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamentos(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	
	public String salvar(){
		try {
			rn.salvar(medicamento);
		} catch (Exception e) {
			return "";
		}
		return "listMedicamentos";
	}
	
	
	public String excluir(String idParam){
		Long idMedicamento = Long.parseLong(idParam);
		try {
			rn.excluir(idMedicamento);
			medicamentos = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String editar(String idParam){
		Long idMedicamento = Long.parseLong(idParam);
		medicamento = rn.buscarPorId(idMedicamento);
		return "cadMedicamentos";
	}
	 

}
