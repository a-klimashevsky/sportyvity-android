package com.sportivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.sportivity.views.ExerciseView;
import com.sportivity.web.entities.Exercise;

import java.util.LinkedList;
import java.util.List;

public class WorkoutActivity extends AppCompatActivity {

    private TableLayout mWorkoutView;

    List<Exercise> mExercises = new LinkedList<>();

    private int mExerciseCount;

    private View mPopupView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_workout);
        mPopupView = findViewById(R.id.popup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mWorkoutView = (TableLayout) findViewById(R.id.workout);
        makeFakedData();
        bind();
    }

    private void makeFakedData() {
        Exercise exercise = new Exercise();
        exercise.setTitle("Deadlift");
        exercise.setReps(6);
        exercise.setSets(3);
        mExercises.add(exercise);

        exercise = new Exercise();
        exercise.setTitle("Benchpress");
        exercise.setReps(6);
        exercise.setSets(4);
        mExercises.add(exercise);

        exercise = new Exercise();
        exercise.setTitle("Thrust rod");
        exercise.setReps(5);
        exercise.setSets(4);
        mExercises.add(exercise);

        exercise = new Exercise();
        exercise.setTitle("Pull-ups");
        exercise.setReps(5);
        exercise.setSets(4);
        mExercises.add(exercise);
    }

    private void bind() {
        for (Exercise exercise : mExercises) {
            final TableRow row = new TableRow(this);
            mWorkoutView.addView(row);
            TableLayout.LayoutParams p = (TableLayout.LayoutParams) row.getLayoutParams();
            p.setMargins(0, 0, 0, dpToPx(4));
            ExerciseView view = new ExerciseView(this, exercise, new ExerciseView.ExecriceListener() {
                @Override
                public void done() {
                    int index = mWorkoutView.indexOfChild(row);
                    if (index != mWorkoutView.getChildCount() - 1) {
                        TableRow tr = (TableRow) mWorkoutView.getChildAt(index + 1);
                        ExerciseView ev = (ExerciseView) tr.getChildAt(0);
                        ev.open();
                    }
                    mExerciseCount++;
                    if (mExerciseCount == mExercises.size()) {
                        showPopup();
                    }
                }
            });
            TableRow.LayoutParams params = new TableRow.LayoutParams();
            params.weight = 4;
            params.setMarginEnd(dpToPx(4));
            view.setLayoutParams(params);
            view.setPadding(dpToPx(4), dpToPx(8), dpToPx(4), dpToPx(8));
            row.addView(view);
            TextView textView = new TextView(this);
            params = new TableRow.LayoutParams();
            params.weight = 1;
            textView.setLayoutParams(params);
            textView.setPadding(dpToPx(4), dpToPx(8), dpToPx(4), dpToPx(8));
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setTextColor(Color.WHITE);
            textView.setBackground(getResources().getDrawable(R.drawable.block_background_gray));
            textView.setText(exercise.getReps() + "*" + exercise.getSets());
            row.addView(textView);
        }
        TableRow tr = (TableRow) mWorkoutView.getChildAt(0);
        ExerciseView ev = (ExerciseView) tr.getChildAt(0);
        ev.open();
    }

    private void showPopup() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View v = getCurrentFocus();

            imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);

        mPopupView.setVisibility(View.VISIBLE);
    }

    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        float px = dp * density;
        return (int) px;
    }
}
