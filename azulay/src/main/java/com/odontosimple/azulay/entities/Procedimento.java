package com.odontosimple.azulay.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odontosimple.azulay.entities.enums.Dentes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_procedimento")
public class Procedimento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @ManyToMany
    @JoinTable(name = "tb_procedimento_dentecode", joinColumns = @JoinColumn(name = "procedimento_id"),
    inverseJoinColumns = @JoinColumn(name = "dentecode_id"))
    private Set<DenteCode> dentecodes = new HashSet<>();

    @OneToMany(mappedBy = "id.procedimento")
    private Set<TratamentoItem> items = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;


    public Procedimento(){

    }

    public Procedimento(Long id, String name, Double price, Status status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<DenteCode> getDentecodes() {
        return dentecodes;
    }

    @JsonIgnore
    public Set<Tratamento> getTratamentos(){
        Set<Tratamento> set = new HashSet<>();
        for (TratamentoItem x: items) {
            set.add(x.getTratamento());
        }
        return set;
    }

    /*
    public Dente getDentes() {
        return Dentes.valueOf(dente);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procedimento that = (Procedimento) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
