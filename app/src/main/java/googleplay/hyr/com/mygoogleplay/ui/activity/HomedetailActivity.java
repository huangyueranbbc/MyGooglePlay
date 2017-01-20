package googleplay.hyr.com.mygoogleplay.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;

import googleplay.hyr.com.mygoogleplay.R;
import googleplay.hyr.com.mygoogleplay.http.protocol.HomeDetailProtocol;
import googleplay.hyr.com.mygoogleplay.pojo.AppInfo;
import googleplay.hyr.com.mygoogleplay.ui.holder.DetailAppInfoHolder;
import googleplay.hyr.com.mygoogleplay.ui.holder.DetailDesHolder;
import googleplay.hyr.com.mygoogleplay.ui.holder.DetailPicsHolder;
import googleplay.hyr.com.mygoogleplay.ui.holder.DetailSafeHolder;
import googleplay.hyr.com.mygoogleplay.ui.view.LoadingPage;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * 首页详情页面Activity
 */
public class HomedetailActivity extends BaseActivity {

    private LoadingPage mLoadingPage;
    private String packageName;
    private AppInfo data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLoadingPage = new LoadingPage(this) {
            @Override
            public View onCreateSuccessView() {
                return HomedetailActivity.this.onCreateSuccessView();
            }

            @Override
            public ResultState onLoad() {
                return HomedetailActivity.this.onLoad();
            }
        };

        setContentView(mLoadingPage);// 直接将一个view对象设置给Activity

        // 获取从HomeFragment传递过来的包名参数
        packageName = getIntent().getStringExtra("packageName");

        // 开始加载网络数据
        mLoadingPage.loadData();

        initActionBar();
    }

    /**
     * 初始化actionBar
     */
    private void initActionBar() {
        ActionBar actionbar = getSupportActionBar();
        actionbar.setHomeButtonEnabled(true);// home处可以点击
        actionbar.setDisplayHomeAsUpEnabled(true);// 显示左上角返回键,当和侧边栏结合时展示三个杠图片
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public View onCreateSuccessView() {
        // 初始化成功布局文件
        View view = UIUtils.inflate(R.layout.page_home_detail);

        // 初始化应用信息模块
        FrameLayout flDetailAppInfo = (FrameLayout) view.findViewById(R.id.fl_detail_appinfo);

        // 动态给帧布局填充页面
        DetailAppInfoHolder appInfoHolder = new DetailAppInfoHolder();
        flDetailAppInfo.addView(appInfoHolder.getRootView());
        appInfoHolder.setData(data);

        // 初始化安全描述模块
        FrameLayout flDetailSafe = (FrameLayout) view.findViewById(R.id.fl_detail_safe);
        DetailSafeHolder safeHolder = new DetailSafeHolder();
        flDetailSafe.addView(safeHolder.getRootView());
        safeHolder.setData(data);

        // 初始化截图模块
        HorizontalScrollView hsvPic = (HorizontalScrollView) view.findViewById(R.id.hsv_detail_pics);
        DetailPicsHolder detailPicsHolder = new DetailPicsHolder();
        hsvPic.addView(detailPicsHolder.getRootView());
        detailPicsHolder.setData(data);

        // 初始化描述
        FrameLayout flDeatilDes = (FrameLayout) view.findViewById(R.id.fl_detail_des);
        DetailDesHolder detailDesHolder = new DetailDesHolder();
        flDeatilDes.addView(detailDesHolder.getRootView());
        detailDesHolder.setData(data);

        return view;
    }

    public LoadingPage.ResultState onLoad() {
        // 请求网络,加载数据
        HomeDetailProtocol protocol = new HomeDetailProtocol(packageName);
        data = protocol.getData(0);

        if (data != null) {
            return LoadingPage.ResultState.STATE_SUCCESS;
        } else {
            return LoadingPage.ResultState.STATE_ERROR;
        }
    }

}
