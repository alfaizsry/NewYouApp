package com.alfaiz.app.newyou.data

import com.alfaiz.app.newyou.R

object DummyGejala {
    val batuk = Item(
            R.drawable.cough,
            "Batuk Kering",
            "Batuk kering adalah salah satu gejala dari COVID-19 dimana batuk tersebut tidak menghasilkan lendir atau dahak dari saluran udara. Seseorang dengan batuk kering mungkin mengalami tenggorokan kering, gatal, sakit, atau kasar. Mungkin juga ada sensasi gelitik di tenggorokan atau bagian tenggorokan yang terasa kering, bahkan saat menelan."
    )
    val lelah = Item(
            R.drawable.fatigue,
            "Kelelahan",
            "Kelelahan sendiri merupakan gejala paling umum dari infeksi virus corona. Menurut dr. Reza Fahlevi, Sp.A, lelah pada penderita COVID-19 bisa terjadi karena hipoksia alias kekurangan oksigen dalam sel jaringan tubuh. Dan perbedaan nyata gejala lelah biasa dan akibat COVID-19 terletak pada kadar saturasi oksigen di dalam tubuh."
    )
    val demam = Item(
            R.drawable.fever,
            "Demam",
            "Demam adalah peningkatan suhu tubuh di atas 38 derajat Celsius yang umumnya merupakan respons tubuh terhadap penyakit. Suhu tubuh yang meningkat atau demam sebenarnya merupakan salah satu gejala dari COVID-19. Demam ini bisa berlangsung 5 sampai 7 hari disertai dengan gejala lainnya."
    )
    val sesak = Item(
            R.drawable.difficulty_breathing,
            "Sesak Nafas",
            "Sesak nafas adalah salah satu gejala atau tanda yang khas dari COVID-19 . Kondisi ini dapat menimbulkan panik dan justru membuat keadaan semakin parah. Maka dari itu, saat mengalami sesak nafas sangat dianjurkan untuk tetap tenang."
    )
    val pusing = Item(
            R.drawable.pain,
            "Sakit Kepala",
            "Sakit kepala merupakan salah satu gejala umum dari infeksi virus Corona COVID-19. Meskipun begitu, gejala ini juga bisa dirasakan pada penyakit lain. Dikutip dari Times of India, perbedaan antara sakit kepala biasa dengan sakit kepala gejala COVID-19, yaitu sakit kepala gejala COVID-19 berlangsung selama 72 jam, disertai gangguan pencernaan, dan sakit yang ada akan terasa berdenyut-denyut."
    )

    fun getAll() : MutableList<Item> {
        val gejalaList = mutableListOf<Item>()

        with(gejalaList){
            add(batuk)
            add(sesak)
            add(demam)
            add(lelah)
            add(pusing)
        }

        return gejalaList
    }

    fun getSome() : MutableList<Item> {
        val gejalaList = mutableListOf<Item>()

        with(gejalaList){
            add(batuk)
            add(sesak)
            add(demam)
        }

        return gejalaList
    }
}