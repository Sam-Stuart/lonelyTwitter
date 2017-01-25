package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
    private ArrayAdapter<Tweet> adapter;

    //Lab 3 content

    private ArrayList<Tweet> tweetList;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);



		try {
			Tweet tweet = new NormalTweet("First Tweet");
			tweet.setMessage("ASDFASGAJSFgj");
			ImportantTweet importantTweet = new ImportantTweet("Very Important");
			importantTweet.getDate();
			NormalTweet normaltweet = new NormalTweet("im normal");

			ArrayList<Tweet> arrayList = new ArrayList<Tweet>();
			arrayList.add(tweet);
			arrayList.add(normaltweet);
			arrayList.add(importantTweet);



		} catch (TweetToLongException e) {
			e.printStackTrace();
		}


		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
                //added Lab 3
                try {
                    Tweet tweet = new NormalTweet(text);
                    tweetList.add(tweet);
                } catch (TweetToLongException e) {
                    e.printStackTrace();
                }

                adapter.notifyDataSetChanged();
                saveInFile();
               // saveInFile(text, new Date(System.currentTimeMillis()));
               // finish();

			}


		});

        clearButton.setOnClickListener(new View.OnClickListener()  {

            public void onClick(View v) {

                tweetList.clear();


                adapter.notifyDataSetChanged();
                saveInFile();
                // saveInFile(text, new Date(System.currentTimeMillis()));
                // finish();

            }


        });







	}

	@Override
	protected void onStart() {

		super.onStart();
		//String[] tweets = loadFromFile();

        //altered Lab 3
        loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}




	private void loadFromFile() {
		//ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            //Taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            //Jan 24 2017 18:19
            Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
            tweetList = gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
            tweetList = new ArrayList<Tweet>();

		} catch (IOException e) {
			throw  new RuntimeException();
		}

    }





	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(tweetList,out);
            out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Handle Exception
			//throw new RuntimeException();
		} catch (IOException e) {
			// TODO Handle Exception
            throw new RuntimeException();
		}
	}
}