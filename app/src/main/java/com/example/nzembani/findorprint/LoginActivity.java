package com.example.nzembani.findorprint;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
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
                        if (!task.startsWith("www") || !task.startsWith("http://") || !task.startsWith("https://"))
                            task = "www." + task;
                        if (!task.startsWith("http://") || !task.startsWith("https://"))
                            task = "https://" + task;
                        mWebView.loadUrl(task);
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
  }
}
