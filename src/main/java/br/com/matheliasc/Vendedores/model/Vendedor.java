package br.com.matheliasc.Vendedores.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Vendedor {

    private Integer id;
    private LocalDate dataInclusao;
    private String nome;
    private String telefone;
    private Integer idade;
    private String cidade;
    private String estado;
    private String regiao;
}
