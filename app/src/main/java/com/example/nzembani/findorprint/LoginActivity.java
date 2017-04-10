package com.example.nzembani.findorprint;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.FrameLayout;



public class LoginActivity extends AppCompatActivity {

    private WebView mWebView;
    private String task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        FrameLayout root = new FrameLayout(this);
        mWebView = new WebView(this);
        root.addView(mWebView);
        setContentView(root);

        final EditText taskEditText = new EditText(this);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Add your url")
                .setMessage("Don't forget the extension (.eu, .com, .fr ...)")
                .setView(taskEditText)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        task = String.valueOf(taskEditText.getText());
                        if (!task.startsWith("www"))
                            task = "www." + task;
                        if (!task.startsWith("http://") || !task.startsWith("https://"))
                            task = "https://" + task;
                        mWebView.loadUrl(task);
                        //setContentView(mWebView);
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();

        //setupWebView();

        //mWebView.loadUrl("https://api.imgur.com/oauth2/authorize?client_id=" + MyAppConstants.MY_IMGUR_CLIENT_ID + "&response_type=token");
        //System.out.println(task);

    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/


    /**
     * Récupere le token d'après l'url
     */

 /*   private void setupWebView() {
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // intercept the tokens
                // http://example.com#access_token=ACCESS_TOKEN&token_type=Bearer&expires_in=3600
                boolean tokensURL = false;
                if (url.startsWith(MyAppConstants.MY_IMGUR_REDIRECT_URL)) {
                    tokensURL = true;
                    Matcher m;

                    m = refreshTokenPattern.matcher(url);
                    m.find();
                    String refreshToken = m.group(1);

                    m = accessTokenPattern.matcher(url);
                    m.find();
                    String accessToken = m.group(1);

                    m = expiresInPattern.matcher(url);
                    m.find();
                    long expiresIn = Long.valueOf(m.group(1));

                    //ImgurAuthorization.getInstance().saveRefreshToken(refreshToken, accessToken, expiresIn);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this, str, Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
                }
                return tokensURL;
            }
        });*/
}
