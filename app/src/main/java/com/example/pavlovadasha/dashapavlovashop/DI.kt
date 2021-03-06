package com.example.pavlovadasha.dashapavlovashop

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

val di = Kodein {
    bind<RequestMaker>() with singleton { OkHttpRequestMaker() }
}