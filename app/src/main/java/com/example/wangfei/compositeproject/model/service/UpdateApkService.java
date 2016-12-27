package com.example.wangfei.compositeproject.model.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.model.utils.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wangfei on 16/10/26.
 */

public class UpdateApkService extends IntentService {

    private URL url;
    private HttpURLConnection httpURLConnection;
    private NotificationManager mManager;
    private NotificationCompat.Builder mBuilder;
    private File apk_file;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public UpdateApkService() {
        super("apk update");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String apk_url = intent.getStringExtra("apk_url");

        mManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(this);
        int icon = getApplicationInfo().icon;
        String apkname = getString(getApplicationInfo().labelRes);
        mBuilder.setSmallIcon(icon)
                .setContentTitle(apkname);

        try {
            url = new URL(apk_url);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setConnectTimeout(10 * 1000);
            httpURLConnection.setReadTimeout(10 * 1000);
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            httpURLConnection.connect();

            String rootPath = FileUtils.getRootPath();

            InputStream in = httpURLConnection.getInputStream();
            String apkName = apk_url.substring(apk_url.lastIndexOf("/") + 1, apk_url.length());
            apk_file = new File(rootPath, apkName);
            FileOutputStream out = new FileOutputStream(apk_file);
            byte[] buffer = new byte[10 * 1000];
            int byteRead = 0;
            int byteSum = 0;
            int byteTotal = httpURLConnection.getContentLength();
            int byteSumold = 0;
            while ((byteRead = in.read(buffer)) != -1) {
                byteSum += byteRead;
                out.write(buffer, 0, byteRead);
                if (byteSum != byteSumold) {
                    int percent = (int) (byteSum * 100L / byteTotal);
                    notifi(percent);
                    byteSumold = byteSum;
                }
            }

            //下载完成 安装apk
            installApk(apk_file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void installApk(File apk_file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(apk_file),"application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    private void notifi(int percent) {
        mBuilder.setContentText(getString(R.string.APK_DOWNLOAD_PERCENT, percent))
                .setProgress(100, percent, false);

        PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(), PendingIntent.FLAG_CANCEL_CURRENT);
        mBuilder.setContentIntent(pendingintent);

        mManager.notify(0,mBuilder.build());
    }
}
