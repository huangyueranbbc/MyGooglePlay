package googleplay.hyr.com.mygoogleplay.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import googleplay.hyr.com.mygoogleplay.http.protocol.HotProtocol;
import googleplay.hyr.com.mygoogleplay.ui.view.FlowLayout;
import googleplay.hyr.com.mygoogleplay.ui.view.LoadingPage;
import googleplay.hyr.com.mygoogleplay.utils.DrawableUtils;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * Created by huangyueran on 2017/1/13.
 * 排行Fragment
 */
public class HotFragment extends BaseFragment {

    private ArrayList<String> data;

    @Override
    public View onCreateSuccessView() {
        // 支持上下滑动
        ScrollView scrollView = new ScrollView(UIUtils.getContext());
        FlowLayout flowLayout = new FlowLayout(UIUtils.getContext());

        int padding = UIUtils.dip2px(10);
        flowLayout.setPadding(padding, padding, padding, padding); // 设置内边距
        flowLayout.setHorizontalSpacing(UIUtils.dip2px(6)); // 水平间距
        flowLayout.setVerticalSpacing(UIUtils.dip2px(8)); // 垂直间距

        for (int i = 0; i < data.size(); i++) {
            final String keyword = data.get(i);
            TextView textView = new TextView(UIUtils.getContext());
            textView.setText(keyword);

            textView.setTextColor(Color.WHITE); //文字颜色 白色
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);// 18sp
            textView.setPadding(padding, padding, padding, padding);
            textView.setGravity(Gravity.CENTER);

            // 生成随机颜色
            Random random = new Random();
            int r = 30 + random.nextInt(200);
            int g = 30 + random.nextInt(200);
            int b = 30 + random.nextInt(200);

            int color = 0xffcecece;// 按下后偏白的背景色

            // GradientDrawable bgNormal = DrawableUtils.getGradientDrawable(Color.rgb(r, g, b), UIUtils.dip2px(6));
            // GradientDrawable bgPress = DrawableUtils.getGradientDrawable(color, UIUtils.dip2px(6));
            // StateListDrawable selector = DrawableUtils.getSelector(bgNormal, bgPress);

            StateListDrawable selector = DrawableUtils.getSelector(Color.rgb(r, g, b), color, UIUtils.dip2px(6));
            textView.setBackgroundDrawable(selector);

            flowLayout.addView(textView);

            // 只有设置点击事件, 状态选择器才起作用
            textView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(UIUtils.getContext(), keyword, Toast.LENGTH_SHORT).show();
                }
            });
        }

        scrollView.addView(flowLayout);
        return scrollView;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        HotProtocol protocol = new HotProtocol();
        data = protocol.getData(0);
        return check(data);
    }
}
