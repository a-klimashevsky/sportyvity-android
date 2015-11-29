package com.sportivity.views;

import android.content.Context;
import android.graphics.Color;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.sportivity.R;
import com.sportivity.web.entities.Exercise;

/**
 * Created by Alex Klimashevsky on 29.11.2015.
 */
public class ExerciseView extends TableLayout implements View.OnClickListener {

    private Exercise mExercise;

    private boolean isExpanded = false;

    private int mDoneCount;

    private ExecriceListener mListener;

    public ExerciseView(Context context, Exercise exercise, ExecriceListener listener) {
        super(context);
        mListener = listener;
        setBackground(context.getResources().getDrawable(R.drawable.block_background));
        mExercise = exercise;
        bind(context);
    }

    public void open() {
        isExpanded = true;
        bind(getContext());
    }

    private void bind(Context context) {
        removeAllViews();
        TextView titleView = new TextView(context);
        titleView.setOnClickListener(this);
        int id = isExpanded ? R.drawable.ic_arrow_up_white : R.drawable.ic_arrow_down_white;
        titleView.setCompoundDrawablesWithIntrinsicBounds(0, 0, id, 0);
        titleView.setTextColor(Color.WHITE);
        titleView.setText(mExercise.getTitle());
        addView(titleView);
        if (isExpanded)
            for (int i = 0; i < mExercise.getReps(); i++) {
                final TableRow row = (TableRow) LayoutInflater.from(getContext())
                        .inflate(R.layout.item_excercise, this, false);
                final EditText et = (EditText) row.findViewById(R.id.weight);
                final Button done = (Button) row.findViewById(R.id.done);
                et.setOnFocusChangeListener(new OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.showSoftInput(v, InputMethodManager.SHOW_FORCED);
                    }
                });
                et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                                || (actionId == EditorInfo.IME_ACTION_NEXT)
                                || (actionId == EditorInfo.IME_ACTION_DONE)) {
                            done(done, et);
                        }
                        return false;
                    }
                });
                et.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.requestFocus();
                    }
                });
                done.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        done(v, et);
                    }
                });
                addView(row);
            }
    }

    private void done(View v, EditText et) {
        v.setVisibility(View.INVISIBLE);
        et.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        et.setTextColor(Color.WHITE);
        et.setEnabled(false);
        et.setClickable(false);
        et.setFocusable(false);
        mDoneCount++;
        if (mDoneCount == mExercise.getReps()) {
            mListener.done();
            isExpanded = false;
            setBackground(getContext().getResources().getDrawable(R.drawable.block_background_inverted));
            bind(getContext());
        } else {
            TableRow r = (TableRow) getChildAt(mDoneCount);
            EditText et1 = (EditText) r.findViewById(R.id.weight);
            et1.performClick();
            /*InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(et1, InputMethodManager.SHOW_FORCED);*/
        }
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    @Override
    public void onClick(View v) {
        isExpanded = !isExpanded;
        bind(getContext());
    }

    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        float px = dp * density;
        return (int) px;
    }

    public interface ExecriceListener {
        void done();
    }
}
