package br.com.matheliasc.Vendedores.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Atuacao {

    @Id
    private String regiao;
    @ElementCollection(targetClass = String.class)
    private List<String> estados;
}
