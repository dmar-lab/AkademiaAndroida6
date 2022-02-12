package dmar.akan.akademiaandroida

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val linearLayoutManager: LinearLayoutManager by inject()
    private val gridLayoutManager: GridLayoutManager by inject()
    private val itemDecoration: DividerItemDecoration by inject()
//    private val itemDecoration: RecyclerView.ItemDecoration by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
