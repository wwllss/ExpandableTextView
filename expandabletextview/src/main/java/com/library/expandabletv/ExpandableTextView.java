package com.library.expandabletv;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Yuan.Zhang on 2015/6/1
 */
public class ExpandableTextView extends TextView {

    private int showLines;

    private int color;

    private String expandText = "展示";

    private Handler handler = new Handler();

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView);
        showLines = array.getInt(R.styleable.ExpandableTextView_showLines,1);
        color = array.getColor(R.styleable.ExpandableTextView_expandColor, Color.BLUE);
        expandText = array.getString(R.styleable.ExpandableTextView_expandText);
        array.recycle();
    }

    public void setContentText(final String text) {
        setText(text);

        Layout layout = getLayout();
        if (layout == null)
            return;
        int line = layout.getLineCount();
        if (line <= showLines)
            return;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < showLines; i++) {
            int start = layout.getLineStart(i);
            int end = layout.getLineEnd(i);
            result.append(text.substring(start, end));
        }
        result.delete(result.length() - 7, result.length()).append("... ").append(expandText);
        SpannableString string = new SpannableString(result);
        string.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setMaxLines(Integer.MAX_VALUE);
                        setText(text);
                    }
                }, 200);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(color);
                ds.setUnderlineText(false);
            }
        }, result.length() - 2, result.length()
                , Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        setText(string);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void setExpandText(String s) {
        if (TextUtils.isEmpty(s))
            return;
        this.expandText = s;
    }

    public String getExpandText() {
        return this.expandText;
    }

    public int getShowLines() {
        return showLines;
    }

    public void setShowLines(int showLines) {
        if (showLines < 1) {
            return;
        }
        this.showLines = showLines;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        Color.parseColor(String.valueOf(color));
        this.color = color;
    }
}
