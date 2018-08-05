package com.gabrielcunha.gamescore

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gabrielcunha.gamescore.viewmodel.ScoreViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Pega a instancia do ViewModel
    private val viewModel : ScoreViewModel by lazy {
        ViewModelProviders.of(this).get(ScoreViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btTeamA.setOnClickListener { viewModel.updateTimeA() }
        btTeamB.setOnClickListener { viewModel.updateTimeB() }
        btReset.setOnClickListener { viewModel.reset() }

        // Atualiza a view com os valores atualizados do ViewModel
        viewModel._scoreTeamA.observe(this, Observer {value ->
            textTeamA.text = value.toString()
        })

        viewModel._scoreTeamB.observe(this, Observer { value ->
            textTeamB.text = value.toString()
        })
    }


}
