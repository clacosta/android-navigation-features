package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.alura.aluraesporte.NavGraphDirections
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.LoginViewModel
import org.koin.android.viewmodel.ext.android.viewModel

abstract class BaseFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModel()
    private val controlador by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verificaSeEstaLogado()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_deslogar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item.let { menuItem ->
            when (menuItem?.itemId) {
                R.id.menu_deslogar -> {
                    loginViewModel.desloga()
                    vaiParaLogin()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun vaiParaLogin() {
        val directions =
            NavGraphDirections.actionGlobalLogin()
        controlador.navigate(directions)
    }

    private fun verificaSeEstaLogado() {
        if (loginViewModel.naoEstaLogado()) {
            vaiParaLogin()
        }
    }

}