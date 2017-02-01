# CoordinatorTabLayout

[![License](https://img.shields.io/badge/license-Apache%202.0-green.svg)](https://github.com/hugeterry/CoordinatorTabLayout/blob/master/LICENSE.txt)
[![Download](https://api.bintray.com/packages/hugeterry/CoordinatorTabLayout/CoordinatorTabLayout/images/download.svg) ](https://bintray.com/hugeterry/CoordinatorTabLayout/CoordinatorTabLayout/_latestVersion)

[中文版文档](README_CN.md)

CoordinatorTabLayout is a custom combination of controls, you can quickly achieve TabLayout and CoordinatorLayout combined style
Inherited to CoordinatorLayout, CollapsingToolbarLayout contains the TabLayout in the CoordinatorLayout.

![show](showUI/show1.gif)


##Usage

###Step 1

Add the following to your build.gradle:
```
dependencies {
    compile 'cn.hugeterry.coordinatortablayout:coordinatortablayout:1.0.5'
}
```

###Step 2

Config in xml:
```
<cn.hugeterry.coordinatortablayout.CoordinatorTabLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/coordinatortablayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <android.support.v4.view.ViewPager
        android:id="@+id/vp"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior="@string/appbar_scrolling_view_behavior" />
</cn.hugeterry.coordinatortablayout.CoordinatorTabLayout>
```


###Step 3

Use it in your own code:</br>
1.setTitle(String title):Set the CoordinatorTabLayout's title.</br>
2.setupWithViewPager(ViewPager viewPager):To link the two together.</br>
3.setImageArray(int[] imageArray):Set the image array of the header according to the number of tabs and pass it to the control.
```
        //Add the fragment to the viewpager
        initFragments();
        initViewPager();
        //Image array
        mImageArray = new int[]{
                R.mipmap.bg_android,
                R.mipmap.bg_ios,
                R.mipmap.bg_js,
                R.mipmap.bg_other};

        mCoordinatorTabLayout = (CoordinatorTabLayout) findViewById(R.id.coordinatortablayout);
        mCoordinatorTabLayout.setTitle("Demo")
                .setImageArray(mImageArray)
                .setupWithViewPager(mViewPager);
```

Finish, enjoy it.


##More

###set the content scrim

![show](showUI/show2.gif)

setImageArray(int[] imageArray, int[] colorArray):Set the color array to use for the content scrim for each tab.
```
        mColorArray = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light};
        mCoordinatorTabLayout.setImageArray(mImageArray, mColorArray);
 ```

###set back enable
setBackEnable(Boolean canBack):To enable the Up button for an activity that has a parent activity.
```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...
        mCoordinatorTabLayout.setBackEnable(true);
        ...
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
```

###Gets the child control
getActionBar():get the ActionBar
getTabLayout():get the TabLayout

[More code](https://github.com/hugeterry/CoordinatorTabLayout/blob/master/sample/src/main/java/cn/hugeterry/coordinatortablayoutdemo/MainActivity.java)


##Attributes
- app:contentScrim -> color.Defaults to ?attr/colorPrimary
- app:tabIndicatorColor -> color.
- app:tabTextColor -> color.


## LICENSE
    Copyright 2017 HugeTerry.
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

