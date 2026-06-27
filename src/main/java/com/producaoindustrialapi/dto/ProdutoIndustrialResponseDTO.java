package com.producaoindustrialapi.dto;

public class ProdutoIndustrialResponseDTO {

    private Long id;
    private String codigo;
    private String nome;
    private String especificacoes;
    private Integer tempoProducaoMin;
    private Double custoUnitario;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEspecificacoes() { return especificacoes; }
    public void setEspecificacoes(String especificacoes) { this.especificacoes = especificacoes; }
    public Integer getTempoProducaoMin() { return tempoProducaoMin; }
    public void setTempoProducaoMin(Integer tempoProducaoMin) { this.tempoProducaoMin = tempoProducaoMin; }
    public Double getCustoUnitario() { return custoUnitario; }
    public void setCustoUnitario(Double custoUnitario) { this.custoUnitario = custoUnitario; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
