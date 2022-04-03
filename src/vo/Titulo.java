package vo;

import java.util.ArrayList;

public class Titulo {
	private String tipo;
	private String titulo;
	private ArrayList<String> elenco;
	private String descricao;
	private ArrayList<String> genero;
	private String diretor;
	private String classificacaoEtaria;
	private ArrayList<Player> plataforma;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public ArrayList<String> getElenco() {
		return elenco;
	}
	public void setElenco(ArrayList<String> elenco) {
		this.elenco = elenco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ArrayList<String> getGenero() {
		return genero;
	}
	public void setGenero(ArrayList<String> genero) {
		this.genero = genero;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public String getClassificacaoEtaria() {
		return classificacaoEtaria;
	}
	public void setClassificacaoEtaria(String classificacaoEtaria) {
		this.classificacaoEtaria = classificacaoEtaria;
	}
	public ArrayList<Player> getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(ArrayList<Player> plataforma) {
		this.plataforma = plataforma;
	}
	public Titulo(String tipo, String titulo, ArrayList<String> elenco, String descricao, ArrayList<String> genero,
			String diretor, String classificacaoEtaria, ArrayList<Player> plataforma) {
		this.tipo = tipo;
		this.titulo = titulo;
		this.elenco = elenco;
		this.descricao = descricao;
		this.genero = genero;
		this.diretor = diretor;
		this.classificacaoEtaria = classificacaoEtaria;
		this.plataforma = plataforma;
	}
	@Override
	public String toString() {
		return "********************************************************\n"
				+ "Titulo\n"
				+ "	Tipo: " + tipo
				+ "\n	Título: " + this.titulo
				+ "\n	Elenco: " + this.elenco
				+ "\n	Descricao: " + this.descricao
				+ "\n	Gênero: " + this.genero
				+ "\n	Diretor: " + this.diretor
				+ "\n	Classificacao etária: " + this.classificacaoEtaria
				+ "\n	Plataforma:\n	" + this.plataforma
				+ "\n********************************************************";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classificacaoEtaria == null) ? 0 : classificacaoEtaria.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((diretor == null) ? 0 : diretor.hashCode());
		result = prime * result + ((elenco == null) ? 0 : elenco.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titulo other = (Titulo) obj;
		if (classificacaoEtaria == null) {
			if (other.classificacaoEtaria != null)
				return false;
		} else if (!classificacaoEtaria.equals(other.classificacaoEtaria))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (diretor == null) {
			if (other.diretor != null)
				return false;
		} else if (!diretor.equals(other.diretor))
			return false;
		if (elenco == null) {
			if (other.elenco != null)
				return false;
		} else if (!elenco.equals(other.elenco))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		//
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		//
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equalsIgnoreCase(other.titulo))
			return false;
		return true;
	}
	
	public boolean equalsSemPlayer(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titulo other = (Titulo) obj;
		if (classificacaoEtaria == null) {
			if (other.classificacaoEtaria != null)
				return false;
		} else if (!classificacaoEtaria.equals(other.classificacaoEtaria))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (diretor == null) {
			if (other.diretor != null)
				return false;
		} else if (!diretor.equals(other.diretor))
			return false;
		if (elenco == null) {
			if (other.elenco != null)
				return false;
		} else if (!elenco.equals(other.elenco))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		//sem plataforma
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equalsIgnoreCase(other.titulo))
			return false;
		return true;
	}
	
	
	
}
