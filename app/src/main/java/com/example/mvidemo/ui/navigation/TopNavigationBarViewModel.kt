package com.example.mvidemo.ui.navigation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class TopNavigationBarViewModel @Inject constructor(

) : ContainerHost<TopNavigationBarState, TopNavigationBarSideEffect>, ViewModel() {

    override val container = container<TopNavigationBarState, TopNavigationBarSideEffect> (
        TopNavigationBarState()
    )

    fun back() {
        intent {
            postSideEffect(TopNavigationBarSideEffect.Back)
        }
    }

    fun next() {
        intent {
            postSideEffect(TopNavigationBarSideEffect.Next)
        }
    }
}