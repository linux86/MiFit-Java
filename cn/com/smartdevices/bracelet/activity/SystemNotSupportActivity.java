package cn.com.smartdevices.bracelet.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.xiaomi.hm.health.R;

public class SystemNotSupportActivity extends SystemBarTintActivity implements OnClickListener {
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.exit:
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.system_not_support);
        ((Button) findViewById(R.id.exit)).setOnClickListener(this);
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.x);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.x);
        C0401a.a((Activity) this);
    }
}
