package cn.hugeterry.coordinatortablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;

/**
 * Created by hugeterry(http://hugeterry.cn)
 * Date: 17/1/27 14:57
 */

public class Coordinatortablayout extends CoordinatorLayout {
    private ImageView mImageView;
    private int mImageSrc;

    public Coordinatortablayout(Context context) {
        super(context);
    }

    public Coordinatortablayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initWidget(context, attrs);

    }

    public Coordinatortablayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initWidget(context, attrs);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_coordinatortablayout, this, true);

        mImageView = (ImageView) findViewById(R.id.imageview);

    }

    private void initWidget(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs
                , R.styleable.Coordinatortablayout);
        mImageSrc = typedArray.getResourceId(R.styleable.Coordinatortablayout_tab_image_src, 0);
        mImageView.setImageResource(mImageSrc);
    }


}
