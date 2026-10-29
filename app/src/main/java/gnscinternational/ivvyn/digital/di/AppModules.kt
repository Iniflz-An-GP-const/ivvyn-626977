package gnscinternational.ivvyn.digital.di

import androidx.room.Room
import gnscinternational.ivvyn.digital.data.database.GENNLAppDatabase
import gnscinternational.ivvyn.digital.data.repository.HighScoreRepository
import gnscinternational.ivvyn.digital.data.model.Difficulty
import gnscinternational.ivvyn.digital.ui.viewmodel.GameViewModel
import gnscinternational.ivvyn.digital.ui.viewmodel.HighScoreViewModel
import gnscinternational.ivvyn.digital.ui.viewmodel.MenuViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private const val DB_NAME = "gennl_db"

val dataModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = GENNLAppDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<GENNLAppDatabase>().highScoreDao() }

    single {
        HighScoreRepository(
            highScoreDao = get(),
            coroutineDispatcher = get(DispatchersQualifiers.IO)
        )
    }
}

val viewModule = module {
    viewModel { (difficulty: Difficulty) ->
        GameViewModel(difficulty = difficulty, highScoreRepository = get())
    }

    viewModel { HighScoreViewModel(highScoreRepository = get()) }

    viewModel { MenuViewModel(highScoreRepository = get()) }
}

val appModules: List<Module> = listOf(dispatcherModule, dataModule, viewModule)
