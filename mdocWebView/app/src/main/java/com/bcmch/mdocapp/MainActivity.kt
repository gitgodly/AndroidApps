package com.bcmch.mdocapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webViewClient = WebViewClient()
        val webView = WebView(this)

        webView.webViewClient=WebViewClient()
        webView.webChromeClient = WebChromeClient();
        webView.settings.setJavaScriptEnabled(true);
        setContentView(webView)
        webView.loadUrl("https://mdoc.mybcmch.com/test.html")
    }
}
