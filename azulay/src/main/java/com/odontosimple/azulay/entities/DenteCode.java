package com.odontosimple.azulay.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_dentecode")
public class DenteCode implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "dentecodes")
    private Set<Procedimento> procedimentos = new HashSet<>();

    public DenteCode(){

    }

    public DenteCode(Long id, int number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DenteCode denteCode = (DenteCode) o;
        return id.equals(denteCode.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


