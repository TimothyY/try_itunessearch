package example.com.try_itunessearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import example.com.try_itunessearch.basic_recyclerview.BasicRecyclerViewActivity;
import example.com.try_itunessearch.basic_webservice.BasicWebServiceActivity;
import example.com.try_itunessearch.combination.ItunesSearchActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navigateTo(View view) {
        if(view.getId()==R.id.btnBasicWebServiceAccess){
            startActivity(new Intent(this, BasicWebServiceActivity.class));
        }else if(view.getId()==R.id.btnBasicRecyclerView){
            startActivity(new Intent(this, BasicRecyclerViewActivity.class));
        }else if(view.getId()==R.id.btnCombination){
            startActivity(new Intent(this, ItunesSearchActivity.class));
        }
    }
}
