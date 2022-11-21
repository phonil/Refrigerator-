package opg.app.myrefrigerator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter { // ViewPager2

    public int mCount;

    public MyAdapter(HomeFragment fa, int count) { // 아래 super 보니 main을 부모로 하려나본데, 프래그먼트에 쓸거면 프래그먼트를 부모로 해도 되는거잖아
        super(fa); // public MyAdapter(MainActivity fa, int count) 원래 이거임
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        if(index==0) return new Fragment1();
        else if(index==1) return new Fragment2();
        else if(index==2) return new Fragment3();
        else return new Fragment4();

    }

    @Override
    public int getItemCount() {
        return 2000;
    }

    public int getRealPosition(int position) { return position % mCount; }

}