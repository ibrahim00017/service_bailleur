package com.bootcamp.service;

import com.bootcamp.entities.Bailleur;
import com.bootcamp.service.BailleurCRUD;

public class BailleurFS {

    public static Bailleur findByName(String name){
        if(BailleurCRUD.exist(name))
            return BailleurCRUD.read(name);
        return null;
    }

    public static Bailleur getById(Long id){
        if(BailleurCRUD.exist(id))
            return BailleurCRUD.read(id);
        return null;
    }

    public static boolean create(Bailleur bailleur){
        String nom = bailleur.getNom();

        if(BailleurCRUD.exist(bailleur.getNom()))
            return false;
        return BailleurCRUD.create(bailleur);
    }

    public static boolean delete(Long id){

        if(BailleurCRUD.exist(id)) {
            Bailleur bailleur = BailleurCRUD.read(id);
            return BailleurCRUD.delete(bailleur);

        }
        return false;
    }

    public static boolean update(Bailleur bailleur){
        if(BailleurCRUD.exist(bailleur.getId()))
            return BailleurCRUD.update(bailleur);
        return false;
    }

}
