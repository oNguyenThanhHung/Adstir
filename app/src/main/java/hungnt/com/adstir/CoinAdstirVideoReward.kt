package hungnt.com.adstir

import android.app.Activity
import com.ad_stir.common.Log
import com.ad_stir.interstitial.AdstirVideoAds
import com.ad_stir.videoreward.AdstirVideoReward
import com.ad_stir.videoreward.AdstirVideoRewardListener

class CoinAdstirVideoReward private constructor(private val activity: Activity) {

    private var adstirVideoReward: AdstirVideoReward? = null
    private var callbackVideoRewardListener: CallbackVideoRewardListener? = null
    private var mSpotId: Int = -1
    private var isLoading: Boolean = false

    private val adstirVideoRewardListener = object : AdstirVideoRewardListener {
        override fun onFinished(spot_no: Int) {
            callbackVideoRewardListener?.onFinished()
        }

        override fun onReward(spot_no: Int) {
            callbackVideoRewardListener?.onReward()
        }

        override fun onRewardCanceled(spot_no: Int) {
            callbackVideoRewardListener?.onRewardCanceled()
        }

        override fun onLoad(spot_no: Int) {
            isLoading = false
            callbackVideoRewardListener?.onLoad()
        }

        override fun onFailed(spot_no: Int) {
            isLoading = false
            callbackVideoRewardListener?.onFailed()
        }

        override fun onClose(spot_no: Int) {
            callbackVideoRewardListener?.onClose()
        }

        override fun onStart(spot_no: Int) {
            callbackVideoRewardListener?.onStart()
        }

        override fun onStartFailed(spot_no: Int) {
            callbackVideoRewardListener?.onStartFailed()
        }
    }

    fun setSpotId(spot_no: Int) {
        if (spot_no > 0 && mSpotId != spot_no) {
            mSpotId = spot_no
            Log.setLogLevel(android.util.Log.DEBUG)
            AdstirVideoAds.init(activity, activity.getString(R.string.adstir_media_id), spot_no)
        }
    }


    fun setCallbackVideoRewardListener(listener: CallbackVideoRewardListener) {
        callbackVideoRewardListener = listener
    }

    fun setMediaUserId(mediaUserId: String?) {
        if (mediaUserId != null) {
            AdstirVideoAds.setMediaUserID(mediaUserId)
        }
    }

    fun initAdstirVideo() {
        if (mSpotId > 0) {
            adstirVideoReward = AdstirVideoReward(activity, activity.getString(R.string.adstir_media_id), mSpotId)
            adstirVideoReward?.adstirVideoRewardListener = adstirVideoRewardListener
        }
    }

    fun loadVideoReward() {
        isLoading = true
        adstirVideoReward?.load()
    }

    fun showVideoReward() : Boolean {
        adstirVideoReward?.let {
            if (it.canShow()) {
                it.showRewardVideo()
                return true
            }
        }
        return false
    }

    fun isPlayVideoReward(): Boolean = adstirVideoReward?.canShow() ?: false

    fun isLoading():Boolean = isLoading

    fun onResume() {
        adstirVideoReward?.resume()
    }

    fun onPause() {
        adstirVideoReward?.pause()
    }

    fun onDestroy() {
        adstirVideoReward?.apply {
            destroy()
            adstirVideoRewardListener = null
        }

        isLoading = false
    }

    companion object {
        private var instance: CoinAdstirVideoReward? = null

        fun getInstance(activity: Activity): CoinAdstirVideoReward {
            if (instance == null) {
                instance = CoinAdstirVideoReward(activity)
            }
            return instance!!
        }
    }
}
