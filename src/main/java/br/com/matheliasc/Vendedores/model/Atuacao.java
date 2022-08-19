package br.com.matheliasc.Vendedores.model;

import lombok.Data;

import java.util.List;

@Data
public class Atuacao {

    private String regiao;
    private List<String> estados;
}
