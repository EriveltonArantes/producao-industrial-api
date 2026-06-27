package com.producaoindustrialapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "linhaprods")
public class LinhaProd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String responsavel;
    private Integer capacidadeDiaria;
    @Column(nullable = false)
    private String turno;
    private Boolean status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
