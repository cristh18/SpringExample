package com.cristto.service;

import com.cristto.model.AppUser;

import java.util.List;

public interface AppUserService {
    int insertAppUser(AppUser appUser);

    AppUser readAppUserById(int id);

    void updateAppUser(AppUser appUser);

    void deleteAppUser(int id);

    List<AppUser> getAllAppUsers();
}
