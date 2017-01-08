package com.cristto.service.impl;

import com.cristto.model.AppUser;
import com.cristto.service.AppUserService;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public int insertAppUser(AppUser appUser) {
        return (Integer) sessionFactory
                .getCurrentSession()
                .save(appUser);
    }

    @Transactional
    public AppUser readAppUserById(int id) {
        return (AppUser) sessionFactory
                .getCurrentSession()
                .createCriteria(AppUser.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Transactional
    public void updateAppUser(AppUser appUser) {
        sessionFactory
                .getCurrentSession()
                .update(appUser);
    }

    @Transactional
    public void deleteAppUser(int id) {
        sessionFactory
                .getCurrentSession()
                .delete(readAppUserById(id));
    }

    @Transactional
    public List<AppUser> getAllAppUsers() {
        return sessionFactory
                .getCurrentSession()
                .createCriteria(AppUser.class)
                .list();
    }
}