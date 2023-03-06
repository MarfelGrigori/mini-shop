package sm.tosk.android.common.viewmodel

import android.app.Activity
import androidx.fragment.app.Fragment
import sm.tosk.android.common.activity.getActivityComponent

fun Activity.getViewModelFactory() = getActivityComponent().getViewModelFactory()

fun Fragment.getViewModelFactory() = getActivityComponent().getViewModelFactory()