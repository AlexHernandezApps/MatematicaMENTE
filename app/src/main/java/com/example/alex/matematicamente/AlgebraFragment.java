package com.example.alex.matematicamente;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlgebraFragment extends Fragment {

    SubsamplingScaleImageView imageView;

    public AlgebraFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_algebra, container, false);
        imageView = (SubsamplingScaleImageView) view.findViewById(R.id.image);
        imageView.setImage(ImageSource.resource(R.drawable.algebra_logo));

        return view;
    }

}
