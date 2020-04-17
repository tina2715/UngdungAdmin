package com.udgs123.ungdungadmin.Model;

import android.view.View;

import androidx.annotation.NonNull;

public interface OnItemClickListener {
    void onClick(View v, @NonNull int position);
    void onLongClick(View v, @NonNull int position);
}
