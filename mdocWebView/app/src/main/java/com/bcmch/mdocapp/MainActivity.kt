package com.bcmch.mdocapp
import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val appurl = "https://tm.mybcmch.com"

    @SuppressLint("AddJavascriptInterface", "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webView = WebView(this)
        webView.webViewClient=WebViewClient()
        webView.webChromeClient = WebChromeClient()
        webView.settings.setJavaScriptEnabled(true)
        webView.settings.setDomStorageEnabled(true)
        webView.addJavascriptInterface(WebAppInterface(this), "Android")
        setContentView(webView)
        webView.loadUrl(appurl)
    }


}
/** Instantiate the interface and set the context  */
class WebAppInterface(private val mContext: Context) {

    /** Show a toast from the web page  */
    @JavascriptInterface
    fun showToast(toast: String) {
        Toast.makeText(mContext, toast, Toast.LENGTH_LONG).show()
    }
}
