/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutirao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MaxColler
 */
@Stateless
public class AlimentoFacade extends AbstractFacade<Alimento> {
    @PersistenceContext(unitName = "Mutirao2015PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlimentoFacade() {
        super(Alimento.class);
    }
    
}
