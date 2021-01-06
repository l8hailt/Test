package com.example.test;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment;

public class TestFragment extends Fragment {

    public static TestFragment getInstance() {
        TestFragment fragment = new TestFragment();
        return fragment;
    }

    public TestFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

//    private TestDialog testDialog;
//    private List<TestModel> data;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (!checkPermission())
            requestPermission();

//        final TextView tvValue = view.findViewById(R.id.tvValue);
//
//        data = new ArrayList<>();
//        data.add(new TestModel(0));
//        data.add(new TestModel(0));
//        data.add(new TestModel(0));
//
//        view.findViewById(R.id.btnTest).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (testDialog == null) {
//                    testDialog = TestDialog.getInstance(getContext(), data);
//                    testDialog.setCancelable(false);
//                }
//
//                testDialog.setCallback(new TestCallback() {
//                    @Override
//                    public void onOkDialog() {
//                        StringBuilder text = new StringBuilder();
//                        for (TestModel model : data) {
//                            text.append(model.getTestField()).append("\n");
//                        }
//                        tvValue.setText(text);
//                    }
//
//                    @Override
//                    public void onCancelDialog() {
//                        StringBuilder text = new StringBuilder();
//                        for (TestModel model : data) {
//                            text.append(model.getTestField()).append("\n");
//                        }
//                        tvValue.setText(text);
//                    }
//                });
//                testDialog.show();
//
//            }
//        });

        showDialogChooseFolder();
    }

    private void showDialogChooseFolder() {
        new AlertDialog.Builder(getContext())
            .setMessage("Choose folder")
            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
                    startActivityForResult(intent, 333);
                }
            }).show();
    }

    private boolean checkPermission() {
        return ActivityCompat.checkSelfPermission(getActivity(),
            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(getActivity(),
            Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        requestPermissions(
            new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
            333);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 333) {
            if (permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.e("TAG", "onRequestPermissionsResult: permission granted");
            } else {
                boolean shouldShowRationale = shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)
                    && shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION);
                Log.e("TAG", "onRequestPermissionsResult: " + shouldShowRationale);
                if (shouldShowRationale) {
                    requestPermission();
                } else {
                    Log.e("TAG", "onRequestPermissionsResult: do nothing");
                }
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 333) {
                Log.e("TAG", "onActivityResult: " + data);
                if (data == null) return;
                Uri treeUri = data.getData();
                Log.e("TAG", "onActivityResult: " + treeUri);
                if (DocumentFile.fromTreeUri(getContext(), treeUri).canWrite()) {
                    Log.e("TAG", "onActivityResult: canWrite");
                    int takeFlags = data.getFlags();
                    takeFlags =
                        takeFlags & (Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    // Check for the freshest data.
                    getActivity().getContentResolver().takePersistableUriPermission(treeUri, takeFlags);
//                    AppSettings.treeUri = treeUri.toString()

//                    Log.d(MainActivity:: class.java.simpleName, "Tree Uri -> $treeUri")
//
//                    btnSAve.callOnClick()
                }
            }
        }
    }
}
