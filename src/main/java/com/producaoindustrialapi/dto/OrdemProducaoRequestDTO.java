package com.producaoindustrialapi.dto;

import jakarta.validation.constraints.*;

public class OrdemProducaoRequestDTO {

    @NotNull(message = "LinhaProdId é obrigatório")
    @Positive(message = "LinhaProdId deve ser um ID válido (positivo)")
    private Long linhaProdId;
    @NotNull(message = "ProdutoIndustrialId é obrigatório")
    @Positive(message = "ProdutoIndustrialId deve ser um ID válido (positivo)")
    private Long produtoIndustrialId;
    @Min(value = 0, message = "quantidade não pode ser negativo")
    @NotNull(message = "quantidade não pode ser nulo")
    private Long quantidade;
    @FutureOrPresent(message = "data inicio não pode ser retroativo")
    @NotNull(message = "data inicio não pode ser nulo")
    private java.time.LocalDateTime dataInicio;
    @NotNull(message = "data prevista não pode ser nulo")
    private java.time.LocalDateTime dataPrevista;
    @NotBlank(message = "status não pode estar em branco")
    private String status;
    @Min(value = 0, message = "prioridade não pode ser negativo")
    @NotNull(message = "prioridade não pode ser nulo")
    private Integer prioridade;

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
