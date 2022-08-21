package br.com.matheliasc.Vendedores.model.dto;

import br.com.matheliasc.Vendedores.model.Vendedor;
import lombok.Data;

import java.util.List;

@Data
public class VendedorDTO {
    private String nome;
    private String telefone;
    private Integer idade;
    private String cidade;
    private String estado;
    private List<String> estados;

    public VendedorDTO(Vendedor vendedor, List<String> estados){
        this.nome = vendedor.getNome();
        this.telefone = vendedor.getTelefone();
        this.idade = vendedor.getIdade();
        this.cidade = vendedor.getCidade();
        this.estado = vendedor.getEstado();
        this.estados = estados;
    }

}
