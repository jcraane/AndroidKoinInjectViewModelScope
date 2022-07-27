package com.example.myapplication

import com.example.myapplication.ui.dashboard.DashboardViewModel
import com.example.myapplication.ui.home.RandomGenerator
import com.example.myapplication.ui.home.HomeViewModel
import com.example.myapplication.ui.notifications.NotificationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        HomeViewModel()
    }

    viewModel {
        DashboardViewModel()
    }

    viewModel {
        NotificationsViewModel()
    }

    single {
        RandomGenerator()
    }
}