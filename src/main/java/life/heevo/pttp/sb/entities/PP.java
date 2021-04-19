package life.heevo.pttp.sb.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa um Profissional Prescritor
 * 
 * @author hl
 * @author rk
 *
 */
@Entity
@Table(name = "pps")
public class PP {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	@Column(name="NOMpp", nullable = false, length = 255)
	private String nome;
	@Column(name="CPFpp", nullable = false, unique = true, length=11)
	private String cpf;
	@Column(name = "CRPpp", nullable = true, length=20)
	private String codRegPro;
	@Column(name = "CRPUFpp", nullable = true, length=2)
	private String crpUf;
	@Column(name = "MAILpp", nullable = true, length=255)
	private String email;
	@Column(name = "DTNASCpp", nullable = true)
	@Temporal(value = TemporalType.DATE)
	private Date DTNASCpp;
	@Column(name = "CEPCOMpp", nullable = true, length=8)
	private String CepCom;
	@Column(name = "NUMCOMpp", nullable = true, length=10)
	private String NumCom;
	@Column(name = "RUACOMpp", nullable = true, length=255)
	private String RuaCom;
	@Column(name = "BAICOMpp", nullable = true, length=255)
	private String BaiCom;
	@Column(name = "CIDCOMpp", nullable = true, length=255)
	private String CidCom;
	@Column(name = "ESTCOMpp", nullable = true, length=2)
	private String EstCom;
	@Column(name = "TELRESpp", nullable = true, length=14)
	private String TelRes;
	@Column(name = "TELCOMpp", nullable = true, length=14)
	private String TelCom;
	@Column(name = "DTCRIADOpp", nullable = true)
	@Temporal(value = TemporalType.DATE)
	private Date DTCRIADOpp;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pp")
	private List<Prontuario> prontuarios;
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "IDUSER")
	private Usuario usuario;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name="pps_expertises",
			joinColumns = {@JoinColumn(name="idPp",referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "idExpertise", referencedColumnName = "id")}
	)
	private Set<Especialidade> expertises;
	
	public PP() {
	}
	



	@Override
	public String toString() {
		return "PP [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCodRegPro() {
		return codRegPro;
	}

	public void setCodRegPro(String codRegPro) {
		this.codRegPro = codRegPro;
	}

	public String getCrpUf() {
		return crpUf;
	}

	public void setCrpUf(String crpUf) {
		this.crpUf = crpUf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDTNASCpp() {
		return DTNASCpp;
	}

	public void setDTNASCpp(Date dTNASCpp) {
		DTNASCpp = dTNASCpp;
	}


	public String getCepCom() {
		return CepCom;
	}

	public void setCepCom(String cepCom) {
		CepCom = cepCom;
	}


	public String getRuaCom() {
		return RuaCom;
	}

	public void setRuaCom(String ruaCom) {
		RuaCom = ruaCom;
	}

	public String getBaiCom() {
		return BaiCom;
	}

	public void setBaiCom(String baiCom) {
		BaiCom = baiCom;
	}

	public String getCidCom() {
		return CidCom;
	}

	public void setCidCom(String cidCom) {
		CidCom = cidCom;
	}

	public String getEstCom() {
		return EstCom;
	}

	public void setEstCom(String estCom) {
		EstCom = estCom;
	}

	public String getTelRes() {
		return TelRes;
	}

	public void setTelRes(String telRes) {
		TelRes = telRes;
	}

	public String getTelCom() {
		return TelCom;
	}

	public void setTelCom(String telCom) {
		TelCom = telCom;
	}

	public Date getDTCRIADOpp() {
		return DTCRIADOpp;
	}

	public void setDTCRIADOpp(Date dTCRIADOpp) {
		DTCRIADOpp = dTCRIADOpp;
	}

	public List<Prontuario> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<Prontuario> prontuarios) {
		this.prontuarios = prontuarios;
	}


	public String getNumCom() {
		return NumCom;
	}



	public void setNumCom(String numCom) {
		NumCom = numCom;
	}




	public Usuario getUsuario() {
		return usuario;
	}




	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
