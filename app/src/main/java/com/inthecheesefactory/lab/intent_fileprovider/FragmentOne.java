package com.inthecheesefactory.lab.intent_fileprovider;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sakka on 11-08-2017.
 */

public class FragmentOne extends Fragment {

    private Button btnGotoSecFragment;
    private View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment1,container,false);

        initUi();
        return rootview;
    }

    private void initUi() {
        btnGotoSecFragment = (Button) rootview.findViewById(R.id.btnGotoSecFragment);
        btnGotoSecFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoFragmentSec();
            }
        });
    }
    private void gotoFragmentSec() {
        Fragment fragment = new FragmentTwo();
        FragmentTransaction _transaction = getActivity().getSupportFragmentManager().beginTransaction();
        _transaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        _transaction.replace(R.id.frame_container,fragment,"second fragment");
        _transaction.addToBackStack("second fragment");
        _transaction.commit();
    }
}
