package googleplay.hyr.com.mygoogleplay.ui.holder;

import android.view.View;
import android.widget.TextView;

import googleplay.hyr.com.mygoogleplay.R;
import googleplay.hyr.com.mygoogleplay.pojo.AppInfo;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * Created by huangyueran on 2017/1/15.
 */
public class HomeHolder extends BaseHolder<AppInfo> {

    private TextView tvContent;

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
        tvContent = (TextView) view.findViewById(R.id.tv_content);

        return view;
    }

    /**
     * 刷新数据
     *
     * @param data
     */
    @Override
    public void refreshView(AppInfo data) {
        tvContent.setText(data.name);
    }
}
