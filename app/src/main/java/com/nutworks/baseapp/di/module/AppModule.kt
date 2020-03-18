package com.nutworks.baseapp.di.module

import org.koin.dsl.module

val appModule = module {

    single<FirebaseAuth> { FirebaseAuthImpl() }
}
