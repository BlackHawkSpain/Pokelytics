package study.project.pokelytics.di

import android.content.Context
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.dsl.module
import study.project.pokelytics.Navigator

@FlowPreview
@ExperimentalCoroutinesApi
val appModule = module {
    factory { (context: Context) -> Navigator(context) }
}