package com.producaoindustrialapi.dto;

import jakarta.validation.constraints.*;

public class LinhaProdRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "responsavel não pode estar em branco")
    private String responsavel;
    @Min(value = 0, message = "capacidade diaria não pode ser negativo")
    @NotNull(message = "capacidade diaria não pode ser nulo")
    private Integer capacidadeDiaria;
    @NotBlank(message = "turno não pode estar em branco")
    private String turno;
    @NotNull(message = "status não pode ser nulo")
    private Boolean status;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
    public Integer getCapacidadeDiaria() { return capacidadeDiaria; }
    public void setCapacidadeDiaria(Integer capacidadeDiaria) { this.capacidadeDiaria = capacidadeDiaria; }
    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
