package com.example.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UsersRepository {

    private Database database;
    private UsersDao usersDao;
    private LiveData<List<Users>> usersList;

    public UsersRepository(Application application) {

        database = Database.getDatabase(application);
        usersDao = database.usersDao();
        usersList = usersDao.getAllUsers();
    }

    public LiveData<List<Users>> getUsersList(){
        return database.usersDao().getAllUsers();
    }

    public void insertUsers(final Users users){
        new AsyncTask<Void, Void, Void>(

        ) {
            @Override
            protected Void doInBackground(Void... voids) {
                database.usersDao().insertUser(users);
                return null;
            }
        }.execute();
    }

    public void updateUsers(final Users users){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                database.usersDao().updateUser(users);
                return null;
            }
        }.execute();
    }

    public void deleteUsers(final Users users){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                database.usersDao().deleteUser(users);
                return null;
            }
        }.execute();
    }

}
