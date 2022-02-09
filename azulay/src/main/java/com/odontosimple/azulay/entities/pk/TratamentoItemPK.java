package com.odontosimple.azulay.entities.pk;

import com.odontosimple.azulay.entities.Procedimento;
import com.odontosimple.azulay.entities.Tratamento;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TratamentoItemPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "tratamento_id")
    private Tratamento tratamento;

    @ManyToOne
    @JoinColumn(name = "procedimento_id")
    private Procedimento procedimento;

    public Tratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TratamentoItemPK that = (TratamentoItemPK) o;
        return tratamento.equals(that.tratamento) && procedimento.equals(that.procedimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tratamento, procedimento);
    }
}
