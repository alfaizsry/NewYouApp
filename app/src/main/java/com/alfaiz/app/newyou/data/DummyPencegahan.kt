package com.alfaiz.app.newyou.data

import com.alfaiz.app.newyou.R

object DummyPencegahan {
    val rumah = Item(
            R.drawable.home,
            "Tetap di Rumah",
            "Untuk membatasi dan mencegah penyebaran COVID-19, kita perlu melakukan karantina massal untuk menekan atau memitigasi pandemi dengan tetap berada di rumah kecuali terdapat pekerjaan atau keperluan mendadak."
    )
    val cuci = Item(
            R.drawable.soap,
            "Cuci Tangan",
            "Untuk membatasi dan mencegah penyebaran COVID-19, kita juga perlu menjaga kebersihan diri kita dengan selalu mencuci tangan dengan bersih sebelum dan sesudah beraktivitas ataupun bepergian."
    )
    val jarak = Item(
            R.drawable.distance,
            "Menjaga Jarak",
            "Untuk membatasi dan mencegah penyebaran COVID-19, upaya dapat kita lakukan untuk mencegah penyebaran virus corona di masyarakat adalah dengan menjaga jarak(Physical Distancing). Secara sederhana Physical Distancing adalah menjaga jarak lebih dari 1 meter dengan siapapun. Dengan kata lain kita diharuskan untuk tidak berdekatan dan tidak berkumpul secara berkerumunan."
    )
    val masker = Item(
            R.drawable.mask,
            "Memakai Masker",
            "Untuk membatasi dan mencegah penyebaran COVID-19, upaya lain yang dapat kita lakukan adalah dengan menggunakan masker untuk melindung diri dari penularan kuman penyebab penyakit, terutama di tengah pandemi COVID-19 saat ini karena masker wajah tersebut dapat melindungi Anda dari percikan cairan tubuh orang lain ketika batuk dan bersin. Selain itu, masker juga mampu mencegah Anda menyebarkan tetesan liur atau ingus yang mungkin saja mengandung kuman."
    )
    val olahraga = Item(
            R.drawable.jogging,
            "Olahraga",
            "Untuk membatasi dan mencegah penyebaran COVID-19, kita juga harus berolahraga untuk dapat menigkatkan stamina supaya tidak mudah kelelahan, menjaga tubuh agar tetap bugar dan sehat, serta meningkatkan kekebalan tubuh terhadap berbagai penyakit, khusus COVID-19."
    )
    fun getAll() : MutableList<Item> {
        val pencegahanList = mutableListOf<Item>()

        with(pencegahanList){
            add(rumah)
            add(masker)
            add(jarak)
            add(cuci)
            add(olahraga)
        }

        return pencegahanList
    }
    fun getSome() : MutableList<Item> {
        val pencegahanList = mutableListOf<Item>()

        with(pencegahanList){
            add(rumah)
            add(masker)
            add(jarak)
        }

        return pencegahanList
    }
}