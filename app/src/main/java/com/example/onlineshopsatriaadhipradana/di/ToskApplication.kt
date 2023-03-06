package sm.tosk.android.common.application

import android.app.Application
import com.example.onlineshopsatriaadhipradana.di.ApplicationComponent
import com.example.onlineshopsatriaadhipradana.di.DaggerApplicationComponent


class ToskApplication : Application() {
    val applicationComponent: ApplicationComponent = DaggerApplicationComponent
        .builder()
        .addApplicationModule(ApplicationModule(this))
        .build()

    override fun onCreate() {
        super.onCreate()

    }
}