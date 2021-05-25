package com.example.e_ftasee.repository
import com.example.e_ftasee.models.Table

class TableRepository {

    // a list of all restaurant's tables
    private val tables: MutableList<Table> = ArrayList()

    //instead of these, we can use a db service such as firestone
    init {
        if (tables.isEmpty()){
            tables.add(Table(1,11111))
            tables.add(Table(2,22222))
            tables.add(Table(3,33333))
            tables.add(Table(4,44444))
            tables.add(Table(5,55555))
            tables.add(Table(6,66666))
            tables.add(Table(7,77777))
            tables.add(Table(8,88888))
            tables.add(Table(9,99999))
            tables.add(Table(10,12121))
            tables.add(Table(11,13131))
        }
    }

    //returns all tables
    fun getTables():  MutableList<Table>{
        return tables;
    }

}