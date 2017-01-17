package googleplay.hyr.com.mygoogleplay.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import googleplay.hyr.com.mygoogleplay.R;
import googleplay.hyr.com.mygoogleplay.http.HttpHelper;
import googleplay.hyr.com.mygoogleplay.pojo.SubjectInfo;
import googleplay.hyr.com.mygoogleplay.utils.BitmapHelper;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * 专题holder
 * Created by huangyueran on 2017/1/17.
 */
public class SubjectHolder extends BaseHolder<SubjectInfo> {

    private ImageView ivPic;
    private TextView tvTitle;

    private BitmapUtils mBitmapUtils;

    @Override
    public View initView() {
        View view = UIUtils.inflate(R.layout.list_item_subject);
        ivPic = (ImageView) view.findViewById(R.id.iv_pic);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);

        mBitmapUtils = BitmapHelper.getBitmapUtils();

        return view;
    }

    @Override
    public void refreshView(SubjectInfo data) {
        tvTitle.setText(data.des);
        mBitmapUtils.display(ivPic, HttpHelper.URL + "image?name=" + data.url);
    }
}
