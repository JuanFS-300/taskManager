package taskManager;


	public class Atividades {
	    private String categoria;
	    private String nome;
	    private String descricao;
	    private String duracao;
	    private int idAtividade;

	    public Atividades(String categoria, String nome, String descricao, String duracao,int idAtividade) {
	        this.categoria = categoria;
	        this.nome = nome;
	        this.descricao = descricao;
	        this.duracao = duracao;    
	        this.idAtividade = idAtividade;
	    }
	    
	    public int getIdAtividade() {
			return this.idAtividade;
		}

		public void setIdAtividade(int idAtividade) {
			this.idAtividade = idAtividade;
		}



		public String getCategoria() {
	        return this.categoria;
	    }

	    public void setCategoria(String categoria) {
	        this.categoria = categoria;
	    }

	    public String getNome() {
	        return this.nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getDescricao() {
	        return this.descricao;
	    }

	    public void setDescricao(String descricao) {
	        this.descricao = descricao;
	    }

	    public String getDuracao() {
	        return this.duracao;
	    }

	    public void setDuracao(String duracao) {
	        this.duracao = duracao;
	    }

	    @Override
		public String toString() {
			return categoria + "," + nome + "," + descricao + ","
					+ duracao + "," + idAtividade;
		}
	    
	}

