package com.odontosimple.azulay.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odontosimple.azulay.entities.pk.TratamentoItemPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "tb_tratamento_item")
public class TratamentoItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private TratamentoItemPK id = new TratamentoItemPK();
    private Integer quantity;
    private Double price;

    public TratamentoItem(){

    }

    public TratamentoItem(Tratamento tratamento, Procedimento procedimento, Integer quantity, Double price) {
        id.setTratamento(tratamento);
        id.setProcedimento(procedimento);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Tratamento getTratamento(){
        return id.getTratamento();
    }

    public void setTratamento(Tratamento tratamento){
        id.setTratamento(tratamento);
    }

    public Procedimento getProcedimento(){
        return id.getProcedimento();
    }

    public void setProcedimento(Procedimento procedimento){
        id.setProcedimento(procedimento);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal() {
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TratamentoItem that = (TratamentoItem) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
