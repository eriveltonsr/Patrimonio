package Bean;

import java.util.Date;

/**
 *
 * @author Erivelton e Matheus Vinicius
 */
public class Itens {

    private int id;
    private String nome_item;
    private int Patrimonio_numero;
    private Date data_hora;
    private String setor_envio;
    private String setor_recebido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_item() {
        return nome_item;
    }

    public void setNome_item(String nome_item) {
        this.nome_item = nome_item;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public int getPatrimonio_numero() {
        return Patrimonio_numero;
    }

    public void setPatrimonio_numero(int Patrimonio_numero) {
        this.Patrimonio_numero = Patrimonio_numero;
    }

    public String getSetor_envio() {
        return setor_envio;
    }

    public void setSetor_envio(String setor_envio) {
        this.setor_envio = setor_envio;
    }

    public String getSetor_recebido() {
        return setor_recebido;
    }

    public void setSetor_recebido(String setor_recebido) {
        this.setor_recebido = setor_recebido;
    }
    
    
    
}
