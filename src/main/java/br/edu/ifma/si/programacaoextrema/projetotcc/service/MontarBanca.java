/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifma.si.programacaoextrema.projetotcc.service;

import br.edu.ifma.si.programacaoextrema.projetotcc.connection.EMFactory;
import br.edu.ifma.si.programacaoextrema.projetotcc.model.Banca;
import br.edu.ifma.si.programacaoextrema.projetotcc.model.Professor;
import br.edu.ifma.si.programacaoextrema.projetotcc.model.TCC;
import br.edu.ifma.si.programacaoextrema.projetotcc.repository.BancaRepository;
import java.util.Iterator;
import java.util.Objects;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.swing.JComboBox;

/**
 *
 * @author Segismar Junior
 */
public class MontarBanca {
    private final BancaRepository repositorio;
    private final EntityManager manager;
    
    public MontarBanca( ) {
	this.manager = new EMFactory().getEntityManager();
	this.repositorio = new BancaRepository(manager);
    }
    
    public Banca salva(Banca banca) throws BancaException {

	try {
            manager.getTransaction().begin();

            Banca bancaExistente = repositorio.buscaPorId(banca.getId());
            Banca tccExistente =  repositorio.buscaPorTCC(banca.getTcc());

		if (Objects.nonNull(bancaExistente) && !Objects.equals(banca, bancaExistente) && Objects.nonNull(tccExistente) && !Objects.equals(banca, bancaExistente)) {
                    throw new BancaException("Já existe um TCC existente.");
		}
                    Banca BancaSalva = repositorio.salvaOuAtualiza(banca);
                    manager.getTransaction().commit();
                    return BancaSalva;
		} catch	(Exception e) {
                    throw new RuntimeException(e);
		}
    }
   
    
    public void mostrarTCC (JComboBox<TCC> cmbTCC, int id){
        manager.getTransaction().begin();
        
        Query query = manager.createQuery("Select ");
        query.setParameter("id", id);
        Iterator it = query.getResultList().iterator();
        TCC tcc = null;
        try{
            while (it.hasNext()){
                tcc = (TCC) it.next();
                cmbTCC.addItem(tcc);
            }
        }
        catch(Exception e){
            System.out.println("Não se pode listar os dados do TCC" + manager.getMessage());
        }
    }
    public void mostrarProfessor1(JComboBox<Professor> cmbProfessor, int id){
        manager.getTransaction().begin();
        
        Query query = manager.createQuery("Select ");
        query.setParameter("id", id);
        Iterator it = query.getResultList().iterator();
        Professor professor1 = null;
        try{
            while (it.hasNext()){
                professor1 = (Professor) it.next();
                cmbProfessor.addItem(professor1);
            }
        }
        catch(Exception e){
            System.out.println("Não se pode listar os dados do TCC" + manager.getMessage());
        }
    }    
    
    
    
    

	
    
}
