package com.unsoed.informatikamobile

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.activity.viewModels
import com.unsoed.informatikamobile.viewmodel.MainViewModel
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsoed.informatikamobile.databinding.ActivityDaftarBukuBinding
import com.unsoed.informatikamobile.ui.adapter.BookAdapter

class DaftarBukuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDaftarBukuBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = BookAdapter( emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = adapter

        viewModel.books.observe( this) {
            adapter.setData(it)
        }

        viewModel.fetchBooks( "kotlin programming")
    }
}