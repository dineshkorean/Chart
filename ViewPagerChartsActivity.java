package lecho.lib.hellocharts.samples;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.BubbleChartData;
import lecho.lib.hellocharts.model.BubbleValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.BubbleChartView;
import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;
import lecho.lib.hellocharts.view.PreviewLineChartView;

public class ViewPagerChartsActivity extends ActionBarActivity  {


    SectionsPagerAdapter mSectionsPagerAdapter;


    ViewPager mViewPager;
   static  ArrayList<Integer> obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_charts);

         obj = new ArrayList<Integer>();

	  /*This is how elements should be added to the array list*/
        obj.add(2000);
        obj.add(4000);
        obj.add(3000);
        obj.add(600);
        obj.add(5000);

        obj.add(5000);
        obj.add(9000);
        obj.add(3000);
        obj.add(4000);
        obj.add(2000);

        obj.add(2000);
        obj.add(4000);
        obj.add(3000);
        obj.add(9000);
        obj.add(5000);

        obj.add(5000);
        obj.add(9000);
        obj.add(3000);
        obj.add(4000);
        obj.add(2000);


        obj.add(4000);
        obj.add(2000);



        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        //actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);

        mViewPager.setAdapter(mSectionsPagerAdapter);


    }


    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_view_pager_charts, container, false);
            RelativeLayout layout = (RelativeLayout) rootView;
            int sectionNum = getArguments().getInt(ARG_SECTION_NUMBER);
            switch (sectionNum) {
                case 1:
                    LineChartView lineChartView = new LineChartView(getActivity());
                    lineChartView.setLineChartData(generateLineChartData());
                    lineChartView.setZoomType(ZoomType.HORIZONTAL);



                    lineChartView.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);




                    layout.addView(lineChartView);

                   // layout.setPadding(100,0,0,0);
                    break;
                case 2:

                case 3:

                case 4:

                case 5:

            }

            return rootView;
        }

        private LineChartData generateLineChartData() {


            int numValues = 20;

            List<PointValue> values = new ArrayList<PointValue>();
          /*  for (int i = 0; i < numValues; ++i) {
                values.add(new PointValue(i, (float) Math.random() * 100f));
            }*/


            int arralylist_Length=obj.size();
            Log.v("arralylist_Length",""+arralylist_Length);
            Log.e("arralylist_Length",""+arralylist_Length);
            Log.d("arralylist_Length",""+arralylist_Length);

            for (int i = 0; i < numValues; ++i) {
                values.add(new PointValue(i, obj.get(i)));
            }


            Line line = new Line(values);
            line.setColor(ChartUtils.COLOR_GREEN_BRIGHT);

           // line.setPointRadius(3);
            //line.setPointColor(ChartUtils.COLOR_RED);

            List<Line> lines = new ArrayList<Line>();
            lines.add(line);

            LineChartData data = new LineChartData(lines);



            data.setAxisXBottom(new Axis().setName("Months"));

            data.setAxisYLeft(new Axis().setName("l").setHasLines(true));
            //



            return data;

        }



    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "";
             /*   case 1:
                    return "ColumnChart";

                case 4:
                    return "PieChart";*/
            }
            return null;
        }
    }

}
