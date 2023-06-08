package com.example.arabic.restaurants;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListOfFood extends AppCompatActivity {
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_food);

        dbHelper=new DBHelper(ListOfFood.this) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS Information");
                super.onCreate(db);
            }
        };

        dbHelper.InsertInformation("MCDONALDS","McDonald's is an American fast food company, founded in 1940 as a restaurant operated by Richard and Maurice McDonald, in San Bernardino, California, United States. They rechristened their business as a hamburger stand. The first time a McDonald's franchise used the Golden Arches logo was in 1953 at a location in Phoenix, Arizona");
        dbHelper.InsertInformation("BBB","The BBB Hamburger chain opened a new and kosher Mehadrin branch in central Jerusalem, adjacent to the picturesque Nahalat Shiva neighborhood and close to Mamilla Boulevard. The large branch is spread over 420 square meters and boasts a spacious and stylish space divided into two floors.");
        dbHelper.InsertInformation("KFC","KFC,is an American fast food restaurant chain that specializes in fried chicken. Headquartered in Louisville, Kentucky, it is the world's second-largest restaurant chain (as measured by sales) after McDonald's, with almost 20,000 locations globally in 123 countries and territories as of December 2015. The chain is a subsidiary of Yum! Brands, a restaurant company that also owns the Pizza Hut, Taco Bell, and WingStreet chains");
        dbHelper.InsertInformation("PIZZA HUT","Pizza Hut is an American restaurant chain and international franchise founded in 1958 by Dan and Frank Carney. The company is known for its Italian-American cuisine menu including pizza and pasta, as well as side dishes and desserts. Pizza Hut has 16,796 restaurants worldwide as of March 2018,[2] making it the world's largest pizza chain in terms of locations. It is a subsidiary of Yum! Brands, Inc., one of the world's largest restaurant companies");
        dbHelper.InsertInformation("BURGERIM","BURGERIM operates a chain of restaurants serving burgers.The chain has branches throughout the country and its menu offers a hamburger of various sizes.The idea behind the brand is simple: instead of one big burger, guests enjoy a series of mini-burger to enjoy with a side of thick cut fries and a soda. You’ll also find chicken wings, salads, a chicken sandwich, and desserts like cheesecake on the menu.");
        dbHelper.InsertInformation("CHICKERS","CHICKERS Nazareth is a fast food place where you can enjoy a selection of fast food, baguettes of your choice with meat, chicken, and cheese.Chickers also serve salads of all kinds, and drinks.");


        dbHelper.InsertInformation("RONEN","Ronen is a typical Israeli Grill restaurant in the heart of Netanya. with an amazing concept ,You come and choose the fresh piece of meat that you want from the large variety and they grill it for you!.The restaurant is also a symbol of conviviality and authenticity, with a kitchen filled with a lot of generosity and love.Using the most important, fresh products, Ronen Bessarim always give a lot of attention on the quality of his products to serve the best meats to his customers.You always have a warm welcome in this restaurant where simplicity rhymes with taste!");
        dbHelper.InsertInformation("TISHREEN","Tishreen restaurant Nazareth is a fusion cuisine that combines traditional food with the latest dishes from the world's leading cuisines, created by chefs. Tishreen offers its customers a rich and varied Mediterranean menu.");
        dbHelper.InsertInformation("VILLANAZARETH","Eating at this restaurant with a great view of Mary's Well will be a positive experience for visitors. Visit this place and order great coffee. It's easy to find Villa Nazareth Hotel due to the convenient location. Most guests point out that the staff is patient. If you want to enjoy fabulous service, you should visit this place. Enjoy the pleasant atmosphere here. Google users granted the rating of 4.6 to this spot.");
        dbHelper.InsertInformation("FRANGELICO","frangelico is a chain os sushi bars ,the franchise began its journey about a decade ago in the city of Haifa. The menu features everything from sushi through soups, salads, stir-fry,meats and desserts. Theres also an alcohol bar with a vriety of drinks including draft beers ,whiskey,cocktails and more");
        dbHelper.InsertInformation("BAYAT","Bayat Restaurant Bar is an authentic great little restaurant, with some tasty dishes, a young, lively atmosphere and a big selection of alcohol (the place is owned by Christians, hence the free-flowing alcohol - including Taibe beer, the only real Palestinian beer).");
        dbHelper.InsertInformation("DIANA","Here you will find the most mouthwatering grilled meat variety! The juicy shawarma, savory lamb ribs and lamb skewers are definitely worth booking a table beforehand! There also are a large variety of fresh salads and appetizers, such as the delightful Abu Hummus that will be a perfect option to complement your meat main dishes.The menu also represents multiple choices of fresh grilled fish and seafood snacks, such as shrimps and squids, traditional Arabic dishes such as kibbeh, safih and kofta, a selection of desserts, including kanafeh, sachlav, baklava with various tastes and much more.");

        //dbHelper.InsertInformation("KFC","");



        Button Fastfood = findViewById(R.id.button3);
        Fastfood.setOnClickListener(lis);

        Button Restaurants = findViewById(R.id.button4);
        Restaurants.setOnClickListener(lis1);
    }

    View.OnClickListener lis = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), FASTFOOD.class);
            startActivity(intent);


        }
    };
    View.OnClickListener lis1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), Restaurants.class);
            startActivity(intent);
        }

    };

}
