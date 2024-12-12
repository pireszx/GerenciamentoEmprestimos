package beans;

import java.util.Objects;

/**
 *
 * @author João Capudo
 */
public class Emprestimo {

    private int id;
    private Item id_item;
    private Usuario id_usuario;
    private String data_emprestimo;
    private String data_vencimento;
    private String estado;

    public Emprestimo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getId_item() {
        return id_item;
    }

    public void setId_item(Item id_item) {
        this.id_item = id_item;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Emprestimo other = (Emprestimo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_item != other.id_item) {
            return false;
        }
        if (this.id_usuario != other.id_usuario) {
            return false;
        }
        if (!Objects.equals(this.data_emprestimo, other.data_emprestimo)) {
            return false;
        }
        if (!Objects.equals(this.data_vencimento, other.data_vencimento)) {
            return false;
        }
        return Objects.equals(this.estado, other.estado);
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "id=" + id + ", id_item=" + id_item + ", id_usuario=" + id_usuario + ", data_emprestimo=" + data_emprestimo + ", data_vencimento=" + data_vencimento + ", estado=" + estado + '}';
    }

}
