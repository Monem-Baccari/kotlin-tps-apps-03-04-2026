package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Category
import com.example.mycity.model.Recommendation

object LocalDataProvider {
    val categories = listOf(
        Category(1, R.string.category_cafes, R.drawable.cafe_angelina),
        Category(2, R.string.category_restaurants, R.drawable.restaurant_icon),
        Category(3, R.string.category_parks, R.drawable.park_icon),
        Category(4, R.string.category_museums, R.drawable.museum_icon)
    )

    val recommendations = listOf(
        // Cafés
        Recommendation(1, 1, R.string.cafe1_name, R.string.cafe1_desc, R.drawable.cafe_angelina, R.string.cafe1_address),
        Recommendation(2, 1, R.string.cafe2_name, R.string.cafe2_desc, R.drawable.cafe_angelina, R.string.cafe2_address),
        Recommendation(3, 1, R.string.cafe3_name, R.string.cafe3_desc, R.drawable.cafe_angelina, R.string.cafe3_address),

        // Restaurants
        Recommendation(4, 2, R.string.rest1_name, R.string.rest1_desc, R.drawable.restaurant_icon, R.string.rest1_address),
        Recommendation(5, 2, R.string.rest2_name, R.string.rest2_desc, R.drawable.restaurant_icon, R.string.rest2_address),
        Recommendation(6, 2, R.string.rest3_name, R.string.rest3_desc, R.drawable.restaurant_icon, R.string.rest3_address),

        // Parks
        Recommendation(7, 3, R.string.park1_name, R.string.park1_desc, R.drawable.park_icon, R.string.park1_address),
        Recommendation(8, 3, R.string.park2_name, R.string.park2_desc, R.drawable.park_icon, R.string.park2_address),
        Recommendation(9, 3, R.string.park3_name, R.string.park3_desc, R.drawable.park_icon, R.string.park3_address),

        // Museums
        Recommendation(10, 4, R.string.mus1_name, R.string.mus1_desc, R.drawable.museum_icon, R.string.mus1_address),
        Recommendation(11, 4, R.string.mus2_name, R.string.mus2_desc, R.drawable.museum_icon, R.string.mus2_address),
        Recommendation(12, 4, R.string.mus3_name, R.string.mus3_desc, R.drawable.museum_icon, R.string.mus3_address)
    )
}
