package sm.tosk.android.common.viewmodel

import androidx.lifecycle.*
import com.example.onlineshopsatriaadhipradana.di.CommonViewModelFactory
import dagger.*
import javax.inject.Provider

@Module
class ViewModelModule {
    @Provides
    fun provideViewModelFactory(
        viewModelProviders: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
    ): ViewModelProvider.Factory = CommonViewModelFactory(viewModelProviders)
}