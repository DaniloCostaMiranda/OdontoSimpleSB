package com.odontosimple.azulay.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name ="tb_status")
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private List<Tratamento> tratamentos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private List<Procedimento> procedimentos = new ArrayList<>();

    public Status(){

    }

    public Status(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tratamento> getTratamentos() {
        return tratamentos;
    }

    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return id.equals(status.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
