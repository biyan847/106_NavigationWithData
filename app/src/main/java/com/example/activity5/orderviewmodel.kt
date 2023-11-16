package com.example.activity5

import androidx.lifecycle.ViewModel
import com.example.activity5.data.OrderUistate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat


private const val HARGA_PER_CUP = 3000
class orderviewmodel : ViewModel (){
    private val _stateUI = MutableStateFlow(OrderUistate())
    val stateUI: StateFlow<OrderUistate> = _stateUI.asStateFlow()

    fun setJumlah(jmlEsJumbo: Int) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                jumlah = jmlEsJumbo,
                harga = hitungHarga(jumlah = jmlEsJumbo)
            )
        }
    }

    fun setRasa(rasaPilihan: String) {
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(rasa = rasaPilihan) }

    }

    fun resetOrder() {
        _stateUI.value = OrderUistate()
    }

    private fun hitungHarga(jumlah: Int = _stateUI.value.jumlah): String {
        val kalkulasiHarga = jumlah * HARGA_PER_CUP

        return NumberFormat.getInstance().format(kalkulasiHarga)
    }


}