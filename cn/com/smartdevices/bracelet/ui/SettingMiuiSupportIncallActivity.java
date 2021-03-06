package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.B;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.D;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventNotifyStatusClosed;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import com.huami.android.view.b;
import com.huami.android.view.c;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import de.greenrobot.event.EventBus;

public class SettingMiuiSupportIncallActivity extends SystemBarTintActivity implements OnClickListener {
    private String a = "SettingMiuiSupportIncallActivity";
    private TextView b = null;
    private TextView c = null;
    private TextView d = null;
    private Switch e = null;
    private LinearLayout f = null;
    private B g = B.a();
    private Switch h;
    private TextView i;
    private LinearLayout j = null;
    private LinearLayout k = null;
    private TextView l;
    private boolean m = false;
    private TextView n;
    private String o = a.f;

    private void a() {
        this.b = (TextView) findViewById(R.id.phone_notify_home_back);
        this.b.setText(R.string.incoming_call_notify);
        this.b.setOnClickListener(this);
        this.e = (Switch) findViewById(R.id.phone_notify_switch);
        this.e.setOnCheckedChangeListener(new C0800eu(this));
        this.f = (LinearLayout) findViewById(R.id.phone_notify_ll);
        this.f.setOnClickListener(this);
        this.c = (TextView) findViewById(R.id.phone_notify_switch_title);
        this.c.setText(R.string.incoming_call_notify);
        String[] stringArray = getResources().getStringArray(R.array.phone_notify_tips);
        String[] stringArray2 = getResources().getStringArray(R.array.contacts_notify_title);
        this.d = (TextView) findViewById(R.id.phone_notify_tips);
        this.d.setText(stringArray[0]);
        this.i = (TextView) findViewById(R.id.contacts_notify_switch_title);
        this.i.setText(stringArray2[0]);
        this.k = (LinearLayout) findViewById(R.id.contacts_notify_ll);
        this.k.setOnClickListener(this);
        this.h = (Switch) findViewById(R.id.contacts_notify_switch);
        this.h.setOnCheckedChangeListener(new C0801ev(this));
        this.j = (LinearLayout) findViewById(R.id.incoming_delay_sencond_ll);
        this.j.setOnClickListener(this);
        this.n = (TextView) findViewById(R.id.delay_title_tv);
        this.l = (TextView) findViewById(R.id.delay_sencond_tv);
        if (this.m && this.g.c(this.o)) {
            this.e.setChecked(true);
            a(true);
        } else {
            this.e.setChecked(false);
            a(false);
        }
        b();
    }

    private void a(boolean z) {
        this.k.setEnabled(z);
        this.j.setEnabled(z);
        this.h.setChecked(false);
        this.h.setEnabled(z);
        if (z) {
            this.i.setTextColor(getResources().getColor(R.color.main_ui_title_color));
            this.l.setTextColor(getResources().getColor(R.color.main_ui_title_color));
            this.n.setTextColor(getResources().getColor(R.color.main_ui_title_color));
            return;
        }
        this.i.setTextColor(getResources().getColor(R.color.disabled_text_color));
        this.l.setText(a.f);
        this.l.setTextColor(getResources().getColor(R.color.disabled_text_color));
        this.n.setTextColor(getResources().getColor(R.color.disabled_text_color));
    }

    private void b() {
        e();
        d();
    }

    private void b(boolean z) {
        if (this.g.d(this.o, z)) {
            D.c(getApplicationContext(), z);
            if (z) {
                d();
            } else {
                D.a(getApplicationContext());
                e();
            }
            if (!z) {
                EventBus.getDefault().post(new EventNotifyStatusClosed());
            }
            a(z);
            return;
        }
        a(false);
        b.a((Context) this, (int) R.string.notify_set_failed, 0).show();
    }

    private void c() {
        c.showPanel((Activity) this, new C0705bg());
    }

    private void c(boolean z) {
        if (this.g.f(this.o, z)) {
            D.d(getApplicationContext(), z);
            this.h.setChecked(z);
            return;
        }
        this.h.setChecked(false);
        b.a((Context) this, (int) R.string.notify_set_failed, 0).show();
    }

    private void d() {
        int i = 3;
        C0596r.d(this.a, "updateDelaySencondUI ------");
        B a = B.a();
        String string = getResources().getString(R.string.unit_sec_short);
        if (this.m && a.c(this.o)) {
            int e = a.e(this.o);
            C0596r.d(this.a, "api.getIncallDelay   curTime = " + e);
            if (e >= 3) {
                i = e;
            }
            D.a(getApplicationContext(), i);
            C0596r.d(this.a, "updateDelaySencondUI   curTime = " + i);
            this.l.setText(i + string);
        }
    }

    private void e() {
        B a = B.a();
        if (!this.m) {
            return;
        }
        if (a.f(this.o)) {
            this.h.setChecked(true);
        } else {
            this.h.setChecked(false);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.phone_notify_home_back:
                finish();
                return;
            case R.id.phone_notify_ll:
                this.e.toggle();
                return;
            case R.id.incoming_delay_sencond_ll:
                c();
                return;
            case R.id.contacts_notify_ll:
                this.h.toggle();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_incoming_supprotmiui_notify);
        EventBus.getDefault().register(this);
        this.o = Keeper.readBraceletBtInfo().b;
        this.m = B.a().f();
        a();
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(EventSettingFragmentUpdate eventSettingFragmentUpdate) {
        d();
    }
}
