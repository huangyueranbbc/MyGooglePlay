package googleplay.hyr.com.mygoogleplay.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

import googleplay.hyr.com.mygoogleplay.R;
import googleplay.hyr.com.mygoogleplay.ui.fragment.BaseFragment;
import googleplay.hyr.com.mygoogleplay.ui.fragment.FragmentFactory;
import googleplay.hyr.com.mygoogleplay.ui.view.PagerTab;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

public class MainActivity extends BaseActivity {

    private PagerTab mPagerTab;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    private void initActionBar() {
        // 获取actionbar对象
        ActionBar actionBar = getSupportActionBar();
        // 左上角显示logo
        actionBar.setHomeButtonEnabled(true);
        // 左上角显示返回图标, 和侧边栏绑定后显示侧边栏图标
        actionBar.setDisplayHomeAsUpEnabled(true);
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
