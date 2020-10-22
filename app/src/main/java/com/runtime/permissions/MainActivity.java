package com.runtime.permissions;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.runtime.permission.annotation.NeedsPermission;
import com.runtime.permission.annotation.OnPermissionDenied;
import com.example.android.system.runtimepermissions.R;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA = 0;
    private static final int REQUEST_CONTACTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @NeedsPermission(value = Manifest.permission.CAMERA, requestCode = REQUEST_CAMERA)
    public void openCamera(View view) {
        Log.e("test", "我调用了摄像头");
    }

    @NeedsPermission(value = {Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS}, requestCode = REQUEST_CONTACTS)
    public void openContacts(View view) {
        Log.e("test", "我调用了通讯录");
    }

    /**
     * 权限被拒绝的时候调用
     *
     * @param requestCode 权限回调码
     */
    @OnPermissionDenied
    private void permissionDenied(int requestCode) {
        if (requestCode == REQUEST_CONTACTS) {
            Log.e("test", "通讯录，权限被拒绝");
        } else if (requestCode == REQUEST_CAMERA) {
            Log.e("test", "摄像头，权限被拒绝");
        }
    }

}
