package avaitors.flysky;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstTravelActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_travel);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static int[] imagearr =
                {
                        R.drawable.help1,
                        R.drawable.help3,
                        R.drawable.small_lag,
                        R.drawable.help5,
                        R.drawable.lsc,
                        R.drawable.bp,
                        R.drawable.sc,
                        R.drawable.t,
                        R.drawable.intoflight,
                        R.drawable.boa,
                        R.drawable.phone,
                        R.drawable.help
                };


        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_first_travel, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getResources().getTextArray(R.array.biggner_instr)[getArguments().getInt(ARG_SECTION_NUMBER)]);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.section_image);
            imageView.setImageResource(imagearr[getArguments().getInt(ARG_SECTION_NUMBER)]);
            TextView textView1 = (TextView) rootView.findViewById(R.id.section_desc);
            textView1.setText(getResources().getTextArray(R.array.biggner_desc)[getArguments().getInt(ARG_SECTION_NUMBER)]);

            //Bitmap b = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
            //  int pixel = b.getPixel(10,10);
            //  rootView.setBackgroundColor(Color.rgb(Color.red(pixel),Color.green(pixel),Color.blue(pixel)));

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 12;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
