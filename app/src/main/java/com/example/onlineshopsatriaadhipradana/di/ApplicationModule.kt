package sm.tosk.android.common.application

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: ToskApplication) {
    @Provides
    fun provideContext(): Context = application
}