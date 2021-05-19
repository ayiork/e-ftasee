package com.example.e_ftasee.repository
import com.example.e_ftasee.models.User

class UsersRepository {

    // a list of all restaurant's tables
    private val users: MutableList<User> = ArrayList()

    //instead of these, we can use a db service such as firestone
    init {
        if (users.isEmpty()){
            users.add(User("andreasnaoum","andreasnaoum123","Andreas Naoum"))
            users.add(User("andreasyiorkatzi","andreasyiorkatzi123","Andreas Yiorkatzi"))
            users.add(User("andreasshiamtanis","andreasshiamtanis123", "Andreas Yiorkatzi"))
        }
    }

    fun getUsers():  MutableList<User>{
        return users;
    }

}