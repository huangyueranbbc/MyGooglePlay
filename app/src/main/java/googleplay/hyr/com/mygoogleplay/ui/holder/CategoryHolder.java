package googleplay.hyr.com.mygoogleplay.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.BitmapUtils;

import googleplay.hyr.com.mygoogleplay.R;
import googleplay.hyr.com.mygoogleplay.http.HttpHelper;
import googleplay.hyr.com.mygoogleplay.pojo.CategoryInfo;
import googleplay.hyr.com.mygoogleplay.utils.BitmapHelper;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * Created by huangyueran on 2017/1/19.
 * 分类模块普通holder
 */
public class CategoryHolder extends BaseHolder<CategoryInfo> implements View.OnClickListener {

    private TextView tvName1, tvName2, tvName3;
    private ImageView ivIcon1, ivIcon2, ivIcon3;
    private LinearLayout llGrid1, llGrid2, llGrid3;

    private BitmapUtils mBitmapUtils;

    @Override
    public View initView() {
        View view = UIUtils.inflate(R.layout.list_item_category);

        tvName1 = (TextView) view.findViewById(R.id.tv_name1);
        tvName2 = (TextView) view.findViewById(R.id.tv_name2);
        tvName3 = (TextView) view.findViewById(R.id.tv_name3);

        ivIcon1 = (ImageView) view.findViewById(R.id.iv_icon1);
        ivIcon2 = (ImageView) view.findViewById(R.id.iv_icon2);
        ivIcon3 = (ImageView) view.findViewById(R.id.iv_icon3);

        llGrid1 = (LinearLayout) view.findViewById(R.id.ll_grid1);
        llGrid2 = (LinearLayout) view.findViewById(R.id.ll_grid2);
        llGrid3 = (LinearLayout) view.findViewById(R.id.ll_grid3);

        llGrid1.setOnClickListener(this);
        llGrid2.setOnClickListener(this);
        llGrid3.setOnClickListener(this);

        mBitmapUtils = BitmapHelper.getBitmapUtils();

        return view;
    }

    @Override
    public void refreshView(CategoryInfo data) {
        tvName1.setText(data.getName1());
        tvName2.setText(data.getName2());
        tvName3.setText(data.getName3());

        mBitmapUtils.display(ivIcon1, HttpHelper.URL + "image?name=" + data.getUrl1());
        mBitmapUtils.display(ivIcon2, HttpHelper.URL + "image?name=" + data.getUrl2());
        mBitmapUtils.display(ivIcon3, HttpHelper.URL + "image?name=" + data.getUrl3());
    }

    @Override
    public void onClick(View v) {
        CategoryInfo info = getData();

        switch (v.getId()) {
            case R.id.ll_grid1:
                Toast.makeText(UIUtils.getContext(), info.getName1(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_grid2:
                Toast.makeText(UIUtils.getContext(), info.getName2(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_grid3:
                Toast.makeText(UIUtils.getContext(), info.getName3(), Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }
}
