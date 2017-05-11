package winter.zxb.smilesb101.viewthisworld.View;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import winter.zxb.smilesb101.viewthisworld.Bean.TextGanioBean;
import winter.zxb.smilesb101.viewthisworld.Model.ITextGanioModel;
import winter.zxb.smilesb101.viewthisworld.R;
import winter.zxb.smilesb101.viewthisworld.View.Interface.IMainActivityView;
import winter.zxb.smilesb101.viewthisworld.View.adapter.MainActivityPagerAdapter;
import winter.zxb.smilesb101.viewthisworld.View.customView.RoundImageView;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener,IMainActivityView{

static final String TAG = "MainActivity";
	ViewPager viewPager;
	MainActivityPagerAdapter adapter;
	RoundImageView headImage;
	TabLayout tabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);*/

		headImage = (RoundImageView)findViewById(R.id.headImage);
		headImage.setOnClickListener(this);

		viewPager = (ViewPager)findViewById(R.id.viewPager);

		tabLayout = (TabLayout)findViewById(R.id.tablayout);
		adapter = new MainActivityPagerAdapter(this.getSupportFragmentManager(),this,0);
		setTabLayout(adapter);

		FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				Snackbar.make(view,"Replace with your own action",Snackbar.LENGTH_LONG)
						.setAction("Action",null).show();
			}
		});

		DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
		/*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();*/

		NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);

		ITextGanioModel.I_GANIO_MODEL.getSearchContent("Android",new ITextGanioModel.IGanioListener(){
			@Override
			public void onSuccess(ArrayList<TextGanioBean> ganioList){

			}

			@Override
			public void onError(String error){

			}
		});


	}

	/**
	 * 设置adapter
	 */
	void setTabLayout(MainActivityPagerAdapter adapter)
	{
		viewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(viewPager);

		ArrayList<Integer> titleImages = adapter.getPageImages();

		for(int i = 0;i<tabLayout.getTabCount();i++)
		{
			TabLayout.Tab tab = tabLayout.getTabAt(i);
			if(tab!=null)
			{
				tab.setIcon(titleImages.get(i));
				tab.setText("");
			}
		}
	}

	@Override
	public void onBackPressed(){
		DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
		if(drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if(id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item){
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if(id == R.id.nav_ganio) {
			// 打开干货界面
			setTabLayout(adapter);
		}else if(id== R.id.nav_zixun)
		{
			//打开资讯界面
			Log.i(TAG,"onNavigationItemSelected: 资讯界面");
			MainActivityPagerAdapter mainAdapter = new MainActivityPagerAdapter(this.getSupportFragmentManager(),this,1);
			setTabLayout(mainAdapter);
		}
		else if(id == R.id.nav_douban) {
			//打开豆瓣界面
			MainActivityPagerAdapter mainAdapter = new MainActivityPagerAdapter(this.getSupportFragmentManager(),this,2);
			setTabLayout(mainAdapter);
		}
		else if(id == R.id.nav_music) {
            // 打开知乎界面
			MainActivityPagerAdapter mainAdapter = new MainActivityPagerAdapter(this.getSupportFragmentManager(),this,3);
			setTabLayout(mainAdapter);
		} else if(id == R.id.nav_comic) {
			//打开漫画界面
			MainActivityPagerAdapter mainAdapter = new MainActivityPagerAdapter(this.getSupportFragmentManager(),this,4);
			setTabLayout(mainAdapter);
		} else if(id == R.id.nav_share) {

		} else if(id == R.id.nav_send) {

		}

		DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	@Override
	public void onClick(View v){
		switch(v.getId())
		{
			case R.id.headImage:
				Log.i(TAG,"onClick: 展开导航");
				DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
				drawer.openDrawer(GravityCompat.START);
				break;
			default:
				break;
		}
	}

	/**
	 * 下面是View接口的实现
	 *
	 */

	@Override
	public String getGanioType(){
		return "";//tabLayout.getTabAt(tabLayout.getSelectedTabPosition()).getText().toString();
	}

	/**
	 * 展示干货
	 */
	@Override
	public void showGaino(){

	}

	@Override
	public void showLoding(){

	}

	@Override
	public void closeLoding(){

	}

	@Override
	public void onError(String error){

	}
}
