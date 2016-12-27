package com.example.wangfei.compositeproject.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.control.LineActivity;
import com.example.wangfei.compositeproject.control.ToolbarActivity;
import com.example.wangfei.compositeproject.model.BaseFragment;
import com.example.wangfei.compositeproject.model.service.UpdateApkService;
import com.example.wangfei.compositeproject.model.utils.CircleImageview;
import com.example.wangfei.compositeproject.model.utils.FileUtils;
import com.example.wangfei.compositeproject.model.utils.ImageUtils;
import com.example.wangfei.compositeproject.model.utils.LogUtils;
import com.example.wangfei.compositeproject.model.utils.RoundImageview;
import com.example.wangfei.compositeproject.model.utils.TimeUtils;
import com.example.wangfei.compositeproject.model.utils.ToastUtils;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.app.Activity.RESULT_OK;

/**
 * Created by wangfei on 16/9/14.
 */

public class WinterFragment extends BaseFragment {

    private static final int OPEN_CAMERA = 100;
    private static final int OPEN_GALLERY = 101;
    private static final int CROP_PHOTO_CODE = 102;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.circle_icon)
    CircleImageview circleIcon;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_icon)
    LinearLayout llIcon;
    @BindView(R.id.bt_video)
    Button btVideo;
    @BindView(R.id.bt_toactivity)
    Button btToactivity;
    @BindView(R.id.bt_line)
    Button btLine;
    @BindView(R.id.bt_scroll)
    Button btScroll;
    @BindView(R.id.bt_grid)
    Button btGrid;
    @BindView(R.id.bt_mixgrid)
    Button btMixgrid;
    @BindView(R.id.iv_https)
    ImageView ivHttps;
    //    @BindView(R.id.tv_camera)
//    TextView tvCamera;
//    @BindView(R.id.tv_pics)
//    TextView tvPics;
//    @BindView(R.id.tv_cancel)
//    TextView tvCancel;
    private View view;
    private PopupWindow popupWindow;
    private int crop = 300;
    private Uri mInputUri;
    private CircleImageview iconView;
    private ImageView mIvicon;
    private Response response;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtils.d("Winter -----", "onCreateView");

        view = inflater.inflate(R.layout.fragment_winter, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LogUtils.d("Winter -----", "onActivityCreated");

        initView();
    }

    private Uri initFile() {
        return Uri.fromFile(new File(FileUtils.getRootPath(), TimeUtils.getCurMillis() + ".jpeg"));
    }

    private void initView() {
        LinearLayout mLLIcon = (LinearLayout) view.findViewById(R.id.ll_icon);
        iconView = (CircleImageview) view.findViewById(R.id.circle_icon);
        mIvicon = (ImageView) view.findViewById(R.id.iv_icon);
        LogUtils.d("-----", FileUtils.getRootPath());
        ImageUtils.loadBitmap(this, "https://img.alicdn.com/tps/TB1SAvJLXXXXXXqXFXXXXXXXXXX-1680-400.jpg", ivHttps, 0, 0);
    }

    @OnClick({R.id.ll_icon, R.id.bt_video, R.id.bt_toactivity, R.id.bt_line, R.id.bt_scroll, R.id.bt_grid, R.id.bt_mixgrid})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_icon:
                ToastUtils.show("ahahhahhdjlsdjlk");
                View popView = View.inflate(mActivity, R.layout.popup_camera, null);
                popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        View rootView = view.findViewById(android.R.id.content).getRootView();
                popView.findViewById(R.id.tv_camera).setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        mInputUri = initFile();//照片保存路径
                        LogUtils.d("-----", mInputUri.toString());
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, mInputUri);
                        startActivityForResult(intent, OPEN_CAMERA);
                        popupWindow.dismiss();
                    }
                });
                popView.findViewById(R.id.tv_pics).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(intent, OPEN_GALLERY);
                        popupWindow.dismiss();
                    }
                });
                popView.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.BLUE));
                popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
                break;
            case R.id.bt_video:
                String videoUrl = "http://7xlpgh.com2.z0.glb.qiniucdn.com/tYh9pRzLf35Wo-19_Amv1cMR10I=/Fkp9ItVY_-dbF2ewNx0wBiFfQNFj?e=1474967867&token=TKTkohoY7kTOiR_TKD39XQR7sLZ6lDrpG6rBjcwZ:GS3OE-zW2orphshdfVF5c-ySR4c=";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(videoUrl), "video/*");
                startActivity(intent);
                break;
            case R.id.bt_toactivity:
                Intent intent1 = new Intent(mActivity, ToolbarActivity.class);
                startActivity(intent1);
                break;
            case R.id.bt_line:
                Intent intent2 = new Intent(mActivity, LineActivity.class);
                startActivity(intent2);
                break;
            case R.id.bt_scroll:
