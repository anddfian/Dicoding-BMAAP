package com.delixha.myuniversity

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.delixha.myuniversity.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_UNIVERSITY = "extra_university"
    }

    private lateinit var binding: ActivityDetailBinding
    private var university: University? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        university = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_UNIVERSITY, University::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_UNIVERSITY)
        }

        if (university != null) {
            supportActionBar?.title = university?.name
            Glide.with(binding.root)
                .load(university?.photo)
                .listener(object : RequestListener<Drawable> {
                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.shammerFotoPerguruanTinggi.stopShimmer()
                        binding.shammerFotoPerguruanTinggi.visibility = View.GONE
                        return false
                    }

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Toast.makeText(this@DetailActivity, "Error: $e", Toast.LENGTH_SHORT).show()
                        return false
                    }
                })
                .into(binding.fotoPerguruanTinggi)
            Glide.with(binding.root)
                .load(university?.logo)
                .listener(object : RequestListener<Drawable> {
                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.shimmerLogoPerguruanTinggi.stopShimmer()
                        binding.shimmerLogoPerguruanTinggi.visibility = View.GONE
                        return false
                    }

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Toast.makeText(this@DetailActivity, "Error: $e", Toast.LENGTH_SHORT).show()
                        return false
                    }
                })
                .into(binding.logoPerguruanTinggi)
            binding.namaPerguruanTinggi.text = university?.name
            binding.akreditasiPerguruanTinggi.text = university?.accreditation
            binding.deskripsiPerguruanTinggi.text = university?.description
            Glide.with(binding.root)
                .load(university?.rectorPhoto)
                .listener(object : RequestListener<Drawable> {
                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.shimmerFotoRektor.stopShimmer()
                        binding.shimmerFotoRektor.visibility = View.GONE
                        return false
                    }

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Toast.makeText(this@DetailActivity, "Error: $e", Toast.LENGTH_SHORT).show()
                        return false
                    }
                })
                .into(binding.fotoRektor)
            binding.rektorPerguruanTinggi.text = university?.rector
            binding.mottoPerguruanTinggi.text = university?.motto
            binding.jenisPerguruanTinggi.text = university?.type
            binding.didirikanPerguruanTinggi.text = university?.established
            binding.lokasiPerguruanTinggi.text = university?.location
            binding.kampusPerguruanTinggi.text = university?.campus
            binding.warnaPerguruanTinggi.text = university?.color
            binding.websitePerguruanTinggi.text = university?.website
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                this.finish()
            }
            R.id.action_share -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "[ MyUniversity Share ]\n\nKampus ${university?.name} | ${university?.accreditation}\nBerlokasi di ${university?.location}\n\nInformasi Lebih Lanjut Kunjungi Website: ${university?.website}"
                    )
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}