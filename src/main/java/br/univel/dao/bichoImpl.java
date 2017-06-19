package br.univel.dao;

import java.util.ArrayList;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.univel.bicho.Bicho;

@Stateless
@Remote(bichoDao.class)
public class bichoImpl implements bichoDao {
	@PersistenceContext(unitName = "QuatroPata")
	EntityManager em;

	@Override
	public Bicho criar(Bicho bicho) {

		em.persist(bicho);

		return bicho;
		
	}

	@Override
	public void deletar(Bicho bicho) {
		
		Bicho bch = em.find(Bicho.class, bicho.getId());
		
		em.remove(bch);
	}

	@Override
	public Bicho editar(Bicho bicho) {
		
		em.merge(bicho);

		return bicho;
		
	}

	@Override
	public Bicho pegarPorID(int id) {

		Bicho bicho = em.find(Bicho.class, id);

		return bicho;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Bicho> pegarTodos() {

		Query query = em.createQuery("from Bicho");
		
		ArrayList<Bicho> bichos = (ArrayList<Bicho>) query.getResultList();
				
		
//		ArrayList<Bicho> bichos = (ArrayList<Bicho>) query.getResult();
		
		return bichos;
	}

}
