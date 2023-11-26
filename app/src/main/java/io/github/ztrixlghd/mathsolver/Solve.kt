package io.github.ztrixlghd.mathsolver

import com.fathzer.soft.javaluator.DoubleEvaluator

data class Problem(var text: String, var isLinearEquation: Boolean, var isQuadraticEquation: Boolean, var isSimpleProblem: Boolean)

class Solve {

    public fun AnalyzeProblem(problem: String): Problem {
        val Alphabet = listOf<Char>('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')

        var newProblem = Problem(text = "", isLinearEquation = false, isQuadraticEquation = false, isSimpleProblem = false)
        newProblem.text = problem.replace(" ", "").replace(":", "/").lowercase()

        if (!Alphabet.any{newProblem.text.contains(it)}) {
            newProblem.isSimpleProblem = true
        }
        else if (Alphabet.any{newProblem.text.contains(it)} and newProblem.text.contains('^') and newProblem.text.contains("=0")) {
            newProblem.isQuadraticEquation = true
        }
        else if (Alphabet.any{newProblem.text.contains(it)} and !newProblem.text.contains('^')){
            newProblem.isLinearEquation = true
        }

        return newProblem
    }

    public fun SolveSimpleProblem(problem: Problem): Double {
        return DoubleEvaluator().evaluate(problem.text)
    }

}