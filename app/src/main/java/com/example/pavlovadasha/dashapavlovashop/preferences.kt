package com.example.pavlovadasha.dashapavlovashop

import com.chibatching.kotpref.KotprefModel

object Preferences : KotprefModel() {
    var currentCategoryUrl by nullableStringPref(default = null)
}