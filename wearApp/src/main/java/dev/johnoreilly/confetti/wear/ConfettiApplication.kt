package dev.johnoreilly.confetti.wear

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import dev.johnoreilly.confetti.di.initKoin
import dev.johnoreilly.confetti.wear.di.appModule
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class ConfettiApplication : Application(), ImageLoaderFactory {

    override fun newImageLoader(): ImageLoader = get()

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@ConfettiApplication)
            modules(appModule)
        }
    }
}