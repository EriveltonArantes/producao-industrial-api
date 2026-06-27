package com.producaoindustrialapi.dto;

import jakarta.validation.constraints.*;

public class ProdutoIndustrialRequestDTO {

    @NotBlank(message = "codigo não pode estar em branco")
    private String codigo;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "especificacoes não pode estar em branco")
    private String especificacoes;
    @NotNull(message = "tempo producao min não pode ser nulo")
    private Integer tempoProducaoMin;
    @DecimalMin(value = "0.0", message = "custo unitario não pode ser negativo")
    @NotNull(message = "custo unitario não pode ser nulo")
    private Double custoUnitario;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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
