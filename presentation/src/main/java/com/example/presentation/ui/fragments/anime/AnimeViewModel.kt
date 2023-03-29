package com.example.presentation.ui.fragments.anime

import androidx.lifecycle.viewModelScope
import com.example.domain.either.Either
import com.example.domain.models.DataItem
import com.example.domain.usecases.FetchAnimeUseCase
import com.example.presentation.base.BaseViewModel
import com.example.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val fetchAnimeUseCase: FetchAnimeUseCase
) : BaseViewModel() {

    private val _countriesState =
        MutableStateFlow<UIState<List<DataItem>>>(UIState.Loading())
    val countriesState = _countriesState.asStateFlow()

    init {
        fetchAnimeById()
    }

    private fun fetchAnimeById() {
        viewModelScope.launch {
            fetchAnimeUseCase().collect { it ->
                when (it) {
                    is Either.Left -> {
                        it.message?.let {
                            _countriesState.value = UIState.Error(it)
                        }
                    }
                    is Either.Right -> {
                        it.data?.let {
                            _countriesState.value = UIState.Success(it)
                        }
                    }
                }
            }
        }
    }
}