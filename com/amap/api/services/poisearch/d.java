package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d implements Creator<Groupbuy> {
    d() {
    }

    public Groupbuy a(Parcel parcel) {
        return new Groupbuy(parcel);
    }

    public Groupbuy[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
