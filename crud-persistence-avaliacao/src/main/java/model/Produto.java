package model;

import javax.persistence.*;
/**
 * @author: Rodrigo Ramos
 * */

@Entity
@Table(name = "tbl_Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    @Column
    private Double preco;

    @Column
    private String descricao;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Produto: " + descricao +
                " | Preço: " + preco + "\n";
    }
}
