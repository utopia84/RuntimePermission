package com.runtime.permissions;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.runtime.permission.annotation.NeedsPermission;
import com.runtime.permission.annotation.OnPermissionDenied;
import com.example.android.system.runtimepermissions.R;

public class NeedPermissionFragment extends androidx.fragment.app.Fragment implements View.OnClickListener {

    private final int REQUEST_CODE = 3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_need_permission, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnPhoneState = view.findViewById(R.id.btn_read_phone_state);
        btnPhoneState.setOnClickListener(this);
    }


    @NeedsPermission(value = Manifest.permission.RECORD_AUDIO, requestCode = REQUEST_CODE)
    public void readPhoneState(View view) {
        Log.e("test", "获取麦克风权限");
    }


    /**
     * 权限被拒绝的时候调用
     *
     * @param requestCode 权限回调码
     */
    @OnPermissionDenied
    private void permissionDenied(int requestCode) {
        if (requestCode == REQUEST_CODE) {
            Log.e("test", "麦克风，权限被拒绝");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_read_phone_state:
                readPhoneState(v);
                break;
        }
    }


}
