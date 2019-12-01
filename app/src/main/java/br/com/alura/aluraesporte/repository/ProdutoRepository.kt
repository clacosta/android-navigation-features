package br.com.alura.aluraesporte.repository

import androidx.lifecycle.LiveData
import br.com.alura.aluraesporte.database.dao.ProdutoDAO
import br.com.alura.aluraesporte.model.Pagamento
import br.com.alura.aluraesporte.model.Produto

class ProdutoRepository(private val dao: ProdutoDAO) {

    fun buscaTodos(): LiveData<List<Produto>> = dao.buscaTodos()

    fun buscaPorId(id: Long): LiveData<Produto> = dao.buscaPorId(id)
    fun todos(): LiveData<List<Pagamento>> = dao.todos()

}
