package com.example.attendancemonitoringserver.DatabaseModules.Daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.attendancemonitoringserver.DatabaseModules.Models.User;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void create(User user);

    @Query("SELECT * FROM users LIMIT 1")
    User getUser();
}
