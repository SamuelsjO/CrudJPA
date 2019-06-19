package br.samuel.crudjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.samuel.crudjpa.modelo.Local;

public class LocalDao {

	public EntityManager getEM(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TesteJPA");
		return factory.createEntityManager();
	}
	
	public Local salvar(Local local) throws Exception{
		EntityManager em = getEM();
	   try{
		   	em.getTransaction().begin();
			if(local.getId() == null){	
			em.persist(local);//executa o insert
			}
		
			else{	
				if(!em.contains(local)){
					if(em.find(Local.class, local.getId()) == null){
						throw new Exception("Erro ao atualizar o local");
					}
				}
				local = em.merge(local);//executa o update
			}
			em.getTransaction().commit();
	   }finally{
		em.close();
	}
		return local;
	}
	
	public void remover(Long id){
		EntityManager em = getEM();
		Local local = em.find(Local.class, id);
		try{
			em.getTransaction().begin();
			em.remove(local);//executa remove
			em.getTransaction().commit();
		}finally{
			em.close();
		}
	}
	
	public Local consultarPorId(Long id){
		EntityManager em = getEM();
		Local l = null;
		try {
			l = em.find(Local.class, id);//executa o select
		} finally {
			em.close();
		}
		return l;
	}
}