//                Intent intent3 = new Intent(mActivity, LbsActivity.class);

                //打开微信
//                Intent intent3 = new Intent();
//                intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent3.addCategory(Intent.CATEGORY_LAUNCHER);
//                intent3.setAction(Intent.ACTION_MAIN);
//                ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
//                intent3.setComponent(componentName);
//                startActivity(intent3);

//                startActivity(intent3);
                    okhttpsample();

                break;
            case R.id.bt_grid:
                String url = new String("http://file.daokoudai.com/package/31/08/3108e63e022cad47706b0e4231d407c4.apk");
                Intent intent4 = new Intent(mActivity, UpdateApkService.class);
                intent4.putExtra("apk_url", url);
                mActivity.startService(intent4);
                break;
            case R.id.bt_mixgrid:

                break;
        }

    }

    private void okhttpsample() {
        String url = new String("https://www.baidu.com");
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            LogUtils.d("-----",response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Nullable
//    @OnClick({R.id.tv_camera, R.id.tv_pics, R.id.tv_cancel})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.tv_camera:
//                Intent intent = new Intent(Intent.ACTION_CAMERA_BUTTON);
//                startActivity(intent);
//                popupWindow.dismiss();
//                break;
//            case R.id.tv_pics:
//                break;
//            case R.id.tv_cancel:
//                popupWindow.dismiss();
//                break;
//        }
//    }

    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("output", uri);
        intent.putExtra("crop", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", crop);
        intent.putExtra("outputY", crop);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mInputUri);
        startActivityForResult(intent, CROP_PHOTO_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case OPEN_CAMERA:
                cropPhoto(mInputUri);
                break;
            case OPEN_GALLERY:
                if (resultCode == RESULT_OK) {
                    if (data != null && data.getData() != null) {
                        mInputUri = data.getData();
                        cropPhoto(mInputUri);
                    }
                }
                break;
            case CROP_PHOTO_CODE:

                if (mInputUri != null) {
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(mActivity.getContentResolver(), mInputUri);
                        iconView.setImageBitmap(bitmap);
                        ImageUtils.loadBitmap(this, mInputUri, iconView);
                        mIvicon.setImageBitmap(bitmap);

                        //圆形图片
                        RoundedBitmapDrawable drawable = RoundImageview.getCircle(getResources(), bitmap);
                        mIvicon.setImageDrawable(drawable);
                        //https图片
                        ImageUtils.loadBitmap(this, "https://img.alicdn.com/tps/TB1SAvJLXXXXXXqXFXXXXXXXXXX-1680-400.jpg", mIvicon, 0, 0);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        LogUtils.d("Winter -----", "onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        LogUtils.d("Winter -----", "onCreate");
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        LogUtils.d("Winter -----", "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        LogUtils.d("Winter -----", "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        LogUtils.d("Winter -----", "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        LogUtils.d("Winter -----", "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        // TODO Auto-generated method stub
        LogUtils.d("Winter -----", "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        LogUtils.d("Winter -----", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        // TODO Auto-generated method stub
        LogUtils.d("Winter -----", "onDetach");
        super.onDetach();
    }

}
