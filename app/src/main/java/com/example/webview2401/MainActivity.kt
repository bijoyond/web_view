package com.example.webview2401

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.webview2401.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

      binding.webview.loadUrl("https://evaly.com.bd/")

        binding.webview.settings.javaScriptEnabled = true

        binding.webview.webViewClient = object : WebViewClient(){

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                binding.webview.visibility =View.GONE
                binding.progressBer.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                binding.webview.visibility = View.VISIBLE
                binding.progressBer.visibility = View.GONE

            }

        }

    }

    override fun onBackPressed() {

      if (binding.webview.canGoBack()){
          binding.webview.goBack()

          }else{

}
        super.onBackPressed()
    }
}