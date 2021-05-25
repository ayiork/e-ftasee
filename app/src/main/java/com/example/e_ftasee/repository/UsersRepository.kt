package com.example.e_ftasee.repository
import com.example.e_ftasee.models.Admin

class UsersRepository {

    // a list of all admins
    private val admins: MutableList<Admin> = ArrayList()

    //instead of these, we can use a db such as firestone
    init {
        if (admins.isEmpty()){
            admins.add(Admin("anaoum","asnaoum123","Andreas Naoum"))
            admins.add(Admin("ayiork","ayiork123","Andreas Yiorkatzi"))
            admins.add(Admin("ashiamtanis","ahiamtanis123", "Andreas Shiamtanis"))
            admins.add(Admin("a","aa","A Aa"))
        }
    }

    fun getUsers():  MutableList<Admin>{
        return admins;
    }

}