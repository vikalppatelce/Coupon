package demo.vicshady.coupondunia;

import java.io.IOException;
import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import demo.vicshady.coupondunia.dto.CouponAdapter;
import demo.vicshady.coupondunia.dto.CouponsDTO;

public class CollectionActivity extends SherlockFragmentActivity {

	ListView listCoupons;
	ProgressBar progress;
	ArrayList<CouponsDTO> couponListDTO;
	ImageLoader imageLoader;
	DisplayImageOptions options;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.collection);

		listCoupons = (ListView) findViewById(R.id.list);
		progress = (ProgressBar) findViewById(R.id.progress);

		imageLoader = ImageLoader.getInstance();
        // Initialize ImageLoader with configuration. Do it once.
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        
        options = new DisplayImageOptions.Builder()
        .showImageOnLoading(R.drawable.logo) // resource or drawable
        .showImageForEmptyUri(R.drawable.logo) // resource or drawable
        .showImageOnFail(R.drawable.logo) //this is the image that will be displayed if download fails
        .cacheInMemory()
        .cacheOnDisc()
        .build();
		
		JacksonParserTask jTask = new JacksonParserTask();
		jTask.execute();
	}

	@SuppressWarnings("deprecation")
	public void parseJSON() throws JsonParseException, IOException {
		JsonFactory f = new JsonFactory();
		JsonParser jp = null;
		try {
			jp = f.createJsonParser(getAssets().open("task_data.txt"));

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String responseCode;
		boolean loopParse = false;
		jp.nextToken(); // will return JsonToken.START_OBJECT (verify?)
		while (jp.nextToken() != JsonToken.END_OBJECT) {
			String fieldname = jp.getCurrentName();
			jp.nextToken(); // move to value, or START_OBJECT/START_ARRAY

			if ("status".equals(fieldname)) {
				while (jp.nextToken() != JsonToken.END_OBJECT) {
					String responsefield = jp.getCurrentName();
					jp.nextToken(); // move to value
					if ("rcode".equals(responsefield)) {
						responseCode = jp.getText();
					} else if ("message".equals(responsefield)) {
						if (jp.getText().compareToIgnoreCase("OK") > 0)
							loopParse = true;
						else
							loopParse = false;
					} else {
						Log.i("Jackson", "Unrecognized TOken");
					}
				}
			}

			else if ("data".equals(fieldname)) {

				while (jp.nextToken() != JsonToken.END_OBJECT) {
					String categoryfield = jp.getCurrentName();
					jp.nextToken(); // move to value

					if ("CategoryName".equals(categoryfield)) {
						responseCode = jp.getText();
					}

					else if ("URLKeyword".equals(categoryfield)) {
						if (jp.getText().compareToIgnoreCase("OK") > 0)
							loopParse = true;
						else
							loopParse = false;
					}

					else if ("Coupons".equals(jp.getCurrentName())) {
						jp.nextToken();
						CouponsDTO couponDTO = new CouponsDTO();
						couponListDTO = new ArrayList<CouponsDTO>();
						while (jp.nextToken() != JsonToken.END_ARRAY) {
							String couponfield = jp.getCurrentName();
							
							if("}".equals(jp.getText()))
							{
								couponListDTO.add(couponDTO);
								couponDTO = new CouponsDTO();
							}
							if (jp.nextToken() == JsonToken.END_ARRAY) {
								break;
							}
							if ("CouponID".equals(couponfield)) {
								couponDTO.setCouponID(jp.getText());
							} else if ("CouponCode".equals(couponfield)) {
								couponDTO.setCouponCode(jp.getText());
							}
							else if ("CountSuccess".equals(couponfield)) {
								couponDTO.setCountSuccess(jp.getText());
							} 
							else if ("CountFail".equals(couponfield)) {
								couponDTO.setCountFail(jp.getText());
							} 
							else if ("Hits".equals(couponfield)) {
								couponDTO.setHits(jp.getText());
							} 
							else if ("Discount".equals(couponfield)) {
								couponDTO.setDiscount(jp.getText());
							} 
							else if ("Title".equals(couponfield)) {
								couponDTO.setTitle(jp.getText());
							} 
							else if ("Description".equals(couponfield)) {
								couponDTO.setDescription(jp.getText());
							} 
							else if ("WebsiteID".equals(couponfield)) {
								couponDTO.setWebsiteID(jp.getText());
							} 
							else if ("Expiry".equals(couponfield)) {
								couponDTO.setExpiry(jp.getText());
							} 
							else if ("DateVerified".equals(couponfield)) {
								couponDTO.setDateVerified(jp.getText());
							} 
							else if ("Priority".equals(couponfield)) {
								couponDTO.setPriority(jp.getText());
							} 
							else if ("IsOneTimeUse".equals(couponfield)) {
								couponDTO.setIsOneTimeUse(jp.getText());
							} 
							else if ("IsDeal".equals(couponfield)) {
								couponDTO.setIsDeal(jp.getText());
							} 
							else if ("CouponPopularityScore".equals(couponfield)) {
								couponDTO.setCouponPopularityScore(jp.getText());
							} 
							else if ("FullTerms".equals(couponfield)) {
								couponDTO.setFullTerms(jp.getText());
							} 
							else if ("FeaturedCouponRank".equals(couponfield)) {
								couponDTO.setFeaturedCouponRank(jp.getText());
							} 
							else if ("AccessCode".equals(couponfield)) {
								couponDTO.setAccessCode(jp.getText());
							} 
							else if ("WebsiteName".equals(couponfield)) {
								couponDTO.setWebsiteName(jp.getText());
							} 
							else if ("WebsiteTitle".equals(couponfield)) {
								couponDTO.setWebsiteTitle(jp.getText());
							} 
							else if ("LandingPageURL".equals(couponfield)) {
								couponDTO.setLandingPageURL(jp.getText());
							} 
							else if ("ImageURL".equals(couponfield)) {
								couponDTO.setImageURL(jp.getText());
							}
						}
					}

					else if ("Count".equals(jp.getCurrentName())) {
						jp.nextToken();
						while (jp.nextToken() != JsonToken.END_ARRAY) {
							String counterfield = jp.getCurrentName();
							if (jp.nextToken() == JsonToken.END_ARRAY) {
								break;
							}
							if ("0".equals(counterfield)) {
								responseCode = jp.getText();
							} else if ("counter".equals(counterfield)) {
								if (jp.getText().compareToIgnoreCase("OK") > 0)
									loopParse = true;
								else
									loopParse = false;
							} else {
								Log.i("Jackson", "Unrecognized TOken");
							}
						}
					}
				}
			}

			else if ("hash".equals(fieldname)) {
			}

			else {
				Log.i("Jackson", "Unrecognized TOken");
			}
		}
		jp.close();
	}
	
	
	private class JacksonParserTask extends AsyncTask<Void, Void, String>
	{
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String n = null;
			try {
				parseJSON();
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return n;
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			progress.setVisibility(View.INVISIBLE);
			listCoupons.setAdapter(new CouponAdapter(CollectionActivity.this, couponListDTO,imageLoader,options));
		}
	}
}
