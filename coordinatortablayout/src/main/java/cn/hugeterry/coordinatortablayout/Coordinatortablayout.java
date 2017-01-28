package cn.hugeterry.coordinatortablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by hugeterry(http://hugeterry.cn)
 * Date: 17/1/27 14:57
 */

public class Coordinatortablayout extends CoordinatorLayout {
    private Context mContext;
    private Toolbar mToolbar;
    private ActionBar mActionbar;
    private TabLayout mTabLayout;
    private ImageView mImageView;
    private ViewPager mViewPager;
    private int[] mImageArray;

    public Coordinatortablayout(Context context) {
        super(context);
        mContext = context;
    }

    public Coordinatortablayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView(context);
        initWidget(context, attrs);

    }

    public Coordinatortablayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView(context);
        initWidget(context, attrs);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_coordinatortablayout, this, true);
        initToolbar();
        setupTabLayout();
    }

    private void initWidget(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs
                , R.styleable.Coordinatortablayout);

    }

    private void setupTabLayout() {
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
        mImageView = (ImageView) findViewById(R.id.imageview);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mImageView.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_dismiss));
                mImageView.setImageResource(mImageArray[tab.getPosition()]);
                mImageView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_show));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        ((AppCompatActivity) mContext).setSupportActionBar(mToolbar);
        mActionbar = ((AppCompatActivity) mContext).getSupportActionBar();
    }

    /**
     * 设置Toolbar标题
     *
     * @param title 标题
     */
    public void setToolbarTitle(String title) {
        if (mActionbar != null) {
            mActionbar.setTitle(title);
        }
    }

    /**
     * 设置Toolbar显示返回按钮及标题
     *
     * @param canBack 是否返回
     */
    public void setToolbarBackEnable(Boolean canBack) {
        if (canBack && mActionbar != null) {
            mActionbar.setDisplayHomeAsUpEnabled(true);
            mActionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
        }
    }

    /**
     * 设置与该组件搭配的ViewPager
     *
     * @param vp 与TabLayout结合的ViewPager
     */
    public void setupWithViewPager(ViewPager vp) {
        mViewPager = vp;
    }

    /**
     * 设置每个tab对应的图片
     *
     * @param imageArray 图片数组
     */
    public void setupImageArray(int[] imageArray) {
        if (imageArray != null) {
            mImageArray = imageArray;
        }
    }
}