package com.example.test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.test.upload_file_android_q.ContentUriUtils;
import com.example.test.upload_file_android_q.FileUtils;
import com.example.test.upload_file_android_q.RetroClient;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //    private ConstraintLayout constraintLayout;
    private ImageView imgTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        constraintLayout = findViewById(R.id.mainLayout);
        imgTest = findViewById(R.id.imgTest);

//        ObjectAnimator anim = ObjectAnimator.ofInt(constraintLayout, "backgroundColor", Color.WHITE, Color.RED,
//            Color.WHITE);
//        anim.setDuration(1500);
//        anim.setEvaluator(new ArgbEvaluator());
//        anim.setRepeatMode(ValueAnimator.REVERSE);
//        anim.setRepeatCount(ValueAnimator.INFINITE);
//        anim.setInterpolator(new LinearInterpolator());
//        anim.start();

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                .setReorderingAllowed(true)
//                .add(R.id.mainLayout, NewStyleFragment.class, null)
//                .commit();
//        }

//        TestFragment fragment = TestFragment.getInstance();
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.mainLayout, fragment, "TestFragment")
//                .commitAllowingStateLoss();

//        WebView webView = new WebView(this);
//        setContentView(webView);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setDomStorageEnabled(true);
//        webView.getSettings().setUserAgentString("Mozilla/5.0 (iPhone; CPU iPhone OS 11_2_2 like Mac OS X) AppleWebKit/604.1.34 (KHTML, like Gecko) CriOS/64.0.3282.112 Mobile/15C202 Safari/604.1");
//        webView.setWebViewClient(new WebViewClient());
//        webView.setWebChromeClient(new WebChromeClient());
//        webView.addJavascriptInterface(this, "JSAction");

//        webView.loadUrl("file:///android_asset/fpt-ai-livechat.html");
//        webView.loadUrl("https://livechat.fpt.ai/v35/src/index.html");


    }

//    @JavascriptInterface
//    public void action(int number) {
//        Log.e("TAG", "action: " + number);
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 333) {
                Log.e("TAG", "onActivityResult: " + data.getData());
//                String path = getRealPathFromURI(this, data.getData());
//                Log.e("TAG", "onActivityResult: " + path);
                Glide.with(this).load(data.getData()).into(imgTest);

                try {
                    ExifInterface exifInterface = new ExifInterface(getContentResolver().openInputStream(data.getData()));
                    Log.e("TAG", "onActivityResult: " + exifInterface.getDateTime());
                    Log.e("TAG", "onActivityResult: " + exifInterface.getRotationDegrees());
                    if (exifInterface.getLatLong() != null) {
                        double lat = exifInterface.getLatLong()[0];
                        double lng = exifInterface.getLatLong()[1];
                        Log.e("TAG", "onActivityResult: " + lat + " | " + lng);
                        Geocoder geocoder = new Geocoder(this);
                        List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
                        if (addresses != null && !addresses.isEmpty()) {
                            Address address = addresses.get(0);
                            Log.e("TAG", "onActivityResult: " + address.getAddressLine(0));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //                    String otherPath = ContentUriUtils.INSTANCE.getFilePath(this, data.getData());
//                String otherPath = FileUtils.getPath(this, data.getData());
//                Log.e("TAG", "onActivityResult: otherPath " + otherPath);
//                uploadImage(otherPath, null);

//                try {
//                    InputStream iStream = getContentResolver().openInputStream(data.getData());
//                    MimeTypeMap mime = MimeTypeMap.getSingleton();
//                    String type = mime.getExtensionFromMimeType(getContentResolver().getType(data.getData()));
////                    byte[] inputData = getBytes(iStream);
////                    Log.e("TAG", "onActivityResult: " + inputData.length);
//                    String cacheFilePath = saveFile(iStream, type);
//                    uploadImage(cacheFilePath, null);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            } else if (requestCode == 123) {
                Log.e("TAG", "onActivityResult: " + data.getData());

//                try {
//                    InputStream iStream = getContentResolver().openInputStream(data.getData());
//                    MimeTypeMap mime = MimeTypeMap.getSingleton();
//                    String type = mime.getExtensionFromMimeType(getContentResolver().getType(data.getData()));
////                    byte[] inputData = getBytes(iStream);
////                    Log.e("TAG", "onActivityResult: " + inputData.length);
//                    String cacheFilePath = saveFile(iStream, type);
//                    uploadImage(cacheFilePath, null);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                //                    String otherPath = ContentUriUtils.INSTANCE.getFilePath(this, data.getData());
                String otherPath = FileUtils.getPath(this, data.getData());
                Log.e("TAG", "onActivityResult: otherPath " + otherPath);
                uploadImage(otherPath, null);
            }
        }
    }

    private void uploadImage(String path, byte[] data) {
        //pass it like this

        File file = new File(path);
        RequestBody requestFile;
        if (!path.isEmpty()) {
            requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        } else {
            requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), data);
        }

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
            MultipartBody.Part.createFormData("image", file.getName(), requestFile);

        RetroClient.getInstance().uploadImage(body).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e("TAG", "onResponse: ");
                if (response.isSuccessful()) {
                    Log.e("TAG", "onResponse: isSuccessful");
                    if (response.body() != null) {
                        Log.e("TAG", "onResponse: " + response.body());
                        if (file.exists()) {
                            if (file.delete()) {
                                Log.e("TAG", "onResponse: OK");
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
    }

    private String saveFile(InputStream is, String extension) throws IOException {
        byte[] buffer = new byte[is.available()];
        is.read(buffer);

        File targetFile = new File(getCacheDir(), System.currentTimeMillis() + "." + extension);
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);

        return targetFile.getAbsolutePath();
    }

    public byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }

    public String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void pickFile(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 333);
    }

    public void pickPDF(View view) {
        Intent intentPDF = new Intent(Intent.ACTION_GET_CONTENT);
        intentPDF.setType("application/pdf");
        intentPDF.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intentPDF, "Select Picture"), 123);
    }
}