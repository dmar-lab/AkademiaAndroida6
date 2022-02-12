package dmar.akan.akademiaandroida.di

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    factory {
        LinearLayoutManager(androidContext(), LinearLayoutManager.VERTICAL, false)
    }

    factory {
        StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

    factory<RecyclerView.ItemDecoration> {
        DividerItemDecoration(androidContext(), DividerItemDecoration.VERTICAL)
    }
}