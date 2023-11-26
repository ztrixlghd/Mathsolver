package io.github.ztrixlghd.mathsolver

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

import io.github.ztrixlghd.mathsolver.Solve

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val problem: EditText = findViewById(R.id.problem)
        val solve_btn: Button = findViewById(R.id.solve_btn)

        solve_btn.setOnClickListener {
            val solveCLient = Solve()
            val newProblem = solveCLient.AnalyzeProblem(problem.text.toString())
            if (newProblem.isSimpleProblem == true) {
                println(solveCLient.SolveSimpleProblem(newProblem))
            }
            println(newProblem)
        }

    }
}
