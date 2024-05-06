package taskManager;

public class Atividades {
    private String categoria;
    private String nome;
    private String descricao;
    private int duracao;
    private String prioridade;
    private String usuario;

    public Atividades(String categoria, String nome, String descricao, int duracao, String prioridade, String usuario) {
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.prioridade = prioridade;
        this.usuario = usuario;
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

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getPrioridade() {
        return this.prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString(){
        return this.nome;
    }
}

