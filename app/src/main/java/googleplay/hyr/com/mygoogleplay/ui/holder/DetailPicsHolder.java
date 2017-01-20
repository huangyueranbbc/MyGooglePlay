package googleplay.hyr.com.mygoogleplay.ui.holder;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

import googleplay.hyr.com.mygoogleplay.R;
import googleplay.hyr.com.mygoogleplay.http.HttpHelper;
import googleplay.hyr.com.mygoogleplay.pojo.AppInfo;
import googleplay.hyr.com.mygoogleplay.utils.BitmapHelper;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * Created by huangyueran on 2017/1/20.
 * 应用详情页--截图展示Holder
 */
public class DetailPicsHolder extends BaseHolder<AppInfo> {

    private ImageView[] ivPics;

    private BitmapUtils mBitmapUtils;

    @Override
    public View initView() {
        View view = UIUtils.inflate(R.layout.layout_detail_picinfo);

        ivPics = new ImageView[5];
        ivPics[0] = (ImageView) view.findViewById(R.id.iv_pic1);
        ivPics[1] = (ImageView) view.findViewById(R.id.iv_pic2);
        ivPics[2] = (ImageView) view.findViewById(R.id.iv_pic3);
        ivPics[3] = (ImageView) view.findViewById(R.id.iv_pic4);
        ivPics[4] = (ImageView) view.findViewById(R.id.iv_pic5);

        mBitmapUtils = BitmapHelper.getBitmapUtils();

        return view;
    }

    @Override
    public void refreshView(AppInfo data) {
        final ArrayList<String> screen = data.screen;

        for (int i = 0; i < 5; i++) {
            if (i < screen.size()) {
                mBitmapUtils.display(ivPics[i], HttpHelper.URL + "image?name=" + screen.get(i));

                ivPics[i].setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //跳转activity, activity展示viewpager
                        //将集合通过intent传递过去, 当前点击的位置i也可以传过去
                        Intent intent = new Intent();
                        intent.putExtra("list", screen);
                    }
                });
            } else {
                ivPics[i].setVisibility(View.GONE);
            }
        }

    }
}
