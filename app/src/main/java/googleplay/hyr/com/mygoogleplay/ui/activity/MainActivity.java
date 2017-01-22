package googleplay.hyr.com.mygoogleplay.ui.activity;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import googleplay.hyr.com.mygoogleplay.R;
import googleplay.hyr.com.mygoogleplay.ui.fragment.BaseFragment;
import googleplay.hyr.com.mygoogleplay.ui.fragment.FragmentFactory;
import googleplay.hyr.com.mygoogleplay.ui.view.PagerTab;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

public class MainActivity extends BaseActivity {

    private PagerTab mPagerTab;

    private ViewPager mViewPager;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            List<String> permissions = new ArrayList<String>();

            permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (!permissions.isEmpty()) {
                requestPermissions(permissions.toArray(new String[permissions.size()]), 1);
            }
        }

        mPagerTab = (PagerTab) findViewById(R.id.pager_tab);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        MyPagerAdapter myAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myAdapter);

        // 将指针和viewpager绑定
        mPagerTab.setViewPager(mViewPager);

        // 绑定页面切换事件监听
        mPagerTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                BaseFragment fragment = FragmentFactory.createFragment(position);
                // 开始加载数据
                fragment.loadData();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        initActionBar();
    }

    /**
     * 初始化actionBar
     */
    private void initActionBar() {
        ActionBar actionbar = getSupportActionBar();

        actionbar.setHomeButtonEnabled(true);// home处可以点击
        actionbar.setDisplayHomeAsUpEnabled(true);// 显示左上角返回键,当和侧边栏结合时展示三个杠图片

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);

        // 初始化抽屉开关
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open, R.string.drawer_close);
        toggle.syncState();// 同步状态, 将DrawerLayout和开关关联在一起
    }

    /**
     * 拦截返回键点击事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // 切换抽屉
                toggle.onOptionsItemSelected(item);
                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        private String[] mTabNames; //标题名称的数组

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            mTabNames = UIUtils.getStringArray(R.array.tab_names);
        }

        /**
         * 返回页签标题
         *
         * @param position
         * @return
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return mTabNames[position];
        }

        /**
         * 返回当前位置的Fragment对象
         *
         * @param position
         * @return
         */
        @Override
        public Fragment getItem(int position) {
            BaseFragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }


        /**
         * 返回Fragment个数
         *
         * @return
         */
        @Override
        public int getCount() {
            return mTabNames.length;
        }
    }
}
