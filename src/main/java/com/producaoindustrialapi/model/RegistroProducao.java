package com.producaoindustrialapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "registroproducoes")
public class RegistroProducao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ordemProducao_id")
    private OrdemProducao ordemProducao;
    private java.time.LocalDateTime data;
    @Column(nullable = false)
    private String turno;
    private Integer quantidadeProduzida;
    private Integer refugo;
    @Column(nullable = false)
    private String operador;
    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public OrdemProducao getOrdemProducao() { return ordemProducao; }
    public void setOrdemProducao(OrdemProducao ordemProducao) { this.ordemProducao = ordemProducao; }
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
