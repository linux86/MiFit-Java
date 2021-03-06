package cn.com.smartdevices.bracelet.heartrate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.xiaomi.hm.health.R;

public class HeartRateBuyGuideActivity extends SystemBarTintActivity implements OnClickListener {
    private TextView a;
    private String b = "http://m.mi.com/1/#/product/view?product_id=1154500018";

    private void a() {
        this.a = (TextView) findViewById(R.id.has_bracelet);
        this.a.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.has_bracelet:
                if (!TextUtils.isEmpty(this.b)) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.b));
                    intent.addCategory("android.intent.category.BROWSABLE");
                    startActivity(intent);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_heart_buy_guide);
        a();
    }
}
