package com.producaoindustrialapi.dto;

import jakarta.validation.constraints.*;

public class RegistroProducaoRequestDTO {

    @NotNull(message = "OrdemProducaoId é obrigatório")
    @Positive(message = "OrdemProducaoId deve ser um ID válido (positivo)")
    private Long ordemProducaoId;
    @NotNull(message = "data não pode ser nulo")
    private java.time.LocalDateTime data;
    @NotBlank(message = "turno não pode estar em branco")
    private String turno;
    @Min(value = 0, message = "quantidade produzida não pode ser negativo")
    @NotNull(message = "quantidade produzida não pode ser nulo")
    private Integer quantidadeProduzida;
    @NotNull(message = "refugo não pode ser nulo")
    private Integer refugo;
    @NotBlank(message = "operador não pode estar em branco")
    private String operador;

    private String observacoes;

    public Long getOrdemProducaoId() { return ordemProducaoId; }
    public void setOrdemProducaoId(Long ordemProducaoId) { this.ordemProducaoId = ordemProducaoId; }
    public java.time.LocalDateTime getData() { return data; }
    public void setData(java.time.LocalDateTime data) { this.data = data; }
    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
    public Integer getQuantidadeProduzida() { return quantidadeProduzida; }
    public void setQuantidadeProduzida(Integer quantidadeProduzida) { this.quantidadeProduzida = quantidadeProduzida; }
    public Integer getRefugo() { return refugo; }
    public void setRefugo(Integer refugo) { this.refugo = refugo; }
    public String getOperador() { return operador; }
    public void setOperador(String operador) { this.operador = operador; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
