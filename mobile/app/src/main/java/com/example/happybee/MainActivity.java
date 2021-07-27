package com.example.happybee;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public TextView tvServerResponse;
    private String requestMetod;
    private Object lock = new Object();

    Bitmap bitmap;

    private String URLPlus = Connection.SERVER;

    private ImageView imageFromGallery;
    private Button btnAddImage;
    private static final int SELECT_IMAGE = 1;
    Uri imageUri;

    public class HttpGetRequest extends AsyncTask<Void, Void, String> {
        static final int READ_TIMEOUT = 15000;
        static final int CONNECTION_TIMEOUT = 15000;

        @Override
        protected String doInBackground(Void... params) {
            String result;
            String inputLine;


            try {
                // connect to the server
                URL myUrl = new URL(URLPlus);
                HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
                connection.setRequestMethod(requestMetod);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                connection.connect();

                // get the string from the input stream
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                while ((inputLine = reader.readLine()) != null) {
                    stringBuilder.append(inputLine);
                }
                reader.close();
                streamReader.close();
                result = stringBuilder.toString();

            } catch (IOException e) {
                e.printStackTrace();
                result = "error";
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            tvServerResponse.setText(result);
        }
    }

    public String switchRequest(String b) {
        if (b.equals("GET")) {
            requestMetod = "GET";
            URLPlus += "?table=info&id=7";
        } else if (b.equals("PUT")) {
            requestMetod = "PUT";
            URLPlus += "?table=info&titlu=AlbinaMea&descriere='Albina cu viata 10'&id_parinte=2&id=3";
        } else if (b.equals("POST")) {
            requestMetod = "POST";
            URLPlus += "?table=info&titlu=Albina&descriere=short_descript&id_parinte=0";
        } else if (b.equals("DELETE")) {
            requestMetod = "DELETE";
            URLPlus += "?table=info&id=4";
        } else if (b.equals("IMAGE")) {
            requestMetod = "POST";
            URLPlus += "uploadImg";
        }
        return requestMetod;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageFromGallery = findViewById(R.id.imageDB);
        Button imagebtn = findViewById(R.id.buttonOpenGallery);
        imagebtn.setOnClickListener(onButtonClickListener);

        Button postImage = findViewById(R.id.buttonPostImage);
        postImage.setOnClickListener(onButtonClickListenerPostImage);

        tvServerResponse = findViewById(R.id.txt1);
        Button contactServerButton = findViewById(R.id.buttonADD);
        contactServerButton.setOnClickListener(onButtonClickListenerGET);

        tvServerResponse = findViewById(R.id.txt1);
        Button contactServerButtonPut = findViewById(R.id.buttonPUT);
        contactServerButtonPut.setOnClickListener(onButtonClickListenerPUT);

        tvServerResponse = findViewById(R.id.txt1);
        Button contactServerButtonPost = findViewById(R.id.buttonPOST);
        contactServerButtonPost.setOnClickListener(onButtonClickListenerPOST);

        tvServerResponse = findViewById(R.id.txt1);
        Button contactServerButtonDelete = findViewById(R.id.buttonDelete);
        contactServerButtonDelete.setOnClickListener(onButtonClickListenerDELETE);

    }

    View.OnClickListener onButtonClickListenerGET = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HttpGetRequest request = new HttpGetRequest();
            switchRequest("GET");
            request.execute();
        }
    };
    View.OnClickListener onButtonClickListenerPOST = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HttpGetRequest request = new HttpGetRequest();
            switchRequest("POST");
            request.execute();
        }
    };
    View.OnClickListener onButtonClickListenerPUT = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            PUT put = new PUT(lock, URLPlus, "GET");
            tvServerResponse.setText(put.responsePut);

//            synchronized (lock) {
//                try {
//                    lock.wait();
//                    Log.i("Rezultat",put.responsePut);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//                HttpGetRequest request = new HttpGetRequest();
//                switchRequest("PUT");
//                request.execute();

//            POST.URLPost=URLPost1;
//            POST.HttpPOSTRequest request2 = new POST.HttpPOSTRequest();
//            request2.execute(URLPlus);
//            tvServerResponse.setText(request2.responsePost);
//        }
        }

    };
    View.OnClickListener onButtonClickListenerDELETE = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HttpGetRequest request = new HttpGetRequest();
            switchRequest("DELETE");
            request.execute();
        }
    };

    View.OnClickListener onButtonClickListenerPostImage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //uploadImage();
            //uploaduserimage();
        }
    };

    View.OnClickListener onButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent gallery = new Intent();
            gallery.setType("image/*");
            gallery.setAction(Intent.ACTION_GET_CONTENT);

            startActivityForResult(Intent.createChooser(gallery, "Selecteaza imaginea"), SELECT_IMAGE);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                imageFromGallery.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


//    public String getPath(Uri uri) {
//        String[] projection = {MediaStore.MediaColumns.DATA};
//        Cursor cursor = managedQuery(uri, projection, null, null, null);
//        column_index = cursor
//                .getColumnIndexOrThrow(MediaColumns.DATA);
//        cursor.moveToFirst();
//        imagePath = cursor.getString(column_index);
//
//        return cursor.getString(column_index);
//    }

    private String getPath(Uri uri) {
        String path = "";
        // Log.d("Uri", String.valueOf(imageUri));
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);

        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null
        );
        cursor.moveToFirst();
        Log.d("Count", String.valueOf(cursor.getCount()));
        if (cursor.moveToFirst() && cursor.getCount() >= 1) {
// get values from cursor here
            path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        }
        cursor.close();
        return path;
    }
//    private void uploadImage() {
//        File file = new File(imageUri);
//
//        Retrofit retrofit = NetworkClient.getRetrofit();
//
//        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
//        MultipartBody.Part parts = MultipartBody.Part.createFormData("newimage", file.getName(), requestBody);
//
//        RequestBody someData = RequestBody.create(MediaType.parse("text/plain"), "This is a new Image");
//
//        UploadApis uploadApis = retrofit.create(UploadApis.class);
//        Call call = uploadApis.uploadImage(parts, someData);
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//
//            }
//        });
//    }
    private void uploaduserimage() {

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        switchRequest("IMAGE");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLPlus, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("Myresponse", "" + response);
                Toast.makeText(MainActivity.this, "" + response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Mysmart", "" + error);
                Toast.makeText(MainActivity.this, "" + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();

                String images = getStringImage(bitmap);
                Log.i("Mynewsam", "" + images);

                // Remember key value must be same as the get bitmapdeceded parameter value
                param.put("img_front", images);
                return param;
                }
            };
        requestQueue.add(stringRequest);
    }

    private String getStringImage(Bitmap bitmap) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        final String temp = Base64.encodeToString(b, Base64.DEFAULT);
        Log.i("My_data_image", "" + temp);
        return temp;
    }
}
//    private void uploadImage(){
//        String path = getPath(imageUri);
//        String ImageName = String.valueOf(imageFromGallery.getTag());
//
//        switchRequest("IMAGE");
//            try {
//                String uploadid = UUID.randomUUID().toString();
//                try {
//                    new MultipartUploadRequest(this, uploadid, URLPlus)
//                            .addFileToUpload(path, "image")
//                            .addParameter("name", ImageName)
//                            .setNotificationConfig(new UploadNotificationConfig())
//                            .setMaxRetries(2)
//                            .startUpload();
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }



