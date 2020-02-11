/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifma.si.programacaoextrema.projetotcc.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author silas
 */
@Entity
@Table(name = "banca")
public class Banca implements Serializable, Entidade {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @OneToOne
    @JoinColumn(name = "tcc_id", nullable = false)
    private TCC tcc;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private LocalDate data;

    @Column(name = "endereco", length = 150)
    private String endereco;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="professor1_id", referencedColumnName = "id")
    private Professor professor1;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="professor2_id", referencedColumnName = "id")
    private Professor professor2;
    
    @Column(name = "status")
    private boolean status;
    
    

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TCC getTcc() {
        return tcc;
    }

    public void setTcc(TCC tcc) {
        this.tcc = tcc;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banca)) {
            return false;
        }
        Banca other = (Banca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifma.si.programacaoextrema.projetotcc.model.Banca[ id=" + id + " ]";
    }
    
}
