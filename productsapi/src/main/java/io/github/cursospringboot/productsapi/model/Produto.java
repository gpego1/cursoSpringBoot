package io.github.cursospringboot.productsapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private Double preco;

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
