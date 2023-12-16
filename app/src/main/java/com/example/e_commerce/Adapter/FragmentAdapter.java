package com.example.e_commerce.Adapter;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.e_commerce.fragment.Cart;
import com.example.e_commerce.fragment.Home;
import com.example.e_commerce.fragment.Profile;

// Factory interface for creating fragments
interface FragmentFactory {
    Fragment createFragment();
}

// Concrete implementations of the factory interface
class HomeFactory implements FragmentFactory {
    @Override
    public Fragment createFragment() {
        return new Home();
    }
}

class ProfileFactory implements FragmentFactory {
    @Override
    public Fragment createFragment() {
        return new Profile();
    }
}

class CartFactory implements FragmentFactory {
    @Override
    public Fragment createFragment() {
        return new Cart();
    }
}

public class FragmentAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"Home", "Profile", "My Cart"};
    private Context context;
    private FragmentFactory[] fragmentFactories;

    public FragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

        // Initialize fragment factories
        fragmentFactories = new FragmentFactory[]{
                new HomeFactory(),
                new ProfileFactory(),
                new CartFactory()
        };
    }

    @Override
    public Fragment getItem(int position) {
        // Use the factory to create fragments
        return fragmentFactories[position].createFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}