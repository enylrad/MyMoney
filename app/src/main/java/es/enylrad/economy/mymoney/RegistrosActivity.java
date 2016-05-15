package es.enylrad.economy.mymoney;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import java.util.List;
import java.util.Vector;

import es.enylrad.economy.mymoney.fragment.GastosFragment;
import es.enylrad.economy.mymoney.fragment.IngresosFragment;
import es.enylrad.economy.mymoney.fragment.ResumenFragment;

public class RegistrosActivity extends AppCompatActivity {

    private MaterialViewPager mViewPager;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.registros_activity);


        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);
        ViewPager viewPager = mViewPager.getViewPager();
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(1);

        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.gasto,
                                "http://t2.uccdn.com/images/3/3/4/img_como_ahorrar_gastos_de_la_tarjeta_de_credito_7433_orig.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://imagenes.es.sftcdn.net/blog/es/2008/03/finance.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.ingreso,
                                "https://gabrielmazzola.files.wordpress.com/2015/02/ingresos.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static class MyPagerAdapter extends FragmentStatePagerAdapter {

        private static int NUM_ITEMS = 3;

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
                case 0: // Fragment # 0 - This will show FirstFragment different title
                    return GastosFragment.newInstance(1, "Gastos");
                case 1: // Fragment # 0 - This will show FirstFragment
                    return ResumenFragment.newInstance(0, "Resumen");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return IngresosFragment.newInstance(2, "Ingresos");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0:
                    return "Gastos";
                case 1:
                    return "Resumen";
                case 2:
                    return "Ingresos";
                default:
                    return null;
            }

        }

    }
}
