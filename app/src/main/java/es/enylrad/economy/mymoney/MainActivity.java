package es.enylrad.economy.mymoney;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import java.util.List;
import java.util.Vector;

import es.enylrad.economy.mymoney.fragment.GastosFragment;
import es.enylrad.economy.mymoney.fragment.GraficaFragment;
import es.enylrad.economy.mymoney.fragment.IngresosFragment;
import es.enylrad.economy.mymoney.fragment.ResumenFragment;

public class MainActivity extends AppCompatActivity {

    private MaterialViewPager mViewPager;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);
        ViewPager viewPager = mViewPager.getViewPager();
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.gasto,
                                "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.ingreso,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        fragments = new Vector<>();
    }

    public static class MyPagerAdapter extends FragmentStatePagerAdapter {

        private static int NUM_ITEMS = 4;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return ResumenFragment.newInstance(0, "Resumen");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return GastosFragment.newInstance(1, "Gastos");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return IngresosFragment.newInstance(2, "Ingresos");
                case 3: // Fragment # 1 - This will show SecondFragment
                    return GraficaFragment.newInstance(3, "Gráfico");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0:
                    return "Resumen";
                case 1:
                    return "Gastos";
                case 2:
                    return "Ingresos";
                case 3:
                    return "Gráfico";
                default:
                    return null;
            }

        }

    }
}
