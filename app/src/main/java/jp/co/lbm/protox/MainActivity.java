package jp.co.lbm.protox;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    static final String URL = "https://www.google.co.jp";
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Web Viewの初期設定
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient()); // WebViewを設定する
        webView.getSettings().setJavaScriptEnabled(true); // JavaScriptを有効にする
        webView.loadUrl(URL); // URLを読み込む
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        return super.onKeyDown(keyCode, event);
        if(keyCode == KeyEvent.KEYCODE_BACK){ // 戻るボタンがタップされた時
            if(webView != null && webView.canGoBack()){ // WebViewがNULLでなく、閲覧履歴があるなら
                webView.goBack(); // 一つ前のウェブページを表示する
            }
            return true;
        }else{
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();// バックグラウンドからフォアグランドに戻った時など
        if(webView != null) { // WebViewが空でなければ
            String url = webView.getUrl(); // 現在のウェブページを
            webView.loadUrl(url); // 再表示する
        }
    }
}