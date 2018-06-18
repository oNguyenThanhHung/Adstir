package hungnt.com.adstir

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ad_stir.interstitial.AdstirVideoAds
import com.ad_stir.videoreward.AdstirVideoRewardListener
import kotlinx.android.synthetic.main.activity_incentivized_video.*

class VideoRewardActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incentivized_video)

        val adstirVideoReward = MainActivity.adstirVideoReward
        MainActivity.adstirVideoReward.setAdstirVideoRewardListener(listener)

        button_play.setOnClickListener {
            AdstirVideoAds.setMediaUserID(description.text.toString())

            if (adstirVideoReward.canShow()) {
                Log.d("hung1234", "showRewardVideo")
                Toast.makeText(this@VideoRewardActivity, "showRewardVideo", Toast.LENGTH_SHORT).show()
                adstirVideoReward.showRewardVideo()
            } else {
                Log.d("hung1234", "loadVideo")
                adstirVideoReward.load()
            }
        }

        description.setText("androidVideo01")
    }

    private val listener = object : AdstirVideoRewardListener {

        override fun onLoad(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onLoad()", Toast.LENGTH_SHORT).show()
            Log.d("hung1234", "onLoad() returned: ")
        }

        override fun onFailed(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onFailed()", Toast.LENGTH_SHORT).show()
            Log.d("hung1234", "onFailed() returned: ")

        }

        override fun onStart(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onStart()", Toast.LENGTH_SHORT).show()

            Log.d("hung1234", "onStart() returned: ")
        }

        override fun onStartFailed(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onStartFailed()", Toast.LENGTH_SHORT).show()

            Log.d("hung1234", "onStartFailed() returned: ")
        }

        override fun onFinished(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onFinished()", Toast.LENGTH_SHORT).show()

            Log.d("hung1234", "onFinished() returned: ")
        }

        override fun onReward(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onReward()", Toast.LENGTH_SHORT).show()

            Log.d("hung1234", "onReward() returned: ")
        }

        override fun onRewardCanceled(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onRewardCanceled()", Toast.LENGTH_SHORT).show()

            Log.d("hung1234", "onRewardCanceled() returned: ")
        }

        override fun onClose(spot_no: Int) {
            Toast.makeText(this@VideoRewardActivity, "onClose()", Toast.LENGTH_SHORT).show()

            Log.d("hung1234", "onClose() returned: ")
        }
    }
}
