package service;

/**
 * Created by Redbullek on 2017-01-10.
 */


import java.util.ArrayList;
import java.util.List;

import domain.antywirus;
import domain.pakiet;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class antywirusmanager implements Iantywirusmanager{

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long addantywirus(antywirus antywirus) {
        antywirus.setId(null);
        return (Long) sessionFactory.getCurrentSession()
                .save(antywirus);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<antywirus> Wszystkieantywirusy() {
        return sessionFactory
                .getCurrentSession()
                .getNamedQuery("antywirus.all")
                .list();
    }

    @Override
    public antywirus findByIdantywirus(Long id) {
        return (antywirus) sessionFactory
                .getCurrentSession()
                .get(antywirus.class,id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public antywirus findByNazwa(String nazwa) {
        return (antywirus) sessionFactory
                .getCurrentSession()
                .getNamedQuery("antywirus.byNazwa")
                .setString("name",nazwa)
                .uniqueResult();
    }
/*
    @Override
    public void deleteantywirus(antywirus antywirus) {
        antywirus = (antywirus) sessionFactory.getCurrentSession()
                .get(antywirus.class,antywirus.getId());
        //fetchtype lazy here
        if(antywirus.getPakiety()!=null)
            for (antywirus antywirus1: antywirus.getPakiety()){
                antywirus.setModels(null);
                sessionFactory.getCurrentSession().update(antywirus);

            }
        sessionFactory.getCurrentSession().delete(antywirus);

    }
    */
}
