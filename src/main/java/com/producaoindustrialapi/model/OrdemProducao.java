package com.producaoindustrialapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ordemproducoes")
public class OrdemProducao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "linhaProd_id")
    private LinhaProd linhaProd;
    @ManyToOne
    @JoinColumn(name = "produtoIndustrial_id")
    private ProdutoIndustrial produtoIndustrial;
    private Long quantidade;
    private java.time.LocalDateTime dataInicio;
    private java.time.LocalDateTime dataPrevista;
    @Column(nullable = false)
    private String status;
    private Integer prioridade;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LinhaProd getLinhaProd() { return linhaProd; }
    public void setLinhaProd(LinhaProd linhaProd) { this.linhaProd = linhaProd; }
    public ProdutoIndustrial getProdutoIndustrial() { return produtoIndustrial; }
    public void setProdutoIndustrial(ProdutoIndustrial produtoIndustrial) { this.produtoIndustrial = produtoIndustrial; }
    public Long getQuantidade() { return quantidade; }
    public void setQuantidade(Long quantidade) { this.quantidade = quantidade; }
    public java.time.LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(java.time.LocalDateTime dataInicio) { this.dataInicio = dataInicio; }
    public java.time.LocalDateTime getDataPrevista() { return dataPrevista; }
    public void setDataPrevista(java.time.LocalDateTime dataPrevista) { this.dataPrevista = dataPrevista; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Integer getPrioridade() { return prioridade; }
    public void setPrioridade(Integer prioridade) { this.prioridade = prioridade; }
}
