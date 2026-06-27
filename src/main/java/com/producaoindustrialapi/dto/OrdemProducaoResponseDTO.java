package com.producaoindustrialapi.dto;

public class OrdemProducaoResponseDTO {

    private Long id;
    private Long linhaProdId;
    private Long produtoIndustrialId;
    private Long quantidade;
    private java.time.LocalDateTime dataInicio;
    private java.time.LocalDateTime dataPrevista;
    private String status;
    private Integer prioridade;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getLinhaProdId() { return linhaProdId; }
    public void setLinhaProdId(Long linhaProdId) { this.linhaProdId = linhaProdId; }
    public Long getProdutoIndustrialId() { return produtoIndustrialId; }
    public void setProdutoIndustrialId(Long produtoIndustrialId) { this.produtoIndustrialId = produtoIndustrialId; }
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
