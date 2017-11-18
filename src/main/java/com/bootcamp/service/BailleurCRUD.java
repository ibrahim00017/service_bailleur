package com.bootcamp.service;

import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.Bailleur;
import com.bootcamp.repository.BailleurRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BailleurCRUD implements AppConstants {


    public static boolean create(Bailleur bailleur) {
        BailleurRepository bailleurRepository = new BailleurRepository(AppConstants.unitPersistence);
        try {
            return bailleurRepository.create(bailleur);

        } catch (SQLException ex) {

            Logger.getLogger(BailleurCRUD.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public static boolean update(Bailleur bailleur) {
        BailleurRepository bailleurRepository = new BailleurRepository(AppConstants.unitPersistence);
		try {
			return bailleurRepository.update(bailleur);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(BailleurCRUD.class.getName()).log(Level.SEVERE, null, ex);

		}
		return false;

	}


	public static Bailleur read(String name){
        BailleurRepository bailleurRepository = new BailleurRepository(AppConstants.unitPersistence);
		try {
			return bailleurRepository.findByPropertyUnique("nom",name);

		} catch (SQLException e) {
			Logger.getLogger(BailleurCRUD.class.getName()).log(Level.SEVERE, null, e);

		}
		return null;
	}

	public static List<Bailleur> readAll(String pays) {
        BailleurRepository bailleurRepository = new BailleurRepository(AppConstants.unitPersistence);
		try {
			return bailleurRepository.findByProperty("pays", pays);
		} catch (SQLException e) {
		Logger.getLogger(BailleurCRUD.class.getName()).log(Level.SEVERE, null, e);

	 }

			return null;


	}


    public static boolean delete(Bailleur bailleur) {
        BailleurRepository bailleurRepository = new BailleurRepository(AppConstants.unitPersistence);
        try {
            bailleurRepository.remove(bailleur);
            return true;
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            Logger.getLogger(BailleurCRUD.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public static Bailleur read(Long id) {
        BailleurRepository bailleurRepository = new BailleurRepository(AppConstants.unitPersistence);
        try {
            return bailleurRepository.findByPropertyUnique("id",id);

        } catch (SQLException ex) {
            Logger.getLogger(BailleurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<Bailleur> readAll() {
        BailleurRepository bailleurRepository = new BailleurRepository(AppConstants.unitPersistence);
        try {
            return bailleurRepository.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(BailleurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean exist(String name){
        BailleurRepository bailleurRepository = new BailleurRepository(AppConstants.unitPersistence);
        return bailleurRepository.isRecordExist(name);
    }

    public static boolean exist(Long id){
        BailleurRepository bailleurRepository = new BailleurRepository(AppConstants.unitPersistence);
        return bailleurRepository.isRecordExist(id);
    }

}
