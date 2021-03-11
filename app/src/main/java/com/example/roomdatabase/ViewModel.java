package com.example.roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private UsersRepository usersRepository;
    private LiveData<List<Users>> usersList;

    public ViewModel(@NonNull Application application) {
        super(application);

        usersRepository = new UsersRepository(application);
        usersList = usersRepository.getUsersList();
    }

    public LiveData<List<Users>> getUsersList(){
        return usersRepository.getUsersList();
    }

    public void insertUser(Users users){
        usersRepository.insertUsers(users);
    }

    public void updateUser(Users users){
        usersRepository.updateUsers(users);
    } //update user

    public void deleteUser(Users users){
        usersRepository.deleteUsers(users);
    } //delete user
}
