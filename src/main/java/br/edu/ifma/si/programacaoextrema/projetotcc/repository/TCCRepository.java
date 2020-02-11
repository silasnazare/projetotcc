/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifma.si.programacaoextrema.projetotcc.repository;

import br.edu.ifma.si.programacaoextrema.projetotcc.model.TCC;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author silas
 */
public class TCCRepository {
    
    private final EntityManager manager;
    private DAO<TCC> daoTCC;

    public TCCRepository(EntityManager manager) {
        this.manager = manager;
        daoTCC = new DAO<TCC>(manager);
    }
    
    public TCC buscaPorId(Integer id) {
        return daoTCC.buscaPorId(TCC.class, id);
    }

    public List<TCC> buscaPor(String nome) {
        return this.manager.createQuery("from TCC " + "where upper(nome) like :nome", TCC.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public TCC salvaOuAtualiza(TCC tcc) {
        return daoTCC.salvaOuAtualiza(tcc);
    }

    public void remove(TCC tcc) {
        daoTCC.remove(tcc);
    }
    
}
