package com.roberthmdz.jetpackcomposeintroduction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView


class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // If the layout handle composable components and layout normal components in xml use this
        /*return inflater.inflate(R.layout.fragment_first, container, false).apply {
            findViewById<ComposeView>(R.id.compose_view).setContent {

                NuevoComponible()

            }
        }*/

        // if the design only have composable component use this
        return ComposeView(requireContext()).apply {
            setContent {
                NuevoComponible()
            }

        }
    }

}

@Composable
fun NuevoComponible() {
    Text(text = "Hello")
}