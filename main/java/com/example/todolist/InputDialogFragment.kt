package com.example.todolist
import android.annotation.TargetApi
import android.app.AlertDialog
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.dialog_input.view.*

class InputDialogFragment : DialogFragment(){
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        /* 入力ボタン・キャンセルボタンを作成 */
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(R.layout.dialog_input)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(R.string.resist) { _, _ ->
                Log.d("MyKotlinApp", "RESIST PUSHED")
            }

        /* テキストをメインに渡す */
        val view = View.inflate(context, R.layout.dialog_input, null)

        builder.setView(view)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(R.string.resist) { _, _ ->
                val step = view.editText.text.toString()
                viewModel.inputStepCount.value = step.toInt()
            }
        return builder.create()
    }

}