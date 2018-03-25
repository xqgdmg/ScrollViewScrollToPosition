package dmg.xqg.com.scrollviewscrolltoposition;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dmg.xqg.com.scrollviewscrolltoposition.utils.DensityUtil;
import dmg.xqg.com.scrollviewscrolltoposition.view.NoAutoScrollViewWithPosition;
import dmg.xqg.com.scrollviewscrolltoposition.view.ViewDetailsBtnDialog;

public class MainActivity extends Activity implements View.OnClickListener {

    NoAutoScrollViewWithPosition noAutoScrollViewWithPosition;
    private TextView tvMoneyUse;
    private TextView tvProjectAdvantage;
    private TextView tvProjectIntroduction;
    private Button btnMenu;
    private int mCurrenY;
    private TextView shareAllocation;
    private TextView projectAdvantage;
    private TextView enterpriseEvaluation;
    private TextView moneyUse;
    private TextView projectIntroduction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();

    }

    private void initListener() {
        btnMenu.setOnClickListener(this);
    }

    private void initView() {
        tvMoneyUse = (TextView) findViewById(R.id.tvMoneyUse);
        tvProjectAdvantage = (TextView) findViewById(R.id.tvProjectAdvantage);
        tvProjectIntroduction = (TextView) findViewById(R.id.tvProjectIntroduction);
        shareAllocation = (TextView) findViewById(R.id.shareAllocation);
        projectIntroduction = (TextView) findViewById(R.id.projectIntroduction);
        projectAdvantage = (TextView) findViewById(R.id.projectAdvantage);
        enterpriseEvaluation = (TextView) findViewById(R.id.enterpriseEvaluation);
        moneyUse = (TextView) findViewById(R.id.moneyUse);
        btnMenu = (Button) findViewById(R.id.btnMenu);
        noAutoScrollViewWithPosition = (NoAutoScrollViewWithPosition) findViewById(R.id.noAutoScrollViewWithPosition);
    }


    @Override
    public void onClick(View v) {
        noAutoScrollViewWithPosition.setScrollViewListener(new NoAutoScrollViewWithPosition.ScrollViewListener() {
            @Override
            public void onScrollChanged(NoAutoScrollViewWithPosition noAutoScrollViewWithPosition, int x, int y, int oldx, int oldy) {
                mCurrenY = y;
            }
        });

        ViewDetailsBtnDialog viewDetailsBtnDialog = new ViewDetailsBtnDialog();
        viewDetailsBtnDialog.setListener(new ViewDetailsBtnDialog.MyListener() {
            @Override
            public void projectIntroduction() {// 项目介绍
                int[] location = new int[2];
                projectIntroduction.getLocationOnScreen(location);
                Log.e("chris","mCurrenY==" + mCurrenY);
                Log.e("chris","location[1]==" + location[1]);
                noAutoScrollViewWithPosition.setScrollY( mCurrenY + location[1]  - DensityUtil.dip2px(MainActivity.this,17) ); //  + DensityUtil.dip2px(45)
            }

            @Override
            public void shareAllocation() {// 份额分配
                int[] location = new int[2];
                shareAllocation.getLocationOnScreen(location);
                noAutoScrollViewWithPosition.setScrollY( mCurrenY + location[1] - DensityUtil.dip2px(MainActivity.this,17) ); // + DensityUtil.dip2px(45)
            }

            @Override
            public void projectAdvantage() {// 项目优势
                int[] location = new int[2];
                projectAdvantage.getLocationOnScreen(location);
                noAutoScrollViewWithPosition.setScrollY( mCurrenY + location[1] - DensityUtil.dip2px(MainActivity.this,17) ); // + DensityUtil.dip2px(45)
            }

            @Override
            public void moneyUse() {// 资金用途
                int[] location = new int[2];
                moneyUse.getLocationOnScreen(location);
                noAutoScrollViewWithPosition.setScrollY( mCurrenY + location[1] - DensityUtil.dip2px(MainActivity.this,17) ); // + DensityUtil.dip2px(45)
            }

            @Override
            public void enterpriseEvaluation() {// 企业评估
                int[] location = new int[2];
                enterpriseEvaluation.getLocationOnScreen(location);
                noAutoScrollViewWithPosition.setScrollY( mCurrenY + location[1] - DensityUtil.dip2px(MainActivity.this,17) ); // + DensityUtil.dip2px(45)
            }
        });
        viewDetailsBtnDialog.show(getFragmentManager(), "viewDetailsBtnDialog");

    }
}
