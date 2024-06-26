package br.com.projeto.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {
   @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
   @SequenceGenerator(name = "produto_seq", sequenceName = "sq_produto", initialValue = 1, allocationSize = 1)
    private Long id;

   @Column(name = "nomeproduto", length = 100, nullable = false)
    private String nomeProduto;

   @Column(name = "valor", nullable = false )
    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
