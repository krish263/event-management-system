package com.event.booking.system.project.dao.movies.impl;

import com.event.booking.system.project.dao.movies.ShowDAO;
import com.event.booking.system.project.entity.movies.Show;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShowDAOImpl implements ShowDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public ShowDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    public void addShow(Show sh) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(sh);
    }

    @Override
    public List<Show> getShowforGivenMovie(long movieId,long cityId) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("From Show s where s.movie.id=:movieId AND s.city");
        return null;
    }


}
