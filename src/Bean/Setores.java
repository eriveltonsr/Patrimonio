package Bean;

/**
 *
 * @author Erivelton e Matheus Vinicius
 */

public class Setores {
    private int setor_cod;
    private int setor_numero;
    private String setor_nome;

    public int getSetor_cod() {
        return setor_cod;
    }

    public void setSetor_cod(int setor_cod) {
        this.setor_cod = setor_cod;
    }

    public int getSetor_numero() {
        return setor_numero;
    }

    public void setSetor_numero(int setor_numero) {
        this.setor_numero = setor_numero;
    }

    public String getSetor_nome() {
        return setor_nome;
    }

    public void setSetor_nome(String setor_nome) {
        this.setor_nome = setor_nome;
    }

    @Override
    public String toString() {
        return setor_nome; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
