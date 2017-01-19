package googleplay.hyr.com.mygoogleplay.ui.holder;

import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import googleplay.hyr.com.mygoogleplay.R;
import googleplay.hyr.com.mygoogleplay.http.HttpHelper;
import googleplay.hyr.com.mygoogleplay.pojo.AppInfo;
import googleplay.hyr.com.mygoogleplay.utils.BitmapHelper;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * 游戏Holder
 * Created by huangyueran on 2017/1/17.
 */
public class GameHolder extends BaseHolder<AppInfo> {

    private TextView tvName, tvSize, tvDesc;
    private ImageView ivIcon;
    private RatingBar rbStar;
    private BitmapUtils mBitmapUtils;

    /**
     * 初始化布局
     *
     * @return
     */
    @Override
    public View initView() {
        // 1.加载布局
        View view = UIUtils.inflate(R.layout.list_item_home);
        // 2.初始化控件
        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvSize = (TextView) view.findViewById(R.id.tv_size);
        tvDesc = (TextView) view.findViewById(R.id.tv_desc);
        ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
        rbStar = (RatingBar) view.findViewById(R.id.rb_star);

        // mBitmapUtils = new BitmapUtils(UIUtils.getContext());
        mBitmapUtils = BitmapHelper.getBitmapUtils();

        return view;
    }


    /**
     * 刷新数据
     *
     * @param data
     */
    @Override
    public void refreshView(AppInfo data) {
        tvName.setText(data.name);
        tvSize.setText(Formatter.formatFileSize(UIUtils.getContext(), data.size));
        tvDesc.setText(data.des);
        rbStar.setRating(data.stars);

        mBitmapUtils.display(ivIcon, HttpHelper.URL + "image?name=" + data.getIconUrl());
    }
}
