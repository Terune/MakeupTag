//상품을 클릭했을 때 나오는 상세 설명 페이지 액티비티의 레이아웃

package kr.ac.kaist.makeuptag;

import android.content.Context;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;


public class DetailViewActivity extends Activity {

    ImageView itemImage;
    Gallery itemGallery;
    Button itemGoBack;
    int[] images = {
            R.mipmap.minkyu0430_405,
            R.mipmap.i1,
            R.mipmap.i2,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        itemGallery = (Gallery)findViewById(R.id.ItemGallery);
        itemImage = (ImageView)findViewById(R.id.ItemImage);
        itemGoBack = (Button)findViewById(R.id.ItemGoBack);
        itemGoBack.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    finish();
                }
        });

        itemGallery.setAdapter(new GalleryAdapter(this));
        itemGallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemImage.setImageResource(images[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    class GalleryAdapter extends BaseAdapter {
        Context context;

        public GalleryAdapter(Context context){
            this.context = context;
        }

        public int getCount(){
            return images.length;
        }

        public Object getItem(int position){
            return images[position];
        }

        public long getItemId(int position){
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            ImageView image;

            if(convertView == null){
                image = new ImageView(context);
            }
            else {
                image = (ImageView)convertView;
            }

            image.setImageResource(images[position]);
            image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            image.setLayoutParams(new Gallery.LayoutParams(200,200));

            return image;
        }

    }

}
