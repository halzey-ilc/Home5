package com.example.presentation.ui.fragments.anime

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.base.BaseFragment
import com.example.presentation.ui.adapters.AnimeAdapter
import com.example.presentation.utils.UIState
import com.example.presentation.R
import com.example.presentation.databinding.FragmentAnimeBinding
import com.example.presentation.extensions.showText
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(
    R.layout.fragment_anime
) {
    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter()

    override fun initialize() {
        setupRecycler()
    }

    override fun setupSubscribes() {
        subscribeToAnime()
    }

    private fun setupRecycler() = with(binding.recyclerView) {
        layoutManager = GridLayoutManager(requireContext(), 3)
        adapter = animeAdapter
    }

    private fun subscribeToAnime() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.countriesState.collect {
                    when (it) {
                        is UIState.Error -> {
                            showText("error")
                        }
                        is UIState.Loading -> {
                            binding.progressBar.isVisible = true
                        }
                        is UIState.Success -> {
                            showText("success")
                            binding.progressBar.isVisible = false
                            animeAdapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }
}