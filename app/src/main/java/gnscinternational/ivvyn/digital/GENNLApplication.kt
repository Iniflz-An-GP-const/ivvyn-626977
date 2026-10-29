package gnscinternational.ivvyn.digital

import android.app.Application
import gnscinternational.ivvyn.digital.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class GENNLApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@GENNLApplication)
            modules(appModules)
        }
    }
}