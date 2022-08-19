package br.com.matheliasc.Vendedores.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Atuacao {

    @Id
    private String regiao;
    private List<String> estados;
}
