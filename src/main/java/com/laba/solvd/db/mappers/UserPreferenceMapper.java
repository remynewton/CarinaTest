package com.laba.solvd.db.mappers;

import com.laba.solvd.db.models.UserPreference;

public interface UserPreferenceMapper {

    void create(UserPreference userPreference);

    UserPreference findById(Long id);
}