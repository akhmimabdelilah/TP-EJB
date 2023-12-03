package services;

import java.util.List;

import dao.IDaoRemote;
import dao.VilleIDao;
import entities.Ville;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "Abdelilah")
@PermitAll
public class VilleService implements VilleIDao, IDaoRemote<Ville> {

	@PersistenceContext
	private EntityManager em;

	@Override

	public Ville create(Ville o) {
		em.persist(o);
		return o;
	}

	@Override
	public boolean delete(Ville o) {
		if (o != null) {
			// Check if the entity is managed before trying to remove it
			if (em.contains(o)) {
				em.remove(o);
			} else {
				// If the entity is detached, merge it first and then remove
				Ville managedEntity = em.merge(o);
				em.remove(managedEntity);
			}
			return true;
		}
		return false;
	}

	@Override
	public Ville update(Ville o) {
		Ville existingVille = em.find(Ville.class, o.getId());

		if (existingVille != null) {
			// Mettre � jour les propri�t�s de l'entit� existante avec les nouvelles valeurs
			existingVille.setNom(o.getNom());

			// Ajouter d'autres propri�t�s � mettre � jour...

			// Mettre � jour l'entit� dans la base de donn�es
			em.merge(existingVille);
		}

		return o;
	}

	@Override
	public Ville findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Ville.class, id);
	}

	@Override
	public List<Ville> findAll() {
		Query query = em.createQuery("select v from Ville v");
		return query.getResultList();
	}

}
