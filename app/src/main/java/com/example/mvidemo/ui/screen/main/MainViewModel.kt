package com.example.mvidemo.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvidemo.domain.usecase.GetSalesListUseCase
import com.example.mvidemo.ui.common.UiStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSalesListUseCase: GetSalesListUseCase
) : ContainerHost<MainState, MainSideEffect>, ViewModel() {

    override val container = container<MainState, MainSideEffect>(
        MainState()
    )

    init {
        intent {

        }
    }

    fun getAvailableSalesList() {
        intent {
            viewModelScope.launch(Dispatchers.IO) {
                reduce {
                    state.copy(
                        status = UiStatus.Loading,
                        salesLists = emptyList()
                    )
                }

                val salesLists = getSalesListUseCase()

                salesLists.takeIf { it.isNotEmpty() }?.let { salesList ->
                    reduce {
                        state.copy(
                            status = UiStatus.Success,
                            salesLists = salesList
                        )
                    }
                } ?: reduce {
                    state.copy(
                        status = UiStatus.Failed(message = "No data found"),
                        salesLists = salesLists
                    )
                }
            }
        }
    }

    fun showDialog() {
        intent {
            postSideEffect(MainSideEffect.ShowDialog(message = "Hello World!"))
        }
    }
}