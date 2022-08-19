package br.com.matheliasc.Vendedores.model;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Atuacao {

    @Id
    private String regiao;
    @ElementCollection(targetClass = String.class)
    private List<String> estados;
}
