package beans;

import java.util.Objects;

public class Historico {

    private int id_historico;
    private int id_emprestimo;
    private String estado;
    private String data_acao;

    public Historico() {
    }

    public int getId_historico() {
        return id_historico;
    }

    public void setId_historico(int id_historico) {
        this.id_historico = id_historico;
    }

    public int getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getData_acao() {
        return data_acao;
    }

    public void setData_acao(String data_acao) {
        this.data_acao = data_acao;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Historico other = (Historico) obj;
        if (this.id_historico != other.id_historico) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.data_acao, other.data_acao)) {
            return false;
        }
        return this.id_emprestimo == other.id_emprestimo;
    }

    @Override
    public String toString() {
        return "Historico{" + "id_historico=" + id_historico + ", id_emprestimo=" + id_emprestimo + ", estado=" + estado + ", data_acao=" + data_acao + '}';
    }
}
