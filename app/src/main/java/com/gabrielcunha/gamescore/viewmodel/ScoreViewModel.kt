package com.gabrielcunha.gamescore.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    var _scoreTeamA = MutableLiveData<Int>().apply { value = 0 }
    var _scoreTeamB = MutableLiveData<Int>().apply { value = 0 }

    fun updateTimeA() {
        update(_scoreTeamA)
    }

    fun updateTimeB() {
        update(_scoreTeamB)
    }

    fun reset() {
        _scoreTeamA.value = 0
        _scoreTeamB.value = 0
    }

    private fun update(score: MutableLiveData<Int>) {
        val value = score.value ?: 0
        score.value = value + 1
    }
}