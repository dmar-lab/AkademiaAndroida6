package dmar.akan.akademiaandroida.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dmar.akan.akademiaandroida.core.network.NetworkStateProvider
import dmar.akan.akademiaandroida.core.network.NetworkStateProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    factory<RecyclerView.LayoutManager> {
        LinearLayoutManager(androidContext())
    }
    /*factory {
        LinearLayoutManager(androidContext(), LinearLayoutManager.VERTICAL, false)
    }*/

    /*factory {
        StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }*/

    factory {
        DividerItemDecoration(androidContext(), DividerItemDecoration.VERTICAL)
    }

    factory {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    factory<NetworkStateProvider> {
        NetworkStateProviderImpl(get())
    }
}
