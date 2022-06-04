package com.marufalam.coronaapps;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.marufalam.coronaapps.databinding.FragmentHomeBinding;
import com.marufalam.coronaapps.models.CoronaResponseModel;
import com.marufalam.coronaapps.viewmodels.CoronaViewModel;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.PieModel;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    final String TAG = HomeFragment.class.getSimpleName();
    private CoronaViewModel coronaViewModel;
    private PieChart chart;
    private CoronaResponseModel model;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        coronaViewModel = new ViewModelProvider(requireActivity()).get(CoronaViewModel.class);
        coronaViewModel.coronaResponseModelMutableLD.observe(getViewLifecycleOwner(), coronaResponceModel -> {
            Toast.makeText(getContext(), "" + coronaResponceModel.getContinent(), Toast.LENGTH_SHORT).show();
            Log.e(TAG, "onCreateView: " + coronaResponceModel.getCountry());
            model = coronaResponceModel;
            binding.setDetails(coronaResponceModel);
            binding.chart.addPieSlice(new PieModel("Cases",Float.parseFloat(String.valueOf(model.getCases())),Color.parseColor("#42BE00")));
            binding.chart.addPieSlice(new PieModel("Deaths",Float.parseFloat(String.valueOf(model.getTests())),Color.parseColor("#FF0000")));
            binding.chart.addPieSlice(new PieModel("Recovered",Float.parseFloat(String.valueOf(model.getRecovered())),Color.parseColor("#FF5A5A")));
            binding.chart.startAnimation();

        });

      /* todo BarChart
       binding.chart.addBar(new BarModel(2.3f,R.color.red,));
        binding.chart.addBar(new BarModel(2.3f,R.color.white));
        binding.chart.addBar(new BarModel(2.3f,R.color.black));
        binding.chart.addBar(new BarModel(2.3f,R.color.blue));
        binding.chart.addBar(new BarModel(2.3f,R.color.green));
        binding.chart.startAnimation();*/



        return binding.getRoot();
    }

}

