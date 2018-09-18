package com.example.administrator.xy;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.dom.WXDomObject;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;

public class WXCardView extends WXComponent<TextView> {

    private TextView view;
    private Context mContext;
    public WXCardView(WXSDKInstance instance, WXDomObject dom, WXVContainer parent) {
        super(instance, dom, parent);
        mContext = parent.getContext();
        //Toast.makeText(mContext,"lalala",Toast.LENGTH_LONG).show();
    }

    @Override
    protected TextView initComponentHostView(@NonNull Context context) {
        view = new TextView(context);
        view.setMovementMethod(LinkMovementMethod.getInstance());
        view.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        //Toast.makeText(mContext,"lalala",Toast.LENGTH_LONG).show();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)mContext).finish();
            }
        });
        return view;
    }

    @WXComponentProp(name="showmsg")
    public void elevation(String elevation){
        view.setText(elevation);
        //Toast.makeText(mContext,"lalala",Toast.LENGTH_LONG).show();
    }

    @JSMethod
    public void focus() {
        view.setText("ok");
    }
}
