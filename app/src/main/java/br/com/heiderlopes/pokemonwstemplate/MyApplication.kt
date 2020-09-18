package br.com.heiderlopes.pokemonwstemplate

import android.app.Application
import com.facebook.stetho.Stetho
import br.com.heiderlopes.pokemonwstemplate.di.networkModule
import br.com.heiderlopes.pokemonwstemplate.di.repositoryModule
import br.com.heiderlopes.pokemonwstemplate.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        // Start stetho
        Stetho.initializeWithDefaults(this)

        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    viewModelModule,
                    networkModule,
                    repositoryModule
                )
            )
        }

    }
}