package com.example.onlineshopsatriaadhipradana

import android.app.Activity
import androidx.fragment.app.Fragment

fun Activity.getViewModelFactory() = getActivityComponent().getViewModelFactory()

fun Fragment.getViewModelFactory() = getActivityComponent().getViewModelFactory()