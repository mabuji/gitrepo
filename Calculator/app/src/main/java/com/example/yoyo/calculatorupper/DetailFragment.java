package com.example.yoyo.calculatorupper;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "id";
    private static final String ARG_PARAM2 = "param2";
    EditText ed_f, ed_s, ed_t;
    TextView tv_f, tv_s, tv_t;
    Button danwei_calculate, danwei_ce;
    double first, second, third;


    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DetailFragment() {

    }


    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        tv_f = (TextView) view.findViewById(R.id.tv_f);
        tv_s = (TextView) view.findViewById(R.id.tv_s);
        tv_t = (TextView) view.findViewById(R.id.tv_t);
        ed_f = (EditText) view.findViewById(R.id.ed_f);
        ed_s = (EditText) view.findViewById(R.id.ed_s);
        ed_t = (EditText) view.findViewById(R.id.ed_t);

        danwei_calculate = (Button) view.findViewById(R.id.danwei_calculate);
        danwei_ce = (Button) view.findViewById(R.id.danwei_ce);
        danwei_ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_f.setText("");
                ed_s.setText("");
                ed_t.setText("");
            }
        });

        switch (mParam1) {
            case "1":
                tv_f.setText("千米");
                tv_s.setText("米");
                tv_t.setText("厘米");
                danwei_calculate.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String fStr = ed_f.getText().toString();
                        String sStr = ed_s.getText().toString();
                        String tStr = ed_t.getText().toString();
                        if(!fStr.equals("")){
                            first = Double.parseDouble(fStr);
                            ed_s.setText(String.valueOf(first * 1000));
                            ed_t.setText(String.valueOf(first * 100000));
                        }else {
                            if(!sStr.equals("")) {
                                second = Double.parseDouble(sStr);
                                ed_f.setText(String.valueOf(second / 1000));
                                ed_t.setText(String.valueOf(second * 100));
                            }
                            else {
                                if(!tStr.equals("")) {
                                    third = Double.parseDouble(tStr);
                                    ed_f.setText(String.valueOf(third/100000));
                                    ed_s.setText(String.valueOf(third/100));
                                }
                            }
                        }
                    }
                });
                break;
            case "2":
                tv_f.setText("千克");
                tv_s.setText("斤");
                tv_t.setText("克");
                danwei_calculate.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String fStr = ed_f.getText().toString();
                        String sStr = ed_s.getText().toString();
                        String tStr = ed_t.getText().toString();
                        if(!fStr.equals("")){
                            first = Double.parseDouble(fStr);
                            ed_s.setText(String.valueOf(first * 2));
                            ed_t.setText(String.valueOf(first * 1000));
                        }else {
                            if(!sStr.equals("")) {
                                second = Double.parseDouble(sStr);
                                ed_f.setText(String.valueOf(second / 2));
                                ed_t.setText(String.valueOf(second * 500));
                            }
                            else {
                                if(!tStr.equals("")) {
                                    third = Double.parseDouble(tStr);
                                    ed_f.setText(String.valueOf(third/1000));
                                    ed_s.setText(String.valueOf(third/500));
                                }
                            }
                        }
                    }
                });
                break;
            case "3":
                tv_f.setText("时");
                tv_s.setText("分");
                tv_t.setText("秒");
                danwei_calculate.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String fStr = ed_f.getText().toString();
                        String sStr = ed_s.getText().toString();
                        String tStr = ed_t.getText().toString();
                        if(!fStr.equals("")){
                            first = Double.parseDouble(fStr);
                            ed_s.setText(String.valueOf(first * 60));
                            ed_t.setText(String.valueOf(first * 3600));
                        }else {
                            if(!sStr.equals("")) {
                                second = Double.parseDouble(sStr);
                                ed_f.setText(String.valueOf(second / 60));
                                ed_t.setText(String.valueOf(second * 60));
                            }
                            else {
                                if(!tStr.equals("")) {
                                    third = Double.parseDouble(tStr);
                                    ed_f.setText(String.valueOf(third/3600));
                                    ed_s.setText(String.valueOf(third/60));
                                }
                            }
                        }
                    }
                });

        }
        return view;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
