package com.example.e_ftasee.repository

import android.util.Log
import com.example.e_ftasee.models.Food

class FoodRepository {
    lateinit var food: ArrayList<Food>

    init{
        addFood()
    }


    private fun addFood(){
        food = ArrayList()
        food.add(
            Food(name="Mix Souvlaki/Μιξ σουβλάκι", details = "Cyprus pitta with 2 skewers pork and 1 skewer sheftalia/ Κυπριακή πίττα με 2 ξυλάκια χοιρινό και 1 ξυλάκι σιεφταλιά",price = 5.0)
        )
        food.add(
            Food(name="Mix Souvlaki Extra/Μιξ σουβλάκι Έξτρα", details = "Cyprus pitta with 3 skewers pork and 2 skewer sheftalia/ Κυπριακή πίττα με 3 ξυλάκια χοιρινό και 2 ξυλάκι σιεφταλιά",price = 5.0)
        )
        food.add(
            Food(name="Souvlakia/Σουβλάκια", details = "Cyprus pitta with 3 skewers pork/ Κυπριακή πίττα με 3 ξυλάκια χοιρινό ",price = 6.0)
        )
        food.add(
            Food(name="Souvlakia Extra/Σουβλάκια Έξτρα", details = "Cyprus pitta with 5 skewers pork/ Κυπριακή πίττα με 5 ξυλάκια χοιρινό ",price = 6.0)
        )
        food.add(
            Food(name= "kolokasi/Κολοκάσι", details="kolokasi (root vegetables)/Κολοκάσι",price = 4.5)
        )
        food.add(
            Food(name="Afella/Αφέλια", details = "Cafella (pork marinated in coriander)/ Αφέλια ",price = 5.5)
        )
        food.add(
            Food(name= "Halloumi/ Χαλούμι", details="Cyprus pitta with halloumi/ Κυπριακή πίττα με χαλούμι",price = 4.0)
        )
        food.add(
            Food(name="Chicken Souvlaki/Κοτόπουλο σουβλάκι",details="Cyprus pitta with 3 skewers chicken/Κυπριακή πίττα με 3 ξυλάκια",price = 5.5)
        )
        food.add(
            Food(name="Sausages/Λουκάνικο",details = "Cyprus pitta with 3 sausages/Κυπριακή Πίττα με 3 λουκανικά",price = 5.0)
        )
        food.add(
            Food(name="Salad/Σαλάτα",details = "Salad/Σαλάτα με λαχανικά",price = 5.0)
        )
        food.add(
            Food(name="Greek Salad/Ελληνική Σαλάτα",details = "Greek Salad(olives,feta,tomatoes)/Ελληνική Σαλάτα (ελιές, φέτα, ντομάτα)",price = 5.5)
        )
        food.add(
            Food(name="Rizogalo/ Γλυκό Ριζόγαλα", details="Rizogalo with cinnamon/ Ριζόγαλο με κανέλα",price = 4.0)
        )
        food.add(
            Food(name="Spoon Sweets/ Γλυκά του Κουταλιού", details="Seasonal spoon sweets/ Εποχιακά γλυκά του Κουταλιού",price = 4.0)
        )
        food.add(
            Food(name="Cola", details = "Soft Drink Cola/ Αναψυκτικό Cola",price = 2.0)
        )
        food.add(
            Food(name="Sprite", details = "Soft Drink Sprite/ Αναψυκτικό Sprite",price = 2.0)
        )
        food.add(
            Food(name="Fanta", details = "Soft Drink Fanta/ Αναψυκτικό Fanta",price = 2.0)
        )
        food.add(
            Food(name="Orange Juice/Χυμός Πορτοκάλι", details = "Orange Juice 300ml/Χυμός Πορτοκάλι 300ml",price = 2.0)
        )
        food.add(
            Food(name="Small bottle of water/ Μικρή μπουκάλα νερού", details="Small bottle of water/ Μικρή μπουκάλα νερού",price = 1.0)
        )
        food.add(
            Food(name="1L bottle of water/ 1L μπουκάλα νερού", details="1L bottle of water/ 1L μπουκάλα νερού",price = 2.0)
        )
    }

    fun getFoodNames(): Array<String?> {
        val names = arrayOfNulls<String>(food.size)

        food.forEachIndexed { i, foodd ->
            names[i] = foodd.name
        }
        return names
    }

}