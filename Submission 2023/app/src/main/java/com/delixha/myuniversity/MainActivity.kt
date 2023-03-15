package com.delixha.myuniversity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
//import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.delixha.myuniversity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<University>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUniversity.setHasFixedSize(true)

        list.addAll(getListUniversities())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListUniversities(): ArrayList<University> {
        val dataName = resources.getStringArray(R.array.university_name)
        val dataType = resources.getStringArray(R.array.university_type)
        val dataLocation = resources.getStringArray(R.array.university_location)
        val dataLogo = resources.getStringArray(R.array.university_logo)
        val dataAccreditation = resources.getStringArray(R.array.university_accreditation)
        val dataDescription = resources.getStringArray(R.array.university_description)
        val dataRector = resources.getStringArray(R.array.university_rector)
        val dataRectorPhoto = resources.getStringArray(R.array.university_rector_photo)
        val dataMotto = resources.getStringArray(R.array.university_motto)
        val dataEstablished = resources.getStringArray(R.array.university_established)
        val dataCampus = resources.getStringArray(R.array.university_campus)
        val dataColor = resources.getStringArray(R.array.university_color)
        val dataWebsite = resources.getStringArray(R.array.university_website)
        val dataPhoto = resources.getStringArray(R.array.university_photo)
        val listUniversity = ArrayList<University>()
        for (i in dataName.indices) {
            val university = University(
                dataName[i],
                dataType[i],
                dataLocation[i],
                dataLogo[i],
                dataAccreditation[i],
                dataDescription[i],
                dataRector[i],
                dataRectorPhoto[i],
                dataMotto[i],
                dataEstablished[i],
                dataCampus[i],
                dataColor[i],
                dataWebsite[i],
                dataPhoto[i]
            )
            listUniversity.add(university)
        }
        return listUniversity
    }

    private fun showRecyclerList() {
        binding.rvUniversity.layoutManager = LinearLayoutManager(this)
        val listUniversityAdapter = ListUniversityAdapter(list)
        binding.rvUniversity.adapter = listUniversityAdapter

        listUniversityAdapter.setOnItemClickCallback(object :
            ListUniversityAdapter.OnItemClickCallback {
            override fun onItemClicked(university: University) {
                val detailActivityIntent = Intent(this@MainActivity, DetailActivity::class.java)
                detailActivityIntent.putExtra(DetailActivity.EXTRA_UNIVERSITY, university)
                startActivity(detailActivityIntent)
            }
        })
    }
}