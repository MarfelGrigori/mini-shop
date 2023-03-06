package sm.tosk.android.common.application

import android.app.Activity
import androidx.fragment.app.Fragment
import com.example.onlineshopsatriaadhipradana.di.ApplicationComponent
import java.lang.IllegalArgumentException

fun Activity.getApplicationComponent(): ApplicationComponent {
    val application = this.application
    if (application !is ToskApplication) {
        throw IllegalArgumentException("Приложение должно быть типа ToskApplication.")
    }

    return application.applicationComponent
}

fun Fragment.getApplicationComponent(): ApplicationComponent {
    val application = this.requireActivity().application
    if (application !is ToskApplication) {
        throw IllegalArgumentException("Приложение должно быть типа ToskApplication.")
    }

    return application.applicationComponent
}