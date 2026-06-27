package com.producaoindustrialapi.dto;

public class RegistroProducaoResponseDTO {

    private Long id;
    private Long ordemProducaoId;
    private java.time.LocalDateTime data;
    private String turno;
    private Integer quantidadeProduzida;
    private Integer refugo;
    private String operador;
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
