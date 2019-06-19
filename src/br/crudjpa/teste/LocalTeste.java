package br.crudjpa.teste;

import br.samuel.crudjpa.dao.LocalDao;
import br.samuel.crudjpa.modelo.Local;

public class LocalTeste {
  
	public static void main(String[] args) throws Exception {
		Local l = new Local();
		l.setPredio("Lambda");
		l.setSala("L330");
		l.setCapacidade(80);
		
		LocalDao dao = new LocalDao();
		l = dao.salvar(l);//executa o insert
		
		System.out.println("Local salvo" + l.getId() + " " + l.getPredio()+ " " + l.getSala() + 
				" " + l.getSala() + " " + l.getCapacidade());

	    Local l2 = dao.consultarPorId(l.getId());//executa o select
	    System.out.println("Consultar o local " + l.getId() + " " + l.getCapacidade());
	    
	    l2.setCapacidade(190);
	    l2.setPredio("Graus");
	    l2 = dao.salvar(l2);//executa o update
	    
	    System.out.println("Local modificado " +  l2.getId() + " " +  l2.getPredio()+ 
	    		" " +  l2.getSala() + " " +  l2.getSala() + " " +  l2.getCapacidade());
	
	    
	    dao.remover(l2.getId());//executa o delete
	}
	
}
