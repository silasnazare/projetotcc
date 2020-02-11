/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifma.si.programacaoextrema.projetotcc.repository;

import br.edu.ifma.si.programacaoextrema.projetotcc.model.Banca;
import br.edu.ifma.si.programacaoextrema.projetotcc.model.TCC;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author silas
 */
public class BancaRepository {
    
    private final EntityManager manager;
    private DAO<Banca> daoBanca;
    private DAO<TCC> daoTCC;

    public BancaRepository(EntityManager manager) {
        this.manager = manager;
        daoBanca = new DAO<Banca>(manager);
        daoTCC = new DAO<TCC>(manager);
    }
    
  /*  public TCC buscaPorTCC(TCC id) {
        return daoTCC.buscaPorId(TCC.class, id);
    }*/
     public Banca buscaPorId(Integer id) {
        return daoBanca.buscaPorId(Banca.class, id);
    }
    public Banca buscaPorTCC(TCC tcc) {
        return daoBanca.buscaPorObject(Banca.class, tcc);
    }
    
    public List<Banca> buscaPor(String nome) {
        return this.manager.createQuery("from Banca " + "where upper(nome) like :nome", Banca.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Banca salvaOuAtualiza(Banca banca) {
        return daoBanca.salvaOuAtualiza(banca);
    }

    public void remove(Banca banca) {
        daoBanca.remove(banca);
    }
    
}
