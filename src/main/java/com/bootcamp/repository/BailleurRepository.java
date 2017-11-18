package com.bootcamp.repository;

import com.bootcamp.entities.Bailleur;
import com.bootcamp.service.BailleurCRUD;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BailleurRepository extends BaseRepository<Bailleur>{

	public BailleurRepository(String persistUnit) {
		super(persistUnit, Bailleur.class);
		// TODO Auto-generated constructor stub
	}

	public void remove(Bailleur bailleur) throws SQLException {
        if (!this.getEm().contains(bailleur)) {
            bailleur = this.getEm().merge(bailleur);
             this.delete(bailleur);
        }
    }
	
	public Bailleur findById(Long id) throws SQLException {
		Bailleur bailleur = (Bailleur)this.getEm().createQuery("select e from Bailleur e where e.id=:id")
		.setParameter("id",id).getSingleResult();
		return bailleur;
			
	}
	
	public Bailleur findByName(String name) throws SQLException{
				
	  return (Bailleur)this.getEm().createQuery("select e from Bailleur e where e.nom=:name")
							.setParameter("name",name).getSingleResult();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Bailleur> findByPays(String pays) throws SQLException{
		
		  return (List<Bailleur>)this.getEm().createQuery("select e from Bailleur e where e.pays=:pays")
								.setParameter("pays",pays).getResultList();
			
		}

	public boolean isRecordExist(String name) {
		String query = "select count(e) from Bailleur e where e.nom=:name";
		// you will always get a single result

		Long count = (Long) this.getEm().createQuery( query )
				.setParameter("name",name).getSingleResult();
		return ( ( count.equals( 0L ) ) ? false : true );
	}

    public boolean isRecordExist(Long id) {
        String query = "select count(e) from Bailleur e where e.id=:id";
        // you will always get a single result

        Long count = (Long) this.getEm().createQuery( query )
                .setParameter("id",id).getSingleResult();
        return ( ( count.equals( 0L ) ) ? false : true );
    }
	

}
