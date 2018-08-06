package com.gabrielcunha.gamescore

import android.arch.lifecycle.ViewModelProviders
import com.gabrielcunha.gamescore.viewmodel.ScoreViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {

    @Test
    fun changeScoreTest() {
        val vm = getViewModel()
        vm.updateTimeA()
        assertEquals(1, vm._scoreTeamA.value)

        vm.updateTimeB()
        assertEquals(1, vm._scoreTeamB.value)

    }

    @Test
    fun resetTest() {
        val vm = getViewModel()
        vm.reset()
        assertEquals(0, vm._scoreTeamA.value)
        assertEquals(0, vm._scoreTeamB.value)
    }


    private fun getViewModel() : ScoreViewModel {
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        return ViewModelProviders.of(activity).get(ScoreViewModel::class.java)
    }

}
