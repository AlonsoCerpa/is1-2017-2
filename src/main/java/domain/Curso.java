package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Curso implements BaseEntity<Long> {
	@Id
	private Long id;

	private String codigo;

	private String nombre;

	private Integer creditos;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "prerequisito",
		joinColumns = @JoinColumn(name = "idCurso", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "idCursoPrerequisito", referencedColumnName = "id")
	)
	private List<Curso> prerequisitos;
	
	@OneToMany(mappedBy="curso")
	private List<Matricula> matriculas = new ArrayList<Matricula>();

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public List<Curso> getPrerequisitos() {
		return prerequisitos;
	}

	public void setPrerequisitos(List<Curso> prerequisitos) {
		this.prerequisitos = prerequisitos;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
}
