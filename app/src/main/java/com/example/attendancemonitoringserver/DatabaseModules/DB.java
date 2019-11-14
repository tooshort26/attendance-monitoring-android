package com.example.attendancemonitoringserver.DatabaseModules;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.attendancemonitoringserver.DatabaseModules.Daos.AttendanceDao;
import com.example.attendancemonitoringserver.DatabaseModules.Daos.UserDao;
import com.example.attendancemonitoringserver.DatabaseModules.Models.Attendance;
import com.example.attendancemonitoringserver.DatabaseModules.Models.User;


@Database(entities = {User.class, Attendance.class},version = 1)
public abstract class DB extends RoomDatabase {

    private static DB appDatabase;
    private Context context;
    public abstract UserDao userDao();
    public abstract AttendanceDao attendanceDao();

    public synchronized  static DB getInstance(Context context){
        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), DB.class, "attendance_monitoring")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public void destroyInstance() {
        appDatabase = null;
    }
}

